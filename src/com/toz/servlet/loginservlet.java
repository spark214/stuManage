package com.toz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.toz.model.userTable;
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
    userTable user=new userTable();
    user.setPassword(password);
    user.setUsername(username);
    if(new userservice().valiUser(user)){
    	HttpSession session=request.getSession();
    	session.setAttribute("user",user);
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires", 0);
		response.sendRedirect("../main.jsp");
    }
    else{
    	response.sendRedirect("../index.jsp");
    }
	
	}


}
