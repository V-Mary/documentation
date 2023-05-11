package com.documentation.tickects.controller;

import com.documentation.tickects.models.Concert;
import com.documentation.tickects.models.Person;
import com.documentation.tickects.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/person")
@RestController
public class PersonController extends AbstractController<Person>{

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        super(personService);
        this.personService = personService;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") Integer personId, @RequestBody Person person) {
        person.setId(personId);
        Person updatePerson = personService.update(personId, person, new Person());
        if (updatePerson != null) {
            return new ResponseEntity<Person>(updatePerson, HttpStatus.OK);
        } else {
            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
        }
    }
}
