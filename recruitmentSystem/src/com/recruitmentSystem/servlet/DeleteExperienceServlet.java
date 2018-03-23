package com.recruitmentSystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.UserBiz;

/**
 * Servlet implementation class DeleteExperienceServlet
 */
public class DeleteExperienceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteExperienceServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	private void doAll(HttpServletRequest request, HttpServletResponse response) {
		int uid=Integer.parseInt( request.getParameter("uid"));
		int eid=Integer.parseInt(request.getParameter("eid"));
	    //删除指定的经验
	    UserBiz biz= new UserBiz();
	    try {
			biz.deleteExperience(eid);
			//跳转回MyExperienceServlet
			request.setAttribute("uid", uid);
			request.getRequestDispatcher("MyExperienceServlet").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	   
	}

}
