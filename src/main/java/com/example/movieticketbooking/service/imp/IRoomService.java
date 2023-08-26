package com.example.movieticketbooking.service.imp;

import com.example.movieticketbooking.payload.response.RoomResponse;

import java.util.List;

public interface IRoomService {
    List<RoomResponse> getAllRoom();
}
