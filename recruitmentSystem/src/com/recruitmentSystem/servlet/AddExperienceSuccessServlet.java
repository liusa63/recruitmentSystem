package com.recruitmentSystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.UserBiz;

public class AddExperienceSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddExperienceSuccessServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	private void doAll(HttpServletRequest request, HttpServletResponse response) {
		// ����uid��ӹ�������
		int uid=Integer.parseInt(request.getParameter("uid"));
		UserBiz biz= new UserBiz();
		try {
			//��ȡ��rid
			int rid=biz.selectRidByUid(uid);
			//��ӵ����ݿ�
			String ecompany=request.getParameter("ecompany");
			String etimes=request.getParameter("etimes");
			String epost=request.getParameter("epost");
			String edes=request.getParameter("edes");
			biz.addExperience(rid, ecompany, etimes, epost, edes);
			//��ӳɹ��󷵻ص�����������б�
			request.setAttribute("uid", uid);
			request.getRequestDispatcher("MyExperienceServlet").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
