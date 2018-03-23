package com.recruitmentSystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.UserBiz;
import com.recruitmentSystem.entity.Experience;
import com.recruitmentSystem.entity.Resume;

/**
 * Servlet implementation class MyResumeServlet
 */
public class MyResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyResumeServlet() {
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
		//����uid�����ݿ��ѯ������Ϣ
		int uid=Integer.parseInt(request.getParameter("uid"));
		UserBiz  biz= new UserBiz ();
		try {
			int rid=biz.selectRidByUid(uid);
			if(rid!=0){//������ڸ��û��ļ�������չʾ��ҳ��:userinfo.jsp(������������)
				//����rid��ѯ������Ϣ
				Resume resume=biz.selectUserInfo(rid);
				//����rid��ѯ��������
				List<Experience>  list=biz.selectUserExperience(rid);
				//ת��
				request.setAttribute("resume", resume);
				request.setAttribute("explist", list);
				request.getRequestDispatcher("/pages/userinfo.jsp").forward(request, response);
			}else{//���û�У�����ʾ�û���������Ϣ
				request.setAttribute("msg", "����û����д���������������ƻ�����Ϣ");
				 //��ת����Ӽ�����ҳ��
				request.getRequestDispatcher("/pages/addmyresume.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
