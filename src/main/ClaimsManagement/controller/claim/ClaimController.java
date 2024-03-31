package controller.claim;

import view.claim.ClaimView;
import model.claim.Claim;

import java.util.List;

public class ClaimController {
    private Claim claim;
    private ClaimView view;

    public ClaimController(Claim claim, ClaimView view) {
        this.claim = claim;
        this.view = view;
    }
}