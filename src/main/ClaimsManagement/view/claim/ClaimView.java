package view.claim;

import model.Claim;

import java.util.Map;
import java.util.Objects;

public abstract class ClaimView {
    public static final String CLAIM_ID = "CLAIM ID";
    public static final String CLAIM_DATE = "CLAIM_DATE";
    public static final String INSURED_PERSON = "INSURED_PERSON";
    public static final String CARD_NUMBER = "CARD_NUMBER";
    public static final String EXAM_DATE = "EXAM_DATE";
    public static final String DOCUMENTS = "DOCUMENTS";
    public static final String CLAIM_AMOUNT = "CLAIM_AMOUNT";
    public static final String STATUS = "STATUS";
    public static final String RECEIVER_BANK_INFO = "RECEIVER_BANK_INFO";

    public abstract void display(Claim claim);

    public abstract Map<String, Objects> displayNewClaimForm();
}
