/**
 * @author Nguyen Ich Kiet - s3978724
 */
package util.claim_process_manager;

import model.claim.Claim;
import model.customer.Customer;
import model.customer.CustomerSet;
import util.ConsoleInput;

import java.util.List;
import java.util.Scanner;

public class CustomerClaimProcessManager implements ClaimProcessManager{
    public CustomerClaimProcessManager() {
    }

    @Override
    public boolean add(Claim claim, Customer customer) {
        customer.addClaim(claim);
        claim.setInsuredPerson(customer);
        return false;
    }

    @Override
    public boolean update(Claim claim) {
        return false;
    }

    @Override
    public boolean delete(Claim claim, Customer customer) {
        return false;
    }

    @Override
    public Claim getOne(String id, Customer customer) {
        return null;
    }

    @Override
    public List<Claim> getAll() {
        return null;
    }
}
