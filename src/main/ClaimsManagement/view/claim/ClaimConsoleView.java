package view.claim;

import model.claim.Claim;
import util.ConsoleInput;

import java.util.HashMap;
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
    public Map<String, String> displayNewClaimForm() {
        Scanner scanner = ConsoleInput.getInstance().getScanner();
        Map<String, String> data = new HashMap<String, String>();
        System.out.println("\tNew Claim Form: ");
        System.out.print("Claim ID (format f-10 number): ");
        data.put(CLAIM_ID, scanner.nextLine());
        System.out.print("Claim Date (yyyy-MM-dd): ");
        data.put(CLAIM_DATE, scanner.nextLine());
        System.out.print("Insured Person ID: ");
        data.put(INSURED_PERSON, scanner.nextLine());
        System.out.print("Card Number: ");
        data.put(CARD_NUMBER, scanner.nextLine());
        System.out.print("Exam Date (yyyy-MM-dd): ");
        data.put(EXAM_DATE, scanner.nextLine());
        System.out.print("Claim Amount: ");
        data.put(CLAIM_AMOUNT, scanner.nextLine());
        return data;
    }
}
