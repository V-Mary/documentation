package com.documentation.tickects.controller;

import com.documentation.tickects.models.Concert;
import com.documentation.tickects.service.ConcertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/concert")
@RestController
public class ConcertController extends AbstractController<Concert> {

    private final ConcertService concertService;

    @Autowired
    public ConcertController(ConcertService concertService) {
        super(concertService);
        this.concertService = concertService;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Concert> updateConcert(@PathVariable("id") Integer concertId, @RequestBody Concert concert) {
        concert.setId(concertId);
        Concert updatedConcert = concertService.update(concertId, concert, new Concert());
        if (updatedConcert != null) {
            return new ResponseEntity<Concert>(updatedConcert, HttpStatus.OK);
        } else {
            return new ResponseEntity<Concert>(HttpStatus.NOT_FOUND);
        }
    }
}