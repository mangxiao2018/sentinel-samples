package com.mangxiao.sentinel.sample.core;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.mangxiao.sentinel.sample.core.exception.ExceptionUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SentinelCoreSampleApplication {

    public static void main(String[] args){
        SpringApplication.run(SentinelCoreSampleApplication.class, args);
    }

    @Bean
    @SentinelRestTemplate(blockHandler = "handleException",blockHandlerClass = ExceptionUtil.class)
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
