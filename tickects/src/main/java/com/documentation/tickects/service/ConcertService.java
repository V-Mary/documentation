package com.documentation.tickects.service;

import com.documentation.tickects.models.Concert;
import com.documentation.tickects.repository.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ConcertService extends AbstractService<Concert>{
    @Autowired
    public ConcertService(ConcertRepository concertRepository) {
        super(concertRepository);
    }

    @Override
    public Concert mapCsvToObject(String[] objectCsv) {
        String name = objectCsv[1];
        LocalDateTime dateAndTime = LocalDateTime.parse(objectCsv[2]);
        String concertType = objectCsv[3];

        return new Concert(name, dateAndTime, concertType);
    }
}
