package TestCase;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-06-23 15-38
 **/
public class BaseTest {
    public static WebDriver Driver;
    @BeforeAll
    public static void initData(){
        String browserName = System.getenv("browser");
        if("chrome".equals(browserName)){
            System.setProperty("webdriver.chrome.driver","存放google驱动的地址");
            driver = new ChromeDriver();
        }else if("firefox".equals(browserName)){
            System.setProperty("webdriver.firefox.driver","存放火狐驱动的地址");
            driver=new FireFoxDriver();
        }else if("safari".equals(browserName)){
            System.setProperty("webdriver.safari.driver","存放safari驱动的地址");
            driver = new safariDriver();
        }
    }
    @AfterAll
    public static void teadown(){
        driver.quit();
    }
}
