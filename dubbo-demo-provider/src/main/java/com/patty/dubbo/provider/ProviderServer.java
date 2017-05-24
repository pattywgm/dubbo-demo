package com.patty.dubbo.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * Version: 3.0
 * Author: pattywgm
 * Time: 17/5/23 下午4:26
 * Desc: 生产者服务
 */
@SpringBootApplication
public class ProviderServer {
    public static void main(String[] args) throws IOException{
        SpringApplication.run(ProviderServer.class, args);

        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟
    }
}
