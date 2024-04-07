/**
 * @author Nguyen Ich Kiet - s3978724
 */
package model.customer;

import model.claim.Claim;
import model.insurance_card.InsuranceCard;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * One of the main classes of the system
 */
public abstract class Customer {
    private String id;
    private String fullName;
    private transient InsuranceCard insuranceCard; // Transient to be excluded from being written to files
    private transient List<Claim> claims; // Transient to be excluded from being written to files

    // Constructors
    public Customer() {
        this.id = "";
        this.fullName = "";
        this.claims = new ArrayList<Claim>();
    }

    public Customer(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
        this.claims = new ArrayList<Claim>();
    }

    public Customer(String id, String fullName, List<Claim> claims) {
        this.id = id;
        this.fullName = fullName;
        this.claims = claims;
    }

    public Customer(String id, String fullName, InsuranceCard insuranceCard, List<Claim> claims) {
        this.id = id;
        this.fullName = fullName;
        this.insuranceCard = insuranceCard;
        this.claims = claims;
    }

    // Getters
    public String getFullName() {
        return fullName;
    }
    public String getId() {
        return id;
    }
    public InsuranceCard getInsuranceCard() {
        return insuranceCard;
    }
    public List<Claim> getClaims() {
        return claims;
    }

    //Setters
    public boolean setInsuranceCard(InsuranceCard card){
        this.insuranceCard = card;
        card.setCardHolder(this);
        return true;
    }

    // Manipulate Claim List
    public void addClaim(Claim claim){
        this.claims.add(claim);
    }
    public void removeClaim(Claim claim){
        this.claims.remove(claim);
    }

    // Override for Set customization
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Customer)) {
            return false;
        }
        return Objects.equals(this.getId(), ((Customer) o).getId());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + fullName + '\'' +
                ", insuranceCard=" + insuranceCard +
                ", claims=" + claims +
                '}';
    }
}
