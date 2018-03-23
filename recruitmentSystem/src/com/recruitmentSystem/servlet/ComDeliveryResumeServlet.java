package com.recruitmentSystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.UserBiz;

/**
 * Servlet implementation class ComDeliveryResumeServlet
 */
public class ComDeliveryResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComDeliveryResumeServlet() {
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
		//Ͷ�ݼ���
		int uid= Integer.parseInt(request.getParameter("uid"));
		UserBiz biz= new UserBiz();
		try {
			//����uid��ѯ��rid
			int rid=biz.selectRidByUid(uid);
			if(rid!=0){
				int pid= Integer.parseInt(request.getParameter("pid"));
				int dstatus= Integer.parseInt(request.getParameter("dstatus"));
				//д�����ݿ��delivery����
				biz.addDelivery(pid,rid,dstatus);
				//��ת����ҳ
				request.setAttribute("uid", uid);
				request.getRequestDispatcher("CompanyListServlet").forward(request, response);
			}else{
				request.setAttribute("uid", uid);
				request.getRequestDispatcher("MyResumeServlet").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
