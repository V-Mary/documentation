package com.documentation.tickects.service;

import com.documentation.tickects.models.Concert;
import com.documentation.tickects.models.Person;
import com.documentation.tickects.models.Ticket;
import com.documentation.tickects.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBLoaderService {

    @Autowired
    FileRepository repository;

    ConcertService concertService;
    PersonService personService;
    TicketService ticketService;


    @Autowired
    public DBLoaderService(ConcertService concertService, PersonService personService, TicketService ticketService) {
        this.concertService = concertService;
        this.personService = personService;
        this.ticketService = ticketService;
    }

    public void dumpCsvToDB(String filepath) {
        List<String[]> data = repository.readAll(filepath);
        data.forEach(entry -> {
            if (entry[0].equals("PERSON")) {
                Person person = personService.mapCsvToObject(entry);
                personService.saveToDatabase(person);
            } else if (entry[0].equals("CONCERT")) {
                Concert contact = concertService.mapCsvToObject(entry);
                concertService.saveToDatabase(contact);
            } else if (entry[0].equals("TICKET")) {
                Ticket ticket = ticketService.mapCsvToObject(entry);
                ticketService.saveToDatabase(ticket);
            }
        });
    }
}
