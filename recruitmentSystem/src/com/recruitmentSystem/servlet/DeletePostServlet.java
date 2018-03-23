package com.recruitmentSystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.CompanyBiz;

/**
 * Servlet implementation class DeletePostServlet
 */
public class DeletePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	
	private void doAll(HttpServletRequest request, HttpServletResponse response) {
		//根据pid删除指定岗位信息
		int pid=Integer.parseInt(request.getParameter("pid"));
		CompanyBiz biz = new CompanyBiz();
		try {
			biz.delPostByPid(pid);
			int uid=Integer.parseInt(request.getParameter("uid"));
			request.setAttribute("uid", uid);
			request.getRequestDispatcher("/MyPostListServlet").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
