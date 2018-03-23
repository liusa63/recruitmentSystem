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
		//����uid��ѯ��cid����Ӹ�λ��Ϣ
		CompanyBiz  biz = new CompanyBiz();
		try {
			int cid = biz.selectCidByUid(uid);
			String  rpost=request.getParameter("rpost");
			String rask=request.getParameter("rask");
			double rsalary=Double.parseDouble(request.getParameter("rsalary"));
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
			String time=df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
			
			
			//���
			 biz.addPost(cid,rpost,rask,rsalary,time);
			 //��ת��MyPostListServlet
			 request.setAttribute("uid", uid);
			 request.getRequestDispatcher("/MyPostListServlet").forward(request, response);
			 
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
