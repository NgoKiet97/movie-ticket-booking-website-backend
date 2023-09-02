package com.example.movieticketbooking.service;


import com.example.movieticketbooking.entity.RoleEntity;
import com.example.movieticketbooking.entity.UserEntity;
import com.example.movieticketbooking.payload.request.SignUpRequest;
import com.example.movieticketbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public boolean checkLogin(String email, String password){
        List<UserEntity> list = userRepository.findByEmailAndPassword(email,password);
        return list.size() > 0;
    }



}
