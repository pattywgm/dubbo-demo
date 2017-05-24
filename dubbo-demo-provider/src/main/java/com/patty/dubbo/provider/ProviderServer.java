package com.patty.dubbo.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.IOException;

/**
 * Version: 3.0
 * Author: pattywgm
 * Time: 17/5/23 下午4:26
 * Desc: 生产者服务
 */
@SpringBootApplication
@EntityScan("com.patty.dubbo.provider.model")
@MapperScan("com.patty.dubbo.provider.dao")
public class ProviderServer {
    public static void main(String[] args) throws IOException{
        SpringApplication.run(ProviderServer.class, args);

        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟
    }
}
