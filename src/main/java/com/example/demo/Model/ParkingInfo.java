package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Base64;
import java.util.Date;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParkingInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long currentcar; //현재 주차된 차량 수
    private Long emptyspace; //주차 가능한 공간 수
    private String parkingname; // 주차장 이름
    private Long totalspace;

    @Lob
    private byte[] image;

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setEmptyspace(Long emptyspace) {
        this.emptyspace = emptyspace;
    }



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

    public Long getCurrentcar() {
        return currentcar;
    }

    public void setCurrentcar(Long currentcar) {
        this.currentcar = currentcar;
    }


    public ParkingInfo(){this.totalspace = 50L;}
    public Long getId() {
        return id;
    }



}
