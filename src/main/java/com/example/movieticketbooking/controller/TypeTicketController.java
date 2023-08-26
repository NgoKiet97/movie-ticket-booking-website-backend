package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.payload.response.BaseResponse;
import com.example.movieticketbooking.service.imp.ITypeTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/type-ticket")
public class TypeTicketController {
    @Autowired
    ITypeTicketService iTypeTicketService;

    @GetMapping("")
    public ResponseEntity<?> getAllTypeTicket(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iTypeTicketService.getAllTypeTicket());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
