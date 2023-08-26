package com.example.movieticketbooking.service;

import com.example.movieticketbooking.entity.RoleEntity;
import com.example.movieticketbooking.entity.SeatEntity;
import com.example.movieticketbooking.payload.response.RoleResponse;
import com.example.movieticketbooking.payload.response.SeatResponse;
import com.example.movieticketbooking.repository.SeatRepository;
import com.example.movieticketbooking.service.imp.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeatService implements ISeatService {
    @Autowired
    SeatRepository seatRepository;

    @Override
    public List<SeatResponse> getAllSeat() {
        List<SeatEntity> seatEntityList = seatRepository.findAll();
        List<SeatResponse> seatResponseList = new ArrayList<SeatResponse>();

        for(SeatEntity entity : seatEntityList){
            SeatResponse seatResponse = new SeatResponse();
            seatResponse.setId(entity.getId());
            seatResponse.setName(entity.getName());
            seatResponse.setRoom(entity.getRoom().getName());

            seatResponseList.add(seatResponse);
        }

        return seatResponseList;
    }
}
