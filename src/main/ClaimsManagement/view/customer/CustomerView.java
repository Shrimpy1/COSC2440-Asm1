/**
 * @author Nguyen Ich Kiet - s3978724
 */
package view.customer;

import model.customer.Customer;

import java.util.Map;

public abstract class CustomerView {
    public static String CUSTOMER_ID = "CUSTOMER ID";
    public static String FULL_NAME = "FULL NAME";
    public static String INSURANCE_CARD = "INSURANCE CARD";
    public static String CLAIMS = "CLAIMS";

    public CustomerView() {
    }

    public abstract void display(Customer customer);

    public abstract void displaySummary(Customer customer);

    public abstract Map<String, String> displayNewCustomerForm();
}
