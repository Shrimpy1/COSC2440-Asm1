/**
 * @author Nguyen Ich Kiet - s3978724
 */
package view.insurance_card;

import model.insurance_card.InsuranceCard;
import util.ConsoleInput;
import util.DateConverter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InsuranceCardConsoleView extends InsuranceCardView{
    private final Scanner scanner;
    public InsuranceCardConsoleView() {
        super();
        this.scanner = ConsoleInput.getInstance().getScanner();
    }

    @Override
    public void display(InsuranceCard card) {
        System.out.println("\tInsurance Card Information:");
        System.out.println("Card Number: " + card.getCardNumber());
        System.out.println("Card Holder: " + card.getCardHolder().getFullName());
        System.out.println("Policy Owner: " + card.getPolicyOwner().getName());
        System.out.println("Expiration Date: " + DateConverter.localDateToString(card.getExpirationDate()));
        System.out.println();
    }

    @Override
    public Map<String, String> displayNewInsuranceCardForm() {
        Map<String, String> data = new HashMap<String, String>();
        System.out.println("New Insurance Card Form:");
        System.out.print("Card number: ");
        data.put(CARD_NUMBER, scanner.nextLine());
        System.out.print("Card holder id: ");
        data.put(CARD_HOLDER_ID, scanner.nextLine());
        System.out.print("Policy owner: ");
        data.put(POLICY_OWNER, scanner.nextLine());
        System.out.print("Expiration date (yyyy-MM-dd): ");
        data.put(EXPIRATION_DATE, scanner.nextLine());
        return data;
    }
}
