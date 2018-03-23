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
		// ��ȡ�û�������û���������
				String username = request.getParameter("username");
				String pwd = request.getParameter("password");
				// ʵ�ֵ�¼��ҵ�����̣�ͨ���û����������ѯ���û��Ƿ���ڣ��Ƿ�Ϊ����Ա)
				AdminBiz biz = new AdminBiz();
				boolean flag = biz.getAdmin(username, pwd);
				if (flag) {
					// ��ת����ҳ��ȥ
					request.getRequestDispatcher("/adminpages/main.jsp").forward(request,
							response);
				} else {
					// ��ʾ�û��������������ת����¼ҳ��
					request.setAttribute("msg", "�û������������");
					request.getRequestDispatcher("/adminlogin.jsp").forward(request,
							response);
				}
	}

}
