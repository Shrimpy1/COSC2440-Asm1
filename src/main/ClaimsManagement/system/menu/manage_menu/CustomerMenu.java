/**
 * @author Nguyen Ich Kiet - s3978724
 */
package system.menu.manage_menu;

import controller.customer.CustomerController;
import controller.customer.DependantController;
import controller.customer.PolicyholderController;
import model.customer.Customer;
import model.customer.CustomerSet;
import model.customer.Dependant;
import model.customer.Policyholder;
import system.menu.ManageMenu;
import system.menu.Menu;
import view.customer.DependantConsoleView;
import view.customer.PolicyholderConsoleView;

public class CustomerMenu extends Menu {
    private CustomerController controller;
    public CustomerMenu() {
        super();
    }

    @Override
    public void initialize() {
        this.options.put(1, "View Customer Detail");
        this.options.put(2, "Manage Customer Claim List");
        this.options.put(3, "Back to Manage Menu");
    }

    @Override
    public void display() {
        System.out.println("\tMANAGE CUSTOMER MENU:");
        super.display();
    }

    @Override
    public Menu handleUserInput(String choice) {
        switch (choice){
            case "View Customer Detail":
                controller.display();
                break;
            case "Manage Customer Claim List":
                return new CustomerClaimMenu(controller.getModel());
            case "Back to Manage Menu":
                return new ManageMenu();
            default:
                break;
        }
        return this;
    }

    public void getCustomerById(){
        Customer customer = null;

        while (customer == null) {
            System.out.print("Enter Customer ID: ");
            String customerId = scanner.nextLine();
            customer = CustomerSet.getInstance().getCustomerById(customerId);
        }

        if (customer instanceof Policyholder) {
            this.controller = new PolicyholderController((Policyholder) customer, new PolicyholderConsoleView());
        } else {
            this.controller = new DependantController((Dependant) customer, new DependantConsoleView());
        }
    }
}
