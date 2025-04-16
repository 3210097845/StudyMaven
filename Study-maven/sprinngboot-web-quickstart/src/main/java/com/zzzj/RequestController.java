package com.zzzj;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//请求处理类
@RestController
public class RequestController {

    @RequestMapping("/request")//标识请求路径
    public String request(HttpServletRequest request)
    {
        //1.获取请求方式
        String method = request.getMethod();
        System.out.println("请求方式:"+"method:"+method);
        //2.获取请求url地址和uil地址
        String url = request.getRequestURL().toString();
        System.out.println("请求url地址:"+"url:"+url);
        String url1 = request.getRequestURI();
        System.out.println("请求uil地址:"+"uil:"+url1);
        //3.获取请求协议
        String protocol = request.getProtocol();
        System.out.println("请求协议:"+"protocol:"+protocol);
        //4.获取请求参数
        String queryString = request.getQueryString();
        System.out.println("请求参数:"+"queryString:"+queryString);
        String name1=request.getParameter("name");
        System.out.println("请求参数:"+"name:"+name1);
        String age1=request.getParameter("age");
        System.out.println("请求参数:"+"age:"+age1);

        //5.获取请求头信息-Accept
        String accept = request.getHeader("Accept");
        System.out.println("accept:"+accept);
        return "OK";
    }
}
