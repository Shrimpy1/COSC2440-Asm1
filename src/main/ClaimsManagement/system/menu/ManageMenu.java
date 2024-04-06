/**
 * @author Nguyen Ich Kiet - s3978724
 */
package system.menu;

import system.menu.manage_menu.ClaimMenu;
import system.menu.manage_menu.CustomerMenu;
import system.menu.manage_menu.InsuranceCardMenu;

public class ManageMenu extends Menu{
    @Override
    public void initialize() {
        this.options.put(1, "Manage Claims");
        this.options.put(2, "Manage Customers");
        this.options.put(3, "Manage Insurance Cards");
        this.options.put(4, "Return to Main Menu");
    }

    @Override
    public void display() {
        System.out.println("\tMANAGE MENU:");
        super.display();
    }

    @Override
    public Menu handleUserInput(String choice) {
        switch (choice) {
            case "Manage Claims":
                return new ClaimMenu();
            case "Manage Customers":
                return new CustomerMenu();
            case "Manage Insurance Cards":
                return new InsuranceCardMenu();
            case "Return to Main Menu":
                return new MainMenu();
            default:
                System.out.println("Invalid input.");
                break;
        }
        return this;
    }
}
