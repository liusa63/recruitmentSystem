package com.recruitmentSystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.UserBiz;

/**
 * Servlet implementation class UpdateExperienceSuccessServlet
 */
public class UpdateExperienceSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateExperienceSuccessServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	private void doAll(HttpServletRequest request, HttpServletResponse response) {
		// ����eid�޸Ĺ�������
		int uid=Integer.parseInt(request.getParameter("uid"));
		int eid=Integer.parseInt(request.getParameter("eid"));
		String ecompany=request.getParameter("ecompany");
		String etimes=request.getParameter("etimes");
		String epost=request.getParameter("epost");
		String edes=request.getParameter("edes");
		UserBiz biz = new UserBiz();
		try {
			//�����޸ķ���
			biz.updateExperience(eid, ecompany, etimes, epost, edes);
			//��ת���ҵĹ�������ҳ��չʾ
			request.setAttribute("uid", uid);
			request.getRequestDispatcher("MyExperienceServlet").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
