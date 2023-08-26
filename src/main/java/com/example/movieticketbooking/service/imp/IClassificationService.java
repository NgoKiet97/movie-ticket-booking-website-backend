package com.example.movieticketbooking.service.imp;

import com.example.movieticketbooking.payload.response.ClassificationResponse;

import java.util.List;

public interface IClassificationService {
    List<ClassificationResponse> getAllClassification();
}
