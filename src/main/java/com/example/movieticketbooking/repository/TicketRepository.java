package com.example.movieticketbooking.repository;

import com.example.movieticketbooking.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
    List<TicketEntity> findByShowMovieIdAndStateTicketId(int showMovieId, int stateTicketId);
}
