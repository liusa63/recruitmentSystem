package com.recruitmentSystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.recruitmentSystem.biz.CompanyBiz;
import com.recruitmentSystem.entity.Relation;

/**
 * Servlet implementation class ChoosePostListServlet
 */
public class ChoosePostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChoosePostListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	private void doAll(HttpServletRequest request, HttpServletResponse response) {
		//��ѯ�����̼���Ϣ
		int uid=Integer.parseInt(request.getParameter("uid"));
		int rid=Integer.parseInt(request.getParameter("rid"));
		//����uid��ѯ��cid,��ͨ��cid��ѯ�����ĸ�λ��Ϣ
		CompanyBiz biz=new CompanyBiz();
		try {
			//��λ����
			List<Relation>  list=biz.selectCompostByUid(uid);
			
			if(list != null && list.size()>0){//���ظ�ҳ��
			request.setAttribute("rid", rid);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/pages/invitepost.jsp").forward(request, response);
			}else{//�ж���û��д��˾��Ϣ
				int cid=biz.selectCidByUid(uid);
				if(cid==0){//û����д��˾��Ϣ
					request.setAttribute("msg", "����û��д��˾��Ϣ���������ƹ�˾��Ϣ������Ӹ�λ��");
					request.getRequestDispatcher("/pages/addcompanyinfo.jsp").forward(request, response);
					
				}else{
					request.setAttribute("msg", "����û��������Ƹ��Ϣ��������Ӹ�λ��");
					request.getRequestDispatcher("/pages/addpost.jsp").forward(request, response);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
