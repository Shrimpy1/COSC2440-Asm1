/**
 * @author Nguyen Ich Kiet - s3978724
 */
package controller.customer;

import model.claim.Claim;
import model.customer.Customer;
import model.customer.CustomerSet;
import model.customer.Dependant;
import view.customer.CustomerView;
import view.customer.DependantConsoleView;

import java.util.List;
import java.util.Map;

public class DependantController implements CustomerController{
    private Dependant model;
    private DependantConsoleView view;

    public DependantController(Dependant model, DependantConsoleView view) {
        this.model = model;
        this.view = view;
    }

    public void setView(DependantConsoleView view) {
        this.view = view;
    }

    public void createNewDependant(){
        Map<String, String> data = view.displayNewCustomerForm();
        String id = data.get(CustomerView.CUSTOMER_ID);
        String fullName = data.get(CustomerView.FULL_NAME);

        Dependant dependant = new Dependant(id, fullName);

        setModel(dependant);

        CustomerSet.getInstance().add(this.model);
    }

    @Override
    public Customer getModel() {
        return model;
    }

    @Override
    public void setModel(Customer model) {
        this.model = (Dependant) model;
    }

    @Override
    public CustomerView getView() {
        return view;
    }

    @Override
    public void setView(CustomerView view) {
        this.view = (DependantConsoleView) view;
    }

    @Override
    public void display() {
        this.view.display(model);
    }

    @Override
    public void displaySummary() {
        this.view.displaySummary(model);
    }

    @Override
    public void addClaim(Claim claim) {
        this.model.addClaim(claim);
    }

    @Override
    public void removeClaim(Claim claim) {
        this.model.removeClaim(claim);
    }

    @Override
    public List<Claim> getClaims() {
        return this.model.getClaims();
    }
}
