/**
 * @author Nguyen Ich Kiet - s3978724
 */
import controller.claim.ClaimController;
import controller.insurance_card.InsuranceCardController;
import model.claim.Claim;
import model.claim.ClaimSet;
import model.customer.CustomerSet;
import model.customer.Dependant;
import model.insurance_card.InsuranceCard;
import model.insurance_card.InsuranceCardSet;
import system.ClaimSystem;
import view.claim.ClaimConsoleView;
import view.customer.CustomerConsoleView;
import view.customer.DependantConsoleView;
import view.customer.PolicyholderConsoleView;
import view.insurance_card.InsuranceCardConsoleView;

public class Main {
    public static void main(String[] args) {
        ClaimSystem system = new ClaimSystem();
        system.initialize();
        system.run();
        system.saveData();
    }
}