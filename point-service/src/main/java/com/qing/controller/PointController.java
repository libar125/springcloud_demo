package com.qing.controller;

import com.qing.entity.OrderEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/point")
public class PointController {

    @GetMapping(value = "/test")
    public void test(){
        System.out.println("this is point controller");
    }


    @PostMapping("/add")
    public String add(@RequestBody OrderEntity order){
        return "add point success 商品名称:"+order.getProductName();
    }
}
