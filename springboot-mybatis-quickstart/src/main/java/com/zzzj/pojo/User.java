package com.zzzj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//创建getter/setter方法
@AllArgsConstructor//创建所有包含参数构造
@NoArgsConstructor//创建无参构造
public class User {
    private Integer id;
    private String password;
    private String username;
    private String name;
    private Integer age;
}
