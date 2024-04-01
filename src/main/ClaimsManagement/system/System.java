/**
 * @author Nguyen Ich Kiet - s3978724
 */
package system;

import java.util.*;

import model.claim.Claim;
import model.claim.ClaimSet;
import model.customer.Customer;
import model.customer.CustomerSet;
import model.insurance_card.InsuranceCard;
import model.insurance_card.InsuranceCardSet;

public class System {
    public System() {
    }

    public void initialize(){
        CustomerSet.getInstance();
        InsuranceCardSet.getInstance();
        ClaimSet.getInstance();


    }
}
