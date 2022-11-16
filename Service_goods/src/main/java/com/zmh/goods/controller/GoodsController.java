package com.zmh.goods.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zmh.goods.entry.Goods;
import com.zmh.goods.openfeign.OrderClient;
import com.zmh.goods.openfeign.StoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/goods")
@RefreshScope /*动态读取配置*/
public class GoodsController {

    /*@Autowired
    private RestTemplate restTemplate;*/


    @Autowired
    private StoreClient storeClient;

    @Autowired
    private OrderClient orderClient;


    @GetMapping("/{str}")
    public Goods mapStamp(@PathVariable Integer str) throws JsonProcessingException {
        Goods goods=new Goods();
        /*请求Service_store模块*/
        /*String res = restTemplate.getForObject("http://service-store/store/" + str, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        Map map = objectMapper.readValue(res, Map.class);
        String port = (String) map.get("port");
        System.out.println("获取当前库存模块的端口号" + "===========>" + port);
        Integer kucun= (Integer) map.get("kucun");
        System.out.println("库存数量"+ "===========>"+kucun);*/

        /*使用OpenFeign来请求对应功能模块*/
        HashMap<String, Object> map = storeClient.get(str);
        System.out.println("获取当前库存模块的端口号" + "===========>" + map.get("port"));
        HashMap map1 = orderClient.returnGoods();
        System.out.println("获取当前物品模块的端口号" + "===========>" + map1.get("port"));
        goods.setPrice(10).setGoods((String) map1.get("goods")).setNumber((Integer) map.get("kucun"));
        return goods;
    }




}
