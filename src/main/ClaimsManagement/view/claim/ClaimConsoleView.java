package view.claim;

import model.Claim;

import java.util.Map;
import java.util.Objects;

public class ClaimConsoleView extends ClaimView {
    @Override
    public void display(Claim claim) {
        System.out.println("Claim ID: " + claim.getId());
        System.out.println("Claim Date: " + claim.getClaimDate());
        System.out.println("Insured Person: " + claim.getInsuredPerson());
        System.out.println("Card Number: " + claim.getCardNumber());
        System.out.println("Exam Date: " + claim.getExamDate());
        System.out.println("Documents: " + claim.getDocuments());
        System.out.println("Claim Amount: " + claim.getClaimAmount());
        System.out.println("Receiver Banking Info: " + claim.getReceiverBankingInfo());
    }

    @Override
    public Map<String, Objects> displayNewClaimForm() {

        return null;
    }
}
