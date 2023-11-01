package com.example.demo.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class ParkingInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String licensePlate;
    private Date entryTime;
    private Long parkingSpaceId;
    private String parkingStatus;
    private String parkingType; // 주차장 종류를 나타내는 열

    public ParkingInfo(){}
    public Long getId() {
        return id;
    }
}
