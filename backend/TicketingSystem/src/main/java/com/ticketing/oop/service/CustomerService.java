package com.ticketing.oop.service;

import com.ticketing.oop.entity.Customer;
import org.springframework.stereotype.Service;
import com.ticketing.oop.respository.CustomerRepository;

import java.util.List;

@Service //makes the class as Spring service component enabling dependency injection.
public class CustomerService {

    private CustomerRepository customerRepository; //Repository for database operations on customers.

    //Receives an instance of CustomerRepository to interact with the database through repository.
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Saves the customer object to the database.
     * @param customer the customer entity to be added.
     * @return saved customer object
     */
    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    /**
     * Retrieves all the customer objects from the database
     * @return list of customers
     */
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    /**
     * Retrieves the customer object with the given id.
     * @param id as input
     * @return the customer object of that id or null if no customer id found.
     */
    public Customer getById(Long id){
        return customerRepository.findById(id).orElse(null);
    }

    /**
     * Deletes the customer of the given id from database
     * @param id as input
     */
    public void deleteId(Long id){
        customerRepository.deleteById(id);
    }
}
