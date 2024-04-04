/**
 * @author Nguyen Ich Kiet - s3978724
 */
package controller.customer;

import model.customer.CustomerSet;
import model.customer.Dependant;
import view.customer.CustomerView;
import view.customer.DependantConsoleView;
import java.util.Map;

public class DependantController {
    private Dependant model;
    private DependantConsoleView view;

    public DependantController(Dependant model, DependantConsoleView view) {
        this.model = model;
        this.view = view;
    }

    public void setModel(Dependant model) {
        this.model = model;
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
}
