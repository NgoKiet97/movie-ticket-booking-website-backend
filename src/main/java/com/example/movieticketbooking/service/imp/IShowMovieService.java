package com.example.movieticketbooking.service.imp;

import com.example.movieticketbooking.payload.request.ShowMovieRequest;
import com.example.movieticketbooking.payload.response.ShowMovieResponse;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface IShowMovieService {
    List<ShowMovieResponse> getAllShowMovie();

    boolean addShowMovie(ShowMovieRequest showMovieRequest);

    List<ShowMovieResponse> getShowMovieByCinemaAndDateAndStateShow(int cinemaId, String date, String stateShow) throws ParseException;

    List<ShowMovieResponse> getShowMovieByMovieAndDateAndStateShow(int movieId, String date, String stateShow) throws ParseException;

    ShowMovieResponse getShowMovieById(int showMovieId);
}
