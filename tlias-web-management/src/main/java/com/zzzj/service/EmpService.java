package com.zzzj.service;

import com.zzzj.pojo.Emp;
import com.zzzj.pojo.PageResult;

import java.time.LocalDate;

public interface EmpService {
    PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
}