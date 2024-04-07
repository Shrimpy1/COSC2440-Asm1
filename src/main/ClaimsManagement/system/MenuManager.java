/**
 * @author Nguyen Ich Kiet - s3978724
 */
package system;

import system.menu.MainMenu;
import system.menu.Menu;
import util.ConsoleInput;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * Handle displaying Menus and get user's option
 */
public class MenuManager {
    private final Scanner scanner;
    private Menu currentMenu;

    // Constructor
    public MenuManager() {
        this.scanner = ConsoleInput.getInstance().getScanner();
        this.currentMenu = new MainMenu();
    }

    /**
     * Display Menus
     * Loop until there is no Menu returned (When user exits program)
     */
    public void run(){
        while (currentMenu != null) {
            currentMenu.display();
            String choice = getUserChoice();
            currentMenu = currentMenu.handleUserInput(choice);
        }
    }

    /**
     * Prompt and get user's choice from each Menu
     * @return String option instead of Integer value
     * so that reordering options should not cause problem
     */
    public String getUserChoice(){
        int choice;
        while (true) {
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                System.out.println();
                break;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }

        // Get option Map from current Menu
        TreeMap<Integer, String> optionsMap = currentMenu.getOptions();

        // Return user's choice
        return optionsMap.get(choice);
    }
}
