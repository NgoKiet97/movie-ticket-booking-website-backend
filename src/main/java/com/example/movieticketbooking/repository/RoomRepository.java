package com.example.movieticketbooking.repository;

import com.example.movieticketbooking.entity.CinemaEntity;
import com.example.movieticketbooking.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {
    List<RoomEntity> findByCinemaId(int cinemaId);
}
