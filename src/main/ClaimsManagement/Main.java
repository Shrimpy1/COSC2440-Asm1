/**
 * @author Nguyen Ich Kiet - s3978724
 */
import controller.InsuranceCardController;
import model.customer.Customer;
import model.customer.CustomerSet;
import model.customer.Dependant;
import model.customer.PolicyHolder;
import model.insurance_card.InsuranceCard;
import model.insurance_card.InsuranceCardSet;
import util.FileHandler;
import view.insurance_card.InsuranceCardConsoleView;
import view.insurance_card.InsuranceCardView;

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
        Customer kiet = new PolicyHolder("123", "kiet");
        CustomerSet.getInstance().add(kiet);

        InsuranceCardController icc = new InsuranceCardController(new InsuranceCard(), new InsuranceCardConsoleView());

        icc.createNewInsuranceCardLoop();

        for (InsuranceCard card : InsuranceCardSet.getInstance().getInsuranceCards()){
            icc.getView().display(card);
        }

        FileHandler.getInstance().writeData("customer", CustomerSet.getInstance().getCustomers());
        FileHandler.getInstance().writeData("insurance_card", InsuranceCardSet.getInstance().getInsuranceCards());
    }
}