package com.example.movieticketbooking.service.imp;

import com.example.movieticketbooking.payload.response.MovieResponse;

import java.util.List;

public interface IMovieService {
    List<MovieResponse> getAllMovie();
}
