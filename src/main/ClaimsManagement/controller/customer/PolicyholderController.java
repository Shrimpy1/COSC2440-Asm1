/**
 * @author Nguyen Ich Kiet - s3978724
 */
package controller.customer;

import model.customer.CustomerSet;
import model.customer.Policyholder;
import view.customer.CustomerView;
import view.customer.PolicyholderConsoleView;

import java.util.Map;

public abstract class PolicyholderController {
    private Policyholder model;
    private PolicyholderConsoleView view;

    public PolicyholderController(Policyholder model, PolicyholderConsoleView view) {
        this.model = model;
        this.view = view;
    }

    public void setModel(Policyholder model) {
        this.model = model;
    }

    public void setView(PolicyholderConsoleView view) {
        this.view = view;
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
