/**
 * @author Nguyen Ich Kiet - s3978724
 */
package system.menu;

import java.util.TreeMap;

/**
 * Structure of all menus
 */
public abstract class Menu {
    protected TreeMap<Integer, String> options; // Tree map for auto ascending ordering

    /**
     * Constructor
     * Add all options into the option Map
     */
    public Menu() {
        this.options = new TreeMap<Integer, String>();

        initialize();
    }

    /**
     * Display all options
     */
    public void display(){
        for (Integer key : options.keySet()){
            System.out.printf("%d. %s%n", key, options.get(key));
        }
    };

    /**
     * Action logic of each menu
     * @param choice String option selected from user
     * @return advancing, returning Menu or self
     */
    public abstract Menu handleUserInput(String choice);

    /**
     * This method is for adding options to the option Map
     */
    public abstract void initialize();

    /**
     * @return option Map to MenuManager to get user choice
     */
    public TreeMap<Integer, String> getOptions() {
        return options;
    }
}
