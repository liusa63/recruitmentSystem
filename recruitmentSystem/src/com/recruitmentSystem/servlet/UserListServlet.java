package com.recruitmentSystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.CompanyBiz;
import com.recruitmentSystem.biz.ResumeBiz;
import com.recruitmentSystem.biz.UserBiz;
import com.recruitmentSystem.entity.RelationVo;
import com.recruitmentSystem.entity.ResumeVo;
import com.recruitmentSystem.util.PageList;

public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	private void doAll(HttpServletRequest request, HttpServletResponse response) {
		//分页查询所有的用户信息：简历，求职意向
		int currentPage=1;
		if(request.getParameter("currentPage")!=null){
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		//设置当前页
		PageList<ResumeVo> page=new PageList<ResumeVo>();
		page.setCurrentPage(currentPage);
		//调用业务处理
		int uid=Integer.parseInt(request.getParameter("uid"));
		ResumeBiz biz=new ResumeBiz();
		try {
		   page=biz.pageListResume(page,5,uid);
		   //返回给JSP
			request.setAttribute("userPage", page);
				//查询我投递过简历或给我发送邀请的公司信息
				UserBiz ubiz=new UserBiz();
				int rid=ubiz.selectRidByUid(uid);
				CompanyBiz combiz =new CompanyBiz();
				List<RelationVo> list=combiz.selectComAboutMe(rid);
			    if(list != null && list.size()>0){
				   request.setAttribute("mylist", list);
			   }else{
				   request.setAttribute("msg", "您还没有向任何公司投递过简历，快去行动吧！");
			   }
				
			//跳转
			request.getRequestDispatcher("/pages/user1.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
