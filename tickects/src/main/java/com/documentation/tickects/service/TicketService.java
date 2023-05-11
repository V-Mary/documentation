package com.documentation.tickects.service;

import com.documentation.tickects.models.Concert;
import com.documentation.tickects.models.Person;
import com.documentation.tickects.models.Ticket;
import com.documentation.tickects.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TicketService extends AbstractService<Ticket>{

    private final ConcertService concertService;

    @Autowired
    public TicketService(TicketRepository ticketRepository, ConcertService concertService) {
        super(ticketRepository);
        this.concertService = concertService;
    }

//    @Autowired
//    public TicketService(TicketRepository ticketRepository) {
//        super(ticketRepository);
//    }

    @Override
    public Ticket mapCsvToObject(String[] objectCsv) {
        Integer seat_number = Integer.parseInt(objectCsv[1]);
        Integer price = Integer.parseInt(objectCsv[2]);
        Concert concert_id = concertService.getById(Integer.parseInt(objectCsv[3]));

        return new Ticket(concert_id, seat_number, price);
//        return new Ticket(seat_number, price);
    }
}
