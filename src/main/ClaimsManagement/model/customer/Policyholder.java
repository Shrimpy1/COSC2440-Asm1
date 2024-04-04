/**
 * @author Nguyen Ich Kiet - s3978724
 */
package model.customer;

import model.claim.Claim;
import model.insurance_card.InsuranceCard;
import java.util.*;
public class Policyholder extends Customer{
    private Set<Dependant> dependants;

    public Policyholder() {
        super();
        this.dependants = new HashSet<Dependant>();
    }

    public Policyholder(String id, String name) {
        super(id, name);
        this.dependants = new HashSet<Dependant>();
    }

    public Policyholder(Set<Dependant> dependants) {
        super();
        this.dependants = dependants;
    }

    public Policyholder(String id, String fullName, Set<Dependant> dependants) {
        super(id, fullName);
        this.dependants = dependants;
    }

    public Policyholder(String id, String name, InsuranceCard insuranceCard, List<Claim> claims) {
        super(id, name, insuranceCard, claims);
        this.dependants = new HashSet<Dependant>();
    }

    public Policyholder(String id, String name, InsuranceCard insuranceCard, List<Claim> claims, Set<Dependant> dependants) {
        super(id, name, insuranceCard, claims);
        this.dependants = dependants;
    }

    public Set<Dependant> getDependants() {
        return dependants;
    }

    public boolean addDependant(Dependant dependant){
        return this.dependants.add(dependant);
    }

    @Override
    public String toString() {
        return "Policyholder{" +
                super.toString() +
                "dependants=" + dependants +
                '}';
    }
}
