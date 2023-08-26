package com.example.movieticketbooking.repository;

import com.example.movieticketbooking.entity.TypeTicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeTicketRepository extends JpaRepository<TypeTicketEntity, Integer> {
}
