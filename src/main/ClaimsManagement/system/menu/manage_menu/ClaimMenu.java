/**
 * @author Nguyen Ich Kiet - s3978724
 */
package system.menu.manage_menu;

import controller.claim.ClaimController;
import model.claim.Claim;
import model.claim.ClaimSet;
import system.menu.ManageMenu;
import system.menu.Menu;
import util.claim_process_manager.CustomerClaimProcessManager;
import view.claim.ClaimConsoleView;

public class ClaimMenu extends Menu {
    private final ClaimController controller;

    public ClaimMenu() {
        super();
        this.controller = new ClaimController(null, new ClaimConsoleView());
    }

    @Override
    public void initialize() {
        this.options.put(1, "View Claim Detail");
        this.options.put(2, "Add Claim");
        this.options.put(3, "Update Claim");
        this.options.put(4, "Delete Claim");
        this.options.put(5, "Back to Manage Menu");
    }

    @Override
    public void display() {
        System.out.println("\tMANAGE CLAIM MENU:");
        super.display();
    }

    @Override
    public Menu handleUserInput(String choice) {
        switch (choice){
            case "View Claim Detail":
                getClaimById();
                controller.display();
                break;
            case "Add Claim":
                controller.createNewClaim();
                break;
            case "Update Claim":
                getClaimById();
                controller.updateModel();
                break;
            case "Delete Claim":
                getClaimById();
                CustomerClaimProcessManager claimManager = new CustomerClaimProcessManager(null);
                claimManager.delete(controller.getModel());
                break;
            case "Back to Manage Menu":
                return new ManageMenu();
            default:
                System.out.println("Invalid input.");
                break;
        }
        return this;
    }

    public void getClaimById(){
        Claim claim = null;

        while (claim == null) {
            System.out.print("Enter Claim ID: ");
            String claimId = scanner.nextLine();
            claim = ClaimSet.getInstance().getClaimById(claimId);
        }

        controller.setModel(claim);
    }
}
