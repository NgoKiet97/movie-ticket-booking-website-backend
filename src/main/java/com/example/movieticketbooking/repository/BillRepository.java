package com.example.movieticketbooking.repository;

import com.example.movieticketbooking.entity.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<BillEntity, Integer> {
    BillEntity findByUserIdAndStateBill(int userId, String state);

    BillEntity findByUserId(int userId);
}
