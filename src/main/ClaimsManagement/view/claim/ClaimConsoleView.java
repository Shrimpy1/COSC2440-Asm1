/**
 * @author Nguyen Ich Kiet - s3978724
 */
package view.claim;

import model.banking_info.BankingInfo;
import model.claim.Claim;
import model.document.Document;
import util.ConsoleInput;
import util.DateConverter;

import java.util.*;
import java.util.stream.Collectors;

public class ClaimConsoleView extends ClaimView {
    private final Scanner scanner;

    public ClaimConsoleView() {
        super();
        this.scanner = ConsoleInput.getInstance().getScanner();
    }

    @Override
    public void display(Claim claim) {
        System.out.println("\tClaim Information:");
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

    @Override
    public int displayUpdateOptions(){
        System.out.println("Choose an option to update: ");
        Map<Integer, String> options = new TreeMap<Integer, String>();
        options.put(1, "Claim ID");
        options.put(2, "Card Number");
        options.put(3, "Claim Date");
        options.put(4, "Exam Date");
        options.put(5, "Claim Amount");
        options.put(6, "Document");
        options.put(7, "Receiver Banking Info");
        displayOptions(options);
        System.out.print("Enter your choice (0 to return): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    @Override
    public String promptNewInfo(String field){
        System.out.printf("Enter new %s:", field);
        return scanner.nextLine();
    }

    @Override
    public int displayDocumentOptions() {
        System.out.println("Choose an option: ");
        Map<Integer, String> options = new TreeMap<Integer, String>();
        options.put(1, "Add Document");
        options.put(2, "Remove Document");
        displayOptions(options);

        System.out.print("Enter your choice (0 to return): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    @Override
    public void displayOptions(Map<Integer, String> options) {
        for (Integer key : options.keySet()){
            System.out.printf("%d. %s%n", key, options.get(key));
        }
    }
}
