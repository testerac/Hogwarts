package com.ApiObject.framework.api;

import com.ApiObject.framework.actions.ApiActionModel;


import lombok.Data;


import java.util.HashMap;

/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-07-08 16-03
 **/
@Data
public class ApiObjectModel {
    private String  name;
    private HashMap<String, ApiActionModel> actions;

    public static  ApiActionModel load(String path){
        Obj

    }
}
