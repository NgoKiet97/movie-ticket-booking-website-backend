package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.payload.response.BaseResponse;
import com.example.movieticketbooking.service.imp.ITypeTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/type-ticket")
@CrossOrigin
public class TypeTicketController {
    @Autowired
    ITypeTicketService iTypeTicketService;

    @GetMapping("")
    public ResponseEntity<?> getAllTypeTicket(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iTypeTicketService.getAllTypeTicket());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<?> getTypeTicketById(@RequestParam int typeId){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iTypeTicketService.getTypeTicketById(typeId));
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
