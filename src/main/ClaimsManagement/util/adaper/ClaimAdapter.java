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

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

public class ClaimAdapter implements JsonSerializer<Claim>, JsonDeserializer<Claim> {
    @Override
    public JsonElement serialize(Claim src, Type type, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("id", src.getId());
        jsonObject.add("claimDate", context.serialize(src.getClaimDate()));
        jsonObject.addProperty("insuredPerson", src.getInsuredPerson().getId());
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
        Customer insuredPerson = CustomerSet.getInstance().getCustomerById(insuredPersonId);
        String cardNumber = jsonObject.get("cardNumber").getAsString();
        LocalDate examDate = context.deserialize(jsonObject.get("examDate"), LocalDate.class);

        JsonArray documentsArray = jsonObject.getAsJsonArray("documents");
        Type listType = new TypeToken<List<Document>>() {}.getType(); // Get type token for deserialization
        List<Document> documents = context.deserialize(documentsArray, listType); // Deserialize the array from data files to List<Document>

        double claimAmount = jsonObject.get("claimAmount").getAsDouble();
        String status = jsonObject.get("status").getAsString();
        BankingInfo bankingInfo = context.deserialize(jsonObject.get("bankingInfo"), BankingInfo.class);

        Claim claim = new Claim(id, claimDate, insuredPerson, cardNumber, examDate, documents, claimAmount, bankingInfo);

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
