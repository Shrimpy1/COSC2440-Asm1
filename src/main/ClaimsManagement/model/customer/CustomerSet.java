/**
 * @author Nguyen Ich Kiet - s3978724
 */
package model.customer;

import com.google.gson.reflect.TypeToken;
import util.FileHandler;

import java.lang.reflect.Type;
import java.util.*;

public class CustomerSet{
    private static CustomerSet instance;
    private Set<Customer> customers;

    public CustomerSet() {
        this.customers = new HashSet<Customer>();
    }

    public static CustomerSet getInstance(){
        if (instance == null){
            instance = new CustomerSet();
        }
        return instance;
    }

    public boolean add(Customer customer){
        return customers.add(customer);
    }

    public boolean remove(Customer customer){
        return customers.remove(customer);
    }

    public Customer getCustomerById(String id){
        for (Customer customer : customers){
            if (Objects.equals(customer.getId(), id)) return customer;
        }
        System.out.println("Customer with the ID not found.");
        return null;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void saveData(){
        Set<Policyholder> data = new HashSet<Policyholder>();

        this.customers.forEach(customer -> {
            if (customer instanceof Policyholder){
                data.add((Policyholder) customer);
            }
        });
        String result = FileHandler.getInstance().writeObjectToFile("customer.json", data)? "Saved customers data successfully!" : "Failed to save customers data!";
        System.out.println(result);
    }

    public void loadData(){
        FileHandler fh = FileHandler.getInstance();
        Type type = new TypeToken<List<Policyholder>>(){}.getType();
        List<Policyholder> policyholderList = fh.loadObjectFromFile("customer.json", type);

        policyholderList.forEach(policyholder -> {
            this.customers.add(policyholder);
            this.customers.addAll(policyholder.getDependants());
        });
    }
}
