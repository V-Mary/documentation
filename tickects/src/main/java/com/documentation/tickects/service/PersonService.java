package com.documentation.tickects.service;

import com.documentation.tickects.models.Concert;
import com.documentation.tickects.models.Person;
import com.documentation.tickects.models.Ticket;
import com.documentation.tickects.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends AbstractService<Person>{

    private final TicketService ticketService;

    @Autowired
    public PersonService(PersonRepository personRepository, TicketService ticketService) {
        super(personRepository);
        this.ticketService = ticketService;
    }

    @Override
    public Person mapCsvToObject(String[] objectCsv) {
        String firts_name = objectCsv[1];
        String last_name = objectCsv[2];
        String email = objectCsv[3];
        Ticket ticket = ticketService.getById(Integer.parseInt(objectCsv[4]));

        return new Person(firts_name, last_name, email ,ticket);
    }

}
