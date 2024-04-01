package controller.customer;

import model.customer.CustomerSet;
import model.customer.Policyholder;
import view.customer.CustomerView;
import view.customer.PolicyholderConsoleView;

import java.util.Map;

public abstract class PolicyholderController {
    private Policyholder policyHolder;
    private PolicyholderConsoleView view;

    public PolicyholderController(Policyholder policyHolder, PolicyholderConsoleView view) {
        this.policyHolder = policyHolder;
        this.view = view;
    }

    public void createNewPolicyHolder(){
        Map<String, String> data = view.displayNewCustomerForm();
        String id = data.get(CustomerView.CUSTOMER_ID);
        String fullName = data.get(CustomerView.FULL_NAME);

        CustomerSet.getInstance().add(new Policyholder(id, fullName));
    }
}