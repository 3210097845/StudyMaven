package com.zzzj.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzzj.mapper.EmpMapper;
import com.zzzj.pojo.Emp;
import com.zzzj.pojo.PageResult;
import com.zzzj.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {
        /**
         *
         * 原始方法
         */
//        //获取总记录数
//        Long count = empMapper.count();
//        //获取每一页的数据列表
//        Integer start = (page - 1) * pageSize;//计算起始索引
//        List<Emp> emplist = empMapper.list(start, pageSize);
//        //封装结果
//       return  new PageResult<Emp>(count,emplist);

        /**
         * 引入PageHelper分页插件
         *
         */
        //设置分页参数
        PageHelper.startPage(page,pageSize);
        //执行查询数据
        List<Emp> emplist = empMapper.list(name,gender,begin,end);
        Page<Emp> p = (Page<Emp>) emplist;
        //封装结果
        return new PageResult<>(p.getTotal(),p.getResult());
    }
}