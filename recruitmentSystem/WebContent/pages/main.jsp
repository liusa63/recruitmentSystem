<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css" type="text/css" media="all" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>

</head>
<body>
<span style="display: none;">
<%@include file="Top1.jsp"%>
</span>
<div id="home" class="banner">
	<div class="container">
		<div  id="top" class="callbacks_container">
			<ul class="rslides" id="slider3">
				<li>
					<div class="banner-info text-center">
						<h1>WELCOME QUE</h1>
						<p>缺工作缺人才就在QUE</p>
						<div class="start">
								<a href="${pageContext.request.contextPath }/LoginSuccessServlet?uid=<%=uid%>">START TOUR</a>
								<a href="${pageContext.request.contextPath }/pages/contact.jsp">CONTACT</a>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</div>
</div>
</body>
</html>