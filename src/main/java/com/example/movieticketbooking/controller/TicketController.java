package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.payload.request.TicketRequest;
import com.example.movieticketbooking.payload.response.BaseResponse;
import com.example.movieticketbooking.service.imp.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @PostMapping("add")
    public ResponseEntity<?> addShowMovie(@Valid @RequestBody TicketRequest ticketRequest){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage(iTicketService.addTicket(ticketRequest) ?
                "Thêm thành công": "Thêm thất bại");
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

}
