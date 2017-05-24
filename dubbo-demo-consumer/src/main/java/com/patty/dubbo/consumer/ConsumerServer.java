package com.patty.dubbo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Version: 3.0
 * Author: pattywgm
 * Time: 17/5/23 下午5:15
 * Desc: 消费者服务
 */

@SpringBootApplication
public class ConsumerServer {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerServer.class, args);
    }
}
