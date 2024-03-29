/**
 * @author Nguyen Ich Kiet - s3978724
 */
package model;

import java.util.*;
import java.time.LocalDate;
import model.customer.Customer;

public class Claim {
    private enum ClaimStatus {
        NEW,
        PROCESSING,
        DONE
    }
    private String id;
    private LocalDate claimDate;
    private Customer insuredPerson;
    private String cardNumber;
    private LocalDate examDate;
    private List<String> documents;
    private double claimAmount;
    private ClaimStatus status;
    private String receiverBankingInfo;

    public Claim() {
        this.id = "";
        this.cardNumber = "";
        this.documents = new ArrayList<String>();
        this.claimAmount = 0;
        this.status = ClaimStatus.NEW;
        this.receiverBankingInfo = "";
    }

    public Claim(String id, LocalDate claimDate, Customer insuredPerson, String cardNumber, LocalDate examDate, List<String> documents, double claimAmount, String receiverBankingInfo) {
        this.id = id;
        this.claimDate = claimDate;
        this.insuredPerson = insuredPerson;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.documents = documents;
        this.claimAmount = claimAmount;
        this.status = ClaimStatus.NEW;
        this.receiverBankingInfo = receiverBankingInfo;
    }

    public String getId() {
        return id;
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public Customer getInsuredPerson() {
        return insuredPerson;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public List<String> getDocuments() {
        return documents;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public ClaimStatus getStatus() {
        return status;
    }

    public String getReceiverBankingInfo() {
        return receiverBankingInfo;
    }

    @Override
    public String toString() {
        return "model.Claim{" +
                "id='" + id + '\'' +
                ", claimDate=" + claimDate +
                ", insuredPerson=" + insuredPerson.getName() +
                ", cardNumber='" + cardNumber + '\'' +
                ", examDate=" + examDate +
                ", documents=" + documents +
                ", claimAmount=" + claimAmount +
                ", status=" + status +
                ", receiverBankingInfo='" + receiverBankingInfo + '\'' +
                '}';
    }
}
