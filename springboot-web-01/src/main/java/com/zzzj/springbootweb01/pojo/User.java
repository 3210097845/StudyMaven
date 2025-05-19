package com.zzzj.springbootweb01.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * 封装用户信息
 */
@Data//这个注解可以直接创建getter和setter方法
@NoArgsConstructor//这个注解可以直接创建创建无参构造方法
@AllArgsConstructor//这个注解可以直接创建创建有参构造方法
public class User {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Integer age;
    private LocalDateTime updateTime;
}