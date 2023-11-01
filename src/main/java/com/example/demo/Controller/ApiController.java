package com.example.demo.Controller;

import com.example.demo.Model.ParkingInfo;
import com.example.demo.Service.ParkingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ApiController {


    private final ParkingService parkingService;

    @PostMapping("/parking")
    public ResponseEntity<String> addParkingInfo(@RequestBody ParkingInfo parkingInfo) {
        ParkingInfo savedParkingInfo = parkingService.saveParkingInfo(parkingInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body("Parking information saved with ID: " + savedParkingInfo.getId());
    }

    @GetMapping("/parking")
    public List<ParkingInfo> getAllParkingInfo() {
        return parkingService.getAllParkingInfo();
    }
}
