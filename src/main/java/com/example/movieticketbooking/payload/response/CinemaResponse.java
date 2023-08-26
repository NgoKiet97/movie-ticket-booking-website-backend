package com.example.movieticketbooking.payload.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CinemaResponse {
    private int id;
    private String name;
    private String address;
}
