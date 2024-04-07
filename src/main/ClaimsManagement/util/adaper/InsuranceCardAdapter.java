/**
 * @author Nguyen Ich Kiet - s3978724
 */
package util.adaper;

import com.google.gson.*;
import model.customer.Customer;
import model.customer.CustomerSet;
import model.insurance_card.InsuranceCard;
import model.policy_owner.PolicyOwner;

import java.lang.reflect.Type;
import java.time.LocalDate;

/**
 * Adapter to customize how Gson write & read a Claim object to files
 * Customization apart from default:
 * Only use cardHolder's ID for the written data
 * This ID when read will be taken to search for the Customer
 * then this InsuranceCard will be added to that Customer
 */
public class InsuranceCardAdapter implements JsonSerializer<InsuranceCard>, JsonDeserializer<InsuranceCard> {
    @Override
    public JsonElement serialize(InsuranceCard src, Type type, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("cardNumber", src.getCardNumber());
        // Only write the Customer's ID instead of whole object. if card holder is null, write nothing
        jsonObject.addProperty("cardHolder", (src.getCardHolder() != null)?src.getCardHolder().getId():"");
        jsonObject.add("policyOwner", context.serialize(src.getPolicyOwner()));
        jsonObject.add("expirationDate", context.serialize(src.getExpirationDate()));
        return jsonObject;
    }

    @Override
    public InsuranceCard deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String cardNumber = jsonObject.get("cardNumber").getAsString();
        String cardHolderId = jsonObject.get("cardHolder").getAsString();
        // Get the right Customer
        PolicyOwner policyOwner = context.deserialize(jsonObject.get("policyOwner"), PolicyOwner.class);
        LocalDate expirationDate = context.deserialize(jsonObject.get("expirationDate"), LocalDate.class);

        // Construct InsuranceCard
        InsuranceCard card = new InsuranceCard(cardNumber, null, policyOwner, expirationDate);

        // Add the card to the Customer
        // Handle null value
        if (!cardHolderId.isEmpty()) {
            // Get the customer with the id from data file
            Customer cardHolder = CustomerSet.getInstance().getCustomerById(cardHolderId);
            cardHolder.setInsuranceCard(card);
        }
        return card;
    }
}
