package com.example.movieticketbooking.repository;

import com.example.movieticketbooking.entity.SeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<SeatEntity, Integer> {
    SeatEntity findByNameAndRoomId(String name, int roomId);
}
