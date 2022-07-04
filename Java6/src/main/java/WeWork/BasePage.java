package WeWork;


import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-07-04 13-18
 **/
public class BasePage {
     AppiumDriver driver;
     private WebElement currentElement;

    public BasePage(AppiumDriver driver){
        this.driver =driver;
    }
    public BasePage(){

    }
    public BasePage find(By by){
        //递归次数控制
        try{
        currentElement = driver.findElement(by);
        ExceptionHandler.retry = 0;
        }catch (Exception exception){
            ExceptionHandler.retry +=1;
            if (ExceptionHandler.retry>ExceptionHandler.retryMax){
                throw exception;
            }
            //todo:处理各种异常

            String pageSource = driver.getPageSource();
            ExceptionHandler.getExceptionHandler().forEach(exceptionHandler ->{
                if(exceptionHandler.isHit(pageSource)){
                    exceptionHandler.handle(driver);
                    //递归调用
                    find(by);
                }
            });
        }

        return this;

    }
    public BasePage click(By by){
        find(by).click();
        return this;

    }
    public BasePage click(){
        currentElement.click();
        return this;
    }


    public BasePage sendKeys(String input) {
        currentElement.sendKeys(input);
        return this;
    }
    public BasePage sendKeys(String input,By by){
        find(by).sendKeys(input);
        return this;

    }
    public String getText(){
        return currentElement.getText();

    }
    public void wait(ExpectedCondition expectedCondition,int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(expectedCondition);
    }
    public void wait(ExpectedCondition expectedCondition){
        wait(expectedCondition,60);
    }


}
