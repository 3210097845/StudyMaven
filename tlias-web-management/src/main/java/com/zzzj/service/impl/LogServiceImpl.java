package com.zzzj.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzzj.mapper.OperateLogMapper;
import com.zzzj.pojo.LogQuerParam;
import com.zzzj.pojo.OperateLog;
import com.zzzj.pojo.PageResult;
import com.zzzj.service.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements Log {
    @Autowired
    private OperateLogMapper operateLogMapper;
    @Override
    public PageResult<OperateLog> page(LogQuerParam logQuerParam) {
        //1. 设置PageHelper分页参数
        PageHelper.startPage(logQuerParam.getPage(), logQuerParam.getPageSize());
        //2. 执行查询
        List<OperateLog> logList = operateLogMapper.page(logQuerParam);
        //3. 封装分页结果
        Page<OperateLog> p = (Page<OperateLog>)logList;
        return new PageResult(p.getTotal(), p.getResult());
    }

}
