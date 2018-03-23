<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style type="text/css">
	a {
	text-decoration: none;
	color: #b9b7c1;
	}
	
	/* 分页 */
	.pageDiv a {
		margin: 10px;
		color:  #b9b7c1;
	}
	
	</style>
</head>
<body>
<%@include file="Top1.jsp"%>
<div id="home" class="banner">
	<div class="container">
		<div  id="top" class="callbacks_container">
		<ul class="rslides">
		<% String msg=(String) request.getAttribute("msg"); 
		  if(msg!=null){
			  %>
			  <%=msg %>
			  <%
		  }else{
			  %>
			  
			  <li>
       
     <table border="1" width="1000px" style="margin-top: 20px; text-align: center;">
						<tr style="color: #b9b7c1">
							<td>姓名</td>
							<td>学历</td>
							<td>求职意向</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${rl}" var="m">
						<tr>
							<td>${m.rname}</td>
							<td>${m.reducation}</td>
							<td>${m.rwant}</td>
							<td>
							<a href="${pageContext.request.contextPath}/ResumeDetailServlet?uid=${m.uid}">详情</a>
                            </td>
						</tr>
					</c:forEach>
					</table>
			  </li>
			
			  
			  
			  
			  
			  <% 
			  
		  }
		%>
			</ul>	
			<input type="button" value="返回" onclick="window.history.go(-1)" style="border-style : none; color:blue;border-radius:20px; width:60px;height:40px;margin-top:50px; margin-left:950px;"/>
  </div>
  </div>
  </div>
  

</body>
</html>