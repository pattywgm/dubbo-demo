package com.patty.dubbo.provider;

import com.alibaba.dubbo.rpc.RpcContext;
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
    public static void main(String[] args) throws IOException {
        SpringApplication.run(ProviderServer.class, args);
        /**
        // 本端是否为提供端，这里会返回true
        boolean isProviderSide = RpcContext.getContext().isProviderSide();
        // 获取调用方IP地址
        String clientIP = RpcContext.getContext().getRemoteHost();
        // 获取当前服务配置信息，所有配置信息都将转换为URL的参数
        String application = RpcContext.getContext().getUrl().getParameter("application");
        System.out.println("clientIp: " + clientIP + " application name: " + application);
         */
        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟
    }
}
