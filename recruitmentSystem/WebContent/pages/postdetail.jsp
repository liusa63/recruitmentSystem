<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<style type="text/css">
	 table td{
	 width:500px;
	 }
	</style>
</head>
<body>
<%@include file="Top1.jsp"%>
<div id="home" class="banner">
	<div class="container">
		<div  id="top" class="callbacks_container">
			<ul class="rslides">
				<li>
					<table  width="1000px;" height="400px;" style="margin-top: 20px; text-align: left; ">
						<tr>
							<td>职&nbsp;&nbsp;&nbsp;&nbsp;位:&nbsp;&nbsp;&nbsp;${postdetail.rpost}</td>
							<td>公&nbsp;&nbsp;&nbsp;&nbsp;司:&nbsp;&nbsp;&nbsp;${com.cname}</td>
						</tr>
						<tr>
							<td>要&nbsp;&nbsp;&nbsp;&nbsp;求:&nbsp;&nbsp;&nbsp;${postdetail.rask}</td>
						    <td>地&nbsp;&nbsp;&nbsp;&nbsp;址:&nbsp;&nbsp;&nbsp;${com.caddress}</td>
						</tr>
						<tr>
							<td>薪&nbsp;&nbsp;&nbsp;&nbsp;资:&nbsp;&nbsp;&nbsp;${postdetail.rsalary}</td>
							<td>介&nbsp;&nbsp;&nbsp;&nbsp;绍:&nbsp;&nbsp;&nbsp;${com.cintroduce}</td> 
						</tr>
						<tr>
						    <td>时&nbsp;&nbsp;&nbsp;&nbsp;间:&nbsp;&nbsp;&nbsp;${postdetail.rtimes}</td>
						    <td>电&nbsp;&nbsp;&nbsp;&nbsp;话:&nbsp;&nbsp;&nbsp;${com.cphone}</td>
						</tr>
						<td></td>
						<td><input type="button" value="返回"  onclick="window.history.go(-1);" style="width:60px;height:40px;margin-left:300px;border-style : none; color:blue;border-radius:20px;"/></td>
						<tr>
					</tr>
				</table>
			</li>
		</ul>
		</div>
  </div>
</div>
</body>
</html>