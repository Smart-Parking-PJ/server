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
    private Integer id;
    private Integer currentcar; //현재 주차된 차량 수
    private Integer emptyspace; //주차 가능한 공간 수
    private String parkingname; // 주차장 이름
    private Integer totalspace;

    @Lob
    private String image;

    public String getImage() {
        return image;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurrentcar() {
        return currentcar;
    }

    public void setCurrentcar(Integer currentcar) {
        this.currentcar = currentcar;
    }

    public Integer getEmptyspace() {
        return emptyspace;
    }

    public void setEmptyspace(Integer emptyspace) {
        this.emptyspace = emptyspace;
    }

    public String getParkingname() {
        return parkingname;
    }

    public void setParkingname(String parkingname) {
        this.parkingname = parkingname;
    }

    public Integer getTotalspace() {
        return totalspace;
    }

    public void setTotalspace(Integer totalspace) {
        this.totalspace = totalspace;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ParkingInfo(){}




}
