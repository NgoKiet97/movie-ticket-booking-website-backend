package com.example.movieticketbooking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "type_ticket")
@Getter @Setter
public class TypeTicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "ticket_price")
    private double ticketPrice;

    @OneToMany(mappedBy = "typeTicket")
    private Set<TicketEntity> tickets;
}
