package com.zzzj.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 统计方法执行耗时
 */

@Component//当前类为组件类.会被spring管理，会自动创建该类的实例并且交给IOC容器管理
@Aspect //当前类为切面类
@Slf4j
public class RecordTimeAspect {

    @Around("execution(* com.zzzj.service.impl.DeptServiceimpl.*(..))")//拦截 DeptServiceimpl 类中的所有方法，在方法执行前后添加自定义逻辑，实现横切关注点的统一处理。
    //上面注解意思是针对哪些方法拦截，并且下面的程序就可以获取到这些方法的运行时间
    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
        //记录方法执行开始时间
        long begin = System.currentTimeMillis();

        //执行原始方法
        Object result = pjp.proceed();

        //记录方法执行结束时间
        long end = System.currentTimeMillis();

        //计算方法执行耗时
        log.info("{} 方法执行耗时: {}毫秒",pjp.getSignature(),end-begin);
        return result;
    }
}