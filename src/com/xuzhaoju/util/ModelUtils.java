package com.xuzhaoju.util;

import java.text.SimpleDateFormat;

/**
 * java类作用描述
 *
 * @author xuzhaoju
 * @createDate 2020/12/23 13:52
 */
public class ModelUtils {

    public static String TIME = "";
    private static SimpleDateFormat dateFormat = null;

    public static SimpleDateFormat getSimpleDateFormat(){
        if (EmptyUtils.isAnyoneEmpty(dateFormat)){
            dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        }
        return dateFormat;
    }
}
