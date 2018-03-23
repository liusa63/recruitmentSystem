package com.recruitmentSystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.AdminBiz;

/**
 * Servlet implementation class DeleteFeedbackServlet
 */
public class DeleteFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFeedbackServlet() {
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
		//根据fid删除反馈信息
				String fid=request.getParameter("fid");
				//业务逻辑，删除反馈信息
				AdminBiz biz=new AdminBiz();
				try {
					biz.delFeedbackByRid(Integer.parseInt(fid));
					request.getRequestDispatcher("/FeedbackServlet").forward(request, response);
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

}
