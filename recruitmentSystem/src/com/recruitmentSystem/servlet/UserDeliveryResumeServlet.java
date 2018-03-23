package com.recruitmentSystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.UserBiz;

/**
 * Servlet implementation class UserDeliveryResumeServlet
 */
public class UserDeliveryResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeliveryResumeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Ͷ�ݼ���
				int uid= Integer.parseInt(request.getParameter("uid"));
				UserBiz biz= new UserBiz();
				try {
					//����uid��ѯ��rid
				    int pid=0;
					int rid= Integer.parseInt(request.getParameter("rid"));
					int dstatus= Integer.parseInt(request.getParameter("dstatus"));
					//д�����ݿ��delivery����
					biz.addDelivery(pid,rid,dstatus);
					//��ת����ҳ
					request.setAttribute("uid", uid);
					request.getRequestDispatcher("UserListServlet").forward(request, response);
				
					
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

}
