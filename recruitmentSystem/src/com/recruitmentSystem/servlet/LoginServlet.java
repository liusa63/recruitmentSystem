package com.recruitmentSystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.UserBiz;
import com.recruitmentSystem.entity.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}
	private void doAll(HttpServletRequest request, HttpServletResponse response) {
		//获取用户名和密码与数据库比对
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserBiz biz= new UserBiz();
		   try {
			User user=  biz.findUserWhenLogin(username, password);
			if(user!=null){//如果用户存在
				if(user.getUbehave().equals("0")){//启用状态：跳转到首页
				int uid=user.getUid();
				String ustatus=user.getUstatus();
				request.getSession().setAttribute("uid", uid);
				request.getSession().setAttribute("ustatus", ustatus);
				request.getRequestDispatcher("/pages/main.jsp").forward(request, response);
				}else{//禁用状态，给出提示
					request.setAttribute("loginFailMsg", "您的账号已被禁用，请等待管理员联系");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}else{//如果用户不存在：在登录页面给出错误提示
				request.setAttribute("loginFailMsg", "您输入的用户不存在，请重新输入或注册");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
