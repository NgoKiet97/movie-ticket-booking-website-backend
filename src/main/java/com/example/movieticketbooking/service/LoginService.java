package com.example.movieticketbooking.service;


import com.example.movieticketbooking.entity.UserEntity;
import com.example.movieticketbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public boolean checkLogin(String username, String password){
        List<UserEntity> list = userRepository.findByNameAndPassword(username,password);
        return list.size() > 0;
    }

//    public boolean insertUser(SignUpRequest signUpRequest){
//        try{
//            UserEntity user = new UserEntity();
//            user.setUsername(signUpRequest.getUsername());
//            user.setPassword(signUpRequest.getPassword());
//            user.setEmail(signUpRequest.getEmail());
//
//            userRepository.save(user);
//            return true;
//        }catch (Exception e){
//            //Xử lý lỗi
//            return false;
//        }
//
//    }

}
