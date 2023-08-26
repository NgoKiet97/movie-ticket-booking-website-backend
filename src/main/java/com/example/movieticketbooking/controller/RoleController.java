package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.payload.response.BaseResponse;
import com.example.movieticketbooking.service.imp.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    IRoleService iRoleService;

    @GetMapping("")
    public ResponseEntity<?> getAllRole(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iRoleService.getAllRole());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
