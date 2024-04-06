/**
 * @author Nguyen Ich Kiet - s3978724
 */
package controller.banking_info;

import model.banking_info.BankingInfo;
import util.ConsoleInput;
import view.banking_info.BankingInfoView;

import java.util.Scanner;

public class BankingInfoController {
    private BankingInfo model;
    private BankingInfoView view;

    public BankingInfoController(BankingInfo model, BankingInfoView view) {
        this.model = model;
        this.view = view;
    }

    public BankingInfo getModel() {
        return model;
    }

    public void setModel(BankingInfo model) {
        this.model = model;
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

        setModel(new BankingInfo(bank, name, number));
    }

    public void display(){
        view.display(model);
    }
}
