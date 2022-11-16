package com.zmh.goods.openfeign;

import com.zmh.goods.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

/*service-order*/
@FeignClient(value = "service-order",configuration = FeignConfig.class)
public interface OrderClient {

    @GetMapping("/order/get")
    HashMap returnGoods();

}
