/**
 * @author Nguyen Ich Kiet - s3978724
 */
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

    public Customer(String id, String name, InsuranceCard insuranceCard, List<Claim> claims) {
        this.id = id;
        this.name = name;
        this.insuranceCard = insuranceCard;
        this.claims = claims;
    }

    public String getName() {
        return name;
    }
}
