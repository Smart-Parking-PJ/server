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

    @Override
    public String toString() {
        return "ParkingInfo{" +
                "id=" + id +
                ", entryTime=" + entryTime +
                ", emptyspace=" + emptyspace +
                ", currentcar=" + currentcar +
                ", parkingname='" + parkingname + '\'' +
                '}';
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    private Date entryTime; //차 들어온 시간


    public void setId(Long id) {
        this.id = id;
    }

    public String getParkingname() {
        return parkingname;
    }

    public void setParkingname(String parkingname) {
        this.parkingname = parkingname;
    }

    public long getEmptyspace() {
        return emptyspace;
    }

    public void setEmptyspace(long emptyspace) {
        this.emptyspace = emptyspace;
    }

    public int getCurrentcar() {
        return currentcar;
    }

    public void setCurrentcar(int currentcar) {
        this.currentcar = currentcar;
    }

    private Long emptyspace; //주차 가능 수
    private int currentcar; //현재 주차된 차 수
    private String parkingname; // 주차장 이름

    public ParkingInfo(){}
    public Long getId() {
        return id;
    }
}
