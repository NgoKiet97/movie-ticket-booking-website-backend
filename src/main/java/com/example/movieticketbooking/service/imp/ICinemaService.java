package com.example.movieticketbooking.service.imp;

import com.example.movieticketbooking.payload.response.CinemaResponse;

import java.util.List;

public interface ICinemaService {
    List<CinemaResponse> getAllCinema();
}
