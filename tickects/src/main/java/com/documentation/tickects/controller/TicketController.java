package com.documentation.tickects.controller;

import com.documentation.tickects.models.Concert;
import com.documentation.tickects.models.Ticket;
import com.documentation.tickects.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


@RequestMapping("/ticket")
@RestController
public class TicketController extends AbstractController<Ticket>{

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService){
        super(ticketService);
        this.ticketService = ticketService;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Ticket> updateConcert(@PathVariable("id") Integer ticketId, @RequestBody Ticket ticket){
        ticket.setId(ticketId);
        Ticket updatedTicket = ticketService.update(ticketId, ticket, new Ticket());
        if (updatedTicket != null) {
            return new ResponseEntity<Ticket>(updatedTicket, HttpStatus.OK);
        } else {
            return new ResponseEntity<Ticket>(HttpStatus.NOT_FOUND);
        }
    }
}
