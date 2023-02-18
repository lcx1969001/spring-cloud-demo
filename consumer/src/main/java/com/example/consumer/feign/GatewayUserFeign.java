package com.example.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "gateway", path = "user-service")
public interface GatewayUserFeign {

    @GetMapping("/user/hello")
    String hello();

}