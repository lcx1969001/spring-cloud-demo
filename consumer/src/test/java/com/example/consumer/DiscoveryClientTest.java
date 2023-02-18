package com.example.consumer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import java.util.List;

@SpringBootTest()
public class DiscoveryClientTest {

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 从注册中心获取所有的服务名称
     */
    @Test
    public void getServices() {
        List<String> serviceNameList = discoveryClient.getServices();
        serviceNameList.forEach(System.out::println);
    }

    /**
     * 从注册中心获取所有的服务实例
     */
    @Test
    public void getInstances() {
        List<String> serviceNameList = discoveryClient.getServices();
        for (String serviceName : serviceNameList) {
            List<ServiceInstance> serviceInstanceList = discoveryClient.getInstances(serviceName);
            for (ServiceInstance serviceInstance : serviceInstanceList) {
                System.out.println(serviceInstance.getServiceId());
                System.out.println(serviceInstance.getUri());
                System.out.println("=====================================");
            }
        }
    }

}
