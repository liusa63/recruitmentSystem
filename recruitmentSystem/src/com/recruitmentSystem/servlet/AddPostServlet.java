package com.recruitmentSystem.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.CompanyBiz;

/**
 * Servlet implementation class AddPostServlet
 */
public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPostServlet() {
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
		int uid = Integer.parseInt(request.getParameter("uid"));
		//根据uid查询到cid再添加岗位信息
		CompanyBiz  biz = new CompanyBiz();
		try {
			int cid = biz.selectCidByUid(uid);
			String  rpost=request.getParameter("rpost");
			String rask=request.getParameter("rask");
			double rsalary=Double.parseDouble(request.getParameter("rsalary"));
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String time=df.format(new Date());// new Date()为获取当前系统时间
			
			
			//添加
			 biz.addPost(cid,rpost,rask,rsalary,time);
			 //跳转：MyPostListServlet
			 request.setAttribute("uid", uid);
			 request.getRequestDispatcher("/MyPostListServlet").forward(request, response);
			 
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
