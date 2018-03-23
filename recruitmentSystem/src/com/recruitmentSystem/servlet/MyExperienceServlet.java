package com.recruitmentSystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.UserBiz;
import com.recruitmentSystem.entity.Experience;

public class MyExperienceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MyExperienceServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}


	private void doAll(HttpServletRequest request, HttpServletResponse response) {
		//����uid�������ҵĹ�������
		int uid=Integer.parseInt(request.getParameter("uid"));
		UserBiz biz= new UserBiz();
		try {
			int rid=biz.selectRidByUid(uid);
			//�жϸ��û��Ƿ����������Ϣ
			if(rid!=0){
				//����rid��������������
				List<Experience> list=biz.selectUserExperience(rid);
				if(list!=null && list.size()>0){
					//չʾ��ҳ����
					String msg=(String)request.getAttribute("msg");
					request.setAttribute("msg", msg);
					request.setAttribute("myexplist", list);
					request.getRequestDispatcher("/pages/myexperience.jsp").forward(request, response);
				}else{
					//����ӹ�������
					request.setAttribute("msg", "����û�������ع������飬������ɸ�ҳ��");
					request.getRequestDispatcher("/pages/addexperience.jsp").forward(request, response);
				}
			}else{
				//û�����������Ϣ
				//��ת����д������Ϣ��ҳ�棬��������Ӧ����ʾ
				request.setAttribute("msg", "������ɸ�����Ϣ����ӹ�������");
				request.getRequestDispatcher("/pages/addmyresume.jsp").forward(request, response);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//���ظ�ҳ�棬����ҳ���ṩ��Ӧ�Ĳ���
		
		
	}

}
