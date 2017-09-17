package com.toz.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toz.service.ResponseUtil;
import com.toz.service.jackson;
import net.sf.json.JSONObject;
import com.toz.model.PageBean;
import com.toz.service.stuinfoservice;
import com.toz.conn.conn;
import com.toz.model.stuInfo;
import net.sf.json.JSONArray;

import java.io.IOException;
import java.sql.Connection;

/**
 * Created by Administrator on 2017/9/12.
 */
public class studisplayservlet extends HttpServlet {
    conn conn = new conn();
    stuinfoservice stuinfoservice = new stuinfoservice();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("page");
        String rows = req.getParameter("rows");
        String truename = req.getParameter("truename");
        if (truename == null) {
            truename = "";
        }
        System.out.print("ssssssssssssss");
        stuInfo stuInfo = new stuInfo();
        stuInfo.setTruename(truename);
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Connection connection = null;

        try {
            connection = conn.getCon();
            JSONObject result = new JSONObject();
            JSONArray jsonArray = jackson.formatRsToJsonArray(stuinfoservice.gradeList(connection, pageBean, stuInfo));
            int total = stuinfoservice.gradeCount(connection, stuInfo);
            result.put("rows", jsonArray);
            result.put("total", total);
            ResponseUtil.write(resp, result);
            System.out.print("sssss11111111");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                this.conn.closeCon(connection);
            } catch (Exception var19) {
                var19.printStackTrace();
            }
        }
    }
}
