package com.recruitmentSystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.CompanyBiz;

/**
 * Servlet implementation class AddCompanyServlet
 */
public class AddCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCompanyServlet() {
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
		//获取用户输入的企业信息---用户主键，企业名称，企业地址，企业介绍，企业电话
				String uid=request.getParameter("uid");
				String cname=request.getParameter("cname");
				String caddress=request.getParameter("caddress");
				String cintroduce=request.getParameter("cintroduce");
				String cphone=request.getParameter("cphone");
				
				//业务逻辑---添加企业的信息
				CompanyBiz service=new CompanyBiz();
				try {
					service.addCompany( Integer.parseInt(uid), cname, caddress, cintroduce, cphone);
				    //跳转到企业信息列表中
					request.getRequestDispatcher("/MyCompanyInfoServlet?uid="+uid).forward(request, response);
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

}
