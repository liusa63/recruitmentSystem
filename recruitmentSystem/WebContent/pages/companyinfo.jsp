<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公司信息</title>
	<script type="text/javascript">
	 
	
	</script>
	</head>
	<body>
	<%@include file="Top1.jsp"%>
		<div id="home" class="banner">
	<div class="container">
		<div  id="top" class="callbacks_container">
			<ul class="rslides">
				<li>
					<form  id="resumeform" action="" method="post">
					<table  width="1000px;" height="400px;" style="margin-top: 20px; text-align: left; ">
						<tr>
							<td>公&nbsp;&nbsp;&nbsp;司&nbsp;&nbsp;名:&nbsp;&nbsp;&nbsp;${com.cname}</td>
						</tr>
						<tr>
							<td>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址:&nbsp;&nbsp;&nbsp;${com.caddress}</td>
						</tr>
						<tr>
							<td>介&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;绍:&nbsp;&nbsp;&nbsp;${com.cintroduce}</td>
						</tr>
						<tr>
						    <td>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话:&nbsp;&nbsp;&nbsp;${com.cphone}</td>
						</tr>
						<tr>
							<td>
							<a href="${pageContext.request.contextPath }/UpdateCompanyInfoServlet?uid=${com.uid}">
							<input type="button" value="修改"  style="border-style : none; color:blue;border-radius:20px;width:60px;height:40px; margin-left: 300px;" />
							</a>
							<input type="button" value="返回" onclick="window.history.go(-1);" style="border-style : none; color:blue;border-radius:20px;width:60px;height:40px; margin-left: 380px; margin-top:-40px;" />
							</td>
						</tr>
					</table>
					</form>
				</li>
			</ul>
		  </div>
	  </div>
   </div>
		
	</body>
</html>
