package WeWork;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-07-04 12-21
 **/
public class App {

    private AndroidDriver driver;
    /*
    * 启动appium，生成driver，代表一次自动化过程
    */

    public DefaultPage start() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", Platform.ANDROID.name());
        desiredCapabilities.setCapability("noReset", "true");
        desiredCapabilities.setCapability("appPackage", "com.tencent.wework");
        desiredCapabilities.setCapability("appActivity", ".launch.LaunchSplashActivity");
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("deviceName", "5GK4C19408007222");

        URL remoteUrl = new URL("http://0.0.0.0:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return new DefaultPage(driver);
    }
    public void close(){

    }
}

