package WeWork.Contect;

import WeWork.App;
import WeWork.ContectPage;
import WeWork.DefaultPage;
import WeWork.Member;
import com.sun.org.apache.xpath.internal.functions.FuncQname;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-07-04 12-27
 **/
public class ContectTest {
    static DefaultPage defaultPage;
    private static App app;
    ContectPage contectPage;


    @BeforeAll
    static void beforeAll() throws MalformedURLException {
         app = new App();
        defaultPage=app.start();
    }
    @BeforeEach
    void beforeEach(){
        contectPage = defaultPage.toContect();
    }
    @Test
    void add() throws InterruptedException{
        String name = "13201870905";
        Member member=contectPage.add(name,name).find(name);
        assertThat(member.getName(),equalTo(name));
        assertThat(member.getPhone(),equalTo("1"));
        assertThat(member.getDepart(),equalTo("自由测试人"));


    }
    @AfterEach
    void afterEach(){
        contectPage.back();
    }
    @AfterAll
   static void close(){
        app.close();
    }

}
