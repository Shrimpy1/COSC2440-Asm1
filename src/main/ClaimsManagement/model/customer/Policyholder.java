/**
 * @author Nguyen Ich Kiet - s3978724
 */
package model.customer;

import model.claim.Claim;
import model.insurance_card.InsuranceCard;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * One of the main classes of the system
 * Policyholder has a list of Dependants
 */
public class Policyholder extends Customer{

    // Constructors
    private Set<Dependant> dependants;

    public Policyholder() {
        super();
        this.dependants = new HashSet<Dependant>();
    }

    public Policyholder(String id, String name) {
        super(id, name);
        this.dependants = new HashSet<Dependant>();
    }

    public Policyholder(String id, String name, InsuranceCard insuranceCard, List<Claim> claims, Set<Dependant> dependants) {
        super(id, name, insuranceCard, claims);
        this.dependants = dependants;
    }

    // Getter for Dependant list
    public Set<Dependant> getDependants() {
        return dependants;
    }

    // Manipulate Dependant list methods
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
