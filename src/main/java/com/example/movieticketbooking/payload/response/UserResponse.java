package com.example.movieticketbooking.payload.response;

import com.example.movieticketbooking.entity.RoleEntity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserResponse {
    private int id;
    private String name ;
    private String email;
    private String address;
    private int age;
    private String avatar;
    private String role;
}
