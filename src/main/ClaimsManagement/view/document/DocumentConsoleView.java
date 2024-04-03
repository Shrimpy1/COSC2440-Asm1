package view.document;

import model.document.Document;
import util.ConsoleInput;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DocumentConsoleView extends DocumentView{
    public DocumentConsoleView() {
        super();
    }

    public void displayFileName(Document document) {
        System.out.println("File name: " + document.getFileName());
    }

    @Override
    public Map<String, String> promptNewDocument(){
        Scanner scanner = ConsoleInput.getInstance().getScanner();
        Map<String, String> data = new HashMap<String, String>();
        System.out.println("\tNew Document:");
        System.out.println("File name: ");
        data.put(FILE_NAME, scanner.nextLine());
        return data;
    }
}
