package com.recruitmentSystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.UserBiz;
import com.recruitmentSystem.entity.Experience;

public class AddExperienceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddExperienceServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	private void doAll(HttpServletRequest request, HttpServletResponse response) {
		//����uid�ж��Ƿ������ӹ�������
		int uid=Integer.parseInt(request.getParameter("uid"));
		UserBiz biz= new UserBiz();
		try {
			int rid=biz.selectRidByUid(uid);
			List<Experience> list=biz.selectUserExperience(rid);
			//���жϹ��������Ƿ�С������
			if(list.size()<3){
				//������ӣ���ת�����ҳ��
				request.getRequestDispatcher("/pages/addexperience.jsp").forward(request, response);
			}else{
				//������ʾ��������3����������
				request.setAttribute("uid", uid);
				request.setAttribute("msg", "�����������������飬��ɾ���������");
				request.getRequestDispatcher("MyExperienceServlet").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
