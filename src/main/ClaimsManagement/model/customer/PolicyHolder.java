/**
 * @author Nguyen Ich Kiet - s3978724
 */
package model.customer;

import model.claim.Claim;
import model.insurance_card.InsuranceCard;
import java.util.*;
public class PolicyHolder extends Customer{
    private List<Dependant> dependants;

    public PolicyHolder() {
        super();
        this.dependants = new ArrayList<Dependant>();
    }

    public PolicyHolder(String id, String name) {
        super(id, name);
        this.dependants = new ArrayList<Dependant>();
    }

    public PolicyHolder(List<Dependant> dependants) {
        super();
        this.dependants = dependants;
    }

    public PolicyHolder(String id, String name, InsuranceCard insuranceCard, List<Claim> claims) {
        super(id, name, insuranceCard, claims);
        this.dependants = new ArrayList<Dependant>();
    }

    public PolicyHolder(String id, String name, InsuranceCard insuranceCard, List<Claim> claims, List<Dependant> dependants) {
        super(id, name, insuranceCard, claims);
        this.dependants = dependants;
    }

    public List<Dependant> getDependants() {
        return dependants;
    }
}
