package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.payload.response.BaseResponse;
import com.example.movieticketbooking.service.imp.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    IRoomService iRoomService;

    @GetMapping("")
    public ResponseEntity<?> getAllRoom(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iRoomService.getAllRoom());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
