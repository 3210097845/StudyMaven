package com.zzzj.controller;


import com.zzzj.pojo.Dept;
import com.zzzj.pojo.Result;
import com.zzzj.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    @GetMapping("/depts")
    public Result list(){
        List<Dept> deptlist = deptService.findAll();
        return Result.success(deptlist);
    }
}
