package com.example.demo.Service;

import com.example.demo.Model.ParkingInfo;
import com.example.demo.Repository.ParkingInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TransactionService {
    @Autowired
    private ParkingInfoRepository parkingInfoRepository;

    @Transactional
    public void saveData(ParkingInfo data){
        try{
            parkingInfoRepository.save(data);
        }catch(Exception e){

        }
    }

}
