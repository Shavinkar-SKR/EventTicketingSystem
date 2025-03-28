package com.ticketing.oop.controller;

import com.ticketing.oop.entity.Vendor;
import com.ticketing.oop.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendor")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    /**
     * Endpoint to add a new vendor.
     * @param vendor The vendor entity to be added.
     * @return The added vendor entity.
     */
    @PostMapping("/add")
    public Vendor storeVendor(@RequestBody Vendor vendor){
        return vendorService.addVendor(vendor);
    }

    /**
     * Endpoint to retrieve all vendors.
     * @return A list of all vendors.
     */
    @GetMapping("/getall")
    public List<Vendor> getVendors(){
        return vendorService.getAllVendors();
    }

    /**
     * Endpoint to retrieve a vendor by ID.
     * @param id The ID of the vendor to retrieve.
     * @return The vendor entity if found, or null if not.
     */
    @GetMapping("/getby/{id}")
    public Vendor getVendorById(@PathVariable Long id){
        return vendorService.getById(id);
    }

    /**
     * Endpoint to delete a vendor by ID.
     * @param id The ID of the vendor to delete.
     * @return A confirmation message indicating deletion status.
     */
    @DeleteMapping("/delete/{id}")
    public String deleteVendorById(@PathVariable Long id){
        vendorService.deleteId(id);
        return "Vendor removed successfully.";
    }
}
