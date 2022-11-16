package com.zmh.order.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/order")
public class OrderController {


    @Value("${server.port}")
    private String port;


    @GetMapping("/get")
    public HashMap returnGoods(){
        HashMap map=new HashMap();
        map.put("goods","大白糖");
        map.put("port",this.port);
        return map;
    }

}
