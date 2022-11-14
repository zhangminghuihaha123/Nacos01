package com.zmh.goods.entry;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)    // 开启链式编程
public class Goods {

    private Integer goodsId;

    private String goods;

    private Integer price;

    private Integer number;
}
