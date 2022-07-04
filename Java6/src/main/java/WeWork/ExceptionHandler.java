package WeWork;

import io.appium.java_client.AppiumDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description:完成异常处理单独的类
 * @author: Mr.libb
 * @creat: 2022-07-04 16-21
 **/
public class ExceptionHandler {

    private static final ArrayList<ExceptionHandler> exceptionHandlers = new ArrayList<ExceptionHandler>();
    static int retryMax = 3;
    static int retry = 0;
    public Boolean isHit(String pageSource){
        return true;
    }
    public void handle(AppiumDriver driver){
    }
    public static List<ExceptionHandler> getExceptionHandler(){
        if(exceptionHandlers.size()==0){
        exceptionHandlers.add(new AppPopuExceptionHandler());
        exceptionHandlers.add(new PopupExceptionHandler());
        }
     return exceptionHandlers;
    }

}
