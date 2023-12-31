package com.mylsaber.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author jiangdi
 */
@SpringBootApplication
@EnableDiscoveryClient
public class LioncatGatewayApp {
    public static void main(String[] args) {
        SpringApplication.run(LioncatGatewayApp.class,args);
    }
}
