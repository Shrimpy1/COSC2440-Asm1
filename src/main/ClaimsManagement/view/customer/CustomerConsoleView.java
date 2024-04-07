/**
 * @author Nguyen Ich Kiet - s3978724
 */
package view.customer;

import model.claim.Claim;
import model.customer.Customer;
import model.insurance_card.InsuranceCard;
import util.ConsoleInput;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CustomerConsoleView extends CustomerView{
    private final Scanner scanner;

    public CustomerConsoleView() {
        super();
        this.scanner = ConsoleInput.getInstance().getScanner();
    }

    @Override
    public void display(Customer customer) {
        System.out.println("Id: " + customer.getId());
        System.out.println("Full Name: " + customer.getFullName());
        // Handle null value
        InsuranceCard card = customer.getInsuranceCard();
        System.out.println("Insurance Card Number: " + ((card != null)?card.getCardNumber():"None"));
        System.out.println("Claims: ");
        // Handle no claims
        List<Claim> claimList = customer.getClaims();
        if (claimList.isEmpty()){
            System.out.println("This Customer has no Claims.");
        } else {
            for (Claim claim : customer.getClaims()) {
                System.out.println("- " + claim.getId());
            }
        }
    }

    @Override
    public void displaySummary(Customer customer) {
        System.out.println("Id: " + customer.getId());
        System.out.println("Full Name: " + customer.getFullName());
    }

    @Override
    public Map<String, String> displayNewCustomerForm() {
        Map<String, String> data = new HashMap<String, String>();
        System.out.print("Customer Id: ");
        data.put(CUSTOMER_ID, scanner.nextLine());
        System.out.print("Full Name: ");
        data.put(FULL_NAME, scanner.nextLine());
        return data;
    }
}
