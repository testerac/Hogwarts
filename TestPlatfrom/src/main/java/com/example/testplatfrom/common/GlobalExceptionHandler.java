package com.example.testplatfrom.common;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * 全局异常捕获，主要业务异常和其他业务异常两种
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-07-11 15-48
 **/
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {
    //业务异常
    @ExceptionHandler(ServiceException.class)
    public resultDto serviceExceptionHandle(ServiceException ex){
        return resultFormat(ex);
    }
    //其他异常
    @ExceptionHandler(Exception.class)
    public resultDto exception(Exception ex){
        return resultFormat(ex);
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public resultDto throwable(Throwable throwable){
        log.error("服务置为不可用",throwable);
        return resultFormat(throwable);
    }

    private <T extends Throwable> String resultFormat(T ex){
        log.error("全局捕获 ==",ex);
        ResultDto resultDto = ResultDto.newInstance();
        resultDto.setAsFailure();


        if(ex instanceof ServiceException){
            ServiceException serviceException = (ServiceException) ex;
            resultDto.setMessage(serviceException.getMessage());

        }else{
            resultDto.setMessage("服务置为不可用",ex.getMessage());

        }
        return resultDto;
    }

}
