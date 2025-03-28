package CLI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicketPool {

    private List<Ticket> ticketDetails;
    private int maxCapacity;

    public TicketPool(Configuration config){
        this.ticketDetails = Collections.synchronizedList(new ArrayList<>());
        this.maxCapacity = config.getMaxTicketCapacity();
    }

    public synchronized void addTickets(Ticket ticket){
        while(ticketDetails.size()>= maxCapacity){
            try{
                wait();
            }catch(InterruptedException e){
                e.printStackTrace();
                throw new RuntimeException(e.getMessage());
            }
        }
        ticketDetails.add(ticket);

        notifyAll();
        System.out.println(Thread.currentThread().getName()+" has added a ticket to the ticket pool. "+
                "Ticket released on " +ticket.getReleasedDate()+
                ". Current size: " + ticketDetails.size()
        );
    }

    public synchronized Ticket buyTickets(){
        while(ticketDetails.isEmpty()){
            try{
                wait();
            }catch (InterruptedException e){
                throw new RuntimeException(e.getMessage());
            }
        }
        Ticket ticket = ticketDetails.remove(0);
        notifyAll();
        System.out.println(Thread.currentThread().getName()+" has bought a ticket from the ticket pool."+
                "Ticket was purchased on "+ ticket.getPurchasedDate()+
                ". Current size: "+ticketDetails.size());
        return ticket;
    }
}
