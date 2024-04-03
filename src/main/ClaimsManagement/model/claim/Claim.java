/**
 * @author Nguyen Ich Kiet - s3978724
 */
package model.claim;

import java.util.*;
import java.time.LocalDate;
import model.customer.Customer;
import model.document.Document;
import model.banking_info.BankingInfo;

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
    private List<Document> documents;
    private double claimAmount;
    private ClaimStatus status;
    private BankingInfo bankingInfo;

    public Claim() {
        this.id = "";
        this.cardNumber = "";
        this.documents = new ArrayList<Document>();
        this.claimAmount = 0;
        this.status = ClaimStatus.NEW;
    }

    public Claim(String id, LocalDate claimDate, Customer insuredPerson, String cardNumber, LocalDate examDate, double claimAmount) {
        this.id = id;
        this.claimDate = claimDate;
        this.insuredPerson = insuredPerson;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.claimAmount = claimAmount;
        this.status = ClaimStatus.NEW;
    }

    public Claim(String id, LocalDate claimDate, Customer insuredPerson, String cardNumber, LocalDate examDate, List<Document> documents, double claimAmount, BankingInfo bankingInfo) {
        this.id = id;
        this.claimDate = claimDate;
        this.insuredPerson = insuredPerson;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.documents = documents;
        this.claimAmount = claimAmount;
        this.status = ClaimStatus.NEW;
        this.bankingInfo = bankingInfo;
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

    public List<Document> getDocuments() {
        return documents;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public ClaimStatus getStatus() {
        return status;
    }

    public BankingInfo getReceiverBankingInfo() {
        return bankingInfo;
    }

    public void setStatusNew(){
        this.status = ClaimStatus.NEW;
    }

    public void setStatusProcessing(){
        this.status = ClaimStatus.PROCESSING;
    }

    public void setStatusDone(){
        this.status = ClaimStatus.DONE;
    }

    public void addDocument(Document document){
        this.documents.add(document);
    }

    @Override
    public String toString() {
        return "model.claim.Claim{" +
                "id='" + id + '\'' +
                ", claimDate=" + claimDate +
                ", insuredPerson=" + insuredPerson.getFullName() +
                ", cardNumber='" + cardNumber + '\'' +
                ", examDate=" + examDate +
                ", documents=" + documents +
                ", claimAmount=" + claimAmount +
                ", status=" + status +
                ", receiverBankingInfo='" + bankingInfo + '\'' +
                '}';
    }
}
