package com.example.movieticketbooking.service.imp;

import com.example.movieticketbooking.payload.response.SeatResponse;

import java.util.List;

public interface ISeatService {
    List<SeatResponse> getAllSeat();

    SeatResponse getByNameAndRoomId(String name, int roomId);
}
