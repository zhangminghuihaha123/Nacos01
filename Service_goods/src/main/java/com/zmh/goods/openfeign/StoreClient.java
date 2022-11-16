package com.zmh.goods.openfeign;

import com.zmh.goods.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;


@FeignClient(value = "service-store",configuration = FeignConfig.class)
/*用来请求在Nacos注册名为service-store的服务*/
public interface StoreClient {

    @GetMapping("/store/{val}")
    public HashMap<String,Object> get(@PathVariable Integer val);
}
