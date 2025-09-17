package com.zzzj.service;

import com.zzzj.pojo.Emp;
import com.zzzj.pojo.EmpQueryParam;
import com.zzzj.pojo.PageResult;

import java.time.LocalDate;

public interface EmpService {
    PageResult<Emp> page(EmpQueryParam empqueryparam);
}