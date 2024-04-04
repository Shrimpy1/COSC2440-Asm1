/**
 * @author Nguyen Ich Kiet - s3978724
 */
package util;

import java.util.Scanner;

public class ConsoleInput {
    private static ConsoleInput consoleInput;
    private Scanner scanner;

    public ConsoleInput() {
        this.scanner = new Scanner(System.in);
    }

    public static ConsoleInput getInstance(){
        if (consoleInput == null){
            consoleInput = new ConsoleInput();
        }
        return consoleInput;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
