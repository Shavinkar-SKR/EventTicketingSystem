package com.ticketing.oop.service;

import com.ticketing.oop.entity.Vendor;
import com.ticketing.oop.respository.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {

    private VendorRepository vendorRepository; //Repository for database operations on vendors.

    public VendorService(VendorRepository vendorRepository){
        this.vendorRepository = vendorRepository;
    }

    /**
     * Adds a new vendor to the database.
     * @param vendor The vendor entity to be added.
     * @return The saved vendor entity.
     */
    public Vendor addVendor(Vendor vendor){
        return vendorRepository.save(vendor);
    }

    /**
     * Retrieves all vendors from the database.
     * @return A list of all vendors.
     */
    public List<Vendor> getAllVendors(){
        return vendorRepository.findAll();
    }

    /**
     * Retrieves a vendor by its ID.
     * @param id The ID of the vendor to be retrieved.
     * @return The vendor entity if found, or null if not.
     */
    public Vendor getById(Long id){
        return vendorRepository.findById(id).orElse(null);
    }

    /**
     * Deletes a vendor by its ID.
     * @param id The ID of the vendor to be deleted.
     */
    public void deleteId(Long id){
        vendorRepository.deleteById(id);
    }
}
