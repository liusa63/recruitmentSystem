<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>我的工作经验</title>
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
	<div class="container">
	  <div  id="top" class="callbacks_container">
	
			<ul class="rslides">
			<%
	  String msg = (String)request.getAttribute("msg");
	if(msg!=null){
		%>
		<%=msg%>
		<% 
	}
	
	%>
				<li>
					<table border="1" width="1000px" style="margin-top: 20px; text-align: center;">
						<tr>
						   <td>任职公司</td>
						   <td>职位</td>
						   <td>任期</td>
						   <td>项目介绍</td>
						   <td>操作</td>
						</tr>
						<c:forEach items="${myexplist}" var="m">
						<tr>
							<td>${m.ecompany}</td>
							<td>${m.etimes}</td>
							<td>${m.epost}</td>
							<td>${m.edes}</td>
							<td>
							<a href="${pageContext.request.contextPath}/DeleteExperienceServlet?uid=<%=uid %>&eid=${m.eid}">删除</a>&nbsp;&nbsp;
							<span style="color: white">|</span>&nbsp; 
							<a href="${pageContext.request.contextPath}/UpdateExperienceServlet?eid=${m.eid}">修改</a>
							</td>
						</tr>
						</c:forEach>
					</table>
					<a href="${pageContext.request.contextPath}/AddExperienceServlet?uid=<%=uid%>">
					<input type="button" value="添加工作经验"  style="margin-top: 50px; margin-left:800px;width:150px;height:50px;border-style : none; color:blue;border-radius:20px; "/>
					</a>
                    <input type="button" value="返回" onclick="window.history.go(-1);" style="width:150px;height:50px; margin-left:800px;border-style : none; color:blue;border-radius:20px;"/>
				</li>
				
			</ul>
		</div>
	</div>
</div>




</body>
</html>