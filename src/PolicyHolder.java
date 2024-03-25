/**
 * @author Nguyen Ich Kiet - s3978724
 */
import java.util.*;
public class PolicyHolder extends Customer{
    private List<Dependant> dependants;

    public PolicyHolder() {
        super();
    }

    public PolicyHolder(List<Dependant> dependants) {
        super();
        this.dependants = dependants;
    }

    public PolicyHolder(String id, String name, InsuranceCard insuranceCard, List<Claim> claims, List<Dependant> dependants) {
        super(id, name, insuranceCard, claims);
        this.dependants = dependants;
    }
}
