/**
 * @author Nguyen Ich Kiet - s3978724
 */
package util;

import java.util.Scanner;

/**
 * Singleton utility class
 * Used to get Scanner object to get user's input
 */
public class ConsoleInput {
    private static ConsoleInput consoleInput; // Global instance
    private final Scanner scanner;

    public ConsoleInput() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Get global instance
     * If no instance exist, construct one.
     */
    public static ConsoleInput getInstance(){
        if (consoleInput == null){
            consoleInput = new ConsoleInput();
        }
        return consoleInput;
    }

    /**
     * Get scanner
     * @return Scanner object
     */
    public Scanner getScanner() {
        return scanner;
    }
}
