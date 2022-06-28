package ceshiren.hogwarts.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.StdSubtypeResolver;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import jdk.internal.org.objectweb.asm.TypeReference;
import jdk.internal.org.objectweb.asm.commons.Remapper;
import org.junit.jupiter.api.Test;

import javax.jws.Oneway;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-06-24 14-36
 **/
public class TestWeb {
    @Test
    void testLogin() {
        Webdriver driver = new ChromeDriver();
        driver.manage().timeOuts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.get("企业微信登录扫码页面地址");
        Thread.sleep(15000);
        driver.manage().getCookies();
        Set<Cookie> cookies = driver.manage().getCookies();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        mapper.writeValue(new File("cookies.yaml"),cookies);
    }
    @Test
    void testLogined() throws IOException,InterruptedException {
        Webdriver driver = new ChromeDriver();
        driver.manage().timeOuts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.get("企业微信登录扫码页面地址");
        driver.manage().getCookies();
        Set<Cookie> cookies = driver.manage().getCookies();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        //反向读出来cookie
        TypeReference typeReference = new TypeReference<List<HashMap<String,Object>>>(){

        };
       List<String, Object> cookies1 = mapper.readValue(new File("cookies.yaml"),typeReference);
       cookies.forEach(cookieMap ->{
           driver.manage().addCookie(new Cookie(cookieMap.get("name").toString(),cookieMap.get("value").toString()));
       });
       driver.naviagte().refresh();

    }





}
