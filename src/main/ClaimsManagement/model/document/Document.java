/**
 * @author Nguyen Ich Kiet - s3978724
 */
package model.document;

/**
 * Subclass for Claim. Holding info of a Claim's documents
 */
public class Document {
    private String fileName;

    public Document() {
    }

    public Document(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public String toString() {
        return "Document{" +
                "fileName='" + fileName + '\'' +
                '}';
    }
}
