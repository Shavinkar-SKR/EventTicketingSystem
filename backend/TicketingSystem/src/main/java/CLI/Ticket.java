package CLI;

import jakarta.persistence.*;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ticketID;

    @Transient
    private static final AtomicInteger ticketCount = new AtomicInteger(0);

    @Column(name = "ticket_name")
    private String ticketName;
    @Column(name = "ticket_price")
    private int ticketPrice;
    @Column
    private Date releasedTicketDate;
    @Column
    private Date purchasedDate;

    public Ticket(){

    }

    public Ticket(String ticketName, int ticketPrice, Date releasedTicketDate, Date purchasedDate) {
        this.ticketID = ticketCount.incrementAndGet();
        this.ticketName = ticketName;
        this.ticketPrice = ticketPrice;
        this.releasedTicketDate = releasedTicketDate;
        this.purchasedDate = purchasedDate;
    }

    public long getTicketID() {
        return ticketID;
    }

    public void setTicketID(long ticketID) {
        this.ticketID = ticketID;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Date getReleasedDate() {
        return releasedTicketDate;
    }

    public void setReleasedDate(Date releasedDate) {
        this.releasedTicketDate = releasedDate;
    }

    public Date getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(Date purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    @Override
    public String toString() {

        return "Ticket{ ticketID=" + ticketID +
                ", ticketName='" + ticketName +
                ", ticketPrice=" + ticketPrice +
                ", purchasedDate=" + purchasedDate +
                '}';
    }
}
