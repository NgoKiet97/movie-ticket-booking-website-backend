package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.payload.response.BaseResponse;
import com.example.movieticketbooking.service.imp.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    IMovieService iMovieService;

    @GetMapping("")
    public ResponseEntity<?> getAllMovie(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iMovieService.getAllMovie());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
