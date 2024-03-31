/**
 * @author Nguyen Ich Kiet - s3978724
 */
package model.customer;

import model.claim.Claim;
import model.insurance_card.InsuranceCard;
import java.util.*;
public abstract class Customer {
    private String id;
    private String name;
    private InsuranceCard insuranceCard;
    private List<Claim> claims;

    public Customer() {
        this.id = "";
        this.name = "";
        this.claims = new ArrayList<Claim>();
    }

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
        this.claims = new ArrayList<Claim>();
    }

    public Customer(String id, String name, List<Claim> claims) {
        this.id = id;
        this.name = name;
        this.claims = claims;
    }

    public Customer(String id, String name, InsuranceCard insuranceCard, List<Claim> claims) {
        this.id = id;
        this.name = name;
        this.insuranceCard = insuranceCard;
        this.claims = claims;
    }

    public boolean addInsuranceCard(InsuranceCard card){
        this.insuranceCard = card;
        card.setCardHolder(this);
        return true;
    }

    public String getName() {
        return name;
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
        return "model.customer.Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", insuranceCard=" + insuranceCard +
                ", claims=" + claims +
                '}';
    }
}
