package com.example.movieticketbooking.payload.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TypeTicketResponse {
    private int id;
    private String name;
    private double price;
}
