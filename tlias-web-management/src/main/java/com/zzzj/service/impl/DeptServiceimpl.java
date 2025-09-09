package com.zzzj.service.impl;

import com.zzzj.mapper.DeptMapper;
import com.zzzj.pojo.Dept;
import com.zzzj.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceimpl implements DeptService {

     @Autowired
     private DeptMapper deptMapper;
    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }
}
