package model.document;

import util.ConsoleInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DocumentList {
    private List<Document> list;

    public static List<Document> promptDocumentList(){
        List<Document> list = new ArrayList<Document>();
        Scanner scanner = ConsoleInput.getInstance().getScanner();
        String answer = "y";
        while (answer.equalsIgnoreCase("y")){
            // create + add documents

            System.out.println("Add more documents? (y/n): ");
            answer = scanner.nextLine();
        }

        return list;
    }

    public List<Document> getList() {
        return list;
    }
}
