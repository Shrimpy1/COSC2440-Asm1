/**
 * @author Nguyen Ich Kiet - s3978724
 */
package system;

import model.claim.ClaimSet;
import model.customer.CustomerSet;
import model.insurance_card.InsuranceCardSet;
import util.ConsoleInput;

import java.util.Scanner;

/**
 * The SYSTEM
 * Include initialize and finalize methods
 */
public class ClaimSystem {
    // Constructor
    public ClaimSystem() {}

    // Load data to the Sets
    public void initialize(){
        CustomerSet.getInstance().loadData();
        InsuranceCardSet.getInstance().loadData();
        ClaimSet.getInstance().loadData();

        System.out.println("--- WELCOME TO CLAIM MANAGEMENT SYSTEM ---");
    }

    // Save data from the Sets
    public void saveData(){
        CustomerSet.getInstance().saveData();
        InsuranceCardSet.getInstance().saveData();
        ClaimSet.getInstance().saveData();
    }

    // Run the system
    public void run(){
        MenuManager menu = new MenuManager();
        menu.run();
    }
}
