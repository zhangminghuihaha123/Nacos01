package com.zmh.goods.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@Configuration
public class NacosConfig {

    /*开启此注解可以从不同功能模块中获取数据*/
    /*比如现在在Service_goods模块中，想要去拿取在Service_order的模块下的数据，因为端口不一致，不可以直接拿*/
    /*所以需要跨越端口，而RestTemplate帮我们解决这件事*/
    /*由于RestTemplate不被spring托管，需要用@Bean托管，然后注入到所需要的容器中*/
    @Bean
    @LoadBalanced /*负载均衡*/
    public RestTemplate restTemplate(){
        /*解决中文乱码问题*/
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.getMessageConverters().set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }

}
