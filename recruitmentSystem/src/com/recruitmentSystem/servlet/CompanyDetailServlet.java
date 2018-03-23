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
		// 根据pid获取职位信息
		//  根据cid获取公司信息
		int pid=Integer.parseInt(request.getParameter("pid"));
		int cid=Integer.parseInt(request.getParameter("cid"));
		CompanyBiz biz = new CompanyBiz();
		try {
			Relation rel=biz.selectPostInfoByPid(pid);
			Company  com=biz.selectCompanyInfoByCid(cid);
			//转发职位详情
			request.setAttribute("postdetail", rel);
			//转发公司信息
			request.setAttribute("com", com);
			request.getRequestDispatcher("/pages/postdetail.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
