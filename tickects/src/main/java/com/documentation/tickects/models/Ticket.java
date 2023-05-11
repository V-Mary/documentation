package com.documentation.tickects.models;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "concert_id", referencedColumnName = "id", nullable = false)
    private Concert concert_id;

    @Column(nullable = false)
    private Integer seat_number;

    @Column(nullable = false)
    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Concert getConcert_id() {
        return concert_id;
    }

    public Ticket(Integer price, Integer seat_number, Concert concert_id) {
        this.seat_number = seat_number;
        this.price = price;
        this.concert_id = concert_id;
    }

    public void setConcert_id(Concert concert_id) {
        this.concert_id = concert_id;
    }

    public Integer getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(Integer seat_number) {
        this.seat_number = seat_number;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Ticket() {
    }

    public Ticket(Concert concert_id, Integer seat_number, Integer price) {
        super();
        this.concert_id = concert_id;
        this.seat_number = seat_number;
        this.price = price;
    }

    public String[] toCsvFormat() {
        String[] record = { "TICKET", this.price.toString(),
                this.seat_number.toString(), this.concert_id.getId().toString() };
        return record;
    }
}
