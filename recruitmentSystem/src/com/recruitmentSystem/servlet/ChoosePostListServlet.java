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
		//查询所有商家信息
		int uid=Integer.parseInt(request.getParameter("uid"));
		int rid=Integer.parseInt(request.getParameter("rid"));
		//根据uid查询到cid,再通过cid查询发布的岗位信息
		CompanyBiz biz=new CompanyBiz();
		try {
			//岗位集合
			List<Relation>  list=biz.selectCompostByUid(uid);
			
			if(list != null && list.size()>0){//返回给页面
			request.setAttribute("rid", rid);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/pages/invitepost.jsp").forward(request, response);
			}else{//判断有没填写公司信息
				int cid=biz.selectCidByUid(uid);
				if(cid==0){//没有填写公司信息
					request.setAttribute("msg", "您还没填写公司信息，请先完善公司信息后再添加岗位。");
					request.getRequestDispatcher("/pages/addcompanyinfo.jsp").forward(request, response);
					
				}else{
					request.setAttribute("msg", "您还没发布过招聘信息，请先添加岗位。");
					request.getRequestDispatcher("/pages/addpost.jsp").forward(request, response);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
