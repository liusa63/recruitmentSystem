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
		//�����û�Id��ѯ��ҵ��Ϣ
    	int uid=Integer.parseInt(request.getParameter("uid"));
    	CompanyBiz  biz = new CompanyBiz();
    	try {
			Company com=biz.selectCompanyInfoByUid(uid);
				//�������Ϣ����ʾ��ҳ��input�У��ɹ��޸�
			if(com != null){
				//���û����Ϣ��Ϊ�գ��û����
			     request.setAttribute("com", com);
			     request.getRequestDispatcher("/pages/updatecompanyinfo.jsp").forward(request, response);
				
			}else{
		    	//���û����Ϣ��Ϊ�գ��û����
			     request.setAttribute("uid", uid);
			     request.getRequestDispatcher("MyCompanyInfoServlet").forward(request, response);
			}
			} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    	
    	
	}


}
