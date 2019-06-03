package com.briup.order.sms.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.briup.order.sms.mapper")
public class MybatisConfig {

}
