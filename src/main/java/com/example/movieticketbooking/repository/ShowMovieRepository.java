package com.example.movieticketbooking.repository;

import com.example.movieticketbooking.entity.ShowMovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowMovieRepository extends JpaRepository<ShowMovieEntity, Integer> {
}
