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
		//��ȡ�û��������������ݿ�ȶ�
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		UserBiz biz= new UserBiz();
		   try {
			User user=  biz.findUserWhenLogin(username, password);
			if(user!=null){//����û�����
				if(user.getUbehave().equals("0")){//����״̬����ת����ҳ
				int uid=user.getUid();
				String ustatus=user.getUstatus();
				request.getSession().setAttribute("uid", uid);
				request.getSession().setAttribute("ustatus", ustatus);
				request.getRequestDispatcher("/pages/main.jsp").forward(request, response);
				}else{//����״̬��������ʾ
					request.setAttribute("loginFailMsg", "�����˺��ѱ����ã���ȴ�����Ա��ϵ");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}else{//����û������ڣ��ڵ�¼ҳ�����������ʾ
				request.setAttribute("loginFailMsg", "��������û������ڣ������������ע��");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
