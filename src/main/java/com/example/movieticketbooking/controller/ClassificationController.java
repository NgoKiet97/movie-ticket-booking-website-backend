package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.payload.response.BaseResponse;
import com.example.movieticketbooking.service.imp.IClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classification")
public class ClassificationController {
    @Autowired
    IClassificationService iClassificationService;

    @GetMapping("")
    public ResponseEntity<?> getAllClassification(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iClassificationService.getAllClassification());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
