/**
 * @author Nguyen Ich Kiet - s3978724
 */
package model.policy_owner;

/**
 * Subclass for Claim. Holding info of a Claim's policy owner
 */
public class PolicyOwner {
    private String name;

    public PolicyOwner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
