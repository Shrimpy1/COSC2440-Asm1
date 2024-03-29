/**
 * @author Nguyen Ich Kiet - s3978724
 */
package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class FileHandler {
    private static FileHandler fileHandler;
    private final Gson gson;

    public FileHandler() {
        this.gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).setPrettyPrinting().create();
    }

    public static FileHandler getInstance(){
        if (fileHandler == null){
            fileHandler = new FileHandler();
        }
        return fileHandler;
    }

    public boolean writeData(String fileName, Object data) {
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            if (dataDir.mkdir()) {
                java.lang.System.out.println("Data directory created: " + dataDir.getAbsolutePath());
            } else {
                java.lang.System.err.println("Failed to create data directory!");
                return false;
            }
        }

        File file = new File(dataDir, (fileName + ".json"));

        try (FileWriter writer = new FileWriter(file)){
            gson.toJson(data, writer);
            java.lang.System.out.println("Printed");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
