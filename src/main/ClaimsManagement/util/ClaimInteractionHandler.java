/**
 * @author Nguyen Ich Kiet - s3978724
 */
package util;

import model.customer.Customer;
import model.customer.CustomerSet;
import util.claim_process_manager.ClaimProcessManager;

import java.util.Scanner;

public class ClaimInteractionHandler {
    ClaimProcessManager claimManager;

    public ClaimInteractionHandler(ClaimProcessManager claimManager) {
        this.claimManager = claimManager;
    }

    public void addClaimToCustomer(){
        Scanner scanner = ConsoleInput.getInstance().getScanner();
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine();
        Customer customer = CustomerSet.getInstance().getCustomerById(customerId);
        System.out.print("Enter Claim ID: ");
        String claimId = scanner.nextLine();
    }
}
