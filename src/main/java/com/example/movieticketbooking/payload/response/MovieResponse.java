package com.example.movieticketbooking.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class MovieResponse {
    private int id;
    private String name;
    private String imageThumbnail;
    private String imagePoster;
    private String description;
    private double duration;
    private String category;
    private String director;
    private String actor;
    private String trailer;
    private String technology;
    private String releaseDate;
    private String classification;
}
