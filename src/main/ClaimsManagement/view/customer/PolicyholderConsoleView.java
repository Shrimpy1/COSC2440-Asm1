/**
 * @author Nguyen Ich Kiet - s3978724
 */
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
    public void display(Customer policyholder) {
        System.out.println("\tPolicyholder information: ");
        super.display(policyholder);
        displayDependants((Policyholder) policyholder);
    }

    @Override
    public void displaySummary(Customer policyholder) {
        System.out.println("\tPolicyholder information: ");
        super.displaySummary(policyholder);
        displayDependants((Policyholder) policyholder);
    }

    @Override
    public Map<String, String> displayNewCustomerForm() {
        System.out.println("\tNew Policyholder Form:");
        return super.displayNewCustomerForm();
    }

    public void displayDependants(Policyholder policyholder){
        System.out.println("Dependants: ");

        Set<Dependant> dependantList = policyholder.getDependants();
        if (dependantList.isEmpty()){
            System.out.println("This Policyholder has no dependants.");
        } else {
            dependantList.forEach(dependant -> System.out.println("- " + dependant.getFullName()));
            System.out.println();
        }
    }
}
