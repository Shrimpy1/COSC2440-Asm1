package controller;

import view.claim.ClaimView;
import model.Claim;

import java.util.List;

public class ClaimController implements ClaimProcessManager {
    private Claim claim;
    private ClaimView view;

    public ClaimController(Claim claim, ClaimView view) {
        this.claim = claim;
        this.view = view;
    }

    @Override
    public boolean add(Claim claim) {
        return false;
    }

    @Override
    public boolean update(Claim claim) {
        return false;
    }

    @Override
    public boolean delete(Claim claim) {
        return false;
    }

    @Override
    public Claim getOne(String id) {
        return null;
    }

    @Override
    public List<Claim> getAll() {
        return null;
    }
}
