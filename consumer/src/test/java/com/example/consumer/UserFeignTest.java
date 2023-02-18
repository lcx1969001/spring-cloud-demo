package com.example.consumer;

import com.example.consumer.feign.UserFeign;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest()
public class UserFeignTest {

    @Autowired
    private UserFeign userFeign;

    /**
     * Feign 默认集成了 Ribbon 的轮询负载均衡策略, 会轮询调用 user-service-1 和 user-service-2 两个服务
     */
    @Test
    public void userFeignTest() {
        for (int i = 0; i < 10; i++) {
            String hello = userFeign.hello();
            System.out.println(hello);
        }
    }

}
