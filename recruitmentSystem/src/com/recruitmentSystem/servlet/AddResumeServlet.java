package com.recruitmentSystem.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.recruitmentSystem.biz.ResumeBiz;

import org.apache.commons.io.FileUtils;
/**
 * Servlet implementation class AddResumeServlet
 */
public class AddResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AddResumeServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		//获取用户添加的个人用户信息 ----简历主键，用户主键，姓名，照片，年龄，性别，电话，邮箱，学历
		String saveDirectory ="E:/images/static";
		int maxPostSize =1 * 5 * 1024 * 1024 ;
		try {
			//response的编码为"utf-8",同时采用缺省的文件名冲突解决策略,实现上传
			MultipartRequest multi =new MultipartRequest(request, saveDirectory, maxPostSize,"utf-8");
			//输出反馈信息
			Enumeration files = multi.getFileNames();
			String fileName="";
			while (files.hasMoreElements()) {
				String name = (String)files.nextElement();
				File f = multi.getFile(name);
				if(f!=null){
					fileName = multi.getFilesystemName(name);
				}
			}
		//获取页面其他信息
		int uid=Integer.parseInt(multi.getParameter("uid"));
		String rname=multi.getParameter("relname");
		String rage=multi.getParameter("rage");
		String rsex=multi.getParameter("rsex");
		String rphone=multi.getParameter("rphone");
		String remail=multi.getParameter("remail");
		String reducation=multi.getParameter("reducation");
		String rwant=multi.getParameter("rwant");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String time=df.format(new Date());// new Date()为获取当前系统时间
		//业务逻辑---添加个人简历
		ResumeBiz service=new ResumeBiz();
	    service.addResume(uid, rname, fileName, rage, rsex, rphone, remail, reducation,rwant,time);
	    //跳转到个人简历列表中
		request.getRequestDispatcher("/MyResumeServlet").forward(request, response);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
