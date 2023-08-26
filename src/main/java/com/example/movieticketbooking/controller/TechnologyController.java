package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.payload.response.BaseResponse;
import com.example.movieticketbooking.service.imp.ITechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/technology")
public class TechnologyController {
    @Autowired
    ITechnologyService iTechnologyService;

    @GetMapping("")
    public ResponseEntity<?> getAllTechnology(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iTechnologyService.getAllTechnology());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
