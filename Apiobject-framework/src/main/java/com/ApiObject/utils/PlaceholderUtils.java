package com.ApiObject.utils;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;



/**
 * @program:
 * @description:配置文件或模板中的占位符替换工具类
 * @author: Mr.libb
 * @creat: 2022-07-08 14-11
 **/
public class PlaceholderUtils {
    public static final Logger logger = LoggerFactory.getLogger(PlaceholderUtils.class);
    /**
     * prefix for System property Placeholders: "${"
     */
    public static  final  String PLACEHOLDER_PREFIX = "${";

    /**
     * Suffix for System property Placeholders: "$}"
     */
    public static  final  String PLACEHOLDER_SUFFIX= "}";

    /**
     * 计算变量名结束的位置
     */



}
