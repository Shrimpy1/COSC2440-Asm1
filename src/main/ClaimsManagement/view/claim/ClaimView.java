/**
 * @author Nguyen Ich Kiet - s3978724
 */
package view.claim;

import model.claim.Claim;

import java.util.Map;

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

    public ClaimView() {
    }

    public abstract void display(Claim claim);
    public abstract void displaySummary(Claim claim);
    public abstract Map<String, String> displayNewClaimForm();
    public abstract String displayUpdateOptions();
    public abstract String displayStatusOptions();
    public abstract String promptNewInfo(String field);
    public abstract String displayDocumentOptions();
    public abstract void displayOptions(Map<Integer, String> options);
}
