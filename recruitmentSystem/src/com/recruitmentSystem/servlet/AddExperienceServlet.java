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
		//根据uid判断是否可以添加工作经验
		int uid=Integer.parseInt(request.getParameter("uid"));
		UserBiz biz= new UserBiz();
		try {
			int rid=biz.selectRidByUid(uid);
			List<Experience> list=biz.selectUserExperience(rid);
			//先判断工作经验是否小于三条
			if(list.size()<3){
				//允许添加，跳转到添加页面
				request.getRequestDispatcher("/pages/addexperience.jsp").forward(request, response);
			}else{
				//给出提示：最多添加3条工作经验
				request.setAttribute("uid", uid);
				request.setAttribute("msg", "最多添加三条工作经验，请删除后再添加");
				request.getRequestDispatcher("MyExperienceServlet").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
