/**
 * @author Nguyen Ich Kiet - s3978724
 */
package system.menu.manage_menu;

import controller.insurance_card.InsuranceCardController;
import model.claim.Claim;
import model.claim.ClaimSet;
import model.insurance_card.InsuranceCard;
import model.insurance_card.InsuranceCardSet;
import system.menu.ManageMenu;
import system.menu.Menu;
import util.ConsoleInput;
import view.insurance_card.InsuranceCardConsoleView;

import java.util.Scanner;

public class InsuranceCardMenu extends Menu {
    private InsuranceCardController controller;

    public InsuranceCardMenu() {
        super();
        this.controller = new InsuranceCardController(null, new InsuranceCardConsoleView());
    }

    @Override
    public void initialize() {
        this.options.put(1, "View Card Detail");
        this.options.put(2, "Back to Manage Menu");
    }

    @Override
    public void display() {
        System.out.println("\tMANAGE CLAIM MENU:");
        super.display();
    }

    @Override
    public Menu handleUserInput(String choice) {
        switch (choice){
            case "View Card Detail":
                getInsuranceCardByNumber();
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

    public void getInsuranceCardByNumber(){
        InsuranceCard card = null;

        while (card == null) {
            Scanner scanner = ConsoleInput.getInstance().getScanner();
            System.out.print("Enter Insurance Card ID: ");
            String cardNumber = scanner.nextLine();
            card = InsuranceCardSet.getInstance().getInsuranceCardByNumber(cardNumber);
        }

        controller.setModel(card);
    }
}
