/**
 * @author Nguyen Ich Kiet - s3978724
 */
package model.claim;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import model.customer.Customer;
import model.document.Document;
import model.banking_info.BankingInfo;

/**
 * One of the main classes of the system
 */
public class Claim {
    public enum ClaimStatus {
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
    private BankingInfo receiverBankingInfo;

    // Constructors
    public Claim() {
        this.id = "";
        this.cardNumber = "";
        this.documents = new ArrayList<Document>();
        this.claimAmount = 0;
        this.status = ClaimStatus.NEW;
    }

    public Claim(String id, LocalDate claimDate, String cardNumber, LocalDate examDate, double claimAmount) {
        this.id = id;
        this.claimDate = claimDate;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.claimAmount = claimAmount;
        this.documents = new ArrayList<Document>();
        this.status = ClaimStatus.NEW;
    }

    public Claim(String id, LocalDate claimDate, String cardNumber, LocalDate examDate, List<Document> documents, double claimAmount, BankingInfo receiverBankingInfo) {
        this.id = id;
        this.claimDate = claimDate;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.documents = documents;
        this.claimAmount = claimAmount;
        this.receiverBankingInfo = receiverBankingInfo;
        this.status = ClaimStatus.NEW;
    }

    public Claim(String id, LocalDate claimDate, Customer insuredPerson, String cardNumber, LocalDate examDate, List<Document> documents, double claimAmount, BankingInfo receiverBankingInfo) {
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

    // Getters
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
        return receiverBankingInfo;
    }

    // Setters
    public void setStatusNew(){
        this.status = ClaimStatus.NEW;
    }
    public void setStatusProcessing(){
        this.status = ClaimStatus.PROCESSING;
    }
    public void setStatusDone(){
        this.status = ClaimStatus.DONE;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setClaimDate(LocalDate claimDate) {
        this.claimDate = claimDate;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }
    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }
    public void setReceiverBankingInfo(BankingInfo receiverBankingInfo) {
        this.receiverBankingInfo = receiverBankingInfo;
    }
    public void setInsuredPerson(Customer insuredPerson) {
        this.insuredPerson = insuredPerson;
    }

    // Manipulate Document List
    public void addDocument(Document document){
        this.documents.add(document);
    }
    public void removeDocument(Document document) {this.documents.remove(document);}

    // Override for Set customization
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Claim)) {
            return false;
        }
        return Objects.equals(this.getId(), ((Claim) o).getId());
    }

    @Override
    public String toString() {
        return "Claim{" +
                "id='" + id + '\'' +
                ", claimDate=" + claimDate +
                ", insuredPerson=" + insuredPerson.getFullName() +
                ", cardNumber='" + cardNumber + '\'' +
                ", examDate=" + examDate +
                ", documents=" + documents +
                ", claimAmount=" + claimAmount +
                ", status=" + status +
                ", receiverBankingInfo='" + receiverBankingInfo + '\'' +
                '}';
    }
}
