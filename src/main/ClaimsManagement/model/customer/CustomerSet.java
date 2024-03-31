package model.customer;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    
}
