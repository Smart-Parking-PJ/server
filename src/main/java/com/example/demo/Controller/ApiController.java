package com.example.demo.Controller;

import com.example.demo.Service.FirstService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final FirstService firstService;

    @GetMapping("/api")
        public Map<String,Object>ApiController(){


        return firstService.getFirstData();
    }
}
