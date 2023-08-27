package com.example.movieticketbooking.controller;

import com.example.movieticketbooking.payload.request.ShowMovieRequest;
import com.example.movieticketbooking.payload.response.BaseResponse;
import com.example.movieticketbooking.service.imp.IShowMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/show-movie")
public class ShowMovieController {
    @Autowired
    IShowMovieService iShowMovieService;

    @GetMapping("")
    public ResponseEntity<?> getAllShowMovie(){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(iShowMovieService.getAllShowMovie());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addShowMovie(@Valid @RequestBody ShowMovieRequest showMovieRequest){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage(iShowMovieService.addShowMovie(showMovieRequest) ?
                "Thêm thành công": "Thêm thất bại");
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

}
