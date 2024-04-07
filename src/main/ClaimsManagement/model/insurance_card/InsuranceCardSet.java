/**
 * @author Nguyen Ich Kiet - s3978724
 */
package model.insurance_card;

import com.google.gson.reflect.TypeToken;
import model.claim.Claim;
import util.FileHandler;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * This singleton class act as the database for InsuranceCard objects
 * Includes save & load data to/from files methods
 */
public class InsuranceCardSet {
    private static InsuranceCardSet instance; // Global instance
    private Set<InsuranceCard> insuranceCards;

    public InsuranceCardSet() {
        this.insuranceCards = new HashSet<InsuranceCard>();
    }

    /**
     * Get global instance
     * If no instance exist, construct one.
     */
    public static InsuranceCardSet getInstance(){
        if (instance == null){
            instance = new InsuranceCardSet();
        }
        return instance;
    }

    // Add to database
    public boolean addInsuranceCard(InsuranceCard insuranceCard){
        return insuranceCards.add(insuranceCard);
    }

    //Remove from database
    public boolean removeInsuranceCard(InsuranceCard insuranceCard){
        return insuranceCards.remove(insuranceCard);
    }

    // Get all InsuranceCards
    public Set<InsuranceCard> getInsuranceCards() {
        return insuranceCards;
    }

    // Get all InsuranceCards
    public InsuranceCard getInsuranceCardByNumber(String cardNumber){
        for (InsuranceCard card : this.insuranceCards){
            if (Objects.equals(card.getCardNumber(), cardNumber)) return card;
        }
        System.out.println("Card with the number not found.");
        return null;
    }

    // Save data of global instance into data files
    public void saveData(){
        String result = FileHandler.getInstance().writeObjectToFile("insurance_card.json", this.insuranceCards)? "Saved insurance cards data successfully!" : "Failed to save insurance cards data!";
        System.out.println(result);
    }

    // Load data from data files to global instance
    public void loadData(){
        FileHandler fh = FileHandler.getInstance();
        Type type = new TypeToken<Set<InsuranceCard>>(){}.getType();
        this.insuranceCards = fh.loadObjectFromFile("insurance_card.json", type);

    }
}
