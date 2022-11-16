package com.zmh.goods.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Configuration
public class FeignConfig {

    /*默认负载均衡随机*/


    /*解决超时在YML中配置*/


    /*一旦超时可以重试*/
    /*
    *
    * 50======>重试周期50毫秒
    * 2========>最大重试周期2S
    * 3========>最多尝试次数
    *
    * */
    @Bean
    public Retryer retryer(){
        return new Retryer.Default(50,TimeUnit.SECONDS.toMillis(2),3);
    }

}
