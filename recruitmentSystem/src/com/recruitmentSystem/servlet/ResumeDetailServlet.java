package com.recruitmentSystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.UserBiz;
import com.recruitmentSystem.entity.Experience;
import com.recruitmentSystem.entity.Resume;

/**
 * Servlet implementation class ResumeDetailServlet
 */
public class ResumeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResumeDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	/**
	 * @param request
	 * @param response
	 */
	private void doAll(HttpServletRequest request, HttpServletResponse response) {
		int uid=Integer.parseInt(request.getParameter("uid"));
		UserBiz  biz= new UserBiz ();
		try {
			int rid=biz.selectRidByUid(uid);
			//根据rid查询基本信息
			Resume resume=biz.selectUserInfo(rid);
			//根据rid查询工作经验
			List<Experience>  list=biz.selectUserExperience(rid);
			//转发
			request.setAttribute("resume", resume);
			request.setAttribute("explist", list);
			request.getRequestDispatcher("/pages/userdetail.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
