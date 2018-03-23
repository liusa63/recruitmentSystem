package com.recruitmentSystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.AdminBiz;

public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取用户输入的用户名和密码
				String username = request.getParameter("username");
				String pwd = request.getParameter("password");
				// 实现登录的业务流程：通过用户名和密码查询该用户是否存在（是否为管理员)
				AdminBiz biz = new AdminBiz();
				boolean flag = biz.getAdmin(username, pwd);
				if (flag) {
					// 跳转到主页上去
					request.getRequestDispatcher("/adminpages/main.jsp").forward(request,
							response);
				} else {
					// 提示用户名或密码错误，跳转到登录页面
					request.setAttribute("msg", "用户名或密码错误");
					request.getRequestDispatcher("/adminlogin.jsp").forward(request,
							response);
				}
	}

}
