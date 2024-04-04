/**
 * @author Nguyen Ich Kiet - s3978724
 */
package controller.insurance_card;

import model.customer.Customer;
import model.customer.CustomerSet;
import model.insurance_card.InsuranceCard;
import model.insurance_card.InsuranceCardSet;
import model.policy_owner.PolicyOwner;
import util.DateConverter;
import view.insurance_card.InsuranceCardView;

import java.time.LocalDate;
import java.util.Map;

public class InsuranceCardController {
    private InsuranceCard model;
    private InsuranceCardView view;

    public InsuranceCardController(InsuranceCard model, InsuranceCardView view) {
        this.model = model;
        this.view = view;
    }

    public void setModel(InsuranceCard model) {
        this.model = model;
    }

    public void setView(InsuranceCardView view) {
        this.view = view;
    }

    public void createNewInsuranceCard(){
        Map<String, String> data = view.displayNewInsuranceCardForm();
        String cardNumber = data.get(InsuranceCardView.CARD_NUMBER);
        String cardHolderId = data.get(InsuranceCardView.CARD_HOLDER_ID);
        String policyOwnerName = data.get(InsuranceCardView.POLICY_OWNER);
        String expirationDate = data.get(InsuranceCardView.EXPIRATION_DATE);

        Customer cardHolder = CustomerSet.getInstance().getCustomerById(cardHolderId);
        PolicyOwner policyOwner = new PolicyOwner(policyOwnerName);
        LocalDate ed = DateConverter.stringToLocalDate(expirationDate);

        InsuranceCard insuranceCard = new InsuranceCard(cardNumber, null, policyOwner, ed);

        cardHolder.setInsuranceCard(insuranceCard);

        view.display(insuranceCard);

        setModel(insuranceCard);

        InsuranceCardSet.getInstance().addInsuranceCard(this.model);
    }

    public InsuranceCard getModel() {
        return model;
    }

    public InsuranceCardView getView() {
        return view;
    }
}
