package com.example.demo.Controller;

import com.example.demo.Model.ParkingInfo;
import com.example.demo.Service.ParkingService;
import com.example.demo.Service.TransactionService;
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

    @Autowired
    private TransactionService transactionService;
    private final ParkingService parkingService;

    @Autowired
    public ApiController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @PostMapping("/parking")
    public ResponseEntity<String> addParkingInfo(@RequestBody ParkingInfo data) {
        try {
            // 이미지를 받아서 ParkingInfo 객체에 저장
            byte[] imageData = data.getImage();

            // 데이터베이스에 저장할 ParkingInfo 객체 생성
            ParkingInfo parkingInfo = new ParkingInfo();
            parkingInfo.setEntryTime(data.getEntryTime());
            parkingInfo.setEmptyspace(data.getEmptyspace());
            parkingInfo.setCurrentcar(data.getCurrentcar());
            parkingInfo.setParkingname(data.getParkingname());
            parkingInfo.setImage(imageData); // 이미지 데이터 설정

            transactionService.saveData(parkingInfo); // 데이터베이스에 저장
            return ResponseEntity.ok("Data saved successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save the data.");
        }
    }

    @GetMapping("/parking")
    public List<ParkingInfo> getAllParkingInfo() {
        return parkingService.getAllParkingInfo();
    }
}
