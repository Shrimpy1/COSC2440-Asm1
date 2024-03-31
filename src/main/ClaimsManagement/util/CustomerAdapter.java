package util;

import com.google.gson.*;
import model.claim.Claim;
import model.claim.ClaimSet;
import model.customer.Customer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import model.customer.Dependant;
import model.customer.PolicyHolder;
import model.insurance_card.InsuranceCard;
import model.insurance_card.InsuranceCardSet;

public class CustomerAdapter implements JsonSerializer<Customer>, JsonDeserializer<Customer> {
    @Override
    public JsonElement serialize(Customer src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", src instanceof PolicyHolder ? "policyholder" : "dependent");
        jsonObject.addProperty("id", src.getId());
        jsonObject.addProperty("name", src.getName());
        jsonObject.addProperty("insuranceCard", src.getInsuranceCard().getCardNumber());

        List<Claim> claims = src.getClaims();
        JsonArray jsonClaims = new JsonArray();
        for (Claim claim : claims){
            jsonClaims.add(new JsonPrimitive(claim.getId()));
        }

        if (src instanceof PolicyHolder) {
            List<Dependant> dependants = ((PolicyHolder) src).getDependants();
            JsonArray jsonDependants = new JsonArray();
            for (Dependant dependant : dependants) {
                jsonDependants.add(new JsonPrimitive(dependant.getId()));
            }
        }

        return jsonObject;
    }

    @Override
    public Customer deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("type").getAsString();
        String id = jsonObject.get("id").getAsString();
        String name = jsonObject.get("name").getAsString();
        String insuranceCardNumber = jsonObject.get("insuranceCard").getAsString();
        InsuranceCard insuranceCard = InsuranceCardSet.getInstance().getInsuranceCardByNumber(insuranceCardNumber);

        JsonArray jsonClaims = jsonObject.getAsJsonArray("claims");
        List<String> claimIds = new ArrayList<String>();
        for (JsonElement element : jsonClaims){
            claimIds.add(element.getAsString());
        }

        List<Claim> claims = new ArrayList<Claim>();
        for (String claimId : claimIds){
            claims.add(ClaimSet.getInstance().getClaimById(claimId));
        }

        if (Objects.equals(type, "dependant")) {
            return new Dependant(id, name, insuranceCard, claims);
        } else {
            return new PolicyHolder(id, name, insuranceCard, claims);
        }
    }
}
