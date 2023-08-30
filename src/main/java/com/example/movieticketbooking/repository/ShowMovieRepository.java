package com.example.movieticketbooking.repository;

import com.example.movieticketbooking.entity.RoomEntity;
import com.example.movieticketbooking.entity.ShowMovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ShowMovieRepository extends JpaRepository<ShowMovieEntity, Integer> {
    List<ShowMovieEntity> findByRoomEntityAndDateAndStateShow(RoomEntity roomEntity, Date date, String stateShow);
}
