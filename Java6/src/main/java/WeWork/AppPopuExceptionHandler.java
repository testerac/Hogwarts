package WeWork;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-07-04 16-53
 **/
public class AppPopuExceptionHandler extends ExceptionHandler {
    @Override
    public Boolean isHit(String pageSource) {
        return pageSource.contains("用户调查") ;
    }

    @Override
    public void handle(AppiumDriver driver) {
        driver.findElement(By.xpath("//*[@text='等待']")).click();

    }
}
