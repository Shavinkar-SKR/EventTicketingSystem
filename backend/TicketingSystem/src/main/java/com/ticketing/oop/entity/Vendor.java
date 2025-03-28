package com.ticketing.oop.entity;

import com.ticketing.oop.config.Configuration;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Vendor implements Runnable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long vendorId;

    @Transient
    private TicketPool ticketPool;

    @Transient
    private int totalTickets;

    @Transient
    private int ticketsReleaseRate;

    @Transient
    private volatile boolean running = false;

    public Vendor() {}

    public Vendor(TicketPool ticketPool, Configuration totalTickets, Configuration ticketsReleaseRate){
        super();
        this.ticketPool = ticketPool;
        this.totalTickets = totalTickets.getTotalTickets();
        this.ticketsReleaseRate = ticketsReleaseRate.getTicketsReleaseRate();
    }

    /**
     * Runs the ticket thread by creating ticket objects and adding them to the pool.
     */
    @Override
    public void run(){
        for(int i = 0; i < totalTickets; i++) {
            Ticket ticket = new Ticket("Amaran", 1000, new Date(), new Date());
            ticketPool.addTickets(ticket);

            try{
                Thread.sleep(ticketsReleaseRate*1000);
            }catch(InterruptedException e){
                if(!running){
                    break;
                }
            }
        }
    }

    public void stopThread(){
        this.running = false;
    }

    public long getVendorId() {
        return vendorId;
    }

    public void setVendorId(long vendorId) {
        this.vendorId = vendorId;
    }
}
