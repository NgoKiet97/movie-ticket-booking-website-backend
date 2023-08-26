package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.payload.response.BaseResponse;
import com.example.movieticketbooking.service.imp.IShowMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show-movie")
public class ShowMovieController {
    @Autowired
    IShowMovieService iShowMovieService;

    @GetMapping("")
    public ResponseEntity<?> getAllShowMovie(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iShowMovieService.getAllShowMovie());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

}
