/**
 * @author Nguyen Ich Kiet - s3978724
 */
package view.document;

import java.util.Map;

public abstract class DocumentView {
    public static String FILE_NAME = "FILE NAME";

    public DocumentView() {
    }

    public abstract Map<String, String> promptNewDocument();
}
