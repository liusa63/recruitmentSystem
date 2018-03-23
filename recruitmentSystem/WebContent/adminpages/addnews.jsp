<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script type="text/javascript">
    function addNews(){
    	$("#newsForm").submit();
    }
</script>
</head>
<body>
     <form action="${pageContext.request.contextPath}/AddNewServlet" method="post" id="newsForm" enctype="multipart/form-data" > 
          <table width="500px;" style="margin-top: 40px; text-align: left; margin-left: 50px;">
                 <tr>
                     <td>新闻标题：<input style="width:200px;height:30px;" type="text" name="ntitle" id="ntitle"/></td>
                 </tr>
                 <tr>
                     <td>新闻内容：<textarea  style="width:500px;height:100px;" name="ncontent" id="ncontent"></textarea></td>
                 </tr>
                 <tr>
                     <td>新闻照片：<input type="file" name="nimg" id="upload" /></td>
                 </tr>
				<tr>
					<td><input type="button" value="提交" onclick="addNews();"
						style="color: purple; margin-left: 400px;" /></td>
				</tr>
		</table>
     </form>
</body>
</html>