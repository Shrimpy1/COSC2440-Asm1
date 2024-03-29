/**
 * @author Nguyen Ich Kiet - s3978724
 */
package controller;

import model.Claim;

import java.util.*;
public interface ClaimProcessManager {
    public boolean add(Claim claim);
    public boolean update(Claim claim);
    public boolean delete(Claim claim);
    public Claim getOne(String id);
    public List<Claim> getAll();
}
