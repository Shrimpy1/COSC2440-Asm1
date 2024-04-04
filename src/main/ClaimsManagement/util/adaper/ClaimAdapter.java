package util.adaper;

import com.google.gson.*;
import model.claim.Claim;

import java.lang.reflect.Type;

public class ClaimAdapter implements JsonSerializer<Claim>, JsonDeserializer<Claim> {
    @Override
    public JsonElement serialize(Claim claim, Type type, JsonSerializationContext context) {
        return null;
    }

    @Override
    public Claim deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        return null;
    }
}
