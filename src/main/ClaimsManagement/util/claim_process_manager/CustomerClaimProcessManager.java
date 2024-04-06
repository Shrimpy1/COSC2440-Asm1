/**
 * @author Nguyen Ich Kiet - s3978724
 */
package util.claim_process_manager;

import controller.claim.ClaimController;
import controller.customer.CustomerController;
import controller.customer.DependantController;
import controller.customer.PolicyholderController;
import model.claim.Claim;
import model.claim.ClaimSet;
import model.customer.Customer;
import model.customer.CustomerSet;
import model.customer.Dependant;
import model.customer.Policyholder;
import util.ConsoleInput;
import view.claim.ClaimConsoleView;
import view.customer.CustomerConsoleView;
import view.customer.DependantConsoleView;
import view.customer.PolicyholderConsoleView;

import java.util.List;
import java.util.Scanner;

public class CustomerClaimProcessManager implements ClaimProcessManager{
    private final CustomerController controller;
    public CustomerClaimProcessManager(Customer customer) {
        if (customer instanceof Policyholder) {
            this.controller = new PolicyholderController((Policyholder) customer, new PolicyholderConsoleView());
        } else {
            this.controller = new DependantController((Dependant) customer, new DependantConsoleView());
        }
    }

    // Switch to another customer
    public void setCustomer(Customer customer){
        controller.setModel(customer);
    }

    // Add claim to a customer's list
    @Override
    public boolean add(Claim claim) {
        controller.addClaim(claim);
        claim.setInsuredPerson(controller.getModel());
        return true;
    }

    // Update a claim
    @Override
    public boolean update(Claim claim) {
        ClaimController claimController = new ClaimController(claim, new ClaimConsoleView());
        claimController.updateModel();
        return false;
    }

    // Remove claim from a customer's list
    @Override
    public boolean remove(Claim claim) {
        controller.removeClaim(claim);
        claim.setInsuredPerson(null);
        return true;
    }

    // Remove completely from the system
    @Override
    public boolean delete(Claim claim) {
        for (Customer customer : CustomerSet.getInstance().getCustomers()){
            customer.getClaims().remove(claim);
        }
        ClaimSet.getInstance().getClaims().remove(claim);
        System.out.println("Claim deleted from the system.");
        return true;
    }

    // Get one claim by id
    @Override
    public Claim getOne(String id) {
        List<Claim> claimList = controller.getClaims();
        for (Claim claim : claimList)
            if (claim.getId().equals(id)){
                return claim;
            }
        System.out.println("Claim with the id not found.");
        return null;
    }

    // Get all claims
    @Override
    public List<Claim> getAll() {
        return controller.getClaims();
    }
}
