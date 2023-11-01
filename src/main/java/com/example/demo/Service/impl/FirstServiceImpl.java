package com.example.demo.Service.impl;

import com.example.demo.Service.FirstService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class FirstServiceImpl implements FirstService {

    @Override
    public Map<String, Object> getFirstData(){
        Map<String, Object>firstData=new HashMap<>();
        //firstData.put("label","check");
        return firstData;
    }
}
