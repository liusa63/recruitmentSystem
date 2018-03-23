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
 * Servlet implementation class MyResumeServlet
 */
public class MyResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyResumeServlet() {
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
		//根据uid从数据库查询简历信息
		int uid=Integer.parseInt(request.getParameter("uid"));
		UserBiz  biz= new UserBiz ();
		try {
			int rid=biz.selectRidByUid(uid);
			if(rid!=0){//如果存在该用户的简历，则展示在页面:userinfo.jsp(包括工作经验)
				//根据rid查询基本信息
				Resume resume=biz.selectUserInfo(rid);
				//根据rid查询工作经验
				List<Experience>  list=biz.selectUserExperience(rid);
				//转发
				request.setAttribute("resume", resume);
				request.setAttribute("explist", list);
				request.getRequestDispatcher("/pages/userinfo.jsp").forward(request, response);
			}else{//如果没有，则提示用户先完善信息
				request.setAttribute("msg", "您还没有填写过简历，请先完善基本信息");
				 //跳转到添加简历的页面
				request.getRequestDispatcher("/pages/addmyresume.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
