package com.zzzj.exception;

public class DeleteclazzException extends RuntimeException{
    public DeleteclazzException(String message) {
        super(message);//输出错误信息
    }
    public DeleteclazzException(String message, Throwable cause) {
        super(message, cause);//cause表示导致这个异常的原因，即原始的异常对象
    }
    public DeleteclazzException() {
        super();
    }

}
