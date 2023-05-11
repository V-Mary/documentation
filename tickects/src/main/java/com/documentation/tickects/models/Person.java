package com.documentation.tickects.models;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String firts_name;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "ticket_id", referencedColumnName = "id", nullable = false)
    private Ticket ticket;

    public Person() {
    }

    public Person(String firts_name, String last_name, String email, Ticket ticket_id) {
        super();
        this.firts_name = firts_name;
        this.last_name = last_name;
        this.email = email;
        this.ticket = ticket_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirts_name() {
        return firts_name;
    }

    public void setFirts_name(String firts_name) {
        this.firts_name = firts_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Ticket getTicket_id() {
        return ticket;
    }

    public void setTicket_id(Ticket ticket_id) {
        this.ticket = ticket_id;
    }

    public String[] toCsvFormat() {
        String[] record = { "PERSON", this.firts_name, this.last_name, this.email, this.ticket.toString() };
        return record;
    }
}
