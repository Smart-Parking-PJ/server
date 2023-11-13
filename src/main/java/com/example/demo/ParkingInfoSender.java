package com.example.demo;
import com.example.demo.Model.ParkingInfo;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ParkingInfoSender {
    public static void main(String[] args) {
        // Create a ParkingInfo object with the data you want to update
        ParkingInfo parkingInfo = new ParkingInfo();
        parkingInfo.setParkingname("S3앞 주차장");
        parkingInfo.setCurrentcar(0);
        parkingInfo.setEmptyspace(0);
        parkingInfo.setTotalspace(50); // Add totalspace if needed

        // Load the image from a file or any other source
        byte[] imageBytes = loadImageFromFile("image/park4.jpg");

        // Create a RestTemplate with HttpComponentsClientHttpRequestFactory
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());

        // Set the request headers
        HttpHeaders headers = new HttpHeaders();

        // Create a MultiPart request entity
        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.add("currentcar", parkingInfo.getCurrentcar());
        body.add("emptyspace", parkingInfo.getEmptyspace());
        body.add("parkingname", parkingInfo.getParkingname());
        body.add("totalspace", parkingInfo.getTotalspace());
        body.add("image", imageBytes);

        // Create an HttpEntity with the headers and body
        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        // Define the API endpoint URL for PATCH
        String apiUrl = "http://43.200.254.150:8080/parking";
       // String apiUrl = "http://localhost:8080/parking";

        // Send the PATCH request using HttpPatch
        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.PATCH, requestEntity, String.class);

        // Handle the response as needed
        String response = responseEntity.getBody();
        System.out.println("Response: " + response);
    }

    private static byte[] loadImageFromFile(String filePath) {
        try {
            File file = new File(filePath);
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, bytesRead);
                }
                return byteArrayOutputStream.toByteArray();
            } else {
                return new byte[0];
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}
