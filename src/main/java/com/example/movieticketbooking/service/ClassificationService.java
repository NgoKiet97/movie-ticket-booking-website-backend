package com.example.movieticketbooking.service;

import com.example.movieticketbooking.entity.ClassificationEntity;
import com.example.movieticketbooking.payload.response.ClassificationResponse;
import com.example.movieticketbooking.repository.ClassificationRepository;
import com.example.movieticketbooking.service.imp.IClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassificationService implements IClassificationService {
    @Autowired
    ClassificationRepository classificationRepository;

    @Override
    public List<ClassificationResponse> getAllClassification() {
        List<ClassificationEntity> classificationEntityList = classificationRepository.findAll();
        List<ClassificationResponse> classificationResponseList =new ArrayList<>();

        for(ClassificationEntity entity : classificationEntityList){
            ClassificationResponse classificationResponse = new ClassificationResponse();
            classificationResponse.setId(entity.getId());
            classificationResponse.setName(entity.getName());
            classificationResponse.setDescription(entity.getDescription());

            classificationResponseList.add(classificationResponse);
        }

        return classificationResponseList;
    }
}
