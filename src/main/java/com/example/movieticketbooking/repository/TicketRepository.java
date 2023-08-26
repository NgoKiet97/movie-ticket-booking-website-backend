package com.example.movieticketbooking.repository;

import com.example.movieticketbooking.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
}
