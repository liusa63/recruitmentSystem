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
		//��ҳ��ѯ���е��û���Ϣ����������ְ����
		int currentPage=1;
		if(request.getParameter("currentPage")!=null){
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		//���õ�ǰҳ
		PageList<ResumeVo> page=new PageList<ResumeVo>();
		page.setCurrentPage(currentPage);
		//����ҵ����
		int uid=Integer.parseInt(request.getParameter("uid"));
		ResumeBiz biz=new ResumeBiz();
		try {
		   page=biz.pageListResume(page,5,uid);
		   //���ظ�JSP
			request.setAttribute("userPage", page);
				//��ѯ��Ͷ�ݹ���������ҷ�������Ĺ�˾��Ϣ
				UserBiz ubiz=new UserBiz();
				int rid=ubiz.selectRidByUid(uid);
				CompanyBiz combiz =new CompanyBiz();
				List<RelationVo> list=combiz.selectComAboutMe(rid);
			    if(list != null && list.size()>0){
				   request.setAttribute("mylist", list);
			   }else{
				   request.setAttribute("msg", "����û�����κι�˾Ͷ�ݹ���������ȥ�ж��ɣ�");
			   }
				
			//��ת
			request.getRequestDispatcher("/pages/user1.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
