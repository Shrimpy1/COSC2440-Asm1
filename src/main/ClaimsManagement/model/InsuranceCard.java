/**
 * @author Nguyen Ich Kiet - s3978724
 */
package model;

import model.customer.Customer;
import java.time.LocalDate;
import prop.PolicyOwner;

public class InsuranceCard {
    private String cardNumber;
    private Customer cardHolder;
    private PolicyOwner policyOwner;
    private LocalDate expirationDate;

    public InsuranceCard() {
        this.cardNumber = "";
    }

    public InsuranceCard(String cardNumber, Customer cardHolder, PolicyOwner policyOwner, LocalDate expirationDate) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.policyOwner = policyOwner;
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "model.InsuranceCard{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cardHolder=" + cardHolder +
                ", policyOwner=" + policyOwner +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
