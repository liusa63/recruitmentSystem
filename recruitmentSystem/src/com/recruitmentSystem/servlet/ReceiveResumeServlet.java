package com.recruitmentSystem.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.recruitmentSystem.biz.CompanyBiz;
import com.recruitmentSystem.biz.UserBiz;
import com.recruitmentSystem.entity.Resume;

/**
 * Servlet implementation class ReceiveResumeServlet
 */
public class ReceiveResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiveResumeServlet() {
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
		// 根据pid和uid查询收到的rid
		int pid= Integer.parseInt(request.getParameter("pid"));
		CompanyBiz biz= new CompanyBiz();
		
		try {
			List<Integer> list=biz.selectAllRidByUid(pid);
			if(list != null && list.size()>0){
				List<Resume> rl= new ArrayList<Resume>();
				for(int rid:list){//根据rid获取简历信息列表
					UserBiz ubiz= new UserBiz();
					//rid的基本信息
					Resume resume= ubiz.selectUserInfo(rid);
					rl.add(resume);
				}
				request.setAttribute("rl",rl);
			    request.getRequestDispatcher("/pages/receivedresume.jsp").forward(request, response);
			}else{
				request.setAttribute("msg","该岗位还没有收到相关简历");
			    request.getRequestDispatcher("/pages/receivedresume.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
