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
		// 根据eid修改工作经验
		int uid=Integer.parseInt(request.getParameter("uid"));
		int eid=Integer.parseInt(request.getParameter("eid"));
		String ecompany=request.getParameter("ecompany");
		String etimes=request.getParameter("etimes");
		String epost=request.getParameter("epost");
		String edes=request.getParameter("edes");
		UserBiz biz = new UserBiz();
		try {
			//调用修改方法
			biz.updateExperience(eid, ecompany, etimes, epost, edes);
			//跳转到我的工作经验页面展示
			request.setAttribute("uid", uid);
			request.getRequestDispatcher("MyExperienceServlet").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
