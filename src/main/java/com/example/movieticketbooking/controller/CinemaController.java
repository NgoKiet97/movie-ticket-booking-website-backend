package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.payload.response.BaseResponse;
import com.example.movieticketbooking.service.imp.ICinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cinema")
@CrossOrigin
public class CinemaController {
    @Autowired
    ICinemaService iCinemaService;

    @GetMapping("")
    public ResponseEntity<?> getAllCinema(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iCinemaService.getAllCinema());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping("/detail")
    public ResponseEntity<?> getCinemaDetail(@RequestParam int cinemaId){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iCinemaService.getCinemaById(cinemaId));
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }


}
