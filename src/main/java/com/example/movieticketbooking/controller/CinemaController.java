package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.payload.response.BaseResponse;
import com.example.movieticketbooking.service.imp.ICinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cinema")
public class CinemaController {
    @Autowired
    ICinemaService iCinemaService;

    @GetMapping("")
    public ResponseEntity<?> getAllCinema(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iCinemaService.getAllCinema());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
