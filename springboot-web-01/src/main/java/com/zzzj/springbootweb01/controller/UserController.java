package com.zzzj.springbootweb01.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.json.JSONConfig;
import cn.hutool.json.JSONUtil;
import com.zzzj.springbootweb01.pojo.User;
import com.zzzj.springbootweb01.service.UserService;
import com.zzzj.springbootweb01.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@RestController//创建一个控制器
//public class UserController {
//
//    @RequestMapping("/list")//映射路径
//    public List<User> list() throws Exception{
//        //1.加载并读取文件
//        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");//获取输入流
//        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());//输入流，字符集，集合
//        //该方法会从输入流 in 中逐行读取文本内容，按 UTF-8 编码解析，并将每一行添加到传入的 ArrayList 中，最终返回填充后的列表。
//
//        //2.解析数据，封装成对象 --> 集合
//        List<User> userList = lines.stream().map(line -> {
//            String[] parts = line.split(",");
//            Integer id = Integer.parseInt(parts[0]);
//            String username = parts[1];
//            String password = parts[2];
//            String name = parts[3];
//            Integer age = Integer.parseInt(parts[4]);
//            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//
//            return new User(id, username, password, name, age, updateTime);
//        }).collect(Collectors.toList());
//
//        //3.响应数据(json格式）
//        //return JSONUtil.toJsonStr(userList, JSONConfig.create().setDateFormat("yyyy-MM-dd HH:mm:ss"));
//        return userList;
//    }
    
//}

//@RestController
//public class UserController {//接受浏览器的请求，并且响应数据
//
//    private UserService userService = new UserServiceImpl();
//
//    @RequestMapping("/list")
//    public List<User> list(){
//        //1.调用Service
//        List<User> userList = userService.findAll();
//        //2.响应数据
//        return userList;
//    }


@RestController
public class UserController {//接受浏览器的请求，并且响应数据
    //属性注入
    @Autowired//注入运行时所依赖的对象
    private UserService userService ;

//    //方式二: 构造器注入
//    private final UserService userService;
//
//    @Autowired //如果当前类中只存在一个构造函数, @Autowired可以省略
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    //方式三: setter注入
//    private UserService userService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
    @RequestMapping("/list")
    public List<User> list(){
        //1.调用Service
        List<User> userList = userService.findAll();
        //2.响应数据
        return userList;
    }
}