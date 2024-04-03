package controller.document;

import model.document.Document;
import view.document.DocumentView;

import java.util.Map;

public class DocumentController {
    private Document document;
    private DocumentView view;

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public DocumentView getView() {
        return view;
    }

    public void setView(DocumentView view) {
        this.view = view;
    }

    public DocumentController(Document document, DocumentView view) {
        this.document = document;
        this.view = view;
    }

    public void createNewDocument(){
        Map<String, String> data = view.promptNewDocument();
        String fileName = data.get(DocumentView.FILE_NAME);

        Document document = new Document(fileName);
        setDocument(document);
    }
}
