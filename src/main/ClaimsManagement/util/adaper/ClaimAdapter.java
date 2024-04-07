/**
 * @author Nguyen Ich Kiet - s3978724
 */
package util.adaper;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import model.banking_info.BankingInfo;
import model.claim.Claim;
import model.customer.Customer;
import model.customer.CustomerSet;
import model.document.Document;
import util.claim_process_manager.CustomerClaimProcessManager;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

/**
 * Adapter to customize how Gson write & read a Claim object to files
 * Customization apart from default:
 * Only use insuredPerson's ID for the written data
 * This ID when read will be taken to search for the Customer
 * then this Claim will be added to that Customer
 */
public class ClaimAdapter implements JsonSerializer<Claim>, JsonDeserializer<Claim> {
    @Override
    public JsonElement serialize(Claim src, Type type, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", src.getId());
        jsonObject.add("claimDate", context.serialize(src.getClaimDate()));
        // Only write the Customer's ID instead of whole object. if claim has no insured person, write nothing
        jsonObject.addProperty("insuredPerson", (src.getInsuredPerson() != null)?src.getInsuredPerson().getId():"");
        jsonObject.addProperty("cardNumber", src.getCardNumber());
        jsonObject.add("examDate", context.serialize(src.getExamDate()));

        JsonArray documentsArray = new JsonArray(); // Create an array for the list of Documents
        src.getDocuments().forEach(document -> documentsArray.add(context.serialize(document))); // Serialize and then add the documents to the list
        jsonObject.add("documents", documentsArray);

        jsonObject.addProperty("claimAmount", src.getClaimAmount());
        jsonObject.addProperty("status", src.getStatus().name());
        jsonObject.add("bankingInfo", context.serialize(src.getReceiverBankingInfo()));
        return jsonObject;
    }

    @Override
    public Claim deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String id = jsonObject.get("id").getAsString();
        LocalDate claimDate = context.deserialize(jsonObject.get("claimDate"), LocalDate.class);
        String insuredPersonId = jsonObject.get("insuredPerson").getAsString();

        String cardNumber = jsonObject.get("cardNumber").getAsString();
        LocalDate examDate = context.deserialize(jsonObject.get("examDate"), LocalDate.class);
        JsonArray documentsArray = jsonObject.getAsJsonArray("documents");
        Type listType = new TypeToken<List<Document>>() {}.getType(); // Get type token for deserialize a List of Document
        List<Document> documents = context.deserialize(documentsArray, listType); // Deserialize the array from data files to List<Document>

        double claimAmount = jsonObject.get("claimAmount").getAsDouble();
        String status = jsonObject.get("status").getAsString();
        BankingInfo bankingInfo = context.deserialize(jsonObject.get("bankingInfo"), BankingInfo.class);

        // Construct a Claim
        Claim claim = new Claim(id, claimDate, cardNumber, examDate, documents, claimAmount, bankingInfo);

        // Add the Claim to the right Customer
        // Handle null value
        if (!insuredPersonId.isEmpty()) {
            // Get the Customer with the ID from data file
            Customer insuredPerson = CustomerSet.getInstance().getCustomerById(insuredPersonId);
            CustomerClaimProcessManager claimManager = new CustomerClaimProcessManager(insuredPerson);
            claimManager.add(claim);
        }

        // Set status
        switch (status.toLowerCase()){
            case "new":
                claim.setStatusNew();
                break;
            case "processing":
                claim.setStatusProcessing();
                break;
            case "done":
                claim.setStatusDone();
                break;
            default:
                System.out.println("Invalid status. Please update the claim.");
                break;
        }

        return claim;
    }
}
