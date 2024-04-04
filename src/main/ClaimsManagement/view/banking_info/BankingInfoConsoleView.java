package view.banking_info;

import model.banking_info.BankingInfo;

public class BankingInfoConsoleView extends BankingInfoView{
    public BankingInfoConsoleView() {
        super();
    }

    public void display(BankingInfo info){
        System.out.println("\tBanking Info:");
        System.out.print("Bank: " + info.getBank());
        System.out.print("Name: " + info.getName());
        System.out.print("Number: " + info.getNumber());
        System.out.println();
    }
}
