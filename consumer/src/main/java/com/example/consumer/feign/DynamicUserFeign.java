package com.example.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;

/**
 * 动态客户端，在调用接口时可以动态指定 url
 * 此处的 name 不能与 UserFeign 中的一样，否则会报错
 * 此处的 url 随便写一个但不能为空，在调用时会动态替换 url
 */
@FeignClient(name = "dynamic-user-service", url = "http://dynamic-user-service")
public interface DynamicUserFeign {

    @GetMapping("/user/hello")
    String hello(URI uri);

}