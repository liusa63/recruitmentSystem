<%@page import="com.recruitmentSystem.entity.Experience"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人详情</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

	
	

</head>
<body>
	<%@include file="Top1.jsp"%>
	<%@include file="index.jsp"%>
	<div id="fh5co-about" class="animate-box fadeInUp animated-fast">
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
				<h2>About Me</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<ul class="info">
					<li><span class="first-block">姓名:</span><span class="second-block">${resume.rname}</span></li>
					<li><span class="first-block">照片:</span><span class="second-block"><img src="/static/${resume.rpic}" style="width:80px; height:80px;"></span></li>
					<li><span class="first-block">年龄:</span><span class="second-block">${resume.rage}</span></li>
					<li><span class="first-block">性别:</span><span class="second-block">${resume.rsex}</span></li>
					<li><span class="first-block">手机:</span><span class="second-block">${resume.rphone}</span></li>
					<li><span class="first-block">邮箱:</span><span class="second-block">${resume.remail}</span></li>
					<li><span class="first-block">学历:</span><span class="second-block">${resume.reducation}</span></li>
					<li><span class="first-block">期望岗位:</span><span class="second-block">${resume.rwant}</span></li>
				</ul>
			</div>
	        <%
		List<Experience> list= (List<Experience>)request.getAttribute("explist");
		/*有工作经验的才展示  */
		if(list!=null && list.size()>0){
			%>
			
	         <div class="col-md-6" style="width:700px;height:500px;" >
				<h3>工作经验</h3>
				<table  height="100px;"   width="700px;" style="text-align:center;">
					   <tr>
					   <td width=100px;>任职公司</td>
					   <td width=100px;>职位</td>
					   <td width=100px;>任期</td>
					   <td width=200px;>项目介绍</td>
					   </tr>
					<c:forEach items="${explist }"  var="l">
					   <tr>
					   <td>${l.ecompany}</td>
					   <td>${l.epost}</td>
					   <td>${l.etimes}</td>
					   <td>${l.edes}</td> 
					   </tr>
					 </c:forEach>
				</table>
			</div>
	          
		<% }%>
	
	<input type="button" value="返回" onclick="window.history.go(-1);" style="border-style : none; color:blue;border-radius:20px; width:60px;height:40px; margin-left:300px; margin-top:300px;"/>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		<%-- <div id="home" class="banner">
	<div class="container">
		<div  id="top" class="callbacks_container">
			
			<ul class="rslides">
				<li>
					
			<div class="restab">
					<table  height="400px;" style="margin-top: 20px; text-align: left; ">
						<tr>
							<td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:${resume.rname}</td>
						</tr>
						<tr>
							<td>照&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;片:<img src="/static/${resume.rpic}" style="width:80px; height:80px;"></td>
						</tr>
						<tr>
							<td>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄:&nbsp;&nbsp;&nbsp;${resume.rage}</td>
						</tr>
						<tr>
						    <td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:&nbsp;&nbsp;&nbsp;${resume.rsex}</td>
						</tr>
						<tr>
							<td>手&nbsp;&nbsp;&nbsp;机&nbsp;&nbsp;号:&nbsp;&nbsp;&nbsp;${resume.rphone}</td>
						</tr>
						<tr>
							<td>电&nbsp;子&nbsp;邮&nbsp;箱:&nbsp;&nbsp;&nbsp;${resume.remail}</td>
						</tr>	
						<tr>
							<td>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历:&nbsp;&nbsp;&nbsp;${resume.reducation}</td>
						</tr>
						<tr>
							<td>岗&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位:&nbsp;&nbsp;&nbsp;${resume.rwant}</td>
						</tr>
						<tr>
							<td>
							
							</td>
						</tr>
					</table>
				</div>
		<%
		List<Experience> list= (List<Experience>)request.getAttribute("explist");
		/*有工作经验的才展示  */
		if(list!=null && list.size()>0){
			%>
			<c:if test="${explist!=null && explist.size>0}">			
			<div class="exptab">
					<table height="100px;">
					   <tr>
					   <td>任职公司</td>
					   <td>职位</td>
					   <td>任期</td>
					   <td>项目介绍</td>
					   </tr>
					<c:forEach items="${explist}"  var="l">
					   <tr>
					   <td>${l.ecompany}</td>
					   <td>${l.epost}</td>
					   <td>${l.etimes}</td>
					   <td>${l.edes}</td> 
					   </tr>
					 </c:forEach>
					</table>
					<input type="button" value="返回" onclick="window.history.go(-1);" style=" margin-left:50px; margin-top:260px;"/>
				</div>
			</c:if>
		<% }%>
		
		<input type="button" value="返回" onclick="window.history.go(-1);" style=" margin-left:50px; margin-top:300px;"/>
				</li>
			</ul>
		  </div>
	  </div>
   </div>
		 --%>
</body>
</html>