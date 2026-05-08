package com.dingshicheng23090200150.cloud.feign;

import com.dingshicheng23090200150.cloudapicommons.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "cloud-payment-service")
public interface PayFeignService {

    @GetMapping("/pay/getPort")
    ResultData<String> getPort();
}