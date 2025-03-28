package CLI;

import jakarta.persistence.*;

@Entity
public class Customer implements Runnable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long customerId;

    @Transient
    private TicketPool ticketPool;

    @Column(name = "maximum_tickets_can_be_purchased")
    private int maximumTicketsCanBePurchased;

    @Transient
    private int customerRetrievalRate;

    @Transient
    private volatile boolean running = true;

    public Customer(){

    }

    public Customer(TicketPool ticketPool, int maximumTicketsCanBePurchased, Configuration customerRetrievalRate){
        this.ticketPool = ticketPool;
        this.maximumTicketsCanBePurchased = maximumTicketsCanBePurchased;
        this.customerRetrievalRate = customerRetrievalRate.getCustomerRetrievalRate();
    }

    @Override
    public void run(){
        for (int i = 0; i < maximumTicketsCanBePurchased; i++) {
            if(running){
                Ticket ticket = ticketPool.buyTickets();
                System.out.println("Ticket purchased by "+Thread.currentThread().getName() +". Ticket is "+ticket);
            }
            try{
                Thread.sleep(customerRetrievalRate*1000L);
            }catch (InterruptedException e){
                if(!running){
                    break;
                }
            }
        }
    }

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
