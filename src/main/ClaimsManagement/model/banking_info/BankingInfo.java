package model.banking_info;

import util.ConsoleInput;

import java.util.Scanner;

public class BankingInfo {
    private String bank;
    private String name;
    private String number;

    public BankingInfo() {
    }

    public BankingInfo(String bank, String name, String number) {
        this.bank = bank;
        this.name = name;
        this.number = number;
    }

    public String getBank() {
        return bank;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return bank + " - " + name + " - " + number;
    }
}
