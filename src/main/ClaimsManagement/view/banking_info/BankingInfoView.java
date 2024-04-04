/**
 * @author Nguyen Ich Kiet - s3978724
 */
package view.banking_info;
import model.banking_info.BankingInfo;

public abstract class BankingInfoView {
    public static String BANK = "BANK";
    public static String NAME = "NAME";
    public static String NUMBER = "NUMBER";

    public BankingInfoView() {
    }

    public abstract void display(BankingInfo bankingInfo);

    public abstract void displaySingleLine(BankingInfo bankingInfo);
}
