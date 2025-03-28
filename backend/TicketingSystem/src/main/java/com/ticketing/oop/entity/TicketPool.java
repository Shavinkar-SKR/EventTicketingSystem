package com.ticketing.oop.entity;

import com.ticketing.oop.config.Configuration;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class TicketPool {

    private List<Ticket> ticketDetails; //declared an array list to store ticket objects.
    private int maxCapacity; //maximum ticket objects the ticketPool can hold.

    public TicketPool(Configuration config){
        this.ticketDetails = Collections.synchronizedList(new ArrayList<>()); //initialises the ticketDetails array list to synchronized list
        this.maxCapacity = config.getMaxTicketCapacity();
    }

    /**
     * Add tickets to the ticket pool preventing race conditions
     * @param ticket
     */
    public synchronized void addTickets(Ticket ticket){
        while(ticketDetails.size()>= maxCapacity){
            try{
                wait(); //makes a thread in the waiting state until the ticket pool has one space free.
            }catch(InterruptedException e){
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }
        }
        ticketDetails.add(ticket); //adds ticket to the ticket pool

        notifyAll(); //if there are any threads waiting, makes them awake to resume the thread.
        System.out.println(Thread.currentThread().getName()+" has added a ticket to the ticket pool. "+
                "Ticket released on " +ticket.getReleasedDate()+
                ". Current size: " + ticketDetails.size()
        );
    }

    /**
     * Customers buy tickets from the pool
     * @return ticket
     */
    public synchronized Ticket buyTickets(){
        while(ticketDetails.isEmpty()){
            try{
                wait(); //it waits if no tickets are available in the ticket pool.
            }catch (InterruptedException e){
                throw new RuntimeException(e.getMessage());
            }
        }
        Ticket ticket = ticketDetails.remove(0); //if tickets are available removes the ticket at the first index.
        notifyAll(); //notifies other threads to resume.
        System.out.println(Thread.currentThread().getName()+" has bought a ticket from the ticket pool."+
                "Ticket was purchased on "+ ticket.getPurchasedDate()+
                ". Current size: "+ticketDetails.size());
        return ticket;
    }
}
