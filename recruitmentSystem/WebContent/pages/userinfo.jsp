<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人简历</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	
	</style>
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
			<div class="col-md-6" style="width:700px;height:500px;">
				<h3>工作经验</h3>
				<table  height="100px;" width="700px;" style="text-align:center">
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
				<ul style="margin-top:50px;margin-left:300px;">
					<li><a href="${pageContext.request.contextPath}/UpdateUserInfoServlet?uid=<%=uid%>">修改基本信息
					<!-- <input type="button" value="修改基本信息"  style="color: purple; position:absolute; margin-top:200px; margin-left: -200px;" /> -->
					</a>
					<li><a href="${pageContext.request.contextPath}/MyExperienceServlet?uid=<%=uid %>">添加/修改工作经验
					<!-- <input type="button" value="添加/修改工作经验"  style="color: purple; position:absolute;  margin-top:200px" /> -->
					</a>
					<li><a href="${pageContext.request.contextPath}/UserListServlet?uid=<%=uid %>">返回
					<!-- <input type="button" value="返回"  style="color: purple; position:absolute; margin-top:200px ; margin-left:200px" /> -->
					</a>
				</ul>
				
			</div>
		</div>
	</div>
</div>

		
	</body>
</html>