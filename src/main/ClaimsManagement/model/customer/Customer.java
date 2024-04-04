/**
 * @author Nguyen Ich Kiet - s3978724
 */
package model.customer;

import model.claim.Claim;
import model.insurance_card.InsuranceCard;
import java.util.*;
public abstract class Customer {
    private String id;
    private String fullName;
    private transient InsuranceCard insuranceCard;
    private transient List<Claim> claims;

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

    public boolean setInsuranceCard(InsuranceCard card){
        this.insuranceCard = card;
        card.setCardHolder(this);
        return true;
    }

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
