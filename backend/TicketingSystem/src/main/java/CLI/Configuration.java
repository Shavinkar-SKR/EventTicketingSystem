package CLI;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Configuration {

    private int totalTickets; //vendor class
    private int ticketsReleaseRate; //vendor class
    private int customerRetrievalRate; //customer class
    private int maxTicketCapacity; //tickerPool class
    private int numberOfVendors ;
    private int numberOfCustomers;
    private int maximumTicketsCanBePurchased;

    public Configuration(int customerRetrievalRate){
        this.customerRetrievalRate = customerRetrievalRate;
    }

    public Configuration(int totalTickets, int ticketsReleaseRate){
        this.totalTickets = totalTickets;
        this.ticketsReleaseRate = ticketsReleaseRate;
    }

    public Configuration(int totalTickets, int ticketsReleaseRate,
                         int customerRetrievalRate, int maxTicketCapacity,
                         int numberOfCustomers, int numberOfVendors,
                         int maximumTicketsCanBePurchased
    )
    {
        super();
        this.totalTickets = totalTickets;
        this.ticketsReleaseRate = ticketsReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maxTicketCapacity = maxTicketCapacity;
        this.numberOfCustomers = numberOfCustomers;
        this.numberOfVendors = numberOfVendors;
        this.maximumTicketsCanBePurchased = maximumTicketsCanBePurchased;
    }

    public void saveConfigurationJson(){
        Gson gson = new Gson();
        try{
            FileWriter myWriter = new FileWriter("CLI.json");
            String json = gson.toJson(this);
            myWriter.write(json);
            System.out.println("Configuration saved successfully in JSON format.");
            myWriter.close();
        }catch (IOException e){
            throw new RuntimeException("Error occurred while writing to the file");
        }
    }

    public void saveConfigurationText(){
        try{
            FileWriter myWriter = new FileWriter("CLI.txt");
            myWriter.write("Total tickets: "+totalTickets+"\n");
            myWriter.write("Tickets Release Rate: "+ticketsReleaseRate+"\n");
            myWriter.write("Customer Retrieval Rate: "+customerRetrievalRate+"\n");
            myWriter.write("Maximum Ticket Capacity: "+maxTicketCapacity+"\n");
            myWriter.write("Number of Customers: "+numberOfCustomers+"\n");
            myWriter.write("Number of Vendors: "+numberOfVendors+"\n");
            myWriter.write("Maximum quantity of tickets can be purchased by each customer: "+maximumTicketsCanBePurchased);
            System.out.println("Configuration saved successfully to the text file.");
            myWriter.close();
        }catch (IOException e){
            throw new RuntimeException("Error occurred while writing to the file");
        }
    }

    public Configuration loadConfiguration(){
        Gson gson = new Gson();
        try{
            FileReader reader = new FileReader("CLI.json");
            System.out.println("File loaded successfully.");
            return gson.fromJson(reader, Configuration.class);
        }catch (IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public int getTotalTickets(){
        return this.totalTickets;
    }

    public int getTicketsReleaseRate(){
        return this.ticketsReleaseRate;
    }

    public int getCustomerRetrievalRate(){
        return this.customerRetrievalRate;
    }

    public int getMaxTicketCapacity(){
        return this.maxTicketCapacity;
    }

    public int getNumberOfVendors() {
        return numberOfVendors;
    }

    public void setNumberOfVendors(int numberOfVendors) {
        this.numberOfVendors = numberOfVendors;
    }

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public void setNumberOfCustomers(int numberOfCustomers) {
        this.numberOfCustomers = numberOfCustomers;
    }

    public int getMaximumTicketsCanBePurchased() {
        return maximumTicketsCanBePurchased;
    }

    public void setMaximumTicketsCanBePurchased(int maximumTicketsCanBePurchased) {
        this.maximumTicketsCanBePurchased = maximumTicketsCanBePurchased;
    }

    @Override
    public String toString() {
        return "Configuration{ totalTickets=" + totalTickets +
                ", ticketsReleaseRate=" + ticketsReleaseRate +
                ", customerRetrievalRate=" + customerRetrievalRate +
                ", maxTicketCapacity=" + maxTicketCapacity +
                '}';
    }
}