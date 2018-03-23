<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link href="${pageContext.request.contextPath }/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" type="text/css" media="all" />
</head>
	<body>
	<div class="header">
	<div class="container">
		<div class="header-left">
			<a href="index.html"><img src="${pageContext.request.contextPath }/images/logo.png" alt=""/></a>
		</div>
		<div class="header-right">
			<span class="menu">MENU</span>
					<ul class="nav1">
					        <% String ustatus=(String)session.getAttribute("ustatus"); %>
					        <% int uid = (Integer)session.getAttribute("uid"); %>
						<%-- <li ><a class="scroll active" href="${pageContext.request.contextPath }/LoginSuccessServlet?uid=<%=uid %>"   target="main">
						首页</a></li>
						<li >
					   <a class="scroll" href="${pageContext.request.contextPath }/UserListServlet?uid=<%=uid %>" target="main">
							个人中心</a>
						</li>	
						<li><a class="scroll" href="${pageContext.request.contextPath }/CompanyListServlet?uid=<%=uid %>" target="main">
							企业中心
						</a></li>
						<li><a class="scroll" href="${pageContext.request.contextPath }/pages/admin.jsp" target="main">
						管理员</a></li> --%>
					</ul>
		</div>				
		</div>
</div>
	</body>
</html>