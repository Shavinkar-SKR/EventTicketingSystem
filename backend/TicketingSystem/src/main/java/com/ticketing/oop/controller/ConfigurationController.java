package com.ticketing.oop.controller;

import com.ticketing.oop.config.Configuration;
import com.ticketing.oop.service.ConfigurationService;
import com.ticketing.oop.service.SimulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/configuration")
@CrossOrigin(origins ="http://localhost:4200") //Allows cross-origin requests from Angular frontend.
public class ConfigurationController {

    @Autowired
    private SimulationService simulationService; //Dependency injection for managing simulation.

    @Autowired
    private ConfigurationService configurationService; //Dependency injection for configuration management.

    @PostMapping("/save")
    public String saveConfiguration(@RequestBody Configuration config) {
        configurationService.saveConfigurationJson(config); //Saves configuration as a JSON file.
        configurationService.saveConfigurationText(config); //Saves configuration as a text file.
        return "Configuration saved successfully.";
    }

    @GetMapping("/get")
    public Configuration getConfiguration() {
        return configurationService.loadConfiguration(); //Loads and returns the saved configuration.

    }

    @PostMapping("/simulation/start")
    public String startSimulator(@RequestBody Configuration config) {
        System.out.println("Simulation started........................................");
        configurationService.saveConfigurationJson(config);
        configurationService.saveConfigurationText(config);
        //Passes configuration details to start the simulation process.
        simulationService.startSimulation(config.getTotalTickets(),
                config.getTicketsReleaseRate(),
                config.getCustomerRetrievalRate(),
                config.getMaxTicketCapacity(),
                config.getNumberOfVendors(),
                config.getNumberOfCustomers(),
                config.getMaximumTicketsCanBePurchased()
        );
        return "Simulation started.....";
    }

    @PostMapping("/simulation/stop")
    public String stopSimulator(){
        simulationService.stopSimulation(); //Stops the simulation process.
        return "Simulation stopped successfully";
    }
}
