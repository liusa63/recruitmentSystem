package com.recruitmentSystem.upload;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;  
import java.io.FileOutputStream;  
import java.io.InputStream;  
import java.util.List;  

import org.apache.commons.fileupload.FileItem;  
import org.apache.commons.fileupload.FileUploadException;  
import org.apache.commons.fileupload.UploadContext;  
import org.apache.commons.fileupload.disk.DiskFileItemFactory;  
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 * Servlet implementation class UploadsServlet
 */
public class UploadsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 private int maxFileSize = 1024 * 1024 * 10;  
	    // �����ļ���·��  
	    private String path = "S:/upload";  
	  
	    private String fileType = "";  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ����ļ�����������  
        request.setCharacterEncoding("UTF-8");  
  
        // ���������ļ������������  
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();  
        // �����������ļ��ϴ��������  
        ServletFileUpload servletFileUpload = new ServletFileUpload( diskFileItemFactory);  
        /* 
         * // �����ļ������ϴ��Ĵ�С servletFileUpload.setFileSizeMax(maxFileSize);// 10M 
         */  
        try {  
            // ����request�����е��ֶκ����������  
            List<FileItem> fileItems = servletFileUpload.parseRequest(request);  
  
            // ������������list����  
            for (FileItem fileItem : fileItems) {  
  
                // �жϽ��������Ƿ�����ͨ���ı��ֶ�  
                if (fileItem.isFormField()) {  
                    // ��ȡ�ֶ�����  
                    String filedName = fileItem.getName();  
                    // ��ȡ�ֶ�����Ӧ��ֵ  
                    String filedValue = fileItem.getString("UTF-8");  
  
                    // ����ı��������  
                    System.out.println(filedName + "=================="   + filedValue);  
                } else {  
                    // �ж���Դ�ļ���С�Ƿ�Ϸ�  
                    if (fileItem.getSize() <= maxFileSize) {  
                        // ��ȡ�ֶ���  
                        String fileName = fileItem.getName();  
                           System.out.println(fileName);
                        // �����ͬ��������ļ�·������  
                        // ie������������������·��C:\Users\chenhongjun\Desktop\tag_1388040641790.txt  
                        // �����ֻ���ļ���  
                        // D:\��Ƶ\day52\¼��12.avi  
  
                        if (!fileName.equals("")) {  
                            // ��ȡ�ϴ��ļ�������  
                            System.out.println(fileItem.getContentType());  
                            // �ж��Ƿ���ָ���������ļ�  
                            if (fileItem.getContentType().equals("image/jpeg")) {  
                                // �ж��Ƿ����"\"  
                                int index = fileName.lastIndexOf("\\");  
                                if (index != -1) {  
                                    fileName = fileName.substring(index + 1);  
                                }  
  
                                // ָ���ļ��洢��·��  
                                File file = new File(path, newFileName(fileName));  
  
                                // ���������  
                                FileOutputStream fos = new FileOutputStream(file);  
  
                                // ��ȡrequest�н�������������  
                                InputStream is = fileItem.getInputStream();  
  
                                // ������������  
                                byte[] buffer = new byte[1024];  
                                int len = 0;  
                                while ((len = (is.read(buffer))) != -1) {  
                                    // ���������ڵ�����д��  
                                    fos.write(buffer, 0, len);  
                                }  
                                fos.flush();  
                                fos.close();  
                                is.close();  
  
                                // ɾ����ʱ�ļ�  
                                fileItem.delete();  
  
                                System.out.println("success");  
                            } else {  
                                System.out.println("���ϴ�ָ�����ļ�����");  
                            }  
  
                        } else {  
                            System.out.println("��ѡ��Ҫ�ϴ����ļ�");  
                        }  
  
                    } else {  
                        System.out.println("�ļ�����,����" + maxFileSize);  
                    }  
                }  
            }  
  
        } catch (FileUploadException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	   // �ļ����Ĵ���  
    public String newFileName(String oldFileName) {  
        // ��ȡ���һ��"."���ֵ�λ���±�  
        int index = oldFileName.lastIndexOf(".");  
        // ��ȡ���һ��"."֮ǰ������  
        String frontStr = oldFileName.substring(0, index);  
        // ��ȡ���һ��"."֮�������  
        String behindStr = oldFileName.substring(index);  
        // ����ƴ���ļ�������  
  
        String newFileName = frontStr + System.currentTimeMillis() + "_"+ behindStr;  
  
        return newFileName;  
    } 

}
