
package com.toz.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.toz.model.stuInfo;
import com.toz.service.stuinfoservice;

public class inputstuinfo extends HttpServlet {

	public inputstuinfo() {
		super();
	}

	public void destroy() {
		super.destroy();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
	
			String nicheng=request.getParameter("nicheng");
			String truename=request.getParameter("truename");

			String csrq=request.getParameter("csrq");
			String zy=request.getParameter("zy");
			System.out.println(zy);
			//String kc=request.getParameter("kc");
			String kcs[]=request.getParameterValues("kc");
			String xqs[]=request.getParameterValues("xq");
			String bz=request.getParameter("bz");
			stuInfo stu=new stuInfo();
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

			if(new stuinfoservice().addStu(stu)) {
				HttpSession session=request.getSession();
				session.setAttribute("aa",11);
//				response.sendRedirect("../inputstuinfo_success.jsp");
				response.sendRedirect("../inputstuinfo.jsp");
			}

			else
				response.sendRedirect("../inputstuinfo.jsp");
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
