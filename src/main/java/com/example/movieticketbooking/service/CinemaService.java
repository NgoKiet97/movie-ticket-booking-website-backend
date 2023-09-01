package com.example.movieticketbooking.service;

import com.example.movieticketbooking.entity.CinemaEntity;
import com.example.movieticketbooking.entity.RoleEntity;
import com.example.movieticketbooking.payload.response.CategoryResponse;
import com.example.movieticketbooking.payload.response.CinemaResponse;
import com.example.movieticketbooking.payload.response.RoleResponse;
import com.example.movieticketbooking.repository.CinemaRepository;
import com.example.movieticketbooking.service.imp.ICategoryService;
import com.example.movieticketbooking.service.imp.ICinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CinemaService implements ICinemaService {
    @Autowired
    CinemaRepository cinemaRepository;

    @Override
    public List<CinemaResponse> getAllCinema() {
        List<CinemaEntity> cinemaEntityList = cinemaRepository.findAll();
        List<CinemaResponse> cinemaResponseList = new ArrayList<CinemaResponse>();

        for(CinemaEntity entity : cinemaEntityList){
            CinemaResponse cinemaResponse = new CinemaResponse();
            cinemaResponse.setId(entity.getId());
            cinemaResponse.setName(entity.getName());
            cinemaResponse.setAddress(entity.getAddress());

            cinemaResponseList.add(cinemaResponse);
        }
        return cinemaResponseList;
    }

    @Override
    public CinemaResponse getCinemaById(int cinemaId) {
        CinemaResponse cinemaResponse = new CinemaResponse();
        Optional<CinemaEntity> cinema = cinemaRepository.findById(cinemaId);
        if(cinema.isPresent()){
            cinemaResponse.setId(cinema.get().getId());
            cinemaResponse.setName(cinema.get().getName());
            cinemaResponse.setAddress(cinema.get().getAddress());
        }

        return cinemaResponse;
    }
}
