package com.toz.service;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class jackson {
    public static JSONArray formatRsToJsonArray(ResultSet rs)throws Exception{
        ResultSetMetaData md=rs.getMetaData();//获得数据库表结构
        int num=md.getColumnCount();
        JSONArray array=new JSONArray();
        while(rs.next()){
            JSONObject mapOfColValues=new JSONObject();//json对象
            for(int i=1;i<=num;i++){
                Object o=rs.getObject(i);
                try {
                    if(o instanceof Date){
                        mapOfColValues.put(md.getColumnName(i), DateUtil.formatDate((Date)o, "yyyy-MM-dd"));
                    }else{
                        mapOfColValues.put(md.getColumnName(i), rs.getObject(i));//（key,values)
                    }
                }catch (Exception e) {
                    System.out.println("此处接收被调用方法内部未被捕获的异常");
                    e.printStackTrace();
                }


            }
            array.add(mapOfColValues);
        }
        return array;
    }

}
