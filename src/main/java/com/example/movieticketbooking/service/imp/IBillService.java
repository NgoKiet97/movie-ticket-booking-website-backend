package com.example.movieticketbooking.service.imp;

import com.example.movieticketbooking.entity.BillEntity;
import com.example.movieticketbooking.payload.response.BillResponse;

import java.util.List;

public interface IBillService {
    List<BillResponse> getAllBill();
}
