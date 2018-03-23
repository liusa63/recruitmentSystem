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
		//首页要展示的内容:企业的招聘信息，最新发布和高薪职位
		CompanyBiz biz =new CompanyBiz();
		String uid = request.getParameter("uid");
		try {
			List<RelationVo> list1 = biz.selectCompanyBySalary(Integer.parseInt(uid));
			List<RelationVo> list2 = biz.selectCompanyByTime(Integer.parseInt(uid));
			List<News> list3=biz.selectNews();
			//根据薪水排序
			request.setAttribute("salarylist", list1);
			//根据发布时间排序
			request.setAttribute("timelist", list2);
			//新闻版块
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
				//根据薪水排序
				request.setAttribute("salarylist", list1);
				//根据发布时间排序
				request.setAttribute("timelist", list2);
				//企业ID-->名称
				request.setAttribute("comlist", list);
				  //根据uid判断是否投递过简历，改变相关状态
					int uid = Integer.parseInt(request.getParameter("uid"));
					UserBiz ubiz= new UserBiz();
					int rid=ubiz.selectRidByUid(uid);
					if(rid!=0){
						//根据rid查询delivery
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
