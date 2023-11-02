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
    private Date entryTime; //차 들어온 시간
    private Long emptyspace; //주차 가능 수
    private int currentcar; //현재 주차된 차 수
    private String parkingname; // 주차장 이름

    public ParkingInfo(){}
    public Long getId() {
        return id;
    }
}
