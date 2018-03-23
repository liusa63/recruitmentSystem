<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>多图片上传</title>
</head>
<body>
<form action="UploadsServlet" method="post" enctype="multipart/form-data">
	<input type="file" name="UplodeName"  multiple="multiple">
	
	<input type="submit" value="上传">
</form>


</body>
</html>
  

 
 
 
<!-- </head>  
  
<body>  
    <form action="UploadsServlet"    enctype="multipart/form-data" method="post">  

        上文件:<input   multiple="multiple"  type="file" name="UplodeName" value="你好">  
     
        <br> <br> <input type="submit" value="提交文件"> 
    </form>  
</body>  
</html>  --> 
