package controller.claim;

import model.claim.ClaimSet;
import model.customer.Customer;
import model.customer.CustomerSet;
import model.document.Document;
import model.document.DocumentList;
import model.receiver_banking_info.ReceiverBankingInfo;
import view.claim.ClaimView;
import model.claim.Claim;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class ClaimController {
    private Claim claim;
    private ClaimView view;

    public ClaimController(Claim claim, ClaimView view) {
        this.claim = claim;
        this.view = view;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }

    public void setView(ClaimView view) {
        this.view = view;
    }

    public void createNewClaim(){
        Map<String, String> data = view.displayNewClaimForm();
        String id = data.get(ClaimView.CLAIM_ID);
        String claimDateStr = data.get(ClaimView.CLAIM_DATE);
        LocalDate claimDate = LocalDate.parse(claimDateStr);
        String insuredPersonId = data.get(ClaimView.INSURED_PERSON);
        Customer insuredPerson = CustomerSet.getInstance().getCustomerById(insuredPersonId);
        String cardNumber = data.get(ClaimView.CARD_NUMBER);
        String examDateStr = data.get(ClaimView.EXAM_DATE);
        LocalDate examDate = LocalDate.parse(examDateStr);
        double claimAmount = Double.parseDouble(data.get(ClaimView.CLAIM_AMOUNT));
        ReceiverBankingInfo rbi = ReceiverBankingInfo.promptBankingInfo();
        List<Document> documents = DocumentList.promptDocumentList();

        Claim claim = new Claim(id, claimDate, insuredPerson, cardNumber, examDate, documents, claimAmount, rbi);
        ClaimSet.getInstance().addClaim(claim);
    }
}