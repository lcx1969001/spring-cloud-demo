package com.example.consumer;

import com.example.consumer.feign.DynamicUserFeign;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.net.URI;
import java.util.List;

@SpringBootTest()
public class DynamicUserFeignTest {

    @Autowired
    private DynamicUserFeign dynamicUserFeign;

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 从注册中心获取 user-service 所有的服务实例，然后通过 uri 动态调用
     */
    @Test
    public void dynamicUserFeignTest() {
        List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances("user-service");
        for (ServiceInstance serviceInstance : serviceInstanceList) {
            URI uri = serviceInstance.getUri();
            String hello = dynamicUserFeign.hello(uri);
            System.out.println(hello);
        }
    }

}
