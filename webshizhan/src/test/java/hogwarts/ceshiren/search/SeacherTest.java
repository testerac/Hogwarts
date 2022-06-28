package hogwarts.ceshiren.search;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-06-24 16-04
 **/
public class SeacherTest {
    @Test
    void search() {
        ChromeDriver driver = new ChromeDriver();
        //selenium3和4的用法不一样
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://ceshiren.com/");
        driver.findElement(By.id("search-button")).click();
        driver.findElement(By.id("search-term")).sendKeys("selenium"+ Keys.ENTER);
        String real =driver.findElement(By.cssSelector(".topic-tittle")).getText();
        assertThat(real, containsString("selenium"));

    }
}
