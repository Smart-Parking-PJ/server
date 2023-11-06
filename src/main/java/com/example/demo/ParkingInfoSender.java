package com.example.demo;

import com.example.demo.Model.ParkingInfo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Timestamp;
import java.io.IOException;

public class ParkingInfoSender {
    public static void main(String[] args) {
        // Create a ParkingInfo object with the data you want to send
        ParkingInfo parkingInfo = new ParkingInfo();
        parkingInfo.setId(1L);
        parkingInfo.setEntryTime(new Timestamp(System.currentTimeMillis()));
        parkingInfo.setEmptyspace(10L);
        parkingInfo.setCurrentcar(1);
        parkingInfo.setParkingname("Sample Parking");

        // Create a RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Create an ObjectMapper to convert ParkingInfo to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String json;
        try {
            json = objectMapper.writeValueAsString(parkingInfo);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Set the request headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create an HTTP entity with the JSON data and headers
        HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);

        // Define the API endpoint URL
        String apiUrl = "http://localhost:8080/parking";

        // Send the POST request
        restTemplate.postForObject(apiUrl, requestEntity, String.class);
    }
}
