package com.ticketing.oop.controller;

import com.ticketing.oop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ticketing.oop.entity.Customer;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService; //Service to manage customer related operations.

    /**
     * Endpoint to add a new customer.
     * @param customer The customer entity to be added.
     * @return The added customer entity.
     */
    @PostMapping("/add")
    public Customer storeCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    /**
     * Endpoint to retrieve all customers.
     * @return A list of all customers.
     */
    @GetMapping("/getall")
    public List<Customer> getCustomers(){
        return customerService.getAllCustomers();
    }

    /**
     * Endpoint to retrieve a customer by ID.
     * @param id The ID of the customer to retrieve.
     * @return The customer entity if found, or null if not.
     */
    @GetMapping("/getby/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerService.getById(id);
    }

    /**
     * Endpoint to delete a customer by ID.
     * @param id The ID of the customer to delete.
     * @return A confirmation message indicating deletion status.
     */
    @DeleteMapping("/delete/{id}")
    public String deleteCustomerById(@PathVariable Long id) {
        customerService.deleteId(id);
        return "Customer with ID " + id + " has been deleted.";
    }
}
