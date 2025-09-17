package com.zzzj.controller;

import com.zzzj.pojo.Emp;
import com.zzzj.pojo.EmpQueryParam;
import com.zzzj.pojo.PageResult;
import com.zzzj.pojo.Result;
import com.zzzj.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * 员工管理
 */
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;
    //传参方式一：

//    @GetMapping
//    public Result  page(@RequestParam(defaultValue = "1") Integer page,
//                        @RequestParam(defaultValue = "10") Integer pageSize,
//                        String name , Integer gender,
//                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
//                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end)//@DateTimeFormat(pattern = "yyyy-MM-dd")日期时间类型参数接收时,需要通过这个注解指定前端传递的日期格式
//    {
//        log.info("查询请求参数： {}, {}, {}, {}, {}, {}", page, pageSize, name, gender, begin, end);
//        PageResult<Emp> pageResult = empService.page(page, pageSize, name, gender, begin, end);
//        return Result.success(pageResult);
//
//    }
@GetMapping
public Result  page(EmpQueryParam empqueryparam)//@DateTimeFormat(pattern = "yyyy-MM-dd")日期时间类型参数接收时,需要通过这个注解指定前端传递的日期格式
{
    log.info("查询请求参数： {}", empqueryparam);
    PageResult<Emp> pageResult = empService.page(empqueryparam);
    return Result.success(pageResult);

}

/**
 * 添加员工
 */
@PostMapping
    public Result save(@RequestBody Emp emp)
{
    log.info("新增员工，员工信息： {}", emp);
    empService.save(emp);
    return Result.success();
}

}