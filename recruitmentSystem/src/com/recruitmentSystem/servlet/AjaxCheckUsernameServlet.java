package com.recruitmentSystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.UserBiz;
import com.recruitmentSystem.entity.User;

/**
 * Servlet implementation class AjaxCheckUsernameServlet
 */
public class AjaxCheckUsernameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxCheckUsernameServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	private void doAll(HttpServletRequest request, HttpServletResponse response) {
		//获取用户名
				String username=request.getParameter("username");
				//业务逻辑，判断用户名是否重复
				UserBiz service=new UserBiz();
				User user=null;
				
				try {
					PrintWriter out=response.getWriter();
					user=service.selectByName(username);
					if(user!=null){
						out.print("fail");
					}else{
						out.print("success");
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

}
