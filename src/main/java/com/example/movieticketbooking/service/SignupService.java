package com.example.movieticketbooking.service;

import com.example.movieticketbooking.entity.RoleEntity;
import com.example.movieticketbooking.entity.UserEntity;
import com.example.movieticketbooking.payload.request.SignUpRequest;
import com.example.movieticketbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignupService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public boolean addUserMember(SignUpRequest signUpRequest){
        try{
            UserEntity user = new UserEntity();
            RoleEntity role = new RoleEntity();
            role.setId(4);

            user.setName(signUpRequest.getName());
            user.setEmail(signUpRequest.getEmail());
            user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
            user.setAddress(signUpRequest.getAddress());
            user.setAge(signUpRequest.getAge());
            user.setAvatar(signUpRequest.getAvatar());
            user.setRole(role);

            userRepository.save(user);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
