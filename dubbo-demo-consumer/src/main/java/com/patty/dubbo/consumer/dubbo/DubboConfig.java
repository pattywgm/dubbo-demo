package com.patty.dubbo.consumer.dubbo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * Version: 3.0
 * Author: pattywgm
 * Time: 17/5/23 下午4:53
 * Desc: Dubbo配置类
 */
@Configuration
@PropertySource("classpath:dubbo/dubbo.properties")
@ImportResource({ "classpath:dubbo/*.xml" })
public class DubboConfig {

}
