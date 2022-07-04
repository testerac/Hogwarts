package WeWork;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-07-04 12-19
 **/
public class DefaultPage extends BasePage{

    By contect_tab=By.xpath("//*[@text='通讯录']");
    public DefaultPage(AppiumDriver driver) {
        super(driver);
        //启动时间很长,所以加一个显示等待,不要使用隐世等待
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='通讯录']")));
    }

    public ContectPage toContect(){
        driver.findElements(contect_tab).click();
        return new ContectPage(driver);

    }
}
