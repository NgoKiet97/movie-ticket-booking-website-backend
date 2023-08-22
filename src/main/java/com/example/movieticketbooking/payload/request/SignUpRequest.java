package com.example.movieticketbooking.payload.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SignUpRequest {
    private String name;
    private String email;
    private String password;
    private String address;
    private int age;
    private String avatar;

}
