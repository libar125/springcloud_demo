package com.qing.controller;

import com.qing.entity.OrderEntity;
import com.qing.fengClient.PointServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Value("${test.name}")
    public String testName;

    @Autowired
    PointServiceFeignClient pointService;

    @GetMapping(value = "/test")
    public void test(){
        System.out.println("this is order controller");
    }


    @GetMapping("/getTestName")
    public String getTestName(){
        return testName;
    }


    @PostMapping("/add")
    public String addOrder(){
        OrderEntity order = new OrderEntity();
        order.setId(1);
        order.setProductName("新鲜车厘子4KG");
        String s = pointService.addPoint(order);
        return s;
    }


}
