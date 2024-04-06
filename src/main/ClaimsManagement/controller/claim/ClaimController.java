/**
 * @author Nguyen Ich Kiet - s3978724
 */
package controller.claim;

import controller.banking_info.BankingInfoController;
import controller.document.DocumentController;
import model.claim.ClaimSet;
import model.customer.Customer;
import model.customer.CustomerSet;
import model.document.Document;
import model.banking_info.BankingInfo;
import util.ConsoleInput;
import util.DateConverter;
import util.claim_process_manager.CustomerClaimProcessManager;
import view.banking_info.BankingInfoConsoleView;
import view.claim.ClaimView;
import model.claim.Claim;
import view.document.DocumentConsoleView;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class ClaimController {
    private Claim model;
    private ClaimView view;

    public ClaimController(Claim model, ClaimView view) {
        this.model = model;
        this.view = view;
    }

    public Claim getModel() {
        return model;
    }

    public ClaimView getView() {
        return view;
    }

    public void setModel(Claim model) {
        this.model = model;
    }

    public void setView(ClaimView view) {
        this.view = view;
    }

    public void setId(String id){
        this.model.setId(id);
    }

    public void setCardNumber(String cardNumber){
        this.model.setCardNumber(cardNumber);
    }

    public void setExamDate(LocalDate examDate){
        this.model.setExamDate(examDate);
    }

    public void setClaimDate(LocalDate claimDate){
        this.model.setClaimDate(claimDate);
    }

    public void setClaimAmount(double claimAmount){
        this.model.setClaimAmount(claimAmount);
    }

    public void createNewClaim(){
        Map<String, String> data = view.displayNewClaimForm();
        String id = data.get(ClaimView.CLAIM_ID);
        String claimDateStr = data.get(ClaimView.CLAIM_DATE);
        LocalDate claimDate = DateConverter.stringToLocalDate(claimDateStr);
        String insuredPersonId = data.get(ClaimView.INSURED_PERSON);
        Customer insuredPerson = CustomerSet.getInstance().getCustomerById(insuredPersonId);
        String cardNumber = data.get(ClaimView.CARD_NUMBER);
        String examDateStr = data.get(ClaimView.EXAM_DATE);
        LocalDate examDate = DateConverter.stringToLocalDate(examDateStr);
        double claimAmount = Double.parseDouble(data.get(ClaimView.CLAIM_AMOUNT));

        Claim claim = new Claim(id, claimDate, cardNumber, examDate, claimAmount);

        setModel(claim);

        addNewDocumentLoop();
        setNewBankingInfo();

        CustomerClaimProcessManager claimManager = new CustomerClaimProcessManager(insuredPerson);
        claimManager.add(claim);

        display();

        ClaimSet.getInstance().addClaim(this.model);
    }

    public void addDocument(Document document){
        this.model.addDocument(document);
    }

    public void removeDocument(Document document){this.model.removeDocument(document);}

    public void addNewDocumentLoop(){
        System.out.println("\tDocuments:");
        Scanner scanner = ConsoleInput.getInstance().getScanner();
        String answer = "y";
        DocumentController dc = new DocumentController(new Document(), new DocumentConsoleView());
        while (answer.equalsIgnoreCase("y")){
            dc.createNewDocument();
            addDocument(dc.getModel());

            System.out.print("Add another one? (y/n): ");
            answer = scanner.nextLine();
            System.out.println();
        }
    }

    public void setBankingInfo(BankingInfo bankingInfo){
        this.model.setReceiverBankingInfo(bankingInfo);
    }

    public void setNewBankingInfo(){
        BankingInfoController bic = new BankingInfoController(new BankingInfo(), new BankingInfoConsoleView());
        bic.promptBankingInfo();
        setBankingInfo(bic.getModel());
    }

    public void setStatusNew(){
        this.model.setStatusNew();
    }

    public void setStatusProcessing(){
        this.model.setStatusProcessing();
    }

    public void setStatusDone(){
        this.model.setStatusDone();
    }

    public void setStatus(String status){
        switch (status){
            case "NEW":
                setStatusNew();
                break;
            case "PROCESSING":
                setStatusProcessing();
                break;
            case "DONE":
                setStatusDone();
                break;
        }
    }

    public void display(){
        view.display(model);
    }

    public void displaySummary(){
        view.displaySummary(model);
    }

    public void updateModel(){
        String choice = view.displayUpdateOptions();
        String data = "";
        switch (choice){
            case "Claim ID":
                data = view.promptNewInfo("Claim ID (format f-10 numbers)");
                setId(data);
                break;
            case "Card Number":
                data = view.promptNewInfo("Card Number");
                setCardNumber(data);
                break;
            case "Claim Date":
                data = view.promptNewInfo("Exam Date (yyyy-MM-dd)");
                setExamDate(DateConverter.stringToLocalDate(data));
                break;
            case "Exam Date":
                data = view.promptNewInfo("Claim Date (yyyy-MM-dd)");
                setClaimDate(DateConverter.stringToLocalDate(data));
                break;
            case "Claim Amount":
                data = view.promptNewInfo("Claim Amount");
                setClaimAmount(Double.parseDouble(data));
                break;
            case "Document":
                updateDocuments();
                break;
            case "Receiver Banking Info":
                setNewBankingInfo();
                break;
            case "Claim Status":
                String status = view.displayStatusOptions();
                setStatus(status);
            default:
                break;
        }
        System.out.println("Claim updated.");
    }

    public void updateDocuments(){
        String  choice = view.displayDocumentOptions();
        switch (choice){
            case "Add Document":
                addNewDocumentLoop();
                break;
            case "Remove Document":
                String newData = view.promptNewInfo("Document File Name");
                Document document = new Document(newData);
                removeDocument(document);
                break;
            default:
                break;
        }
    }
}