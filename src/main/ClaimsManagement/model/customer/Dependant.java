/**
 * @author Nguyen Ich Kiet - s3978724
 */
package model.customer;

import model.claim.Claim;
import model.insurance_card.InsuranceCard;
import java.util.*;
public class Dependant extends Customer{
    public Dependant() {
        super();
    }

    public Dependant(String id, String name) {
        super(id, name);
    }

    public Dependant(String id, String name, InsuranceCard insuranceCard, List<Claim> claims) {
        super(id, name, insuranceCard, claims);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
