package com.example.movieticketbooking.service;

import com.example.movieticketbooking.entity.BillEntity;
import com.example.movieticketbooking.payload.response.BillResponse;
import com.example.movieticketbooking.repository.BillRepository;
import com.example.movieticketbooking.service.imp.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BillService implements IBillService {
    @Autowired
    BillRepository billRepository;

    @Override
    public List<BillResponse> getAllBill() {
        List<BillEntity> billEntityList = billRepository.findAll();
        List<BillResponse> billResponseList = new ArrayList<BillResponse>();

        for(BillEntity entity : billEntityList){
            BillResponse billResponse = new BillResponse();
            billResponse.setId(entity.getId());
            billResponse.setUser(entity.getUser().getName());
            billResponse.setPrice(entity.getPrice());
            billResponse.setStateBill(entity.getStateBill());
            billResponse.setQrCode(entity.getQrCode());

            billResponseList.add(billResponse);
        }

        return billResponseList;
    }
}
