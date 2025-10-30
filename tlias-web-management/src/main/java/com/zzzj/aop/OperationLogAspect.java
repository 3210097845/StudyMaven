package com.zzzj.aop;

import com.zzzj.anno.LogOperation;
import com.zzzj.mapper.OperateLogMapper;
import com.zzzj.pojo.OperateLog;
import com.zzzj.utils.CurrentHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 添加操作日志
 */

@Slf4j
@Aspect
@Component
public class OperationLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    // 环绕通知
    @Around("@annotation(log)")
    public Object around(ProceedingJoinPoint joinPoint, LogOperation log) throws Throwable {
        // 记录开始时间
        long startTime = System.currentTimeMillis();
        // 执行方法
        Object result = joinPoint.proceed();
        // 当前时间
        long endTime = System.currentTimeMillis();
        // 耗时
        long costTime = endTime - startTime;

        // 构建日志对象
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateEmpId(getCurrentUserId()); // 需要实现 getCurrentUserId 方法
        operateLog.setOperateTime(LocalDateTime.now());// 当前时间
        operateLog.setClassName(joinPoint.getTarget().getClass().getName());//获取当前操作类名
        operateLog.setMethodName(joinPoint.getSignature().getName());//获取当前操作方法名
        operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs()));//获取当前操作参数
        operateLog.setReturnValue(result.toString());//获取当前操作方法的返回值
        operateLog.setCostTime(costTime);// 耗时

        // 插入日志
        operateLogMapper.insert(operateLog);
        return result;
    }
    
    // 示例方法，获取当前用户ID
    private int getCurrentUserId() {
        return CurrentHolder.getCurrentId();
    }
}