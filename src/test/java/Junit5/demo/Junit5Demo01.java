package Junit5.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import entity.ResultList;
import entity.ShellResult;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-06-14 02-24
 **/
public class Junit5Demo01 {
    @TestFactory
    Collection<DynamicTest> dynamicTestCollection(){
        return Arrays.asList(
                dynamicTest("1st dynamic test",() ->{
                 assertTrue(true);
                }),
                dynamicTest("2nd dynamic test",() -> assertEquals(4,4)
                )
        );
    }
    @Test
    public void entityTest() throws IOException {
        //反序列化的一个固定写法，反序列化yaml数据到对象列表中去
        ObjectMapper objectMApper = new ObjectMapper(new YAMLFactory());
        ResultList resultList = objectMApper.readValue(new File("src/main/resources/shell_test_result.yaml"),ResultList.class);
    }
    @TestFactory
    //动态生成的逻辑
    Collection<DynamicTest> runShellResult() throws IOException {
        List<DynamicTest> dynamicTestList = new ArrayList<>();
        ObjectMapper objectMApper = new ObjectMapper(new YAMLFactory());
        //动态遍历生成测试方法
        ResultList resultList = objectMApper.readValue(new File("src/main/resources/shell_test_result.yaml"),ResultList.class);
        for(ShellResult shellResult: resultList.getResultList()){
            dynamicTestList.add(
                    dynamicTest(shellResult.getCaseName(),() ->{
                        assertTrue(shellResult.isResult());
                    })
            );
        }
        return  dynamicTestList;
    }
}
