package com.example.movieticketbooking.payload.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BaseResponse {
    private int statusCode = 200;
    private String message = "";
    private Object data = "";

}
