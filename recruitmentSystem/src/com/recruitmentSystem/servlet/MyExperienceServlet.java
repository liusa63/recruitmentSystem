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
		//根据uid遍历出我的工作经验
		int uid=Integer.parseInt(request.getParameter("uid"));
		UserBiz biz= new UserBiz();
		try {
			int rid=biz.selectRidByUid(uid);
			//判断该用户是否填过基本信息
			if(rid!=0){
				//根据rid遍历出工作经验
				List<Experience> list=biz.selectUserExperience(rid);
				if(list!=null && list.size()>0){
					//展示在页面上
					String msg=(String)request.getAttribute("msg");
					request.setAttribute("msg", msg);
					request.setAttribute("myexplist", list);
					request.getRequestDispatcher("/pages/myexperience.jsp").forward(request, response);
				}else{
					//先添加工作经验
					request.setAttribute("msg", "您还没有添加相关工作经验，请先完成该页面");
					request.getRequestDispatcher("/pages/addexperience.jsp").forward(request, response);
				}
			}else{
				//没有填过基本信息
				//跳转到填写基本信息的页面，并给出相应的提示
				request.setAttribute("msg", "请先完成个人信息再添加工作简历");
				request.getRequestDispatcher("/pages/addmyresume.jsp").forward(request, response);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回给页面，并在页面提供相应的操作
		
		
	}

}
