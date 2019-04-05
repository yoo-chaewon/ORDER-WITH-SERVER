package com.example.demo.dao;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDAO {
    // Dummy database. Initialize with some dummy values.
    private static List customers;
    {
        customers = new ArrayList();
        customers.add(new Customer(101, "John", "Doe", "djohn@gmail.com", "121-232-3435"));
        customers.add(new Customer(201, "Russ", "Smith", "sruss@gmail.com", "343-545-2345"));
        customers.add(new Customer(301, "Kate", "Williams", "kwilliams@gmail.com", "876-237-2987"));
    }

    public List list() {
        return customers;
    }

    public Customer get(Long id) {
        /*
        for (Customer c : customers) {
            if (c.getId().equals(id)) {
                return c;
            }
        }*/
        return null;
    }

    public Customer create(Customer customer) {
        customer.setId(System.currentTimeMillis());
        customers.add(customer);
        return customer;
    }

    public Long delete(Long id) {
        /*
        for (Customer c : customers) {
            if (c.getId().equals(id)) {
                customers.remove(c);
                return id;
            }
        }*/
        return null;
    }

    public Customer update(Long id, Customer customer) {
        /*
        for (Customer c : customers) {
            if (c.getId().equals(id)) {
                customer.setId(c.getId());
                customers.remove(c);
                customers.add(customer);
                return customer;
            }
        }*/
        return null;
    }
}
