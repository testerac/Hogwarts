package wework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ContantPageTest {

    private static MainPage main;
    private static ContantPage contant;

    @BeforeAll
    static void beforeAll(){
        //todo:数据清理
        main = new WeWork().defaultPage();
        contant = main.toContant();
    }

    @Test
    void addMamber() {
       List<String> userList= contant.addMamber("2211133111","28373781","13201870905").getCurrentMemberList();
       assertThat(userList,hasItem("2211133111"));
    }


}