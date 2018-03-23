<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>招聘--用户</title>
	<link href="${pageContext.request.contextPath }/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" type="text/css" media="all" />
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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript">
	function jumpfun(){
		   //要跳转的页码
		  var gopage= $("#jump").val();
		  //总页数
		  var countPage=${userPage.countPage};
		  if(gopage!=null){
			 var reg=/^\d+$/;
			  if(reg.test(gopage)){
				  if(gopage>0 && gopage<=countPage){
					  window.location.href="${pageContext.request.contextPath}/UserListServlet?currentPage="+gopage;
				  }else{
					  $("#pageError").html("请输入页码范围内的数");
				  }
			  }else{
				  $("#pageError").html("请输入正整数");
			  }
		  }else{
			  $("#pageError").html("请输入跳转的页码");
		  }
	   }
	
	
	 
	 
	</script>
	
	</head>
	<body>
	<%@include file="top.jsp"%>
<div id="home" class="banner">
	<div class="container">
		<div  id="top" class="callbacks_container">
			
			
	
	 <%  if(ustatus.equals("0")) {%>
		  
		  <div class="test"  style="margin-left: 700px;  width: 500px;height: 80px;">
		        <a href="${pageContext.request.contextPath}/RefreshMyResumeServlet?uid=<%=uid%>">刷新我的简历</a>
				<span style="color: white">|</span>&nbsp;
				<a href="${pageContext.request.contextPath}/MyResumeServlet?uid=<%=uid%>">我的简历信息</a>
				<span style="color: white">|</span>&nbsp; 
				<a href="${pageContext.request.contextPath}/UpdateUserInfoServlet?uid=<%=uid%>">添加/修改基本信息</a>
				<span style="color: white">|</span>&nbsp; 
				<a href="${pageContext.request.contextPath}/MyExperienceServlet?uid=<%=uid%>">我的工作经验</a>
		 </div>
		  <%
	  }
	%>
			
			<ul class="rslides">
				<li>
					<table border="1" width="1000px" style="margin-top: 20px; text-align: center;">
						<tr style="color: #b9b7c1">
							<td>姓名</td>
							<td>学历</td>
							<td>求职意向</td>
							<td>操作</td>
						</tr>
						<c:forEach items="${userPage.list}" var="m">
						<tr>
							<td>${m.rname}</td>
							<td>${m.reducation}</td>
							<td>${m.rwant}</td>
							<td>
							<a href="${pageContext.request.contextPath}/ResumeDetailServlet?uid=${m.uid}">详情</a>&nbsp;&nbsp;
							<%  if(ustatus.equals("1")){%>
							<span style="color: white">|</span>&nbsp; 
							       <c:if  test="${m.dstatus==1}">
								       <a href="javascript:void(0);">已投递&nbsp;&nbsp;</a>&nbsp;&nbsp;
								    </c:if>
								    <c:if  test="${m.dstatus==0}">
								       <a href="javascript:void(0);">已邀请&nbsp;&nbsp;</a>&nbsp;&nbsp;
								    </c:if>
							        <c:if test="${m.dstatus==null}">
							            <a href="ChoosePostListServlet?uid=<%=uid%>&rid=${m.rid}">邀请</a>&nbsp;&nbsp;
							        </c:if>
							<% }%>
							</td>
						</tr>
						</c:forEach>
					</table>
	<div style="float: right; margin-right: 60px; margin-top: 10px;" class="pageDiv">
		<a href="${pageContext.request.contextPath}/UserListServlet?currentPage=1&uid=<%=uid%>">首页</a>
		<c:if test="${userPage.currentPage>1}">
			<a href="${pageContext.request.contextPath}/UserListServlet?currentPage=${userPage.currentPage-1}&uid=<%=uid%>">上一页</a>
		</c:if>
		${userPage.currentPage}
		<c:if test="${userPage.currentPage<userPage.countPage}">
			<a href="${pageContext.request.contextPath}/UserListServlet?currentPage=${userPage.currentPage+1}&uid=<%=uid%>">下一页</a>
		</c:if>
		<a href="${pageContext.request.contextPath}/UserListServlet?currentPage=${userPage.countPage}&uid=<%=uid%>">尾页</a>
		共${userPage.totalNum }条 共${userPage.countPage}页 
		<input type="text" id="jump" style="margin-right: 10px; padding: 2px; width: 30px; border-radius: 3px; border: 1px solid rgba(128, 128, 128, 0.46);" />
		<input type="button" value="跳转" onclick="jumpfun();" /><br> 
		<span id="pageError" style="color: red; margin-left: 200px;"></span>
	</div>
				</li>
			</ul>
		</div>
	</div>
</div>
	</body>
</html>
