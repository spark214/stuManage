package com.toz.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.toz.service.stuinfoservice;

public class queryallservlet extends HttpServlet {

	public queryallservlet() {
		super();
	}


	public void destroy() {
		super.destroy();
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                        doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String osid = request.getParameter("osid");
		List stus = (List) new stuinfoservice().queryAllStu();
		HttpSession session = request.getSession();
		session.setAttribute("stus", stus);
		if (osid.equals("query"))
			response.sendRedirect("../displaystuinfo.jsp");
		else if (osid.equals("modify"))
			response.sendRedirect("../modifystuinfo.jsp");
		else
			response.sendRedirect("../deletestuinfo.jsp");
	}


	public void init() throws ServletException {
	
	}

}
