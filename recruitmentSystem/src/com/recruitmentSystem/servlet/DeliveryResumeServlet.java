package com.recruitmentSystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.UserBiz;

/**
 * Servlet implementation class DeliveryResumeServlet
 */
public class DeliveryResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeliveryResumeServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

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
				request.getRequestDispatcher("LoginSuccessServlet").forward(request, response);
			}else{//用户没有填写简历
				request.setAttribute("uid", uid);
				request.getRequestDispatcher("MyResumeServlet").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
