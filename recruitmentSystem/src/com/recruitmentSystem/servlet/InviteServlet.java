package com.recruitmentSystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.UserBiz;

/**
 * Servlet implementation class InviteServlet
 */
public class InviteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InviteServlet() {
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
		// TODO Auto-generated method stub
		int uid= Integer.parseInt(request.getParameter("uid"));
		int pid= Integer.parseInt(request.getParameter("pid"));
		int rid= Integer.parseInt(request.getParameter("rid"));
		int dstatus= Integer.parseInt(request.getParameter("dstatus"));
		UserBiz biz= new UserBiz();
		//写入数据库的delivery表中
		try {
			biz.addDelivery(pid,rid,dstatus);
			//跳转到用户列表
			request.setAttribute("uid", uid);
			request.getRequestDispatcher("UserListServlet").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
