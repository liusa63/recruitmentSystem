<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="JavaScript"
	src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
<script type="text/javascript">
function changeBehave(uid,ubehave){
	 $("#uid").val(uid);
	 $("#ubehave").val(ubehave);
	 $("#changeBehaveForm").submit();
}
</script>
</head>
<body>

	<form
		action="${pageContext.request.contextPath}/ChangeUserBehaveServlet"
		method="post" id="changeBehaveForm">
		<input type="text" name="uid" id="uid" style="display: none;" /> <input
			type="text" name="ubehave" id="ubehave" style="display: none;" />
	</form>
	<table border="1" width="800px" cellspacing="0" style="margin: 35px 50px; text-align:center;">
		<tr>
			<td>用户名</td>
			<td>电话</td>
			<td>身份</td>
			<td>状态</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${userlist}" var="u">
			<tr>
				<td>${u.uname}</td>
				<td>${u.uphone}</td>
				<td>${u.ustatus eq 0? "个人":"企业"}</td>
				<td>${u.ubehave eq 0? "启用":"禁用"}</td>
				<td>
				<input type="button" value="启用" onclick="changeBehave(${u.uid},0)" /> 
				<input type="button" value="禁用" onclick="changeBehave(${u.uid},1)" />
				<a href="${pageContext.request.contextPath}/UserDetailServlet?uid=${u.uid}">详情</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>