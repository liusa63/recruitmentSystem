package com.recruitmentSystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.UserBiz;

/**
 * Servlet implementation class SearchDeliveryResumeServlet
 */
public class SearchDeliveryResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchDeliveryResumeServlet() {
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
		//投递简历
		int uid= Integer.parseInt(request.getParameter("uid"));
		UserBiz biz= new UserBiz();
		try {
			//根据uid查询到rid
			int rid=biz.selectRidByUid(uid);
			if(rid!=0){
				int pid= Integer.parseInt(request.getParameter("pid"));
				int dstatus= Integer.parseInt(request.getParameter("dstatus"));
				//写入数据库的delivery表中
				biz.addDelivery(pid,rid,dstatus);
				//跳转到首页
				request.setAttribute("uid", uid);
				request.getRequestDispatcher("UserListServlet").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
