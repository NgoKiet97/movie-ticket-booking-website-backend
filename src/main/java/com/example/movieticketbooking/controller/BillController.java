package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.payload.request.BillRequest;
import com.example.movieticketbooking.payload.response.BaseResponse;
import com.example.movieticketbooking.service.imp.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/bill")
@CrossOrigin
public class BillController {
    @Autowired
    IBillService iBillService;

    @GetMapping("")
    public ResponseEntity<?> getAllBill(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iBillService.getAllBill());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping("/find-by-user-and-state")
    public ResponseEntity<?> getBillByUserAndState(
            @RequestParam int userId,
            @RequestParam String state
    ){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iBillService.getBillByUserAndState(userId, state));
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping("/find-by-user")
    public ResponseEntity<?> getBillByUser(
            @RequestParam int userId
    ){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iBillService.getBillByUser(userId));
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addBill(@Valid @RequestBody BillRequest billRequest){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage(iBillService.addBill(billRequest) ?
                "Thêm thành công": "Thêm thất bại");
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
