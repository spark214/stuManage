package com.toz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toz.model.stuInfo;
import com.toz.service.stuinfoservice;

public class modifyonestuinfo extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public modifyonestuinfo() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id=Integer.parseInt(request.getParameter("id"));
		System.out.println("iiiiiiid:"+id);
		String nicheng=request.getParameter("nicheng");
		String truename=request.getParameter("truename");
		String xb=request.getParameter("xb");
		String csrq=request.getParameter("csrq");
		String zy=request.getParameter("zy");
		System.out.println(zy);
		//String kc=request.getParameter("kc");
		String kcs[]=request.getParameterValues("kc");
		String xqs[]=request.getParameterValues("xq");
		String bz=request.getParameter("bz");
		stuInfo stu=new stuInfo();
		stu.setId(id);
		stu.setNicheng(nicheng);
		stu.setTruename(truename);
		
		stu.setCsrq(csrq);
		if(csrq.equals(""))
			stu.setCsrq(null);
		if(kcs!=null)
		stu.setKc(kcs);
		if(xqs!=null)
		stu.setXq(xqs);
		stu.setBz(bz);
		stu.setZy(zy);
		if(new stuinfoservice().updateStu(stu))
			response.sendRedirect("../modifyonestu_success.jsp");
		else
			response.sendRedirect("../modifyOnestu.jsp");

	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
