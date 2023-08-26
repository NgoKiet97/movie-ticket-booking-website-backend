package com.example.movieticketbooking.service;

import com.example.movieticketbooking.entity.RoleEntity;
import com.example.movieticketbooking.payload.response.RoleResponse;
import com.example.movieticketbooking.repository.RoleRepository;
import com.example.movieticketbooking.service.imp.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService implements IRoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<RoleResponse> getAllRole() {
        List<RoleEntity> roleEntityList = roleRepository.findAll();
        List<RoleResponse> roleResponseList = new ArrayList<RoleResponse>();

        for(RoleEntity entity : roleEntityList){
            RoleResponse roleResponse = new RoleResponse();
            roleResponse.setId(entity.getId());
            roleResponse.setName(entity.getName());
            roleResponse.setDescription(entity.getDescription());

            roleResponseList.add(roleResponse);
        }
        return roleResponseList;
    }
}
