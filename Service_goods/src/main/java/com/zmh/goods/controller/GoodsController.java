package com.zmh.goods.controller;

import com.zmh.goods.entry.Goods;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/{str}")
    public HashMap<String,Object> mapStamp(@PathVariable String str){
        HashMap map=new HashMap();
        map.put("port",port);
        map.put("str",str);
        Goods goods=new Goods();
        goods.setGoods("a").setGoodsId(1).setNumber(2).setPrice(3);
        map.put("todo",goods);
        return map;
    }
}
