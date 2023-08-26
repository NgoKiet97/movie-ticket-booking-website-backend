package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.payload.response.BaseResponse;
import com.example.movieticketbooking.service.imp.IStateTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/state ticket")
public class StateTicketController {
    @Autowired
    IStateTicketService iStateTicketService;

    @GetMapping("")
    public ResponseEntity<?> getAllStateTicket(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iStateTicketService.getAllStateTicket());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
