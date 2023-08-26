package com.example.movieticketbooking.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity(name = "movie")
@Getter
@Setter
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "image_thumbnail")
    private String imageThumbnail;

    @Column(name = "image_poster")
    private String imagePoster;

    @Column(name = "description")
    private String description;

    @Column(name = "duration")
    private double duration;

    @Column(name = "director")
    private String director;

    @Column(name = "actor")
    private String actor;

    @Column(name = "trailer")
    private String trailer;

    @Column(name = "release_date")
    private Date releaseDate;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "technology_id")
    private TechnologyEntity technology;

    @ManyToOne
    @JoinColumn(name = "classification_id")
    private ClassificationEntity classification;

    @OneToMany(mappedBy = "movie")
    private Set<ShowMovieEntity> showMovies;
}
