package system.Menu;

import java.util.Map;

public class MainMenu extends Menu{
    public MainMenu() {
        super();
    }

    @Override
    public void initialize() {
        this.options.put(1, "Manage Claims");
        this.options.put(2, "Manage Customers");
        this.options.put(3, "Manage Insurance Cards");
        this.options.put(4, "Exit");
    }

    @Override
    public void display() {
        System.out.println("MAIN MENU:");
        displayOptions();
    }

    @Override
    public Menu handleUserInput(int choice) {
        switch (choice) {
            case 1:
                return new ClaimMenu();
            case 2:
                return this;
            case 3:
                return this;
            case 4:
                System.out.println("Exiting...");
                return null;
            default:
                System.out.println("Invalid input.");
                break;
        }
        return this;
    }
}
