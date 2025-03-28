package com.ticketing.oop.respository;

import com.ticketing.oop.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

//Spring Data JPA repository for the Vendor entity to perform CRUD operations.
public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
