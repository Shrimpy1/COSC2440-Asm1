/**
 * @author Nguyen Ich Kiet - s3978724
 */
import controller.insurance_card.InsuranceCardController;
import model.customer.CustomerSet;
import model.customer.Dependant;
import model.insurance_card.InsuranceCard;
import model.insurance_card.InsuranceCardSet;
import view.customer.CustomerConsoleView;
import view.customer.DependantConsoleView;
import view.customer.PolicyholderConsoleView;
import view.insurance_card.InsuranceCardConsoleView;

public class Main {
    public static void main(String[] args) {
//        InsuranceCard i1 = new InsuranceCard();
//
//        FileHandler fh = FileHandler.getInstance();
//
//        fh.writeData("InsuranceCard", i1);
//        Dependant d1 = new Dependant("123", "John");
//        PolicyHolder p1 = new PolicyHolder("123", "Son");
//
//        System.out.println(d1.equals(p1));
//        PolicyHolder kiet = new PolicyHolder("123", "kiet");
//        Dependant tan = new Dependant("012", "tan");
//        kiet.addDependant(tan);
//
//        CustomerSet.getInstance().add(kiet);
//        CustomerSet.getInstance().add(tan);
//
//        CustomerSet.getInstance().saveData();

        CustomerSet.getInstance();
        InsuranceCardSet.getInstance();

        DependantConsoleView dview = new DependantConsoleView();
        PolicyholderConsoleView pview = new PolicyholderConsoleView();
        System.out.println(CustomerSet.getInstance().getCustomers().size());
        CustomerSet.getInstance().getCustomers().forEach(customer -> {
            if (customer instanceof Dependant){
                dview.display(customer);
            } else {
                pview.display(customer);
            }
        });

        InsuranceCardController icc = new InsuranceCardController(new InsuranceCard(), new InsuranceCardConsoleView());

//        icc.createNewInsuranceCard();

        for (InsuranceCard card : InsuranceCardSet.getInstance().getInsuranceCards()){
            icc.getView().display(card);
        }

        CustomerSet.getInstance().saveData();
        InsuranceCardSet.getInstance().saveData();
//
//        FileHandler.getInstance().writeObjectToFile("customer", CustomerSet.getInstance().getCustomers());
//        FileHandler.getInstance().writeObjectToFile("insurance_card.txt", InsuranceCardSet.getInstance().getInsuranceCards());

//        CustomerSet.getInstance().getCustomers().forEach(customer -> );
    }
}