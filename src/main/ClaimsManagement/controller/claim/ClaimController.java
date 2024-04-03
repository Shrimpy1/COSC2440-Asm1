package controller.claim;

import controller.document.DocumentController;
import model.claim.ClaimSet;
import model.customer.Customer;
import model.customer.CustomerSet;
import model.document.Document;
import model.banking_info.BankingInfo;
import util.ConsoleInput;
import view.claim.ClaimView;
import model.claim.Claim;
import view.document.DocumentConsoleView;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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
        BankingInfo rbi = BankingInfo.promptBankingInfo();

        Claim claim = new Claim(id, claimDate, insuredPerson, cardNumber, examDate, claimAmount);
        setClaim(claim);

        addNewDocumentLoop();

        ClaimSet.getInstance().addClaim(this.claim);
    }

    public void addDocument(Document document){
        this.claim.addDocument(document);
    }

    public void addNewDocumentLoop(){
        Scanner scanner = ConsoleInput.getInstance().getScanner();
        String answer = "y";
        DocumentController dc = new DocumentController(new Document(), new DocumentConsoleView());
        while (answer.equalsIgnoreCase("y")){
            dc.createNewDocument();
            addDocument(dc.getDocument());

            System.out.print("Add another one? (y/n): ");
            answer = scanner.nextLine();
            System.out.println();
        }
    }
}