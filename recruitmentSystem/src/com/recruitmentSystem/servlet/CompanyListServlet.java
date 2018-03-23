package com.recruitmentSystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.CompanyBiz;
import com.recruitmentSystem.entity.RelationVo;
import com.recruitmentSystem.util.PageList;

public class CompanyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public CompanyListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	/**
	 * @param request
	 * @param response
	 */
	private void doAll(HttpServletRequest request, HttpServletResponse response) {
		//分页查询所有的用户信息：简历，求职意向
		int currentPage=1;
		if(request.getParameter("currentPage")!=null){
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		//设置当前页
		PageList<RelationVo> page=new PageList<RelationVo>();
		page.setCurrentPage(currentPage);
		//调用业务处理
		int uid = Integer.parseInt(request.getParameter("uid"));
		CompanyBiz biz=new CompanyBiz();
		try {
		   page=biz.pageListRelation(page,5,uid);
		   //返回给JSP
			request.setAttribute("companyPage", page);
			//跳转
			request.getRequestDispatcher("/pages/company1.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
