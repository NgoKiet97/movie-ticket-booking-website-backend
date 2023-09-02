package com.example.movieticketbooking.service.imp;

import com.example.movieticketbooking.payload.response.UserResponse;

import java.util.List;

public interface IUserService {
    List<UserResponse> getAllUser();

    UserResponse getUserByEmail(String email);
}
