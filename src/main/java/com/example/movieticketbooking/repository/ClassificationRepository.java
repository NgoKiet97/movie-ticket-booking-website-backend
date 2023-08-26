package com.example.movieticketbooking.repository;

import com.example.movieticketbooking.entity.ClassificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassificationRepository extends JpaRepository<ClassificationEntity, Integer> {
}
