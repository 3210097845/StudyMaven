package com.zzzj;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//表示当前类是一个请求处理类
public class HelloController {

    @RequestMapping("/hello") //标识请求路径
    public String hello(String name){//返回的是前端请求的数据
        System.out.println("name:"+name);
        return "hello,"+name+"~";

    }
}
