
import framework.actions.ApiActionModel;
import framework.global.GlobalVariables;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-07-08 15-43
 **/
public class Test01_ApiActionModel {
    @Test
    void runTest(){
        ArrayList<String> actualParameter = new ArrayList<>();
        actualParameter.add("");
        actualParameter.add("");

        ApiActionModel apiActionModel = new ApiActionModel();
        apiActionModel.setUrl("https://qyapi.weixin.qq.com/cgi-bin/${x}");

        HashMap<String,String> globalVariables = new HashMap<>();
        globalVariables.putAll("x","gettoken");
        GlobalVariables.setGlobalVariables(globalVariables);

        ArrayList<String> formalParameter = new ArrayList<>();
        formalParameter.add("corpid");
        formalParameter.add("corpsecret");
        apiActionModel.setFormalParam(formalParameter);

        HashMap<String,String>  query = new HashMap<>();
        query.put("corpid","${corpid}");
        query.put("corpsecret","${corpsecret}");
        apiActionModel.setQuery(query);
        Response response = apiActionModel.run(actualParameter);


    }

}
