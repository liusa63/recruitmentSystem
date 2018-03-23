package com.recruitmentSystem.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.recruitmentSystem.biz.CompanyBiz;
import com.recruitmentSystem.entity.RelationVo;


public class SearchPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchPostServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	private void doAll(HttpServletRequest request, HttpServletResponse response) {
		// uid 
		int uid=Integer.parseInt(request.getParameter("uid"));
		String searchtype=request.getParameter("searchtype");
		String search=request.getParameter("rpost");
	
			//按要求搜索
			List<RelationVo> list= new ArrayList<RelationVo>();
			CompanyBiz biz= new CompanyBiz();
			try {
				list=biz.selectAboutType(uid, searchtype,search);
				
				if(list!=null && list.size()>0){
					request.setAttribute("searchlist", list);
					request.getRequestDispatcher("/pages/searchpostlist.jsp").forward(request, response);
				}else{
				request.setAttribute("msg", "暂时没有相关信息");
				request.getRequestDispatcher("/pages/searchpostlist.jsp").forward(request, response);
				
				}
				/*PrintWriter out=response.getWriter();
				//返回给页面
				JsonConfig config = new JsonConfig(); 
		        config.registerJsonValueProcessor(Date.class, new JSONArrayTestForDate());  
				JSONArray jsonArray = JSONArray.fromObject(list,config);
				out.print(jsonArray.toString());*/
			} catch (Exception e) {
				e.printStackTrace();
			}
	
	}
}
