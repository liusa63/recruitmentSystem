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
 * Servlet implementation class MyPostListServlet
 */
public class MyPostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPostListServlet() {
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

	
	private void doAll(HttpServletRequest request, HttpServletResponse response) {
		//����UID��ѯ��ҵ�����ĸ�λ��Ϣ
		int uid=Integer.parseInt(request.getParameter("uid"));
		//����uid��ѯ��cid,��ͨ��cid��ѯ�����ĸ�λ��Ϣ
		CompanyBiz biz=new CompanyBiz();
		
		try {
			List<Relation>  list=biz.selectCompostByUid(uid);
			if(list!=null && list.size()>0){
				request.setAttribute("postlist", list);
				request.getRequestDispatcher("/pages/mypost.jsp").forward(request, response);
				
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
