/**
 * @author Nguyen Ich Kiet - s3978724
 */
import java.time.LocalDate;
import java.util.*;
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
}
