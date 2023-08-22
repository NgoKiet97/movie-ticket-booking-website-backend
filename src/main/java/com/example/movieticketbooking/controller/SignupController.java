package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.payload.request.SignUpRequest;
import com.example.movieticketbooking.payload.response.BaseResponse;
import com.example.movieticketbooking.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
@CrossOrigin
public class SignupController {

    @Autowired
    private SignupService signupService;

    @PostMapping("")
    public ResponseEntity<?> signup(@RequestBody SignUpRequest signUpRequest){
        boolean isSuccess = signupService.addUserMember(signUpRequest);
        BaseResponse response = new BaseResponse();
        response.setMessage(isSuccess ? "Đăng ký thành công" : "Đăng ký thất bại");
        response.setData(isSuccess);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
