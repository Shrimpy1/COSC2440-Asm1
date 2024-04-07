/**
 * @author Nguyen Ich Kiet - s3978724
 */
package system.menu.manage_menu;

import controller.claim.ClaimController;
import model.claim.Claim;
import model.claim.ClaimSet;
import model.customer.Customer;
import system.menu.Menu;
import util.ConsoleInput;
import util.claim_process_manager.CustomerClaimProcessManager;
import view.claim.ClaimConsoleView;

import java.util.List;
import java.util.Scanner;

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
        List<Claim> claimList = processManager.getAll();

        if (claimList.isEmpty()){
            System.out.println("This customer currently has no Claims.");
        } else {
            for (Claim claim : claimList){
                claimController.setModel(claim);
                claimController.display();
            }
        };
    }

    public void addClaim(){
        Scanner scanner = ConsoleInput.getInstance().getScanner();
        Claim claim = null;

        while (claim == null){
            System.out.print("Enter Claim Id: ");
            String claimId = scanner.nextLine();
            claim = ClaimSet.getInstance().getClaimById(claimId);
        }

        processManager.add(claim);
        System.out.println("Claim has been added to the Customer.");
    }

    public void removeClaim(){
        Scanner scanner = ConsoleInput.getInstance().getScanner();
        Claim claim = null;
        while (claim == null){
            System.out.print("Enter Claim Id: ");
            String claimId = scanner.nextLine();
            claim = processManager.getOne(claimId);
        }

        processManager.remove(claim);
        System.out.println("Claim has been removed from the Customer.");
    }
}
