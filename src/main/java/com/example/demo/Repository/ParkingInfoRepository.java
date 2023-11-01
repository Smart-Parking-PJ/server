package com.example.demo.Repository;

import com.example.demo.Model.ParkingInfo;
import org.springframework.data.repository.CrudRepository;

public interface ParkingInfoRepository extends CrudRepository<ParkingInfo, Long> {
}
