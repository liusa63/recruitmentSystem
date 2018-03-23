package com.recruitmentSystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.AdminBiz;
import com.recruitmentSystem.entity.Feedback;

/**
 * Servlet implementation class FeedbackDetailServlet
 */
public class FeedbackDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackDetailServlet() {
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
		//查看详情
				String fid=request.getParameter("fid");
				//业务逻辑---根据fid查看反馈信息
				AdminBiz biz=new AdminBiz();
				try {
					Feedback feedback=biz.selectFeedbackByFid(Integer.parseInt(fid));
					request.setAttribute("feedback", feedback);
					request.getRequestDispatcher("/adminpages/feedbackdetail.jsp").forward(request, response);
				}catch (Exception e) {
					e.printStackTrace();
				}
		
	}

}
