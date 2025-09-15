package com.zzzj.service.impl;

import com.zzzj.mapper.EmpMapper;
import com.zzzj.pojo.Emp;
import com.zzzj.pojo.PageResult;
import com.zzzj.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 员工管理
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        //获取总记录数
        Long count = empMapper.count();
        //获取每一页的数据列表
        Integer start = (page - 1) * pageSize;//计算起始索引
        List<Emp> emplist = empMapper.list(start, pageSize);
        //封装结果
       return  new PageResult<Emp>(count,emplist);

    }
}