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

/**
 * Utility class for handling operation for a Customer's claim list
 */
public class CustomerClaimProcessManager implements ClaimProcessManager{
    private CustomerController controller; // Inject a controller for Customer CRUD methods

    /**
     * Constructor
     * Choose a controller depending on the processing customer
     * @param customer processing customer
     */
    public CustomerClaimProcessManager(Customer customer) {
        if (customer instanceof Policyholder) {
            this.controller = new PolicyholderController((Policyholder) customer, new PolicyholderConsoleView());
        } else {
            this.controller = new DependantController((Dependant) customer, new DependantConsoleView());
        }
    }

    /**
     * Set to a new Customer to process
     * Create a new controller depending on the new Customer class
     * @param customer Customer object. Can be either a Dependant or Policyholder
     */
    public void setCustomer(Customer customer){
        if (customer instanceof Policyholder) {
            this.controller = new PolicyholderController(null, new PolicyholderConsoleView());
        } else {
            this.controller = new DependantController(null, new DependantConsoleView());
        }
        controller.setModel(customer);
    }

    /**
     * Add a Claim to processing Customer
     * @param claim Claim object
     * @return true
     */
    @Override
    public boolean add(Claim claim) {
        controller.addClaim(claim);
        claim.setInsuredPerson(controller.getModel());
        return true;
    }

    /**
     * Update a claim. This will affect all Customer with the Claim
     * @param claim Claim object
     * @return true
     */
    @Override
    public boolean update(Claim claim) {
        ClaimController claimController = new ClaimController(claim, new ClaimConsoleView());
        claimController.updateModel();
        return true;
    }

    /**
     * Remove a claim to processing Customer
     * @param claim Claim object
     * @return true
     */
    @Override
    public boolean remove(Claim claim) {
        controller.removeClaim(claim);
        claim.setInsuredPerson(null);
        return true;
    }

    /**
     * Remove a Claim completely from the system
     * @param claim Claim object
     * @return true
     */
    @Override
    public boolean delete(Claim claim) {
        for (Customer customer : CustomerSet.getInstance().getCustomers()){
            customer.getClaims().remove(claim);
        }
        ClaimSet.getInstance().getClaims().remove(claim);
        System.out.println("Claim deleted from the system.");
        return true;
    }

    /**
     * Search from the Customer's claim list and return a Claim with input ID
     * @param id String
     * @return Claim object with the id
     */
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

    /**
     * Get the entirety of the Customer's claim list
     * @return List<Claim> of the Customer
     */
    @Override
    public List<Claim> getAll() {
        return controller.getClaims();
    }
}
