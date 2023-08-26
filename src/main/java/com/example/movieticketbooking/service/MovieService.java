package com.example.movieticketbooking.service;

import com.example.movieticketbooking.entity.MovieEntity;
import com.example.movieticketbooking.payload.response.MovieResponse;
import com.example.movieticketbooking.payload.response.RoleResponse;
import com.example.movieticketbooking.repository.MovieRepository;
import com.example.movieticketbooking.service.imp.IMovieService;
import com.example.movieticketbooking.utils.DateHelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService implements IMovieService {
    @Autowired
    MovieRepository movieRepository;

    @Value("${host.name}")
    String hostname;

    @Override
    public List<MovieResponse> getAllMovie() {
        List<MovieEntity> movieEntityList = movieRepository.findAll();
        List<MovieResponse> movieResponseList = new ArrayList<MovieResponse>();

        for(MovieEntity entity : movieEntityList){
            MovieResponse movieResponse = new MovieResponse();

            movieResponse.setId(entity.getId());
            movieResponse.setName(entity.getName());
            movieResponse.setImageThumbnail(hostname + "/download/movie/" + entity.getImageThumbnail());
            movieResponse.setImagePoster(hostname + "/download/movie/" + entity.getImagePoster());
            movieResponse.setDescription(entity.getDescription());
            movieResponse.setDuration(entity.getDuration());
            movieResponse.setCategory(entity.getCategory().getName());
            movieResponse.setDirector(entity.getDirector());
            movieResponse.setActor(entity.getActor());
            movieResponse.setTrailer(entity.getTrailer());
            movieResponse.setTechnology(entity.getTechnology().getName());
            movieResponse.setClassification(entity.getClassification().getName());

            DateHelperUtils dateHelperUtils = new DateHelperUtils();
            movieResponse.setReleaseDate(dateHelperUtils.formatDateToString(entity.getReleaseDate()));

            movieResponseList.add(movieResponse);
        }
        return movieResponseList;
    }
}
