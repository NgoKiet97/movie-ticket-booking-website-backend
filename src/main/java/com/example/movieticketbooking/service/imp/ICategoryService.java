package com.example.movieticketbooking.service.imp;

import com.example.movieticketbooking.payload.response.CategoryResponse;

import java.util.List;

public interface ICategoryService {
    List<CategoryResponse> getAllCategory();
}
