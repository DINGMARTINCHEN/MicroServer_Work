package com.dingshicheng23090200150.cloud.controller;

import com.dingshicheng23090200150.cloud.entities.PayDTO;
import com.dingshicheng23090200150.cloud.resp.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    public static final String PAYMENT_SRV_URL = "http://localhost:8001";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PAYMENT_SRV_URL + "/pay/get/" + id, ResultData.class);
    }

    @GetMapping("/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO) {
        return restTemplate.postForObject(PAYMENT_SRV_URL + "/pay/add", payDTO, ResultData.class);
    }
}