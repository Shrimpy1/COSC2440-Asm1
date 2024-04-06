/**
 * @author Nguyen Ich Kiet - s3978724
 */
package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.claim.Claim;
import model.insurance_card.InsuranceCard;
import util.adaper.ClaimAdapter;
import util.adaper.InsuranceCardAdapter;
import util.adaper.LocalDateAdapter;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;

/**
 * Singleton utility class
 * Used for writing & saving an object to a file
 * Uses Gson to convert to JsonObject
 */
public class FileHandler {
    private static FileHandler instance; // Global instance
    private final Gson gson;

    /**
     * Constructor
     * Create a new Gson instance with all custom adapters
     */
    public FileHandler() {
        this.gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).registerTypeAdapter(InsuranceCard.class, new InsuranceCardAdapter()).registerTypeAdapter(Claim.class, new ClaimAdapter()).setPrettyPrinting().create();
    }

    /**
     * Get global instance
     * If no instance exist, construct one.
     */
    public static FileHandler getInstance(){
        if (instance == null){
            instance = new FileHandler();
        }
        return instance;
    }

    /**
     * Writes an Object to a destination file
     * @param fileName destination file's name
     * @param data input object
     * @return true if the operation succeed
     */
    public boolean writeObjectToFile(String fileName, Object data) {
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            if (dataDir.mkdir()) {
                System.out.println("Data directory created: " + dataDir.getAbsolutePath());
            } else {
                System.err.println("Failed to create data directory!");
                return false;
            }
        }

        File file = new File(dataDir, (fileName));

        try (FileWriter writer = new FileWriter(file)){
            gson.toJson(data, writer);
            return true;
        } catch (IOException e) {
            e.printStackTrace();;
            return false;
        }
    }

    /**
     * Read data file and construct the object
     * @param fileName source file's name
     * @param typeOfT type of the object to be constructed
     * @return T object with data from the file
     * @param <T> type placeholder
     */
    public <T> T loadObjectFromFile(String fileName, Type typeOfT){
        try (BufferedReader reader = new BufferedReader(new FileReader("data/" + fileName))) {
            return gson.fromJson(reader, typeOfT);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    };
}
