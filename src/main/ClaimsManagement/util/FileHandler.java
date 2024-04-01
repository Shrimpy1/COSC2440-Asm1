/**
 * @author Nguyen Ich Kiet - s3978724
 */
package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.insurance_card.InsuranceCard;
import util.adaper.InsuranceCardAdapter;
import util.adaper.LocalDateAdapter;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;

public class FileHandler {
    private static FileHandler instance;
    private final Gson gson;

    public FileHandler() {
        this.gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).registerTypeAdapter(InsuranceCard.class, new InsuranceCardAdapter()).setPrettyPrinting().create();
    }

    public static FileHandler getInstance(){
        if (instance == null){
            instance = new FileHandler();
        }
        return instance;
    }

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
            System.out.println("Printed");
            return true;
        } catch (IOException e) {
            e.printStackTrace();;
            return false;
        }
    }

    public <T> T loadObjectFromFile(String fileName, Type typeOfT){
        try (BufferedReader reader = new BufferedReader(new FileReader("data/" + fileName))) {
            return gson.fromJson(reader, typeOfT);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    };
}
