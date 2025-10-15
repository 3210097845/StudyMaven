package com.zzzj.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzzj.mapper.ClazzMapper;
import com.zzzj.pojo.Clazz;
import com.zzzj.pojo.EmpQueryParam;
import com.zzzj.pojo.PageResult;
import com.zzzj.pojo.Student;
import com.zzzj.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClazzServiceimpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;
    @Override
    public PageResult<Clazz> page(EmpQueryParam clazzQueryParam)
    {
        //设置分页参数
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());
        //执行查询数据
        List<Clazz> clazzlist = clazzMapper.clazzpage(clazzQueryParam);
        Page<Clazz> p = (Page<Clazz>) clazzlist;
        return new PageResult<>(p.getTotal(),p.getResult());
    }
}
