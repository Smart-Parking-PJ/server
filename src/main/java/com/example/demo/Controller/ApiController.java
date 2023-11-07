package com.example.demo.Controller;

import com.example.demo.Model.ParkingInfo;
import com.example.demo.Service.ParkingService;
import com.example.demo.Service.TransactionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PatchMapping("/test")
    public ResponseEntity<String> addParkingInfo(@RequestBody ParkingInfo data) {
        transactionService.saveData(data);
        return ResponseEntity.ok("Data saved successfully.");
    }

    @PatchMapping("/parking")
    public ResponseEntity<String> addParkingInfoWithImage(@RequestPart("file") MultipartFile file, @RequestPart("data") String data) {
        try {
            // MultipartFile에서 이미지 데이터(byte 배열) 추출
            byte[] imageData = file.getBytes();

            // JSON 형식의 데이터를 ParkingInfo 객체로 변환
            ObjectMapper objectMapper = new ObjectMapper();
            ParkingInfo parkingInfo = objectMapper.readValue(data, ParkingInfo.class);

            // ParkingInfo 객체에 이미지 데이터 설정
            parkingInfo.setImage(imageData);

            // 데이터베이스에 저장
            transactionService.saveData(parkingInfo);

            return ResponseEntity.ok("Data and image saved successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save the data and image.");
        }
    }


    @GetMapping("/parking")
    public List<ParkingInfo>  getAllParkingInfo() {
    return parkingService.getAllParkingInfo();
    }
}
