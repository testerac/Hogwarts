package framework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.stream.Stream;


/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-07-04 18-15
 **/
public class SearchTest {
    static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }


    @ParameterizedTest
    @MethodSource("data")
    public void runTestCase(TestCase testCase) {
        /**
         * 统一的步骤处理
         */
      /*  driver.get("https://ceshiren.com");
        driver.findElement(By.id("search-button")).click();

        String keywords = "内推 BAT";
        driver.findElement(By.id("search-term")).sendKeys(keywords+Keys.ENTER);
        String title=driver.findElement(By.cssSelector(".topic-title")).get(0).getText();
        assertThat(title,containsString(keywords));*/

        testCase.run();
    }

    static Stream<POTestCase> data() throws IOException {
        /**
         * 统一的数据读取
         */
       /* return Stream.of("src/test/java/framework/search.yaml",
                "src/test/java/framework/search.yaml");
        //todo: read from directory

    }*/

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        POTestCase testCase = mapper.readValue(new File("src/test/java/framework/search.yaml"),
                POTestCase.class);
        return Stream.of(testCase);

    }
}
