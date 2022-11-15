package com.zmh.store.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/{val}")
    public HashMap<String,Object> get(@PathVariable Integer val){
        HashMap map=new HashMap();
        map.put("port",port);
        map.put("kucun",val);
        return map;
    }
}
