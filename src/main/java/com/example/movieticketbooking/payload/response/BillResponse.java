package com.example.movieticketbooking.payload.response;

import com.example.movieticketbooking.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BillResponse {

    private int id;
    private String user;
    private double price;
    private String qrCode;
    private String stateBill;
}
