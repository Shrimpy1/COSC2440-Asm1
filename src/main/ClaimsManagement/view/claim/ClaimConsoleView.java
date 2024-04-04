/**
 * @author Nguyen Ich Kiet - s3978724
 */
package view.claim;

import model.banking_info.BankingInfo;
import model.claim.Claim;
import model.document.Document;
import util.ConsoleInput;
import util.DateConverter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ClaimConsoleView extends ClaimView {
    @Override
    public void display(Claim claim) {
        System.out.println("Claim ID: " + claim.getId());
        System.out.println("Claim Date: " + DateConverter.localDateToString(claim.getClaimDate()));
        System.out.println("Insured Person: " + claim.getInsuredPerson().getFullName());
        System.out.println("Card Number: " + claim.getCardNumber());
        System.out.println("Exam Date: " + DateConverter.localDateToString(claim.getExamDate()));
        List<Document> documentList = claim.getDocuments();
        String documents = documentList.stream().map(Document::getFileName).collect(Collectors.joining(", ")); // Get all Documents name in a string split by ','
        String claimAmount = String.valueOf(claim.getClaimAmount());
        System.out.println("Documents: " + documents);
        System.out.println("Claim Amount: " + claimAmount);
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
