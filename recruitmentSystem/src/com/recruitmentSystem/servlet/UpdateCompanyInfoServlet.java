package com.recruitmentSystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.CompanyBiz;
import com.recruitmentSystem.entity.Company;

public class UpdateCompanyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateCompanyInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}
	
    private void doAll(HttpServletRequest request, HttpServletResponse response) {
		//根据用户Id查询企业信息
    	int uid=Integer.parseInt(request.getParameter("uid"));
    	CompanyBiz  biz = new CompanyBiz();
    	try {
			Company com=biz.selectCompanyInfoByUid(uid);
				//如果有信息则显示在页面input中，可供修改
			if(com != null){
				//如果没有信息则为空，用户添加
			     request.setAttribute("com", com);
			     request.getRequestDispatcher("/pages/updatecompanyinfo.jsp").forward(request, response);
				
			}else{
		    	//如果没有信息则为空，用户添加
			     request.setAttribute("uid", uid);
			     request.getRequestDispatcher("MyCompanyInfoServlet").forward(request, response);
			}
			} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    	
    	
	}


}
