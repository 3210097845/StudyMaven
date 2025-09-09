package com.zzzj.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//测试一个不与表中列表名数量完全相同的类时，mb是否会执行
@Data//创建getter/setter方法
@AllArgsConstructor//创建所有包含参数构造
@NoArgsConstructor//创建无参构造
public class User2 {
    //private String password;
    private String username;
    private String name;
    private Integer age;

}
