package com.ticketing.oop.config;

public class Configuration {

    private int totalTickets; //vendor class
    private int ticketsReleaseRate; //vendor class
    private int customerRetrievalRate; //customer class
    private int maxTicketCapacity; //tickerPool class
    private int numberOfVendors ;
    private int numberOfCustomers;
    private int maximumTicketsCanBePurchased;

    public Configuration(){} //Empty constructor defined to deserialize json.

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