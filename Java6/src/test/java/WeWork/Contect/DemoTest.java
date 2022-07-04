package WeWork.Contect;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-07-04 10-50
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
        desiredCapabilities.setCapability("deviceName", "5GK4C19408007222");

        URL remoteUrl = new URL("http://0.0.0.0:4723/wd/hub");


        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }
}
