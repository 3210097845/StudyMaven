package com.zzzj.springbootweb01.dao;

import cn.hutool.core.io.IoUtil;
import com.zzzj.springbootweb01.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Repository("udo")//注解，就代表把当前类产生的对象交给IOC容器管理
public class UserDaoImpl implements UserDao {//数据访问层
    @Override
    public List<String> findAll() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = IoUtil.readLines(in, StandardCharsets.UTF_8, new ArrayList<>());
        return lines;
    }
}