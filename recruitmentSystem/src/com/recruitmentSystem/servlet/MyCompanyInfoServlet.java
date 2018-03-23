package com.recruitmentSystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.CompanyBiz;
import com.recruitmentSystem.entity.Company;


public class MyCompanyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyCompanyInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}
	private void doAll(HttpServletRequest request, HttpServletResponse response) {
		//�����û�ID��ѯ��˾����Ϣ
		int uid=Integer.parseInt(request.getParameter("uid"));
		CompanyBiz biz= new CompanyBiz();
		try {
			Company com=  biz.selectCompanyInfoByUid(uid);
			if(com != null){
				//չ����companyinfo.jspҳ��
				request.setAttribute("com", com);
				request.getRequestDispatcher("/pages/companyinfo.jsp").forward(request, response);
			}else{
				//������ʾ
				request.setAttribute("msg", "����û����д��˾��Ϣ��������ɸ�ҳ��");
				request.getRequestDispatcher("/pages/addcompanyinfo.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
