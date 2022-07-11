package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-07-05 21-13
 **/
public class POTestCase {
    public WebDriver driver;
    public String name;
    public List<HashMap<String, Object>> after_all;
    public List<HashMap<String, Object>> befor_all;
    public List<HashMap<String, Object>> after;
    public List<HashMap<String, Object>> before;
    public List<HashMap<String, Object>> steps;

    public void run() {
        AtomicReference<By> default_by = new AtomicReference<>();
        steps.forEach(steps -> {
            steps.entrySet().forEach((entry) -> {
                String action = entry.getKey().toLowerCase();
                String[] key_Arry = action.split("\\.");

                Object value = entry.getValue();

                if (key_Arry.length>1) {
                    String po = key_Arry[0];
                    String poMethod = key_Arry[1];

                    System.out.println(String.format("%s.%s %s ",po,poMethod,value));
                }else{
                    System.out.println(String.format("%s.%s",action,value));
                }


            });
        });
    }
}
