package com.ticketing.oop.service;

import com.google.gson.Gson;
import com.ticketing.oop.config.Configuration;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class ConfigurationService {

    public void saveConfigurationJson(Configuration config){
        Gson gson = new Gson(); //Converts the Configuration object into a JSON string and writes it to a file.
        try{
            FileWriter myWriter = new FileWriter("InputConfiguration.json");
            String json = gson.toJson(config);  //Converts the Configuration object to JSON string.
            myWriter.write(json);
            System.out.println("Configuration saved successfully in JSON format.");
            myWriter.close();
        }catch (IOException e){
            throw new RuntimeException("Error occurred while writing to the file");
        }
    }

    public void saveConfigurationText(Configuration config){
        try{
            FileWriter myWriter = new FileWriter("InputConfiguration.txt");
            myWriter.write("Total tickets: "+config.getTotalTickets()+"\n");
            myWriter.write("Tickets Release Rate: "+config.getTicketsReleaseRate()+"\n");
            myWriter.write("Customer Retrieval Rate: "+config.getCustomerRetrievalRate()+"\n");
            myWriter.write("Maximum Ticket Capacity: "+config.getMaxTicketCapacity()+"\n");
            myWriter.write("Number of Customers: "+config.getNumberOfCustomers()+"\n");
            myWriter.write("Number of Vendors: "+config.getNumberOfVendors()+"\n");
            myWriter.write("Maximum quantity of tickets can be purchased by each customer: "+config.getMaximumTicketsCanBePurchased());
            System.out.println("Configuration saved successfully to the text file.");
            myWriter.close();
        }catch (IOException e){
            throw new RuntimeException("Error occurred while writing to the file");
        }
    }

    public Configuration loadConfiguration(){
        Gson gson = new Gson(); //Gson is used for JSON deserialization.
        try{
            FileReader reader = new FileReader("InputConfiguration.json");
            System.out.println("File loaded successfully.");
            return gson.fromJson(reader, Configuration.class); //Converts JSON string back into a Configuration object
        }catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
