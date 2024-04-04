/**
 * @author Nguyen Ich Kiet - s3978724
 */
package model.claim;

import com.google.gson.reflect.TypeToken;
import util.FileHandler;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

public class ClaimSet {
    private static ClaimSet instance;
    private Set<Claim> claims;

    private ClaimSet() {
        this.claims = new HashSet<Claim>();
    }

    public static ClaimSet getInstance() {
        if (instance == null){
            instance = new ClaimSet();
            instance.loadData();
        }
        return instance;
    }

    public boolean addClaim(Claim claim){
        return claims.add(claim);
    }

    public boolean removeClaim(Claim claim){
        return claims.remove(claim);
    }

    public Set<Claim> getClaims() {
        return claims;
    }

    public Claim getClaimById(String id){
        for (Claim claim : claims){
            if (claim.getId().equals(id)) return claim;
        }
        System.out.println("Claim with the id not found.");
        return null;
    }

    public void saveData(){
        String result = FileHandler.getInstance().writeObjectToFile("claim.json", this.claims)? "Saved claims data successfully!" : "Failed to save claims data!";
        System.out.println(result);
    }

    private void loadData(){
        FileHandler fh = FileHandler.getInstance();
        Type type = new TypeToken<Set<Claim>>(){}.getType();
        this.claims = fh.loadObjectFromFile("claim.json", type);
    }
}
