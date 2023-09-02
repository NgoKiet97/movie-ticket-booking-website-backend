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
@CrossOrigin
public class TicketController {
    @Autowired
    ITicketService iTicketService;


    @GetMapping("")
    public ResponseEntity<?> getAllTicket(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iTicketService.getAllTicket());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping("/find-by-show-and-state")
    public ResponseEntity<?> getTicketByShowMovieAndStateTicket(
            @RequestParam int showMovieId,
            @RequestParam int stateTicketId
    ){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iTicketService.getTicketByShowMovieAndStateTicket(showMovieId, stateTicketId));
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<?> addTicket(@Valid @RequestBody TicketRequest ticketRequest){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage(iTicketService.addTicket(ticketRequest) ?
                "Đặt vé thành công": "Đặt vé thất bại");
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }



}
