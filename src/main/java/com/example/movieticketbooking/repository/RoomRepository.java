package com.example.movieticketbooking.repository;

import com.example.movieticketbooking.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<RoomEntity, Integer> {
}
