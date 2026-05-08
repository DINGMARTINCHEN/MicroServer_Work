package com.dingshicheng23090200150.cloud.controller;

import com.dingshicheng23090200150.cloud.entities.PayDTO;
import com.dingshicheng23090200150.cloud.feign.PayFeignService;
import com.dingshicheng23090200150.cloudapicommons.resp.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController
{
    public static final String PaymentSrv_URL = "http://cloud-payment-service";
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PayFeignService payFeignService;

    @GetMapping("/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO)
    {
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/add",payDTO,ResultData.class);
    }

    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable Integer id)
    {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/"+id, ResultData.class, id);
    }

    @GetMapping("/consumer/pay/getPort")
    public ResultData getPort()
    {
        return payFeignService.getPort();
    }

    @GetMapping("/consumer/pay/getPortWithRetry")
    public ResultData getPortWithRetry()
    {
        return payFeignService.getPortWithRetry();
    }
}