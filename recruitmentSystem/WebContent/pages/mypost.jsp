<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公司岗位</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script type="text/javascript">

</script>
<style type="text/css">
	a {
	text-decoration: none;
	color: #b9b7c1;
	}
	
	table td{
	  width:200px;
	}
	
	</style>

</head>
<body>
<%@include file="Top1.jsp"%>
<div id="home" class="banner">
<%-- <form action="${pageContext.request.contextPath}/pages/addpost.jsp" method="post" id="addpostform" style="display:none">
  <input type="text" id="input" >
</form> --%>
	<div class="container">
	  <div  id="top" class="callbacks_container">
			<ul class="rslides">
				<li>
					<table border="1" width="1000px" style="margin-top: 20px; text-align: center;">
						<tr>
							<td>职位</td>
							<td>要求</td>
							<td>薪水</td>
							<td>时间</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${postlist}" var="m">
						<tr>
							<td>${m.rpost}</td>
							<td>${m.rask}</td>
							<td>${m.rsalary}</td>
							<td>${m.rtimes}</td>
							<td>
							<a href="${pageContext.request.contextPath}/DeletePostServlet?pid=${m.pid}&uid=<%=uid %>">删除</a>&nbsp;&nbsp;
							<span style="color: white">|</span>&nbsp; 
							<a href="${pageContext.request.contextPath}/ReceiveResumeServlet?pid=${m.pid}">收到的简历</a>
							</td>
						</tr>
						</c:forEach>
					</table>
					<a href="${pageContext.request.contextPath}/pages/addpost.jsp">
					<input type="button" value="添加岗位"  style="margin-top: 50px; margin-left:800px;width:100px;height:40px;border-style : none; color:blue;border-radius:20px;"/>
					</a>
                    <input type="button" value="返回" onclick="window.history.go(-1);" style=" margin-left:800px;width:100px;height:40px;border-style : none; color:blue;border-radius:20px;"/>
				</li>
				
			</ul>
		</div>
	</div>
</div>


</body>
</html>