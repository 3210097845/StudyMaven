package com.zzzj.exception;

import com.zzzj.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    //处理异常
    @ExceptionHandler
    public Result handleException(Exception e){//方法形参中指定能够处理的异常类型
        log.error("服务器发生异常: " + e);
        e.printStackTrace();//打印堆栈中的异常信息
        //捕获到异常之后，响应一个标准的Result
        return Result.error("对不起,操作失败,请联系管理员");
    }
    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e){
        log.error("请求出错: " + e);
       String  message = e.getMessage();
       int i =message.indexOf("Duplicate entry");//获取索引
        String errMsg = message.substring(i,message.lastIndexOf("for key"));//截取字符串
        String[] arr = errMsg.split(" ");//获取字段名
        return Result.error("已存在："+arr[2]);


    }
    
}