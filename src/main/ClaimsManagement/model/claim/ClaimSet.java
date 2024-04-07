/**
 * @author Nguyen Ich Kiet - s3978724
 */
package model.claim;

import com.google.gson.reflect.TypeToken;
import util.FileHandler;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

/**
 * This singleton class act as the database for Claim objects
 * Includes save & load data to/from files methods
 */
public class ClaimSet {
    private static ClaimSet instance; // Global instance
    private Set<Claim> claims;

    private ClaimSet() {
        this.claims = new HashSet<Claim>();
    }

    /**
     * Get global instance
     * If no instance exist, construct one.
     */
    public static ClaimSet getInstance() {
        if (instance == null){
            instance = new ClaimSet();
        }
        return instance;
    }

    // Add to database
    public boolean addClaim(Claim claim){
        return claims.add(claim);
    }

    //Remove from database
    public boolean removeClaim(Claim claim){
        return claims.remove(claim);
    }

    // Get all Claims
    public Set<Claim> getClaims() {
        return claims;
    }

    // Get all Claims
    public Claim getClaimById(String id){
        for (Claim claim : claims){
            if (claim.getId().equals(id)) return claim;
        }
        System.out.println("Claim with the id not found.");
        return null;
    }

    // Save data of global instance into data files
    public void saveData(){
        String result = FileHandler.getInstance().writeObjectToFile("claim.json", this.claims)? "Saved claims data successfully!" : "Failed to save claims data!";
        System.out.println(result);
    }

    // Load data from data files to global instance
    public void loadData(){
        FileHandler fh = FileHandler.getInstance();
        Type type = new TypeToken<Set<Claim>>(){}.getType();
        this.claims = fh.loadObjectFromFile("claim.json", type);
    }
}
