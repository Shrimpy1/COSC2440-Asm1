package controller.banking_info;

import model.banking_info.BankingInfo;
import util.ConsoleInput;
import view.banking_info.BankingInfoView;

import java.util.Scanner;

public class BankingInfoController {
    private BankingInfo bankingInfo;
    private BankingInfoView view;

    public BankingInfoController(BankingInfo bankingInfo, BankingInfoView view) {
        this.bankingInfo = bankingInfo;
        this.view = view;
    }

    public BankingInfo getBankingInfo() {
        return bankingInfo;
    }

    public void setBankingInfo(BankingInfo bankingInfo) {
        this.bankingInfo = bankingInfo;
    }

    public BankingInfoView getView() {
        return view;
    }

    public void setView(BankingInfoView view) {
        this.view = view;
    }

    public void promptBankingInfo(){
        Scanner scanner = ConsoleInput.getInstance().getScanner();
        System.out.println("\tReceiver Banking Information: ");
        System.out.print("Bank name: ");
        String bank = scanner.nextLine();
        System.out.print("Full Name: ");
        String name = scanner.nextLine();
        System.out.print("Number: ");
        String number = scanner.nextLine();

        setBankingInfo(new BankingInfo(bank, name, number));
    }
}
