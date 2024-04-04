/**
 * @author Nguyen Ich Kiet - s3978724
 */
package view.banking_info;

import model.banking_info.BankingInfo;

public class BankingInfoConsoleView extends BankingInfoView{
    public BankingInfoConsoleView() {
        super();
    }

    @Override
    public void display(BankingInfo bankingInfo){
        System.out.println("\tBanking Info:");
        System.out.print("Name: " + bankingInfo.getName());
        System.out.print("Bank: " + bankingInfo.getBank());
        System.out.print("Number: " + bankingInfo.getNumber());
        System.out.println();
    }

    @Override
    public void displaySingleLine(BankingInfo bankingInfo){
        System.out.println(bankingInfo.getBank() + " - " + bankingInfo.getName() + " - " + bankingInfo.getNumber());
    }
}
