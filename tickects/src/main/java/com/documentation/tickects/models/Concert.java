package com.documentation.tickects.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "concert")
public class Concert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LocalDateTime dateAndTime;

    @Column(nullable = false)
    private String concertType;

    public Concert(){

    }

    public Concert(Integer id, String name, LocalDateTime dateAndTime, String concertType) {
        this.id = id;
        this.name = name;
        this.dateAndTime = dateAndTime;
        this.concertType = concertType;
    }

    public Concert(String name, LocalDateTime dateAndTime, String concertType) {
        super();
        this.name = name;
        this.dateAndTime = dateAndTime;
        this.concertType = concertType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getConcertType() {
        return concertType;
    }

    public void setConcertType(String concertType) {
        this.concertType = concertType;
    }

    public String[] toCsvFormat() {
        String[] record = { "CONCERT", this.name, this.dateAndTime.toString(), this.concertType.toString() };
        return record;
    }
}
