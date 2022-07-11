package wework;

import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.bys.builder.AppiumByBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Base64;

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
        desiredCapabilities.setCapability("appPackage","io.appium.android.apis");
        desiredCapabilities.setCapability("appActivity","io.appium.android.apis.ApiDemos");
       /* desiredCapabilities.setCapability("settings[fixImageFindScreenshotDims]","false");
        desiredCapabilities.setCapability("settings[fixImageTemplateSize]",true);
        desiredCapabilities.setCapability("settings[getMatchedImageResult]",true);*/


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

    /**
     * 测试appium-opencv图像识别测试
     */
    @Test
    public void testOpenCV() throws InterruptedException, IOException {
        driver.findElement(AppiumBy.accessibilityId("Graphics")).click();
        driver.findElement(AppiumBy.accessibilityId("BitmapMesh")).click();
        WebElement noseElement = driver.findElement(AppiumBy.ImageAsBase64String("存放图片的文件路径"));

        System.out.println (Mapper.WriteValueAsString(noseElement.getRect()));
        noseElement.click();
        driver.setSetting(Setting.IMAGE_MATCH_THRESHOLD,0.5);
        WebElement flowerElement = driver.findElement(AppiumBy.Image(ImageAsBase64String("存放图片的文件路径")));
        System.out.println(Mapper.WriteValueAsString(flowerElement.getRect()));
        flowerElement.click();
    }
    private String getImageAsBase64String(String imagePath) throws IOException{
        return Base64.getEncoder().encodeToString(Files.readAllBytes(imagePath.of(imagePath)));
    }



    @AfterEach
     public void tearDown(){
        driver.quit();
    }
}
