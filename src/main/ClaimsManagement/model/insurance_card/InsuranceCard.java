/**
 * @author Nguyen Ich Kiet - s3978724
 */
package model.insurance_card;

import model.claim.Claim;
import model.customer.Customer;
import model.policy_owner.PolicyOwner;

import java.time.LocalDate;
import java.util.Objects;

/**
 * One of the main classes of the system
 */
public class InsuranceCard {
    private String cardNumber;
    private Customer cardHolder;
    private PolicyOwner policyOwner;
    private LocalDate expirationDate;

    // Constructors
    public InsuranceCard() {
        this.cardNumber = "";
    }

    public InsuranceCard(String cardNumber, Customer cardHolder, PolicyOwner policyOwner, LocalDate expirationDate) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.policyOwner = policyOwner;
        this.expirationDate = expirationDate;
    }

    // Getters
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

    // Setters
    public void setCardHolder(Customer cardHolder) {
        this.cardHolder = cardHolder;
    }

    // Override for Set customization
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof InsuranceCard)) {
            return false;
        }
        return Objects.equals(this.getCardNumber(), ((InsuranceCard) o).getCardNumber());
    }

    // toString
    @Override
    public String toString() {
        return "InsuranceCard{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cardHolder=" + cardHolder.getFullName() +
                ", policyOwner=" + policyOwner.getName() +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
