package com.qing.controller;


import com.qing.util.JwtUtil;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Value("${config.login-timeout}")
    private Long redisTimeout;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping(value = "/login")
    public String login() {

        //验证账号密码
        String userId = "123";
        //jwt生成token
        String token = JwtUtil.getToken(userId);
        //将token存入redis
        redisTemplate.opsForValue().set(token,userId,redisTimeout, TimeUnit.SECONDS);
        //将token返回客户端
        return token;
    }

    @GetMapping(value = "/test")
    public void test(){
        redisTemplate.opsForValue().set("hello","我尼玛");
    }


    @GetMapping(value = "/timeout")
    public String timeout(){
        try {
            Thread.sleep(1);

        }catch (Exception e){
            e.printStackTrace();
        }
        return "time-out";
    }

    @GetMapping(value = "exception")
    public String exception(){
        Integer a = 1/0;
        return "exception";
    }
}
