package com.zmh.goods.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zmh.goods.entry.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/{str}")
    public Goods mapStamp(@PathVariable String str) throws JsonProcessingException {
        Goods goods=new Goods();
        goods.setGoods("a").setGoodsId(1).setPrice(3);
        /*请求Service_store模块*/
        String res = restTemplate.getForObject("http://service-store/store/" + str, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        Map map = objectMapper.readValue(res, Map.class);
        String port = (String) map.get("port");
        System.out.println("获取当前库存模块的端口号" + "===========>" + port);
        Integer kucun= (Integer) map.get("kucun");
        System.out.println("库存数量"+ "===========>"+kucun);
        goods.setNumber(kucun);
        return goods;
    }


}
