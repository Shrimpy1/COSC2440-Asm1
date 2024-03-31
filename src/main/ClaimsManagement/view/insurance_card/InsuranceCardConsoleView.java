package view.insurance_card;

import model.insurance_card.InsuranceCard;
import util.ConsoleInput;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InsuranceCardConsoleView extends InsuranceCardView{
    public InsuranceCardConsoleView() {
        super();
    }

    @Override
    public void display(InsuranceCard card) {
        System.out.println("\nInsurance Card Information:");
        System.out.println("Card Number: " + card.getCardNumber());
        System.out.println("Card Holder: " + card.getCardHolder().getName());
        System.out.println("Policy Owner: " + card.getPolicyOwner());
        System.out.println("Expiration Date: " + card.getExpirationDate());
    }

    @Override
    public Map<String, String> displayNewInsuranceCardForm() {
        Scanner scanner = ConsoleInput.getInstance().getScanner();
        Map<String, String> data = new HashMap<String, String>();
        System.out.println("--- New Insurance Card Form ---");
        System.out.println("Card number: ");
        data.put(CARD_NUMBER, scanner.nextLine());
        System.out.println("Card holder id: ");
        data.put(CARD_HOLDER_ID, scanner.nextLine());
        System.out.println("Policy owner: ");
        data.put(POLICY_OWNER, scanner.nextLine());
        System.out.println("Expiration date (yyyy-MM-dd): ");
        data.put(EXPIRATION_DATE, scanner.nextLine());
        return data;
    }
}
