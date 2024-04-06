/**
 * @author Nguyen Ich Kiet - s3978724
 */
package system.menu.manage_menu;

import controller.claim.ClaimController;
import model.claim.Claim;
import model.claim.ClaimSet;
import model.customer.Customer;
import system.menu.Menu;
import util.claim_process_manager.CustomerClaimProcessManager;
import view.claim.ClaimConsoleView;

public class CustomerClaimMenu extends Menu {
    private final CustomerClaimProcessManager processManager;
    private final ClaimController claimController;
    public CustomerClaimMenu(Customer customer) {
        super();
        this.processManager = new CustomerClaimProcessManager(customer);
        this.claimController = new ClaimController(null, new ClaimConsoleView());
    }

    @Override
    public void initialize() {
        this.options.put(1, "View all Claims");
        this.options.put(2, "Add Claim");
        this.options.put(3, "Remove Claim");
        this.options.put(4, "Back to Manage Customer Menu");
    }

    @Override
    public void display() {
        System.out.println("\tMANAGE CUSTOMER'S CLAIM LIST:");
        super.display();
    }

    @Override
    public Menu handleUserInput(String choice) {
        switch (choice){
            case "View all Claims":
                viewAllClaim();
                break;
            case "Add Claim":
                addClaim();
                break;
            case "Remove Claim":
                removeClaim();
                break;
            case "Back to Manage Customer Menu":
                return new CustomerMenu();
            default:
                break;
        }
        return this;
    }

    public void viewAllClaim(){
        for (Claim claim : processManager.getAll()){
            claimController.setModel(claim);
            claimController.display();
        };
    }

    public void addClaim(){
        System.out.print("Enter Claim Id: ");
        String claimId = scanner.nextLine();
        Claim claim = ClaimSet.getInstance().getClaimById(claimId);
        processManager.add(claim);
    }

    public void removeClaim(){
        System.out.print("Enter Claim Id: ");
        String claimId = scanner.nextLine();
        Claim claim = processManager.getOne(claimId);
        processManager.remove(claim);
    }
}
