package view.claim;

import model.claim.Claim;
import util.ConsoleInput;
import java.util.Map;
import java.util.Scanner;

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
        System.out.println("\n");
    }

    @Override
    public Map<String, Object> displayNewClaimForm() {
        Scanner scanner = ConsoleInput.getInstance().getScanner();

        return null;
    }
}
