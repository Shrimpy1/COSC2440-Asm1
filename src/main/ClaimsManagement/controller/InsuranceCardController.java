package controller;

import model.customer.Customer;
import model.customer.CustomerSet;
import model.insurance_card.InsuranceCard;
import model.insurance_card.InsuranceCardSet;
import util.ConsoleInput;
import util.DateConverter;
import view.insurance_card.InsuranceCardView;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class InsuranceCardController {
    private final InsuranceCard insuranceCard;
    private final InsuranceCardView view;

    public InsuranceCardController(InsuranceCard insuranceCard, InsuranceCardView view) {
        this.insuranceCard = insuranceCard;
        this.view = view;
    }

    public void createNewInsuranceCardLoop(){
        String answer = "y";
        Scanner scanner = ConsoleInput.getInstance().getScanner();
        while (answer.equalsIgnoreCase("y")) {
            Map<String, String> data = view.displayNewInsuranceCardForm();
            String cardNumber = data.get(InsuranceCardView.CARD_NUMBER);
            String cardHolderId = data.get(InsuranceCardView.CARD_HOLDER_ID);
            String policyOwner = data.get(InsuranceCardView.POLICY_OWNER);
            String expirationDate = data.get(InsuranceCardView.EXPIRATION_DATE);

            Customer cardHolder = CustomerSet.getInstance().getCustomerById(cardHolderId);
            LocalDate ed = DateConverter.stringToLocalDate(expirationDate);

            InsuranceCard insuranceCard = new InsuranceCard(cardNumber, cardHolder, policyOwner, ed);

            view.display(insuranceCard);
            InsuranceCardSet.getInstance().addInsuranceCard(insuranceCard);

            System.out.println("Continue? (y/n): ");
            answer = scanner.nextLine();
        }
    }

    public InsuranceCard getInsuranceCard() {
        return insuranceCard;
    }

    public InsuranceCardView getView() {
        return view;
    }
}
