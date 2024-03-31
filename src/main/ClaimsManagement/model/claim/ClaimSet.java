package model.claim;

import java.util.HashSet;
import java.util.Set;

public class ClaimSet {
    private static ClaimSet instance;
    private Set<Claim> claims;

    public ClaimSet() {
        this.claims = new HashSet<Claim>();
    }

    public static ClaimSet getInstance() {
        if (instance == null){
            instance = new ClaimSet();
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
            if (claim.getId() == id) return claim;
        }
        System.out.println("Claim with the id not found.");
        return null;
    }
}
