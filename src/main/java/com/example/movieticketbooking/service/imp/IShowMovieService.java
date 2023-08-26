package com.example.movieticketbooking.service.imp;

import com.example.movieticketbooking.payload.response.ShowMovieResponse;

import java.util.List;

public interface IShowMovieService {
    List<ShowMovieResponse> getAllShowMovie();
}
