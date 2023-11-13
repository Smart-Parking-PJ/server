package com.example.demo.Controller;

import com.example.demo.Model.ParkingInfo;
import com.example.demo.Service.ParkingService;
import com.example.demo.Service.TransactionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<String> addParkingInfoWithImage(
            @RequestParam("currentcar") Integer currentcar,
            @RequestParam("emptyspace") Integer emptyspace,
            @RequestParam("parkingname") String parkingname,
            @RequestParam("totalspace") Integer totalspace,
            @RequestParam("image") MultipartFile file
    ) {
        try {
            // MultipartFile에서 이미지 데이터(byte 배열) 추출
            byte[] imageData = file.getBytes();

            // ParkingInfo 객체 생성 및 데이터 설정
            ParkingInfo parkingInfo = new ParkingInfo();
            parkingInfo.setCurrentcar(currentcar);
            parkingInfo.setEmptyspace(emptyspace);
            parkingInfo.setParkingname(parkingname);
            parkingInfo.setTotalspace(totalspace);
            parkingInfo.setImage(imageData);

            // 데이터베이스에 저장
            transactionService.saveData(parkingInfo);

            return ResponseEntity.ok("Data and image saved successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save the data and image.");
        }
    }

    @PatchMapping(value = "/parking/{id}")
    public ResponseEntity<String> updateParkingInfo(@PathVariable Integer id,
                                                    @RequestParam(value = "currentcar", required = false) Integer currentcar,
                                                    @RequestParam(value = "emptyspace", required = false) Integer emptyspace,
                                                    @RequestParam(value = "parkingname", required = false) String parkingname,
                                                    @RequestParam(value = "image", required = false) byte[] image,
                                                    @RequestParam(value = "totalspace", required = false) Integer totalspace)  {
        try {
            // ID에 해당하는 데이터를 검색
            Optional<ParkingInfo> existingDataOptional = parkingService.getParkingInfoById(id);

            // 데이터가 존재하면 업데이트 수행
            if (existingDataOptional.isPresent()) {
                ParkingInfo existingData = existingDataOptional.get();

                // 이미지 데이터 업데이트
                if (image != null) {
                    existingData.setImage(image);
                }
                // 나머지 필드 업데이트
                if (currentcar != null) {
                    existingData.setCurrentcar(currentcar);
                }
                if (emptyspace != null) {
                    existingData.setEmptyspace(emptyspace);
                }
                if (parkingname != null) {
                    existingData.setParkingname(parkingname);
                }
                if (totalspace != null) {
                    existingData.setTotalspace(totalspace);
                }

                // 업데이트된 데이터 저장
                transactionService.saveData(existingData);

                return ResponseEntity.ok("Data updated successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data not found for ID: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update the data.");
        }
    }


    @GetMapping("/parking")
    public List<ParkingInfo>  getAllParkingInfo() {
     return parkingService.getAllParkingInfo();
    }
    @GetMapping("/parking/{id}")
    public ResponseEntity<ParkingInfo> getParkingInfoById(@PathVariable Integer id) {
        Optional<ParkingInfo> parkingInfoOptional = parkingService.getParkingInfoById(id);

        return parkingInfoOptional
                .map(parkingInfo -> ResponseEntity.ok().body(parkingInfo))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
