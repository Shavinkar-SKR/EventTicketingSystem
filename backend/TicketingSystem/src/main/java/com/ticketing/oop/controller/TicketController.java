package com.ticketing.oop.controller;

import com.ticketing.oop.entity.Ticket;
import com.ticketing.oop.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    /**
     * Endpoint to add a new ticket.
     * @param ticket The ticket entity to be added.
     * @return The added ticket entity.
     */
    @PostMapping("/add")
    public Ticket storeTicket(@RequestBody Ticket ticket){
        return ticketService.addTicket(ticket);
    }

    /**
     * Endpoint to retrieve all tickets.
     * @return A list of all tickets.
     */
    @GetMapping("/getall")
    public List<Ticket> getTickets(){
        return ticketService.getAllTickets();
    }

    /**
     * Endpoint to retrieve a ticket by ID.
     * @param id The ID of the ticket to retrieve.
     * @return The ticket entity if found, or null if not.
     */
    @GetMapping("/getby/{id}")
    public Ticket getTicketById(@PathVariable long id){
        return ticketService.getById(id);
    }

    /**
     * Endpoint to delete a ticket by ID.
     * @param id The ID of the ticket to delete.
     * @return A confirmation message indicating deletion status.
     */
    @DeleteMapping("/delete/{id}")
    public String deleteTicketById(@PathVariable long id){
        ticketService.deleteId(id);
        return "Ticket removed successfully.";
    }
}
