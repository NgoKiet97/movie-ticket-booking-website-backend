package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.payload.response.BaseResponse;
import com.example.movieticketbooking.service.imp.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    IUserService iUserService;

    @GetMapping("")
    public ResponseEntity<?> getAllUser(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iUserService.getAllUser());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping("/find-by-email")
    public ResponseEntity<?> getUserByEmail(@RequestParam String email){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iUserService.getUserByEmail(email));
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }


}
