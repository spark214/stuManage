package com.toz.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Administrator on 2017/9/17.
 */
public class ifsessionservlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);

    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            System.out.print("8888888888");
        HttpSession session=request.getSession();
        System.out.println("666666666666: "+session.getAttribute("user"));
        if (session.getAttribute("user")!=null) {
           request.getRequestDispatcher("main.jsp").forward(request,response);
            System.out.println("!!!!!!!!!!!!!!!!!!!");
        }else {
            response.sendRedirect("index.jsp");
        }

    }
}
