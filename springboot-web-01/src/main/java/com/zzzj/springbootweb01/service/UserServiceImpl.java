package com.zzzj.springbootweb01.service;

import com.zzzj.springbootweb01.dao.UserDao;
import com.zzzj.springbootweb01.dao.UserDaoImpl;
import com.zzzj.springbootweb01.pojo.User;
import com.zzzj.springbootweb01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

//@Component //注解，就代表把当前类产生的对象交给IOC容器管理
//public class UserServiceImpl implements UserService {//逻辑处理层
//
//    private UserDao userDao = new UserDaoImpl();
//
//    @Override
//    public List<User> findAll() {
//        List<String> lines = userDao.findAll();
//        List<User> userList = lines.stream().map(line -> {
//            String[] parts = line.split(",");
//            Integer id = Integer.parseInt(parts[0]);
//            String username = parts[1];
//            String password = parts[2];
//            String name = parts[3];
//            Integer age = Integer.parseInt(parts[4]);
//            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//            return new User(id, username, password, name, age, updateTime);//解析数据，封装成对象 --> 集合
//        }).collect(Collectors.toList());//封装为集合
//        return userList;
//    }
@Service //("userservice")注解后加（属性）可以指定bean的名字 //注解，就代表把当前类产生的对象交给IOC容器管理
public class UserServiceImpl implements UserService {//逻辑处理层
    //属性注入
    @Autowired//注入运行时所依赖的对象
    private UserDao userDao ;

    @Override
    public List<User> findAll() {
        List<String> lines = userDao.findAll();
        List<User> userList = lines.stream().map(line -> {
            String[] parts = line.split(",");
            Integer id = Integer.parseInt(parts[0]);
            String username = parts[1];
            String password = parts[2];
            String name = parts[3];
            Integer age = Integer.parseInt(parts[4]);
            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id, username, password, name, age, updateTime);//解析数据，封装成对象 --> 集合
        }).collect(Collectors.toList());//封装为集合
        return userList;
    }
}