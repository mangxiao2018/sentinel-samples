package com.mangxiao.sentinel.sample.core.controller;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class IndexController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 1、HTTP埋点:Sentinel starter 默认为所有的 HTTP 服务提供了限流埋点，如果只想对 HTTP 服务进行限流，那么只需要引入依赖，无需修改代码。
     * 2、自定义埋点：如果需要对某个特定的方法进行限流或降级，可以通过 `@SentinelResource` 注解来完成限流的埋点，如@SentinelResource("resource")
     * @return
     */
    @SentinelResource("resource")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "Hello";
    }

    @GetMapping("/aa")
    @SentinelResource("aa")
    public String aa(int b, int a) {
        return "Hello test";
    }

    @GetMapping("/test")
    public String test1() {
        return "Hello test";
    }

    @GetMapping("/template")
    public String client() {
        return restTemplate.getForObject("http://www.taobao.com/test", String.class);
    }
}
