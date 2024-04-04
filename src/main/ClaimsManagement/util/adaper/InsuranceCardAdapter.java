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

public class InsuranceCardAdapter implements JsonSerializer<InsuranceCard>, JsonDeserializer<InsuranceCard> {
    @Override
    public JsonElement serialize(InsuranceCard src, Type type, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("cardNumber", src.getCardNumber());
        jsonObject.addProperty("cardHolder", src.getCardHolder().getId());
        jsonObject.add("policyOwner", context.serialize(src.getPolicyOwner()));
        jsonObject.add("expirationDate", context.serialize(src.getExpirationDate()));
        return jsonObject;
    }

    @Override
    public InsuranceCard deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String cardNumber = jsonObject.get("cardNumber").getAsString();
        String cardHolderId = jsonObject.get("cardHolder").getAsString();
        PolicyOwner policyOwner = context.deserialize(jsonObject.get("policyOwner"), PolicyOwner.class);
        LocalDate expirationDate = context.deserialize(jsonObject.get("expirationDate"), LocalDate.class);

        Customer cardHolder = CustomerSet.getInstance().getCustomerById(cardHolderId);

        InsuranceCard card = new InsuranceCard(cardNumber, null, policyOwner, expirationDate);

        cardHolder.setInsuranceCard(card);

        return card;
    }
}
