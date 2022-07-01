package wework;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-06-29 17-49
 **/
public class DemoTest {

    private AndroidDriver driver;

    @BeforeEach
    public  void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", Platform.ANDROID.name());
        desiredCapabilities.setCapability("noReset", "true");
        desiredCapabilities.setCapability("appPackage", "com.tencent.wework");
        desiredCapabilities.setCapability("appActivity", ".launch.LaunchSplashActivity");
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("deviceName","5GK4C19408007222");

        URL remoteUrl = new URL("http://0.0.0.0:4723/wd/hub");


        driver = new AndroidDriver(remoteUrl,desiredCapabilities);
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    //    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
     //  wait.until(driver -> driver.findElements(By.xpath("//*[@text='通讯录']")).size()>0);
    //   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='通讯录']")));


    }
    @Test
   public void sampleTest(){
        driver.findElement(By.xpath("//*[@text='通讯录']")).click();
        driver.findElement(By.id("ixb")).click();
        driver.findElement(By.id("ekp")).click();
        driver.findElement(By.xpath("//*[@text='手动输入添加']")).click();
        driver.findElement(By.id("ber")).sendKeys("13201870905");
        driver.findElement(By.id("alp")).click();
        driver.findElement(By.xpath("//*[@text='保存']")).click();
        driver.findElement(By.id("ix5")).click();

    }
    @AfterEach
     public void tearDown(){
        driver.quit();
    }
}
