package system.Menu;

import controller.claim.ClaimController;
import model.claim.Claim;
import model.claim.ClaimSet;
import view.claim.ClaimConsoleView;

public class ClaimMenu extends Menu{
    private final ClaimController controller;

    public ClaimMenu() {
        super();
        this.controller = new ClaimController(new Claim(), new ClaimConsoleView());
    }

    @Override
    public void initialize() {
        this.options.put(1, "View Claim");
        this.options.put(2, "Add Claim");
        this.options.put(3, "Update Claim");
        this.options.put(4, "Delete Claim");
        this.options.put(5, "Back to Main Menu");
    }

    public void display() {
        System.out.println("MANAGE CLAIM MENU:");
        displayOptions();
    }

    @Override
    public Menu handleUserInput(int choice) {
        switch (choice){
            case 1:
                viewClaim();
                break;
            case 2:
                controller.createNewClaim();
                break;
            case 3:
                updateClaim();
                break;
            case 4:
                break;
            case 5:
                return new MainMenu();
            default:
                System.out.println("Invalid input.");
                break;
        }
        return this;
    }

    public void viewClaim(){
        System.out.print("Enter Claim ID: ");
        String claimId = scanner.nextLine();
        Claim claim = ClaimSet.getInstance().getClaimById(claimId);
        controller.setModel(claim);
        controller.display();
    }

    public void updateClaim(){
        System.out.print("Enter Claim ID: ");
        String claimId = scanner.nextLine();
        Claim claim = ClaimSet.getInstance().getClaimById(claimId);
        controller.setModel(claim);
        controller.updateModel();
    }
}
