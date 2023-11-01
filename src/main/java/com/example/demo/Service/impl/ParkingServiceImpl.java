package com.example.demo.Service.impl;

import com.example.demo.Model.ParkingInfo;
import com.example.demo.Repository.ParkingInfoRepository;
import com.example.demo.Service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ParkingServiceImpl implements ParkingService {
    private final ParkingInfoRepository parkingInfoRepository;

    @Autowired
    public ParkingServiceImpl(ParkingInfoRepository parkingInfoRepository) {
        this.parkingInfoRepository = parkingInfoRepository;
    }

    @Override
    public ParkingInfo saveParkingInfo(ParkingInfo parkingInfo) {
        return parkingInfoRepository.save(parkingInfo);
    }

    @Override
    public List<ParkingInfo> getAllParkingInfo() {
        return (List<ParkingInfo>) parkingInfoRepository.findAll();
    }

}
