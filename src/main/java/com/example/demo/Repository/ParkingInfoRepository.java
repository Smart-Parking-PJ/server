package com.example.demo.Repository;

import com.example.demo.Model.ParkingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ParkingInfoRepository extends JpaRepository<ParkingInfo, Long> {

}
