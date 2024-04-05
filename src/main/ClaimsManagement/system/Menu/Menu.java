package system.Menu;

import util.ConsoleInput;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public abstract class Menu {
    protected Scanner scanner;
    protected Map<Integer, String> options;

    public Menu() {
        this.scanner = ConsoleInput.getInstance().getScanner();
        this.options = new TreeMap<Integer, String>();

        initialize();
    }

    public abstract void display();
    public void displayOptions() {
        for (Integer key : options.keySet()){
            System.out.printf("%d. %s%n", key, options.get(key));
        }
    }
    public abstract Menu handleUserInput(int choice);
    public abstract void initialize();
}
