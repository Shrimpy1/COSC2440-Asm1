/**
 * @author Nguyen Ich Kiet - s3978724
 */
package system;

import model.claim.ClaimSet;
import model.customer.CustomerSet;
import model.insurance_card.InsuranceCardSet;
import util.ConsoleInput;

import java.util.Scanner;

public class ClaimSystem {
    private Scanner scanner;
    public ClaimSystem() {
        this.scanner = ConsoleInput.getInstance().getScanner();
    }

    public void initialize(){
        CustomerSet.getInstance().loadData();
        InsuranceCardSet.getInstance().loadData();
        ClaimSet.getInstance().loadData();
    }

    public void saveData(){
        CustomerSet.getInstance().saveData();
        InsuranceCardSet.getInstance().saveData();
        ClaimSet.getInstance().saveData();
    }

    public void run(){
        MenuManager menu = new MenuManager();
        menu.run();
    }
}
