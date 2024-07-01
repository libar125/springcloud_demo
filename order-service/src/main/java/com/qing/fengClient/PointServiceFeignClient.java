package com.qing.fengClient;


import com.qing.entity.OrderEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "point-service")
public interface PointServiceFeignClient {

    @PostMapping("/point/add")
    String addPoint(@RequestBody OrderEntity order);
}
