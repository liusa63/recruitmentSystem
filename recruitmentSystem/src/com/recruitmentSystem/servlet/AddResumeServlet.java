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
		//��ȡ�û���ӵĸ����û���Ϣ ----�����������û���������������Ƭ�����䣬�Ա𣬵绰�����䣬ѧ��
		String saveDirectory ="E:/images/static";
		int maxPostSize =1 * 5 * 1024 * 1024 ;
		try {
			//response�ı���Ϊ"utf-8",ͬʱ����ȱʡ���ļ�����ͻ�������,ʵ���ϴ�
			MultipartRequest multi =new MultipartRequest(request, saveDirectory, maxPostSize,"utf-8");
			//���������Ϣ
			Enumeration files = multi.getFileNames();
			String fileName="";
			while (files.hasMoreElements()) {
				String name = (String)files.nextElement();
				File f = multi.getFile(name);
				if(f!=null){
					fileName = multi.getFilesystemName(name);
				}
			}
		//��ȡҳ��������Ϣ
		int uid=Integer.parseInt(multi.getParameter("uid"));
		String rname=multi.getParameter("relname");
		String rage=multi.getParameter("rage");
		String rsex=multi.getParameter("rsex");
		String rphone=multi.getParameter("rphone");
		String remail=multi.getParameter("remail");
		String reducation=multi.getParameter("reducation");
		String rwant=multi.getParameter("rwant");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		String time=df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
		//ҵ���߼�---��Ӹ��˼���
		ResumeBiz service=new ResumeBiz();
	    service.addResume(uid, rname, fileName, rage, rsex, rphone, remail, reducation,rwant,time);
	    //��ת�����˼����б���
		request.getRequestDispatcher("/MyResumeServlet").forward(request, response);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
