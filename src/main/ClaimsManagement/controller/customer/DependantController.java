package controller.customer;

import model.customer.CustomerSet;
import model.customer.Dependant;
import view.customer.CustomerView;
import view.customer.DependantConsoleView;
import java.util.Map;

public class DependantController {
    private Dependant dependant;
    private DependantConsoleView view;

    public DependantController(Dependant dependant, DependantConsoleView view) {
        this.dependant = dependant;
        this.view = view;
    }

    public void createNewDependant(){
        Map<String, String> data = view.displayNewCustomerForm();
        String id = data.get(CustomerView.CUSTOMER_ID);
        String fullName = data.get(CustomerView.FULL_NAME);

        CustomerSet.getInstance().add(new Dependant(id, fullName));
    }
}
