/**
 * @author Nguyen Ich Kiet - s3978724
 */
package system.menu;

import controller.claim.ClaimController;
import controller.customer.DependantController;
import controller.customer.PolicyholderController;
import controller.insurance_card.InsuranceCardController;
import model.claim.Claim;
import model.claim.ClaimSet;
import model.customer.Customer;
import model.customer.CustomerSet;
import model.customer.Dependant;
import model.customer.Policyholder;
import model.insurance_card.InsuranceCard;
import model.insurance_card.InsuranceCardSet;
import view.claim.ClaimConsoleView;
import view.customer.DependantConsoleView;
import view.customer.PolicyholderConsoleView;
import view.insurance_card.InsuranceCardConsoleView;

public class ViewMenu extends Menu{
    @Override
    public void initialize() {
        this.options.put(1, "View All Claims");
        this.options.put(2, "View All Customers");
        this.options.put(3, "View All Insurance Cards");
        this.options.put(4, "Return to Main Menu");
    }

    @Override
    public void display(){
        System.out.println("\tVIEW MENU:");
        super.display();
    }

    @Override
    public Menu handleUserInput(String choice) {
        switch (choice) {
            case "View All Claims":
                displayAllClaim();
                break;
            case "View All Customers":
                displayAllCustomer();
                break;
            case "View All Insurance Cards":
                displayAllInsuranceCard();
                break;
            case "Return to Main Menu":
                return new MainMenu();
            default:
                System.out.println("Invalid input.");
                break;
        }
        return this;
    }

    public void displayAllClaim(){
        ClaimController controller = new ClaimController(null, new ClaimConsoleView());
        for (Claim claim : ClaimSet.getInstance().getClaims()){
            controller.setModel(claim);
            controller.displaySummary();
        }
    }

    public void displayAllCustomer(){
        DependantController dependantController = new DependantController(null, new DependantConsoleView());
        PolicyholderController policyholderController = new PolicyholderController(null, new PolicyholderConsoleView());
        for (Customer customer : CustomerSet.getInstance().getCustomers()){
            if (customer instanceof Policyholder){
                policyholderController.setModel(customer);
                policyholderController.displaySummary();
                for (Dependant dependant : ((Policyholder) customer).getDependants()){
                    dependantController.setModel(dependant);
                    dependantController.displaySummary();
                }
            }
        }
    }

    public void displayAllInsuranceCard(){
        InsuranceCardController controller = new InsuranceCardController(null, new InsuranceCardConsoleView());
        for (InsuranceCard card : InsuranceCardSet.getInstance().getInsuranceCards()){
            controller.setModel(card);
            controller.display();
        }
    }
}
