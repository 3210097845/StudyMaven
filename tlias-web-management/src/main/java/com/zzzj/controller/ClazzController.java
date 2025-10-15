package com.zzzj.controller;

import com.zzzj.pojo.*;
import com.zzzj.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {
    @Autowired
    private ClazzService clazzService;
    /**
     * 班级列表查询
     * @return
     */
    @GetMapping
    public Result page(EmpQueryParam  clazzQueryParam)
    {
        log.info("班级列表查询： {}", clazzQueryParam);

        PageResult <Clazz> pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);


    }
}
