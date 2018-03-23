<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TOP</title>
<!-- CSS -->
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/test/css/bootstrap.min.css" rel="stylesheet">
<!-- Ionicons -->
<link href="${pageContext.request.contextPath}/test/fonts/ionicons/css/ionicons.min.css" rel="stylesheet">
<!-- Owl Carousel -->
<link href="${pageContext.request.contextPath}/test/css/owl.carousel.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/test/css/owl.theme.default.css" rel="stylesheet">
<!-- Animate.css -->
<link href="${pageContext.request.contextPath}/test/css/animate.min.css" rel="stylesheet">
<!--Magnific Popup -->
<link href="${pageContext.request.contextPath}/test/css/magnific-popup.css" rel="stylesheet">
<!--Tagsinput CSS -->
<link href="${pageContext.request.contextPath}/test/css/tagsinput.css" rel="stylesheet">		
<!-- Style.css -->
<link href="${pageContext.request.contextPath}/test/css/style.css" rel="stylesheet">
</head>
<body>
<!-- Header -->
<header class="header">
	<div class="container clearfix">
		<div class="header-inner flex space-between items-center">
			<div class="left">
				<div class="logo"><a href="index.html"><img src="${pageContext.request.contextPath}/test/images/logo.png" alt="JobPress" class="img-responsive"></a></div>	
			</div> <!-- end .left -->				
			<div class="right flex space-between no-column items-center">
				<div class="navigation">
					<nav class="main-nav">
					 <% String ustatus=(String)session.getAttribute("ustatus"); %>
					 <% int uid = (Integer)session.getAttribute("uid"); %>
						<ul class="list-unstyled">
							<li>
							<a  href="${pageContext.request.contextPath }/LoginSuccessServlet?uid=<%=uid %>"   >
						     Home</a></li>
							<li>
							<a href="${pageContext.request.contextPath }/UserListServlet?uid=<%=uid %>" >
							User</a></li>
							<li><a href="${pageContext.request.contextPath }/CompanyListServlet?uid=<%=uid %>" >
							Company</a></li>
							<li><a href="${pageContext.request.contextPath }/pages/contact.jsp" > Contact </a></li>
						</ul>
					</nav> <!-- end .main-nav -->
					<a href="" class="responsive-menu-open"><i class="ion-navicon"></i></a>
				</div> <!-- end .navigation -->
				<div class="button-group-merged flex no-column">
					<a href="#" class="button">welcome</a>
					<a href="#" class="button" >QUE</a>
				</div> <!-- end .button-group-merged -->
			</div> <!-- end .right -->
		</div> <!-- end .header-inner -->
	</div> <!-- end .container -->
</header> <!-- end .header -->
</body>
</html>