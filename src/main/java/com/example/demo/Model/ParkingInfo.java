package com.example.demo.Model;

import lombok.Data;

import javax.persistence.*;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setEmptyspace(Long emptyspace) {
        this.emptyspace = emptyspace;
    }

    @Lob
    private byte[] image;

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

    public Long getEmptyspace() {
        return emptyspace - currentcar;
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
