package com.example.demo.Service;

import com.example.demo.Model.ParkingInfo;

import java.util.List;
import java.util.Optional;


public interface ParkingService {
    ParkingInfo saveParkingInfo(ParkingInfo parkingInfo);
    List<ParkingInfo> getAllParkingInfo();
    public Optional<ParkingInfo> getParkingInfoById(Integer id);



}
