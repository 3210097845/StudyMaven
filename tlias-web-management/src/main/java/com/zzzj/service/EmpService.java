package com.zzzj.service;

import com.zzzj.pojo.Emp;
import com.zzzj.pojo.PageResult;

public interface EmpService {
    PageResult<Emp> page(Integer page, Integer pageSize);
}