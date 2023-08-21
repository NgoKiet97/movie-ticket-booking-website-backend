package com.example.movieticketbooking.repository;

import com.example.movieticketbooking.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findByNameAndPassword(String name, String password);
    UserEntity findByName(String name);
}
