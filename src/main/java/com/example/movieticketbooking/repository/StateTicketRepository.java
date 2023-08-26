package com.example.movieticketbooking.repository;

import com.example.movieticketbooking.entity.StateTicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateTicketRepository extends JpaRepository<StateTicketEntity, Integer> {
}
