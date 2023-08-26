package com.example.movieticketbooking.service;

import com.example.movieticketbooking.entity.RoleEntity;
import com.example.movieticketbooking.entity.RoomEntity;
import com.example.movieticketbooking.payload.response.RoleResponse;
import com.example.movieticketbooking.payload.response.RoomResponse;
import com.example.movieticketbooking.repository.RoomRepository;
import com.example.movieticketbooking.service.imp.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService implements IRoomService {
    @Autowired
    RoomRepository roomRepository;

    @Override
    public List<RoomResponse> getAllRoom() {
        List<RoomEntity> roomEntityList = roomRepository.findAll();
        List<RoomResponse> roomResponseList = new ArrayList<RoomResponse>();

        for(RoomEntity entity : roomEntityList){
            RoomResponse roomResponse = new RoomResponse();
            roomResponse.setId(entity.getId());
            roomResponse.setName(entity.getName());
            roomResponse.setCinema(entity.getCinema().getName());
            roomResponseList.add(roomResponse);
        }

        return roomResponseList;
    }
}
