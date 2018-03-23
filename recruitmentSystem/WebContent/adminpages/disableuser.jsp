<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<style type="text/css">
.tab1 {
	width: 400px;
	height: 500px;
	float: left;
}
</style>
</head>
<body>
	<div id="home" class="banner">
		<div class="container">
			<div id="top" class="callbacks_container">
				<ul class="rslides">
					<div class="tab1">
						<table border="1" width="800px" cellspacing="0" style="margin: 35px 50px; text-align:center;">
							<tr>
								<td>姓名</td>
								<td>身份</td>
								<td>联系方式</td>
							    <td>状态</td>
							    <td>操作</td>
							</tr>
							<c:forEach items="${ulist}" var="u">
								<tr>
									<td>${u.uname}</td>
									<td>${u.ustatus eq 0?"个人":"企业"}</td>
									<td>${u.uphone}</td>
								    <td>${u.ubehave eq 1?"禁用":"已删除"}</td> 
								    <td>
								        <a href="${pageContext.request.contextPath}/DeleteUserServlet?uid=${u.uid}"><button type="button">删除</button></a>
								    </td>
								</tr>
							</c:forEach>
						</table>
						
								<input type="button" value="返回"  style="margin-left: 800px;"
									onclick="window.history.go(-1);" /></td>
							
					</div>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>