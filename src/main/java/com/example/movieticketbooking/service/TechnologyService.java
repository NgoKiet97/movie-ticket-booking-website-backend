package com.example.movieticketbooking.service;

import com.example.movieticketbooking.entity.ClassificationEntity;
import com.example.movieticketbooking.entity.TechnologyEntity;
import com.example.movieticketbooking.payload.response.ClassificationResponse;
import com.example.movieticketbooking.payload.response.TechnologyResponse;
import com.example.movieticketbooking.repository.TechnologyRepository;
import com.example.movieticketbooking.service.imp.ITechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechnologyService implements ITechnologyService {
    @Autowired
    TechnologyRepository technologyRepository;

    @Override
    public List<TechnologyResponse> getAllTechnology() {
        List<TechnologyEntity> technologyEntityList = technologyRepository.findAll();
        List<TechnologyResponse> technologyResponseList =new ArrayList<>();

        for(TechnologyEntity entity : technologyEntityList){
            TechnologyResponse technologyResponse = new TechnologyResponse();
            technologyResponse.setId(entity.getId());
            technologyResponse.setName(entity.getName());

            technologyResponseList.add(technologyResponse);
        }
        return technologyResponseList;
    }
}
