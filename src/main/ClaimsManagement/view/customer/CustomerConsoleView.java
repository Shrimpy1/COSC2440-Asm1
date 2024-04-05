/**
 * @author Nguyen Ich Kiet - s3978724
 */
package view.customer;

import model.claim.Claim;
import model.customer.Customer;
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
        System.out.println("Insurance Card Number: " + customer.getInsuranceCard().getCardNumber());
        System.out.println("Claims: ");
        for (Claim claim : customer.getClaims()) {
            System.out.println("- " + claim.getId());
        }
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
