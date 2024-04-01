/**
 * @author Nguyen Ich Kiet - s3978724
 */
package model.insurance_card;

import model.customer.Customer;
import model.policy_owner.PolicyOwner;

import java.time.LocalDate;

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

    public String getCardNumber() {
        return cardNumber;
    }

    public Customer getCardHolder() {
        return cardHolder;
    }

    public PolicyOwner getPolicyOwner() {
        return policyOwner;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setCardHolder(Customer cardHolder) {
        this.cardHolder = cardHolder;
    }

    @Override
    public String toString() {
        return "model.insurance_card.txt.InsuranceCard{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cardHolder=" + cardHolder.getFullName() +
                ", policyOwner=" + policyOwner.getName() +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
