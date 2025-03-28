package com.ticketing.oop.service;

import com.ticketing.oop.config.Configuration;
import com.ticketing.oop.entity.Customer;
import com.ticketing.oop.entity.TicketPool;
import com.ticketing.oop.entity.Vendor;
import org.springframework.stereotype.Service;

@Service
public class SimulationService {

    private Vendor[] vendors; //Array to hold vendor threads
    private Customer[] customers; //Array to hold customer threads

    public void startSimulation(
            int totalTickets, int ticketsReleaseRate, int customerRetrievalRate, int maxTicketCapacity,
            int numberOfVendors, int numberOfCustomers, int maximumTicketsCanBePurchased
    )
    {
        ConfigurationService configService = new ConfigurationService();

        Configuration configLoad = configService.loadConfiguration(); //Loads the saved configuration.
        vendors = new Vendor[numberOfVendors];
        customers = new Customer[numberOfCustomers];

        TicketPool ticketPool = new TicketPool(configLoad);

        for (int i = 0; i<vendors.length; i++) {
            Configuration configVendor = new Configuration(totalTickets/ vendors.length, ticketsReleaseRate);  //Each vendor gets an equal share of total tickets.
            vendors[i] = new Vendor(ticketPool, configVendor, configVendor); //Configures a vendor with ticket pool and rates.
            Thread vendorThread = new Thread(vendors[i], "Vendor ID: "+i); //Creates a thread for each vendor
            vendorThread.start();
        }

        for (int i = 0; i < customers.length; i++) {
            Configuration configCust = new Configuration(customerRetrievalRate); //Configures customer with retrieval rate.
            customers[i] = new Customer(ticketPool, maximumTicketsCanBePurchased, configCust);  //Configures customer with ticket pool and purchase limits.
            Thread customerThread = new Thread(customers[i], "Customer ID: " + i);
            customerThread.start();
        }
    }

    public void stopSimulation(){

        if(vendors!=null){
            for(int i=0; i<vendors.length; i++){ //Stops all vendor threads.
                if(vendors[i]!=null){
                    vendors[i].stopThread(); //Signals vendor thread to stop.
                }
            }
        }

        if(customers!=null){
            for(int i=0; i<customers.length; i++){ //Stops all customer threads
                if(customers[i]!=null){
                    customers[i].stopThread(); //Signals customer thread to stop
                }
            }
        }

        System.out.println("Simulation aborted!!!!!!!!!!!!!!!");
        System.out.println("System exited successfully.");
        System.exit(0); //Terminates the application.

    }
}
