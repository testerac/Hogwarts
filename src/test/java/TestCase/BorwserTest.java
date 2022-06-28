package TestCase;

import org.junit.jupiter.api.Test;

/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-06-23 15-48
 **/
public class BorwserTest extends BaseTest{
    @Test
    void browerTest(){
        driver.get("https://home.testing-studio.com");
    }
}
