package com.dingshicheng23090200150.cloud.feign;

import com.dingshicheng23090200150.cloudapicommons.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.dingshicheng23090200150.cloud.config.FeignConfig;

@FeignClient(value = "cloud-payment-service", configuration = FeignConfig.class)
public interface PayFeignService {

    @GetMapping("/pay/getPort")
    ResultData<String> getPort();

    @GetMapping("/pay/getPortWithRetry")
    ResultData<String> getPortWithRetry();
}