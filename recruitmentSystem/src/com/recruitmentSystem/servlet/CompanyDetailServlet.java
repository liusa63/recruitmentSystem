package com.recruitmentSystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.CompanyBiz;
import com.recruitmentSystem.entity.Company;
import com.recruitmentSystem.entity.Relation;

/**
 * Servlet implementation class CompanyDetailServlet
 */
public class CompanyDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyDetailServlet() {
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
		// ����pid��ȡְλ��Ϣ
		//  ����cid��ȡ��˾��Ϣ
		int pid=Integer.parseInt(request.getParameter("pid"));
		int cid=Integer.parseInt(request.getParameter("cid"));
		CompanyBiz biz = new CompanyBiz();
		try {
			Relation rel=biz.selectPostInfoByPid(pid);
			Company  com=biz.selectCompanyInfoByCid(cid);
			//ת��ְλ����
			request.setAttribute("postdetail", rel);
			//ת����˾��Ϣ
			request.setAttribute("com", com);
			request.getRequestDispatcher("/pages/postdetail.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
