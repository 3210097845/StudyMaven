package com.zzzj.service;

import com.zzzj.pojo.LogQuerParam;
import com.zzzj.pojo.OperateLog;
import com.zzzj.pojo.PageResult;

public interface Log {
    /**
     * 分页查询日志操作
     * @return
     */
    PageResult<OperateLog> page(LogQuerParam logQuerParam);
}
