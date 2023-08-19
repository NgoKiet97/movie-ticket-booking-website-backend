package com.example.movieticketbooking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "bill")
@Getter @Setter
public class BillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "price")
    private double price;

    @Column(name = "qr_code")
    private String qrCode;

    @Column(name = "state_bill")
    private String stateBill;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "bill")
    private Set<TicketEntity> tickets;
}
