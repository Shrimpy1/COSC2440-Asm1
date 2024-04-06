/**
 * @author Nguyen Ich Kiet - s3978724
 */
package system;

import system.menu.MainMenu;
import system.menu.Menu;
import util.ConsoleInput;

import java.util.Scanner;

public class MenuManager {
    private final Scanner scanner;
    private Menu currentMenu;
    public MenuManager() {
        this.scanner = ConsoleInput.getInstance().getScanner();
        this.currentMenu = new MainMenu();
    }

    public void run(){
        while (currentMenu != null) {
            currentMenu.display();
            String choice = getUserChoice();
            currentMenu = currentMenu.handleUserInput(choice);
        }
    }

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
        return currentMenu.getOptions().get(choice);
    }
}
