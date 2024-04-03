package view.document;

import model.document.Document;
import util.ConsoleInput;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class DocumentView {
    public static String FILE_NAME = "FILE NAME";

    public DocumentView() {
    }

    public abstract Map<String, String> promptNewDocument();
}
