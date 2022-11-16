package com.zmh.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient /*开启并注册Nacos*/
@EnableFeignClients /*开启openfeign*/
public class GoodsAplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsAplication.class);
    }
}
