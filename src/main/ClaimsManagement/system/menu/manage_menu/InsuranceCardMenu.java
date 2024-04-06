/**
 * @author Nguyen Ich Kiet - s3978724
 */
package system.menu.manage_menu;

import controller.insurance_card.InsuranceCardController;
import model.insurance_card.InsuranceCard;
import model.insurance_card.InsuranceCardSet;
import system.menu.ManageMenu;
import system.menu.Menu;
import view.insurance_card.InsuranceCardConsoleView;

public class InsuranceCardMenu extends Menu {
    private InsuranceCardController controller;

    public InsuranceCardMenu() {
        super();
    }

    @Override
    public void initialize() {
        this.options.put(1, "View Card Detail");
        this.options.put(2, "Back to Manage Menu");

        System.out.print("Enter Insurance Card Number: ");
        InsuranceCard card = InsuranceCardSet.getInstance().getInsuranceCardByNumber(scanner.nextLine());
        this.controller = new InsuranceCardController(card, new InsuranceCardConsoleView());
    }

    @Override
    public void display() {
        System.out.println("\tMANAGE CLAIM MENU:");
        super.display();
    }

    @Override
    public Menu handleUserInput(String choice) {
        switch (choice){
            case "View Claim":
                controller.display();
                break;
            case "Back to Manage Menu":
                return new ManageMenu();
            default:
                System.out.println("Invalid input.");
                break;
        }
        return this;
    }
}
