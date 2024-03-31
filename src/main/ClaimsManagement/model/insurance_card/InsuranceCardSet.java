package model.insurance_card;

import java.util.HashSet;
import java.util.Set;

public class InsuranceCardSet {
    private static InsuranceCardSet instance;
    private Set<InsuranceCard> insuranceCards;

    public InsuranceCardSet() {
        this.insuranceCards = new HashSet<InsuranceCard>();
    }

    public static InsuranceCardSet getInstance(){
        if (instance == null){
            instance = new InsuranceCardSet();
        }
        return instance;
    }

    public boolean addInsuranceCard(InsuranceCard insuranceCard){
        return insuranceCards.add(insuranceCard);
    }

    public boolean removeInsuranceCard(InsuranceCard insuranceCard){
        return insuranceCards.remove(insuranceCard);
    }

    public Set<InsuranceCard> getInsuranceCards() {
        return insuranceCards;
    }

    public InsuranceCard getInsuranceCardByNumber(String cardNumber){
        for (InsuranceCard card : this.insuranceCards){
            if (card.getCardNumber() == cardNumber) return card;
        }
        System.out.println("Card with the number not found.");
        return null;
    }
}
