package wework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-06-24 18-35
 **/
public class MainPage extends BasePage{
    public MainPage(WebDriver driver) {
        super(driver);
    }

    List<String> getMessages(){
        //todo:
        ArrayList<String> messages = new ArrayList<>();
        messages.add("1");
        return messages;
    }

    ContantPage toContant(){
        driver.findElement(By.linkText("通讯录")).click();
        return new ContantPage(driver);
    }
}
