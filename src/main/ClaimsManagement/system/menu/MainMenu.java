/**
 * @author Nguyen Ich Kiet - s3978724
 */
package system.menu;

public class MainMenu extends Menu{
    public MainMenu() {
        super();
    }

    @Override
    public void initialize() {
        this.options.put(1, "View");
        this.options.put(2, "Manage");
        this.options.put(3, "Exit");
    }

    @Override
    public void display() {
        System.out.println("\tMAIN MENU:");
        super.display();
    }

    @Override
    public Menu handleUserInput(String choice) {
        switch (choice) {
            case "View":
                return new ViewMenu();
            case "Manage":
                return new ManageMenu();
            case "Exit":
                System.out.println("Exiting...");
                return null;
            default:
                System.out.println("Invalid input.");
                break;
        }
        return this;
    }
}
