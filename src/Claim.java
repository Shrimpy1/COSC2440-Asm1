/**
 * @author Nguyen Ich Kiet - s3978724
 */
import java.util.*;
import java.time.LocalDate;
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

    @Override
    public String toString() {
        return "Claim{" +
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
