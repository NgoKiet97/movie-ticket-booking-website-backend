package com.example.movieticketbooking.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BillRequest {
    private int userId;
    private double price;
    private String stateBill;
}
