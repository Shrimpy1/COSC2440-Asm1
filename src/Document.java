/**
 * @author Nguyen Ich Kiet - s3978724
 */
import java.util.*;
public class Document {
    private String fileName;

    public Document() {
    }

    public Document(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "Document{" +
                "fileName='" + fileName + '\'' +
                '}';
    }
}
