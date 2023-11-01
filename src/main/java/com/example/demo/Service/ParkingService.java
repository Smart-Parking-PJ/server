package com.example.demo.Service;

import com.example.demo.Model.ParkingInfo;

import java.util.List;


public interface ParkingService {
    ParkingInfo saveParkingInfo(ParkingInfo parkingInfo);
    List<ParkingInfo> getAllParkingInfo();



}
