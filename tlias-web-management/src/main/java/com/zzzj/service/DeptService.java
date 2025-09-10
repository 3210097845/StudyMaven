package com.zzzj.service;

import com.zzzj.pojo.Dept;

import java.util.List;

public interface DeptService {
//    查询所有部门

    public List<Dept> findAll();
    //删除部门
    public void delete(Integer id);

    //添加部门
    public void add(Dept dept);

    //根据ID查询部门
    public Dept getById(Integer id);

    //修改部门
    public void update(Dept dept);
}
