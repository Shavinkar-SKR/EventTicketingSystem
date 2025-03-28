package com.ticketing.oop.respository;

import com.ticketing.oop.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

//Spring Data JPA repository for the Customer entity to perform CRUD operations.
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
