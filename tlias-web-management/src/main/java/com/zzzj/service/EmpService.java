package com.zzzj.service;

import com.zzzj.pojo.Emp;
import com.zzzj.pojo.EmpQueryParam;
import com.zzzj.pojo.PageResult;

import java.time.LocalDate;

public interface EmpService {
    //分页查询
    PageResult<Emp> page(EmpQueryParam empqueryparam);
    //保存员工基本信息
    public void save(Emp emp);

}