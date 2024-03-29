/**
 * @author Nguyen Ich Kiet - s3978724
 */
package system;

import java.util.*;

import model.Claim;
import model.customer.Customer;
import model.InsuranceCard;

public class System {
    private List<Claim> claimList;
    private List<Customer> customerList;
    private List<InsuranceCard> insuranceCardList;

    public System() {
        claimList = new ArrayList<Claim>();
        customerList = new ArrayList<Customer>();
        insuranceCardList = new ArrayList<InsuranceCard>();
    }
}
