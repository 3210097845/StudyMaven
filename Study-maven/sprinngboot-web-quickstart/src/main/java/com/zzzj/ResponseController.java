package com.zzzj;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResponseController {
    //方式一：基于HttpServletResponse设置响应数据
    @RequestMapping("/response")
    public void response(HttpServletResponse response) throws IOException{
        //1.设置响应状态码
        response.setStatus(401);
        //2.设置响应头
        response.setHeader("name","zzzj");
        //3.设置响应体
        response.getWriter().write("<h1>response<h1>");//以IO流的形式显示给前端,并且会给浏览器中展示出来
    }

    //方式二：spring中提供的方法，将我们想要设置的东西3封装到对象当中，然后直接返回
    @RequestMapping("/response2")
    public ResponseEntity<String> response2(HttpServletResponse response){//<>中指定的是响应体中的泛型是什么类型的

        return ResponseEntity.status(401).header("name","zzzj").body("<h1>response<h1>");
    }

}
