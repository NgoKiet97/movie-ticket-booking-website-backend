package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.payload.response.BaseResponse;
import com.example.movieticketbooking.service.imp.ISeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seat")
public class SeatController {
    @Autowired
    ISeatService iSeatService;

    @GetMapping("")
    public ResponseEntity<?> getAllSeat(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iSeatService.getAllSeat());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

}
