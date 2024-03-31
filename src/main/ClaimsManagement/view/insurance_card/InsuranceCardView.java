package view.insurance_card;

import model.insurance_card.InsuranceCard;
import java.util.Map;

public abstract class InsuranceCardView {
    public static final String CARD_NUMBER = "CARD NUMBER";
    public static final String CARD_HOLDER_ID = "CARD HOLDER ID";
    public static final String POLICY_OWNER = "POLICY OWNER";
    public static final String EXPIRATION_DATE = "EXPIRATION DATE";

    public InsuranceCardView() {
    }

    public abstract void display(InsuranceCard card);

    public abstract Map<String, String> displayNewInsuranceCardForm();
}
