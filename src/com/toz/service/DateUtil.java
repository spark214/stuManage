package com.toz.service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/9/13.
 */
public class DateUtil {

    public static String formatDate(Date date, String format){
        String result="";
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        if(date!=null){
            result=sdf.format(date);
        }
        return result;
    }


    public static Date formatString(String str,String format) throws Exception{
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        return sdf.parse(str);
    }
}
