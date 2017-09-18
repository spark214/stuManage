package com.toz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.toz.model.userTable;
import com.toz.service.StringUtil;
import com.toz.service.userservice;

public class loginservlet extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doPost( request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    String username=request.getParameter("username");
    String password=request.getParameter("password");
	String imageCode=request.getParameter("imageCode");
    userTable user=new userTable();
    user.setPassword(password);
    user.setUsername(username);
    HttpSession session=request.getSession();
    if(StringUtil.isNotEmpty(imageCode)){
    	System.out.println("imageCode is not empty");
		if(imageCode.equals(session.getAttribute("sRand"))){
			System.out.println("imageCode is r");
			if(new userservice().valiUser(user)){
				session.setAttribute("user",user);
				response.sendRedirect("../main.jsp");
			}
			else{

				request.setAttribute("error","账户或密码错误");
				request.getRequestDispatcher("../index.jsp").forward(request, response);
			}
		}
		else {
			System.out.println("imageCode is not r");
			request.setAttribute("error","验证码错误");
			request.getRequestDispatcher("../index.jsp").forward(request, response);
		}
	}else{
		System.out.println("imageCode is empty");
		request.setAttribute("error","验证码为空");
		request.getRequestDispatcher("../index.jsp").forward(request, response);
	}

	
	}


}
