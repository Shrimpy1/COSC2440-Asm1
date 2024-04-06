package controller.customer;

import model.claim.Claim;
import model.customer.Customer;
import view.customer.CustomerView;

import java.util.List;

public interface CustomerController {
    public Customer getModel();

    public void setModel(Customer model);

    public CustomerView getView();

    public void setView(CustomerView view);

    public void display();

    public void displaySummary();

    public void addClaim(Claim claim);

    public void removeClaim(Claim claim);

    public List<Claim> getClaims();
}
