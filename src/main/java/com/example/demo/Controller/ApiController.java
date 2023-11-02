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

//@RequiredArgsConstructor 생성자 자동생성 어노테이션인데 왜 안되는건지 모르겠다
@RestController
public class ApiController {


    private final ParkingService parkingService;

    @Autowired
    public ApiController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

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
