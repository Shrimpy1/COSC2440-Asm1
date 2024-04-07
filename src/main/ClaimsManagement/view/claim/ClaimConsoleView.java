/**
 * @author Nguyen Ich Kiet - s3978724
 */
package view.claim;

import model.claim.Claim;
import model.customer.Customer;
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
        System.out.println("Status: " + claim.getStatus());
        System.out.println("Claim ID: " + claim.getId());
        System.out.println("Claim Date: " + DateConverter.localDateToString(claim.getClaimDate()));
        // Handle null value
        Customer insuredPerson = claim.getInsuredPerson();
        System.out.println("Insured Person: " + ((insuredPerson != null)?insuredPerson.getFullName():"none"));
        System.out.println("Card Number: " + claim.getCardNumber());
        System.out.println("Exam Date: " + DateConverter.localDateToString(claim.getExamDate()));
        List<Document> documentList = claim.getDocuments();
        String documents = documentList.stream().map(Document::getFileName).collect(Collectors.joining(", ")); // Get all Documents name in a string split by ','
        System.out.println("Documents: " + documents);
        String claimAmount = String.valueOf(claim.getClaimAmount());
        System.out.println("Claim Amount: " + claimAmount);
        System.out.println("Receiver Banking Info: " + claim.getReceiverBankingInfo());
        System.out.println();
    }

    @Override
    public void displaySummary(Claim claim) {
        System.out.println("\tClaim Information:");
        System.out.println("Claim ID: " + claim.getId());
        System.out.println("Insured Person: " + claim.getInsuredPerson().getFullName());
        System.out.println("Card Number: " + claim.getCardNumber());
        String claimAmount = String.valueOf(claim.getClaimAmount());
        System.out.println("Claim Amount: " + claimAmount);
        System.out.println();
    }

    @Override
    public Map<String, String> displayNewClaimForm() {
        Map<String, String> data = new HashMap<String, String>();
        System.out.println("\tNew Claim Form: ");
        data.put(CLAIM_ID, promptNewInfo("Claim ID (format f-10 number)"));
        data.put(CLAIM_DATE, promptNewInfo("Claim Date (yyyy-MM-dd)"));
        data.put(INSURED_PERSON, promptNewInfo("Insured Person ID"));
        data.put(CARD_NUMBER, promptNewInfo("Card Number"));
        data.put(EXAM_DATE, promptNewInfo("Exam Date (yyyy-MM-dd)"));
        data.put(CLAIM_AMOUNT, promptNewInfo("Claim Amount"));
        return data;
    }

    @Override
    public String displayUpdateOptions(){
        System.out.println("Choose an option to update: ");
        Map<Integer, String> options = new TreeMap<Integer, String>();
        options.put(1, "Claim ID");
        options.put(2, "Claim Status");
        options.put(3, "Card Number");
        options.put(4, "Claim Date");
        options.put(5, "Exam Date");
        options.put(6, "Claim Amount");
        options.put(7, "Document");
        options.put(8, "Receiver Banking Info");
        displayOptions(options);
        System.out.print("Enter your choice (0 to return): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return options.get(choice);
    }

    @Override
    public String displayStatusOptions() {
        System.out.println("Choose a status: ");
        Map<Integer, String> options = new TreeMap<Integer, String>();
        options.put(1, "NEW");
        options.put(2, "PROCESSING");
        options.put(3, "DONE");
        System.out.print("Enter your choice (0 to return): ");
        displayOptions(options);
        int choice = scanner.nextInt();
        scanner.nextLine();
        return options.get(choice);
    }

    @Override
    public String promptNewInfo(String field){
        System.out.printf("Enter new %s:", field);
        return scanner.nextLine();
    }

    @Override
    public String displayDocumentOptions() {
        System.out.println("Choose an option: ");
        Map<Integer, String> options = new TreeMap<Integer, String>();
        options.put(1, "Add Document");
        options.put(2, "Remove Document");
        displayOptions(options);

        System.out.print("Enter your choice (0 to return): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return options.get(choice);
    }

    @Override
    public void displayOptions(Map<Integer, String> options) {
        for (Integer key : options.keySet()){
            System.out.printf("%d. %s%n", key, options.get(key));
        }
    }
}
