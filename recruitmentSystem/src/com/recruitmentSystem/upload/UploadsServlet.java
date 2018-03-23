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
	    // 定义文件的路径  
	    private String path = "S:/upload";  
	  
	    private String fileType = "";  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决文件的中文乱码  
        request.setCharacterEncoding("UTF-8");  
  
        // 创建磁盘文件工厂处理对象  
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();  
        // 创建服务器文件上传处理对象  
        ServletFileUpload servletFileUpload = new ServletFileUpload( diskFileItemFactory);  
        /* 
         * // 设置文件最大的上传的大小 servletFileUpload.setFileSizeMax(maxFileSize);// 10M 
         */  
        try {  
            // 解析request请求中的字段和请求的内容  
            List<FileItem> fileItems = servletFileUpload.parseRequest(request);  
  
            // 遍历解析出的list集合  
            for (FileItem fileItem : fileItems) {  
  
                // 判断解析出的是否是普通的文本字段  
                if (fileItem.isFormField()) {  
                    // 获取字段名称  
                    String filedName = fileItem.getName();  
                    // 获取字段名对应的值  
                    String filedValue = fileItem.getString("UTF-8");  
  
                    // 输出文本框的内容  
                    System.out.println(filedName + "=================="   + filedValue);  
                } else {  
                    // 判断资源文件大小是否合法  
                    if (fileItem.getSize() <= maxFileSize) {  
                        // 获取字段名  
                        String fileName = fileItem.getName();  
                           System.out.println(fileName);
                        // 解决不同浏览器的文件路径问题  
                        // ie或是其它的是这样的路径C:\Users\chenhongjun\Desktop\tag_1388040641790.txt  
                        // 火狐的只有文件名  
                        // D:\视频\day52\录像12.avi  
  
                        if (!fileName.equals("")) {  
                            // 获取上传文件的类型  
                            System.out.println(fileItem.getContentType());  
                            // 判断是否是指定的类型文件  
                            if (fileItem.getContentType().equals("image/jpeg")) {  
                                // 判断是否包含"\"  
                                int index = fileName.lastIndexOf("\\");  
                                if (index != -1) {  
                                    fileName = fileName.substring(index + 1);  
                                }  
  
                                // 指定文件存储的路径  
                                File file = new File(path, newFileName(fileName));  
  
                                // 创建输出流  
                                FileOutputStream fos = new FileOutputStream(file);  
  
                                // 获取request中解析出的输入流  
                                InputStream is = fileItem.getInputStream();  
  
                                // 创建缓冲区域  
                                byte[] buffer = new byte[1024];  
                                int len = 0;  
                                while ((len = (is.read(buffer))) != -1) {  
                                    // 将缓冲区内的内容写出  
                                    fos.write(buffer, 0, len);  
                                }  
                                fos.flush();  
                                fos.close();  
                                is.close();  
  
                                // 删除临时文件  
                                fileItem.delete();  
  
                                System.out.println("success");  
                            } else {  
                                System.out.println("请上传指定的文件类型");  
                            }  
  
                        } else {  
                            System.out.println("请选择要上传的文件");  
                        }  
  
                    } else {  
                        System.out.println("文件过大,超出" + maxFileSize);  
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
	
	   // 文件名的处理  
    public String newFileName(String oldFileName) {  
        // 获取最后一个"."出现的位置下标  
        int index = oldFileName.lastIndexOf(".");  
        // 截取最后一个"."之前的内容  
        String frontStr = oldFileName.substring(0, index);  
        // 获取最后一个"."之后的内容  
        String behindStr = oldFileName.substring(index);  
        // 重新拼接文件的名称  
  
        String newFileName = frontStr + System.currentTimeMillis() + "_"+ behindStr;  
  
        return newFileName;  
    } 

}
