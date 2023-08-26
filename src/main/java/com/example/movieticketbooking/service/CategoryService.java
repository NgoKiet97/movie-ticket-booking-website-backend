package com.example.movieticketbooking.service;

import com.example.movieticketbooking.entity.CategoryEntity;
import com.example.movieticketbooking.entity.RoleEntity;
import com.example.movieticketbooking.payload.response.CategoryResponse;
import com.example.movieticketbooking.payload.response.RoleResponse;
import com.example.movieticketbooking.repository.CategoryRepository;
import com.example.movieticketbooking.service.imp.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    CategoryRepository categoryRepository;


    @Override
    public List<CategoryResponse> getAllCategory() {
        List<CategoryEntity> categoryEntityList = categoryRepository.findAll();
        List<CategoryResponse> categoryResponseList = new ArrayList<CategoryResponse>();

        for(CategoryEntity entity : categoryEntityList){
            CategoryResponse categoryResponse = new CategoryResponse();
            categoryResponse.setId(entity.getId());
            categoryResponse.setName(entity.getName());

            categoryResponseList.add(categoryResponse);
        }
        return categoryResponseList;
    }
}
