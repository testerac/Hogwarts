package TestCase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-06-15 19-03
 **/
public class AiceTest {
   public static  Webdriver driver;
   public static WebdriverWait wait;
    @BeforeAll
    public static void initData(){
        driver = ChromeDriver;
        //     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @Test
    public void login(){
        driver.get("测试登录的地址");
        driver.findElement(By.xpath("//span[contains*(text(),'登录')]")).click();
        wait.until(new ExpectedCondition<WebElement>(){
            public webElement apply(WebDriver driver){
                return driver.findElement(Byte.id(""));
            }
        });
     WebElement element =  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains*(text(),'登录')]")));
     element.click();
    }

}
