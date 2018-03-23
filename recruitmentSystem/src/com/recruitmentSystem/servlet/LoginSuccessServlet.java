package com.recruitmentSystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.CompanyBiz;
import com.recruitmentSystem.entity.News;
import com.recruitmentSystem.entity.RelationVo;

public class LoginSuccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginSuccessServlet() {
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
		//��ҳҪչʾ������:��ҵ����Ƹ��Ϣ�����·����͸�нְλ
		CompanyBiz biz =new CompanyBiz();
		String uid = request.getParameter("uid");
		try {
			List<RelationVo> list1 = biz.selectCompanyBySalary(Integer.parseInt(uid));
			List<RelationVo> list2 = biz.selectCompanyByTime(Integer.parseInt(uid));
			List<News> list3=biz.selectNews();
			//����нˮ����
			request.setAttribute("salarylist", list1);
			//���ݷ���ʱ������
			request.setAttribute("timelist", list2);
			//���Ű��
			request.setAttribute("newslist", list3);
			//request.getRequestDispatcher("/pages/home.jsp").forward(request, response);
			request.getRequestDispatcher("/pages/Home1.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}

		/* List<Relation> list1 =null;
		    List<Relation> list2 =null;
		   CompanyBiz biz =new CompanyBiz();
		   try {
			list1=biz.selectCompanyBySalary();
			list2=biz.selectCompanyByTime();
			List<Company> list=biz.selectComList();
			if(list1 != null || list2 != null){
				//����нˮ����
				request.setAttribute("salarylist", list1);
				//���ݷ���ʱ������
				request.setAttribute("timelist", list2);
				//��ҵID-->����
				request.setAttribute("comlist", list);
				  //����uid�ж��Ƿ�Ͷ�ݹ��������ı����״̬
					int uid = Integer.parseInt(request.getParameter("uid"));
					UserBiz ubiz= new UserBiz();
					int rid=ubiz.selectRidByUid(uid);
					if(rid!=0){
						//����rid��ѯdelivery
						List<Delivery> dlist=ubiz.findDelivery(rid);
						request.setAttribute("dlist", dlist);
					}
				request.getRequestDispatcher("/pages/home.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}*/



	}

}
