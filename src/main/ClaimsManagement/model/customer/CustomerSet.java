/**
 * @author Nguyen Ich Kiet - s3978724
 */
package model.customer;

import com.google.gson.reflect.TypeToken;
import util.FileHandler;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * This singleton class act as the database for Customer objects
 * Includes save & load data to/from files methods
 */
public class CustomerSet{
    private static CustomerSet instance; // Global
    private Set<Customer> customers;

    public CustomerSet() {
        this.customers = new HashSet<Customer>();
    }

    /**
     * Get global instance
     * If no instance exist, construct one.
     */
    public static CustomerSet getInstance(){
        if (instance == null){
            instance = new CustomerSet();
        }
        return instance;
    }

    // Add to database
    public boolean add(Customer customer){
        return customers.add(customer);
    }

    // Remove from database
    public boolean remove(Customer customer){
        return customers.remove(customer);
    }

    // Get all Customers
    public Set<Customer> getCustomers() {
        return customers;
    }

    // Get all Customers
    public Customer getCustomerById(String id){
        for (Customer customer : customers){
            if (Objects.equals(customer.getId(), id)) return customer;
        }
        System.out.println("Customer with the ID not found.");
        return null;
    }

    // Save data of global instance into data files
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

    // Load data from data files to global instance
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
