package com.zzzj.controller;

import com.github.pagehelper.Page;
import com.zzzj.pojo.LogQuerParam;
import com.zzzj.pojo.OperateLog;
import com.zzzj.pojo.PageResult;
import com.zzzj.pojo.Result;
import com.zzzj.service.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {
    @Autowired
    private Log logService;

    /**
     * 分页查询日志操作
     * @return
     */
    @GetMapping("/page")
    public Result LogPage(LogQuerParam logQuerParam)
    {
        log.info("分页查询日志操作：{}", logQuerParam);
        PageResult pageResult=logService.page(logQuerParam);
        return Result.success(pageResult);
    }
}
