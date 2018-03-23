package com.recruitmentSystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.CompanyBiz;

/**
 * Servlet implementation class UpdateCompanySuccessServlet
 */
public class UpdateCompanySuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCompanySuccessServlet() {
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
		   // 根据用户ID更新数据库中的公司信息
		   int uid=Integer.parseInt(request.getParameter("uid"));
		   String cname=request.getParameter("cname");
		   String caddress=request.getParameter("caddress");
		   String cintroduce=request.getParameter("cintroduce");
		   String cphone=request.getParameter("cphone");
		   CompanyBiz biz= new CompanyBiz();
		   try {
			//调用业务逻辑
			biz.updateCompanyInfo(uid,cname,caddress,cintroduce,cphone);
			//更新后跳转到：companyinfo.jsp查看
			request.setAttribute("uid", uid);
			request.getRequestDispatcher("/MyCompanyInfoServlet").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
