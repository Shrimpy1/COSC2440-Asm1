/**
 * @author Nguyen Ich Kiet - s3978724
 */
package system.menu;

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

    public void display(){
        for (Integer key : options.keySet()){
            System.out.printf("%d. %s%n", key, options.get(key));
        }
    };

    public abstract Menu handleUserInput(String choice);

    public abstract void initialize();

    public Map<Integer, String> getOptions() {
        return options;
    }
}
