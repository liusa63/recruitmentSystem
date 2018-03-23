<%@page import="com.recruitmentSystem.entity.Delivery"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>招聘--首页</title>
	<link href="${pageContext.request.contextPath }/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" type="text/css" media="all" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<style type="text/css">
	a {
	text-decoration: none;
	color: #b9b7c1;
	}
	table  td{
	  width:250px;
	}
	</style>
	
	<script type="text/javascript">
	
	
	</script>
	
	</head>
	<body>
	<%@include file="top.jsp"%>
<div id="home" class="banner">
	<div class="container">
		<div  id="top" class="callbacks_container">
			<ul class="rslides">
				<li>
					<table border="1" width="1000px" style="margin-top: 20px; text-align: center;">
						<th>高薪岗位</th>
						<tr>
							<td>企业名称</td>
							<td>职位</td>
							<td>薪资</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${salarylist}" var="s">
						<tr>
							<td>
							  ${s.cname}
							</td>
							<td>${s.rpost}</td>
							<td>${s.rsalary}</td>
							<td>
							<a href="CompanyDetailServlet?pid=${s.pid}&cid=${s.cid }">详情</a>&nbsp;&nbsp;
							<%  if(ustatus.equals("0")) {%>
							<span style="color: rgba(128, 128, 128, 0.48)">|</span>&nbsp; 
							 <c:if  test="${s.dstatus==1}">
							     <a href="javascript:void(0);">&nbsp;&nbsp;已投递</a>
							 </c:if>
							 <c:if  test="${s.dstatus==0}">
							     <a href="javascript:void(0);">&nbsp;&nbsp;已邀请</a>
							 </c:if>
							  <c:if test="${s.dstatus==null}">
							<a href="DeliveryResumeServlet?uid=<%=uid%>&pid=${s.pid}&dstatus=1">投递简历</a>
						</c:if>
						<%} %>
                            </td>
						</tr>
						</c:forEach>
						
					</table>
				</li>
				<li>
					<table border="1" width="1000px" style="margin-top: 20px; text-align: center;">
						<th>最新岗位</th>
						<tr>
							<td>企业ID</td>
							<td>职位</td>
							<td>薪资</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${timelist}" var="t">
						<tr>
							<td>
							${t.cname}
							</td>
							<td>${t.rpost}</td>
							<td>${t.rsalary}</td>
							<td>
							<a href="CompanyDetailServlet?pid=${t.pid}&cid=${t.cid}">详情</a>&nbsp;&nbsp;
							<%  if(ustatus.equals("0")) {%>
							<span style="color: rgba(128, 128, 128, 0.48)">|</span>&nbsp; 
							 <c:if  test="${t.dstatus==1}">
							     <a href="javascript:void(0);">&nbsp;&nbsp;已投递</a>
							 </c:if>
							 <c:if  test="${t.dstatus==0}">
							     <a href="javascript:void(0);">&nbsp;&nbsp;已邀请</a>
							 </c:if>
							  <c:if test="${t.dstatus==null}">
							<a href="DeliveryResumeServlet?uid=<%=uid%>&pid=${t.pid}&dstatus=1">投递简历</a>
						    </c:if>
                            <%} %>
                            </td>
						</tr>
						</c:forEach>
					</table>
				</li>
				
			</ul>
		</div>
	</div>
</div>
	</body>
</html>
