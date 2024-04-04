/**
 * @author Nguyen Ich Kiet - s3978724
 */
package controller.document;

import model.document.Document;
import view.document.DocumentView;

import java.util.Map;

public class DocumentController {
    private Document model;
    private DocumentView view;

    public Document getModel() {
        return model;
    }

    public void setModel(Document model) {
        this.model = model;
    }

    public DocumentView getView() {
        return view;
    }

    public void setView(DocumentView view) {
        this.view = view;
    }

    public DocumentController(Document model, DocumentView view) {
        this.model = model;
        this.view = view;
    }

    public void createNewDocument(){
        Map<String, String> data = view.promptNewDocument();
        String fileName = data.get(DocumentView.FILE_NAME);

        Document document = new Document(fileName);
        setModel(document);
    }
}
