package com.toz.service;

/**
 * Created by Administrator on 2017/9/12.
 */
public class StringUtil {
    public StringUtil() {
    }

    public static boolean isEmpty(String str) {
        return "".equals(str) || str == null;
    }

    public static boolean isNotEmpty(String str) {
        return !"".equals(str) && str != null;
    }
}
