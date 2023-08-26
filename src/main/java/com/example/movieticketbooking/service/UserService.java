package com.example.movieticketbooking.service;

import com.example.movieticketbooking.entity.UserEntity;
import com.example.movieticketbooking.payload.response.UserResponse;
import com.example.movieticketbooking.repository.UserRepository;
import com.example.movieticketbooking.service.imp.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserResponse> getAllUser() {
        List<UserEntity> userEntityList = userRepository.findAll();
        List<UserResponse> userResponseList = new ArrayList<UserResponse>();

        for (UserEntity entity: userEntityList  ) {
            UserResponse userResponse = new UserResponse();
            userResponse.setId(entity.getId());
            userResponse.setName(entity.getName());
            userResponse.setAge(entity.getAge());
            userResponse.setEmail(entity.getEmail());
            userResponse.setAddress(entity.getAddress());
            userResponse.setRole(entity.getRole().getDescription());

            userResponseList.add(userResponse);
        }

        return userResponseList;
    }
}
