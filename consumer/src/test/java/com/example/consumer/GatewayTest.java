package com.example.consumer;

import com.example.consumer.feign.GatewayUserFeign;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest()
public class GatewayTest {

    @Autowired
    private GatewayUserFeign gatewayUserFeign;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 使用 Feign 通过网关调用服务,适用于服务之间的调用,由网关实现负载均衡
     */
    @Test
    public void feignGatewayTest() {
        for (int i = 0; i < 10; i++) {
            String hello = gatewayUserFeign.hello();
            System.out.println(hello);
        }
    }

    /**
     * 使用 http 通过网关调用服务,适用于网页端、移动端等调用,由网关实现负载均衡
     */
    @Test
    public void httpGatewayTest() {
        for (int i = 0; i < 10; i++) {
            String hello = restTemplate.getForObject("http://127.0.0.1:8300/user-service/user/hello", String.class);
            System.out.println(hello);
        }
    }

}
