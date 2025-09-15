package com.zzzj.controller;

import com.zzzj.pojo.Emp;
import com.zzzj.pojo.PageResult;
import com.zzzj.pojo.Result;
import com.zzzj.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 员工管理
 */
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result  page(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "10") Integer pageSize)
    {
        log.info("分页查询，参数：page={},pageSize={}",page,pageSize);
        PageResult<Emp>  pageResult=empService.page(page,pageSize);
        return Result.success(pageResult);

    }

}