/**
 * @author Nguyen Ich Kiet - s3978724
 */

import system.ClaimSystem;

/**
 * MAIN class
 * Create an instance of system and run
 */
public class Main {
    public static void main(String[] args) {
        ClaimSystem system = new ClaimSystem();
        system.initialize();
        system.run();
        system.saveData();
    }
}