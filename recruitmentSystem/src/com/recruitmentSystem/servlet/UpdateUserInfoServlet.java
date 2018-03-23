package com.recruitmentSystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.UserBiz;
import com.recruitmentSystem.entity.Resume;

/**
 * Servlet implementation class UpdateUserInfoServlet
 */
public class UpdateUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserInfoServlet() {
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

	private void doAll(HttpServletRequest request, HttpServletResponse response) {
		//根据uid获取我的基本信息，进行修改
		int uid=Integer.parseInt(request.getParameter("uid"));
		UserBiz biz=new UserBiz();
		try {
			int rid=biz.selectRidByUid(uid);
			Resume resume=biz.selectUserInfo(rid);
			if(resume!=null){//填写过简历：直接进行修改
				request.setAttribute("resume", resume);
				request.getRequestDispatcher("/pages/updateuserinfo.jsp").forward(request, response);
			}else{//内有填写过简历：跳转到填写简历页面并给出提示
				request.setAttribute("msg", "请先完成基本信息");
				request.getRequestDispatcher("/pages/addmyresume.jsp").forward(request, response);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
		
	}

}
