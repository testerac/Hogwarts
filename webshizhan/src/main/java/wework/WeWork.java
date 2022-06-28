package wework;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-06-24 18-25
 **/
public class WeWork {
    
    //private static ChromeDriver driver;不支持这么做，多线程运行造成影响
    private ChromeDriver driver;

    void start(){
        System.setProperty("webdriver.chrome.driver","存放谷歌驱动的本地地址");
        //多浏览器兼容性测试需要调整，根据变量调整不同的浏览器
        driver = new ChromeDriver();
        loadCookie();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    MainPage defaultPage(){
        start();
        return new MainPage(driver);
    }

    void loadCookie(){
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        TypeReference<List<HashMap<String, Object>>> typeReference = new TypeReference<List<HashMap<String, Object>>>(){};
        List<HashMap<String,Object>> cookies = null;
        try{
            cookies = objectMapper.readValue(this.getClass().getResource("/cookie.yaml"),typeReference);
        }catch (IOException e){
            e.printStackTrace();
        };
        driver.get("https://work.weixin.qq.com/wework_admin/frame");
        cookies.forEach(cookie ->
        {
            driver.manage().addCookie(new Cookie(cookie.get("name").toString(),cookie.get("value").toString()));
        });
        driver.navigate().refresh();
    }
}
