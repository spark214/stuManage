package com.toz.servlet;

import java.io.IOException;

import com.toz.service.ResponseUtil;
import net.sf.json.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toz.service.stuinfoservice;

public class deletestudent extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public deletestudent() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}


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

		String ids=request.getParameter("ids");
		try {
			JSONObject result=new JSONObject();
			int delNums=new stuinfoservice().deleteStu(ids);
			if (delNums>0){
				result.put("success","true");
				result.put("delNums",delNums);
			}else{
				result.put("errorMsg","删除失败");
			}
			ResponseUtil.write(response,result);
		}catch (Exception e){
			e.printStackTrace();
		}

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
