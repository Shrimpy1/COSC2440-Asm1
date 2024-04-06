/**
 * @author Nguyen Ich Kiet - s3978724
 */
package controller.customer;

import model.claim.Claim;
import model.customer.Customer;
import model.customer.CustomerSet;
import model.customer.Dependant;
import model.customer.Policyholder;
import view.customer.CustomerView;
import view.customer.PolicyholderConsoleView;

import java.util.List;
import java.util.Map;

public class PolicyholderController implements CustomerController{
    private Policyholder model;
    private PolicyholderConsoleView view;

    public PolicyholderController(Policyholder model, PolicyholderConsoleView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public Customer getModel(){
        return this.model;
    }

    @Override
    public void setModel(Customer model) {
        this.model = (Policyholder) model;
    }

    @Override
    public CustomerView getView(){
        return this.view;
    }

    @Override
    public void setView(CustomerView view) {
        this.view = (PolicyholderConsoleView) view;
    }

    @Override
    public void display(){
        view.display(model);
    }

    @Override
    public void displaySummary() {
        this.view.displaySummary(model);
    }

    @Override
    public void addClaim(Claim claim) {
        this.model.addClaim(claim);
        for (Dependant dependant : this.model.getDependants()){
            dependant.addClaim(claim);
        }
    }

    @Override
    public void removeClaim(Claim claim) {
        this.model.removeClaim(claim);
        for (Dependant dependant : this.model.getDependants()){
            dependant.removeClaim(claim);
        }
    }

    @Override
    public List<Claim> getClaims() {
        return this.model.getClaims();
    }

    public void createNewPolicyHolder(){
        Map<String, String> data = view.displayNewCustomerForm();
        String id = data.get(CustomerView.CUSTOMER_ID);
        String fullName = data.get(CustomerView.FULL_NAME);

        Policyholder policyholder = new Policyholder(id, fullName);

        setModel(model);

        CustomerSet.getInstance().add(this.model);
    }
}
