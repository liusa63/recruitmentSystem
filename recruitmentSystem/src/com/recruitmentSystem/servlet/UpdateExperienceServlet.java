package com.recruitmentSystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.UserBiz;
import com.recruitmentSystem.entity.Experience;

/**
 * Servlet implementation class UpdateExperienceServlet
 */
public class UpdateExperienceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateExperienceServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doAll(request,response);
	}

	private void  doAll(HttpServletRequest request, HttpServletResponse response) {
		//���¹�������
		 
		int eid=Integer.parseInt(request.getParameter("eid"));
		UserBiz biz= new UserBiz();
		try {
			//��ѯ��������������
			Experience exp=biz.selectOneExperienceByEid(eid);
			//չ����ҳ��
			request.setAttribute("exp", exp);
			request.getRequestDispatcher("/pages/updateexperience.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
