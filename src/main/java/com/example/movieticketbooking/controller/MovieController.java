package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.payload.response.BaseResponse;
import com.example.movieticketbooking.service.imp.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
@CrossOrigin
public class MovieController {
    @Autowired
    IMovieService iMovieService;

    @GetMapping("")
    public ResponseEntity<?> getAllMovie(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iMovieService.getAllMovie());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping("/detail")
    public ResponseEntity<?> getMovieDetail(@RequestParam int movieId){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iMovieService.getMovieById(movieId));
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
