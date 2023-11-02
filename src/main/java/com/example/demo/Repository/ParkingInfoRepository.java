package com.example.demo.Repository;

import com.example.demo.Model.ParkingInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ParkingInfoRepository extends JpaRepository<ParkingInfo, Long> {
}
