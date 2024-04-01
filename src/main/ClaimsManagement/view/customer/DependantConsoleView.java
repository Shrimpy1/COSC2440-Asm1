package view.customer;

import model.customer.Customer;

import java.util.Map;

public class DependantConsoleView extends CustomerConsoleView{
    public DependantConsoleView() {
        super();
    }

    @Override
    public void display(Customer dependant) {
        System.out.println("Dependant information: ");
        super.display(dependant);
    }

    @Override
    public Map<String, String> displayNewCustomerForm() {
        System.out.println("New Dependant Form:");
        return super.displayNewCustomerForm();
    }
}
