package WeWork;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-07-04 16-24
 **/
public class PopupExceptionHandler extends ExceptionHandler{

    @Override
    public Boolean isHit(String pageSource) {
        return pageSource.contains("关闭") && pageSource.contains("等待");
    }

    @Override
    public void handle(AppiumDriver driver) {
        driver.findElement(By.xpath("//*[@text='等待']")).click();

    }
}
