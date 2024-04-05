/**
 * @author Nguyen Ich Kiet - s3978724
 */
package util.claim_process_manager;

import model.claim.Claim;
import model.customer.Customer;

import java.util.*;
public interface ClaimProcessManager {
    public boolean add(Claim claim, Customer customer);
    public boolean update(Claim claim);
    public boolean delete(Claim claim, Customer customer);
    public Claim getOne(String id, Customer customer);
    public List<Claim> getAll();
}
