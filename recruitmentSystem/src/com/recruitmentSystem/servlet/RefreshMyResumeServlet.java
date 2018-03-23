package com.recruitmentSystem.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.UserBiz;

/**
 * Servlet implementation class RefreshMyResumeServlet
 */
public class RefreshMyResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefreshMyResumeServlet() {
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
		 int uid = Integer.parseInt(request.getParameter("uid"));
		 UserBiz biz= new UserBiz();
		 try {
			int rid=biz.selectRidByUid(uid);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String time=df.format(new Date());// new Date()为获取当前系统时间
			biz.refreshResume(rid, time);
			request.getRequestDispatcher("UserListServlet").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
