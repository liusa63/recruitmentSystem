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
		// 根据uid添加工作经验
		int uid=Integer.parseInt(request.getParameter("uid"));
		UserBiz biz= new UserBiz();
		try {
			//获取到rid
			int rid=biz.selectRidByUid(uid);
			//添加到数据库
			String ecompany=request.getParameter("ecompany");
			String etimes=request.getParameter("etimes");
			String epost=request.getParameter("epost");
			String edes=request.getParameter("edes");
			biz.addExperience(rid, ecompany, etimes, epost, edes);
			//添加成功后返回到工作经验的列表
			request.setAttribute("uid", uid);
			request.getRequestDispatcher("MyExperienceServlet").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
