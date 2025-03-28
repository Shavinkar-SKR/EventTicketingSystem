package com.ticketing.oop.entity;

import com.ticketing.oop.config.Configuration;
import jakarta.persistence.*;

@Entity //Customer class is an entity class.
public class Customer implements Runnable {

    @Id //customerID is an unique identifier where it automatically generates id.
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long customerId;

    @Transient //indicates that this field should not be persisted to the database.
    private TicketPool ticketPool;

    @Column(name = "maximum_tickets_can_be_purchased")
    private int maximumTicketsCanBePurchased;

    @Transient
    private int customerRetrievalRate;

    @Transient
    private volatile boolean running = true;

    public Customer(){}

    public Customer(TicketPool ticketPool, int maximumTicketsCanBePurchased, Configuration customerRetrievalRate){
        this.ticketPool = ticketPool;
        this.maximumTicketsCanBePurchased = maximumTicketsCanBePurchased;
        this.customerRetrievalRate = customerRetrievalRate.getCustomerRetrievalRate();
    }

    /**
     * Runs every customer thread considering the maximum tickets each customer can buy.
     */
    @Override
    public void run(){ //run method is the core of the customer thread which is in Runnable class.
        for (int i = 0; i < maximumTicketsCanBePurchased; i++) {
            if(running){ //check if the thread is in the running state.
                Ticket ticket = ticketPool.buyTickets(); //customer buys a ticket from the ticketPool.
                System.out.println("Ticket purchased by "+Thread.currentThread().getName() +". Ticket is "+ticket);
            }
            try{
                Thread.sleep(customerRetrievalRate*1000L); //each customer thread is paused for a certain time.
            }catch (InterruptedException e){
                if(!running){
                    break; //each customer thread is terminated to stop the simulation.
                }
            }
        }
    }

    /**
     * Stops the threads
     */
    public void stopThread(){
        this.running = false;
    }

    public long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public int getMaxTicketQuantity() {
        return maximumTicketsCanBePurchased;
    }

    public void setMaxTicketQuantity(int maximumTicketsCanBePurchased) {
        this.maximumTicketsCanBePurchased = maximumTicketsCanBePurchased;
    }
}
