package wework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-06-25 09-39
 **/
public class BasePage {
     final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement find(By by){
        WebElement element =null;
        //todo: 当出现异常的时候,解决异常，然后重新回归到当前步骤继续执行
        //todo:递归设计,对递归做深度限制
        try {
            element = driver.findElement(by);

        }catch (Exception e){
            e.printStackTrace();
            element = this.find(by);

        }

        return element;
    }
    public void click(){}
    public void SendKeys(){}
}
