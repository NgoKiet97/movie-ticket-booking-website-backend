package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.payload.response.BaseResponse;
import com.example.movieticketbooking.service.imp.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    ITicketService iTicketService;


    @GetMapping("")
    public ResponseEntity<?> getAllTicket(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iTicketService.getAllTicket());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

}
