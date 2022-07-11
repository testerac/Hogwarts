package com.example.testplatfrom.common;

/**
 * 异常服务类
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-07-11 15-29
 **/
public class ServiceException extends RuntimeException{
    private static final long SerivalVsersionUID = 1L;
    private String message;

    @Override
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message=message;

    }
    public ServiceException(final String message,Throwable throwable){
        super(throwable);
        this.message=message;
    }
    public ServiceException(final String message){
        this.message=message;
    }
    public static void throwEx(String message){
        throw new ServiceException(message);
    }


}
