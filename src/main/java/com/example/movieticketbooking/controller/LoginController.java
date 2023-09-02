package com.example.movieticketbooking.controller;


import com.example.movieticketbooking.payload.response.BaseResponse;
import com.example.movieticketbooking.service.LoginService;
import com.example.movieticketbooking.utils.JWTHelperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JWTHelperUtils jwtHelperUtils;
    @Autowired
    private LoginService loginService;

    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String email, @RequestParam String password){
        UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(email,password);
//     Thực thi chứng thực sử dụng CustomAuthenProvider
        authenticationManager.authenticate(user);
//       Chứng thực hành công thì code sẽ chạy tiếp và tạo token
        String token = jwtHelperUtils.generateToken(email);

        BaseResponse response = new BaseResponse();
        response.setMessage("Đăng nhập thành công");
        response.setData(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
