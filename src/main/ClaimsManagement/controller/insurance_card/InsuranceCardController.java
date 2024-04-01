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
    private final InsuranceCard insuranceCard;
    private final InsuranceCardView view;

    public InsuranceCardController(InsuranceCard insuranceCard, InsuranceCardView view) {
        this.insuranceCard = insuranceCard;
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

        InsuranceCardSet.getInstance().addInsuranceCard(insuranceCard);
    }

    public InsuranceCard getInsuranceCard() {
        return insuranceCard;
    }

    public InsuranceCardView getView() {
        return view;
    }
}
