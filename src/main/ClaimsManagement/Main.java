/**
 * @author Nguyen Ich Kiet - s3978724
 */
import model.InsuranceCard;
import util.FileHandler;

public class Main {
    public static void main(String[] args) {
        InsuranceCard i1 = new InsuranceCard();

        FileHandler fh = FileHandler.getInstance();

        fh.writeData("model.InsuranceCard", i1);
    }
}