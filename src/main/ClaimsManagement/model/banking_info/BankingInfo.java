package model.banking_info;

import util.ConsoleInput;

import java.util.Scanner;

public class BankingInfo {
    private String bank;
    private String name;
    private String number;

    public BankingInfo(String bank, String name, String number) {
        this.bank = bank;
        this.name = name;
        this.number = number;
    }

    public static BankingInfo promptBankingInfo(){
        Scanner scanner = ConsoleInput.getInstance().getScanner();
        System.out.println("\tReceiver Banking Information: ");
        System.out.print("Bank name: ");
        String bank = scanner.nextLine();
        System.out.print("Full Name: ");
        String name = scanner.nextLine();
        System.out.print("Number: ");
        String number = scanner.nextLine();

        return new BankingInfo(bank, name, number);
    }

    @Override
    public String toString() {
        return bank + " - " + name + " - " + number;
    }
}
