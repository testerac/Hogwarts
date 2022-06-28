package wework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import java.util.ArrayList;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-06-24 18-43
 **/
public class ContantPage extends BasePage{
    public ContantPage(WebDriver driver) {
        super(driver);
    }

    public ContantPage addMamber(String account, String name, String phone){
        driver.findElement(By.linkText("添加成员")).click();
        driver.findElement(By.name("username")).sendKeys(name);
        driver.findElement(By.name("acctid")).sendKeys(account);
        driver.findElement(By.name("mobbile")).sendKeys(phone);
        driver.findElement(By.linkText("保存")).click();
        return this;
    }
    public ContantPage importContant(String path){
        return this;
    }

    public List<String> getCurrentMemberList(){
        //自动化过程
        driver.findElement(By.cssSelector("#meber_list td :nth-child(2) > span")).forEach(e ->{
           users.add(e.getText());
        });
        List<String> users = new ArrayList<>();

        return users;
    }

}
