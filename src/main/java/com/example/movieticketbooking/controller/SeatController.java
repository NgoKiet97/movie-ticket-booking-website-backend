package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.payload.response.BaseResponse;
import com.example.movieticketbooking.service.imp.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seat")
@CrossOrigin
public class SeatController {
    @Autowired
    ISeatService iSeatService;

    @GetMapping("")
    public ResponseEntity<?> getAllSeat(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iSeatService.getAllSeat());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping("/find-by-name-and-room")
    public ResponseEntity<?> getSeatByNameAndRoom(
            @RequestParam String name,
            @RequestParam int roomId
    ){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iSeatService.getByNameAndRoomId(name, roomId));
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

}
