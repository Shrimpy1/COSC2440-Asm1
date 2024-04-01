package view.customer;

import model.customer.Customer;
import model.customer.Dependant;
import model.customer.Policyholder;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class PolicyholderConsoleView extends CustomerConsoleView{
    public PolicyholderConsoleView() {
        super();
    }

    @Override
    public void display(Customer policyHolder) {
        System.out.println("Policyholder information: ");
        super.display(policyHolder);
        System.out.println("Dependants: ");

        Set<Dependant> dependants = ((Policyholder) policyHolder).getDependants();
        dependants.forEach(dependant -> System.out.println("- " + dependant.getFullName()));
        System.out.println();
    }

    @Override
    public Map<String, String> displayNewCustomerForm() {
        System.out.println("New Policyholder Form:");
        return super.displayNewCustomerForm();
    }

    public void promptAddDependant(Policyholder policyholder){

    }
}
