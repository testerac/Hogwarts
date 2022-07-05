package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-07-04 19-07
 **/
//todo：支持数据化
    //todo:支持page object
    //todo：支持web app service
    //todo：命令行参数支持
    //todo:目录读取
public class TestCase {
    public WebDriver driver;
    public String name;
    public List<HashMap<String,Object>> after_all;
    public List<HashMap<String,Object>> befor_all;
    public List<HashMap<String,Object>>  after;
    public List<HashMap<String,Object>> before;
    public List<HashMap<String,Object>> steps;

    public void run(){
        System.out.println(steps);
        AtomicReference<By> default_by=new AtomicReference<>();
        steps.forEach(steps ->{
            steps.entrySet().forEach((entry)->{
                String action = entry.getKey().toLowerCase();
                Object value = entry.getValue();
                if(action.equals("get")){
                    driver.get((String) value);
                }else if (action.equals("find")){
                    ArrayList<String> values= (ArrayList<String>) value;
                    String loctor_by = values.get(0);
                    String loctor_value = values.get(1);
                    if(loctor_by.equals("id")){
                        default_by.set(By.id(loctor_value));
                    }else if (loctor_by.equals("css")){
                        default_by.set(By.cssSelector(loctor_value));
                    }
                }
                else if(action.equals("click")){
                    driver.findElement(default_by.get()).click();
                }else if(action.equals("sendkeys")){
                    String keys = (String) value;
                    driver.findElement(default_by.get()).sendKeys(keys);
                }else if(action.equals("chrome")){
                    driver = new ChromeDriver();
                }else if (action.equals("wait_imp")){
                    Integer seconds = (Integer) value;
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
                }

            });
        });

    }


}
