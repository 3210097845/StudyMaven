package com.zzzj.service.impl;

import com.zzzj.mapper.DeptMapper;
import com.zzzj.pojo.Dept;
import com.zzzj.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Service 注解的作用是将该类标记为 Spring 的服务层组件。
 * 这样 Spring 在启动时会自动扫描并注册该类为 Bean，
 * 使得可以在 Controller 层或其他 Service 层通过 @Autowired 注入使用。
 * 同时，@Service 也是 @Component 注解的一个特化，用于明确表示这是一个服务层的组件。
 */
@Service
public class DeptServiceimpl implements DeptService {

     @Autowired
     private DeptMapper deptMapper;
    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void delete(Integer id)
    {
        deptMapper.delete(id);
    }

    @Override
    public void add(Dept dept) {
        //补全基础属性
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        //调用mapper层保存数据
        deptMapper.add(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
