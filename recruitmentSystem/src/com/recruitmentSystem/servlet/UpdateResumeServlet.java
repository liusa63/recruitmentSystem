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
import com.recruitmentSystem.biz.UserBiz;

/**
 * Servlet implementation class UpdateResumeServlet
 */
public class UpdateResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateResumeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAll(request,response);
	}

	private void doAll(HttpServletRequest request, HttpServletResponse response) {
		//����rid���¼���������Ϣ
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
		int rid=Integer.parseInt(multi.getParameter("rid"));
		String rname=multi.getParameter("relname");
		String rage=multi.getParameter("rage");
		String rsex=multi.getParameter("rsex");
		String rphone=multi.getParameter("rphone");
		String remail=multi.getParameter("remail");
		String reducation=multi.getParameter("reducation");
		String rwant=multi.getParameter("rwant");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
		String time=df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
		//ҵ���߼�---���¸��˼����Ļ�����Ϣ
		UserBiz biz= new UserBiz();
	    biz.updateResume(rid, rname, fileName, rage, rsex, rphone, remail, reducation,rwant,time);
	    //��ת�����˼����б���
	    int uid = Integer.parseInt(request.getParameter("uid"));
	    request.setAttribute("uid", uid);
		request.getRequestDispatcher("/MyResumeServlet").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
