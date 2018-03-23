<%@page import="com.recruitmentSystem.entity.Delivery"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<%@include file="Top1.jsp"%>
<script type="text/javascript">
function searchsub(){
	 
	  var searchtype=$("#searchtype>option:selected").val();
	  var rpost=$("#rpost").val();
	  if(rpost != null && rpost!=""){
		
		window.location.href="${pageContext.request.contextPath}/SearchPostServlet?uid="+<%=uid%>+"&searchtype="+searchtype+"&rpost="+rpost;
		<%--  $.ajax({
			    type:"post",
			   url:"${pageContext.request.contextPath}/SearchPostServlet?uid="+<%=uid%>+"&searchtype="+searchtype+"&rpost="+rpost,
		       dataType:"json",
		       success: function(data){
		    	   var com=$("#bef");
		    	   for(var i=0;i<data.length;i++){
		    		   var li=data[i].cname+data[i].rpost+data[i].rsalary
		    			   
		    			 /*   "<div class='content'>"+
						 "<h4><a href='#'>"+data[i].cname"</a></h4>"+
						 "<p class='small'>company name</p>"+
					    "</div>"  */
		    		   com.before(li);
		    	   }
		       }
		  }); --%>
	}  
	
 }
</script>

</head>
<body>

<!-- Responsive Menu -->
<div class="responsive-menu">
	<a href="" class="responsive-menu-close"><i class="ion-android-close"></i></a>
	<nav class="responsive-nav"></nav> <!-- end .responsive-nav -->
</div> <!-- end .responsive-menu -->

<!-- Login/Signup Popup -->
<div class="modal fade bs-modal-sm" aria-hidden="true" aria-labelledby="myTabContent"  id="login-signup-popup" role="dialog" tabindex="-1">
	<div class="modal-dialog modal-sm login-signup-modal">
		<div class="modal-content">
			<div class="popup-tabs">
				<ul class="nav nav-tabs" id="myTab">
					<li class=""><a data-toggle="tab" href="#login">login</a></li>
					<li class="active"><a data-toggle="tab" href="#register">Register</a></li>
				</ul>
			</div> <!-- end .popup-tabs -->
			<div class="modal-body">
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade" id="login">
						<form class="login-form">

							<div class="form-group">
								<label for="InputEmail1">Your Email *</label>
								<input type="email" class="form-control" id="InputEmail1" placeholder="Enter your email">
							</div>

							<div class="form-group">
								<label for="InputPassword1">Password *</label>
								<input type="password" class="form-control" id="InputPassword1" placeholder="Password">
							</div>

							<div class="checkbox flex space-between">
								<div>
									<input id="sigin-checkbox" type="checkbox">
									<label for="sigin-checkbox">Remember me</label>
								</div>
								<a href="#0">Lost password?</a>
							</div> <!-- end .checkbox -->

							<button type="button" class="button" data-dismiss="modal">Login</button>
							
							<p class="text-center divider-text small"><span>or login using</span></p>
							
							<div class="social-buttons">
								<ul class="list-unstyled flex space-between">
									<li class="twitter-btn"><a href="#0"><i class="ion-social-twitter"></i></a></li>
									<li class="fb-btn"><a href="#0"><i class="ion-social-facebook"></i></a></li>
									<li class="g-plus-btn"><a href="#0"><i class="ion-social-googleplus"></i></a></li>
								</ul>
							</div> <!-- end .social-buttons -->

						</form> <!-- end .login-form -->
					</div> <!-- end login-tab-content -->

					<div class="tab-pane fade active in" id="register">
						<form class="signup-form">
							<div class="form-group">
								<label for="InputEmail1">Your Email *</label>
								<input type="email" class="form-control" id="InputEmail2" placeholder="Enter your email">
							</div>

							<div class="form-group">
								<label for="InputPassword1">Password *</label>
								<input type="password" class="form-control" id="InputPassword2" placeholder="Password">
							</div>

							<div class="form-group">
								<label for="InputPassword2">Confirm Password *</label>
								<input type="password" class="form-control" id="InputPassword3" placeholder="Password">
							</div>

							<div class="form-group">
								<label for="select1">Register as:</label>
								<div class="select-wrapper">
									<select class="form-control" id="select1">
										<option>Candidate</option>
										<option>Company</option>
									</select>
								</div> <!-- end .select-wrapper -->								    
							</div>

							<div class="checkbox">
								<input id="signup-checkbox" type="checkbox">
								<label for="signup-checkbox">I agree with the Terms of Use</label>
							</div> <!-- end .checkbox -->

							<button type="button" class="button" data-dismiss="modal">Sign Up</button>
							
							<p class="text-center divider-text small"><span>or login using</span></p>
							
							<div class="social-buttons">
								<ul class="list-unstyled flex space-between">
									<li class="twitter-btn"><a href="#0"><i class="ion-social-twitter"></i></a></li>
									<li class="fb-btn"><a href="#0"><i class="ion-social-facebook"></i></a></li>
									<li class="g-plus-btn"><a href="#0"><i class="ion-social-googleplus"></i></a></li>
								</ul>
							</div> <!-- end .social-buttons -->

						</form> <!-- end .signup-form -->
					</div> <!-- end signup-tab-content -->
				</div> <!-- end .mytabcontent -->
			</div> <!-- end .modal-body -->
		</div> <!-- end .modal-content -->
	</div> <!-- end .modal-dialog -->
</div> <!-- end .modal -->

<!-- Hero Section -->
<div class="section hero-section transparent" style="background-image: url('${pageContext.request.contextPath}/test/images/background01.jpg');">
	<div class="inner">
		<div class="container">
			<div class="job-search-form">
				<h2>Over<span>100,000<sup>+</sup></span>jobs are waiting for you</h2>
				<form class="form-inline flex" method="post">
					<div class="form-group">
				       <select id="searchtype" style="height:50px; margin-left:550px; ">
				         <option  value="r_post">岗位</option>
				         <option value="c_address">地址</option>
				         <option value="c_name">公司</option>
				       </select>
					</div>
						<input type="text" class="form-control" name="rpost"  id="rpost" style="width: 476px;z-index: 999; position: absolute;right: 170px;"><!--  placeholder="city / province "> -->
						<i class="ion-ios-location-outline"></i>
					<input type="button"  class="button" onclick="searchsub();" value="搜索" style="margin-left:-30px; width:70px;height:50px;">
				</form>
				<div class="keywords flex">
					<h4 class="self-center">Popular Keywords:</h4>
					<a href="#0" class="button item-center">web design</a>
					<a href="#0" class="button item-center">accountant</a>
					<a href="#0" class="button item-center">car dealer</a>
				</div> <!-- end .keywords -->
			</div> <!-- end .job-search-form -->	
		</div> <!-- end .container -->
		<div class="features-bar">
			<div class="container">
				<div class="features-bar-inner flex space-between">
					<div class="features-box self-center">
						<h3>Leading the industry</h3>
						<a href="#0">About us<i class="ion-ios-arrow-thin-right"></i></a>
					</div> <!-- end .feature-box -->
					<div class="features-box-icon flex no-wrap">
						<img src="${pageContext.request.contextPath}/test/images/feature-icon01.png" alt="cup-icon" class="img-responsive self-center">
						<div class="content self-center">
							<h3>High average salary</h3>
							<a href="#0">Learn more<i class="ion-ios-arrow-thin-right"></i></a>
						</div> <!-- end .content -->							
					</div> <!-- end .feature-box-icon -->
					<div class="features-box-icon flex no-wrap">
						<img src="${pageContext.request.contextPath}/test/images/feature-icon02.png" alt="cup-icon" class="img-responsive self-center">
						<div class="content self-center">
							<h3>2,500,000+ candidates</h3>
							<a href="#0">Our community<i class="ion-ios-arrow-thin-right"></i></a>
						</div> <!-- end .content -->
					</div> <!-- end .feature-box-icon -->
					<div class="user-profile-icon self-center">
						<img src="${pageContext.request.contextPath}/test/images/profile-icon01.png" alt="profile-icon" class="img-responsive self-center">
					</div> <!-- end .profile-icon -->
				</div> <!-- end .features-bar-inner -->
			</div> <!-- end .container -->
		</div> <!-- end .features-bar -->	
	</div> <!-- end .inner -->
</div> <!-- end .section -->

<!-- Featured Jobs Section -->
<div class="section featured-jobs-section">
	<div class="inner">
		<div class="container">
			<div class="section-top-content flex items-center" id="bef">
				<h1>High salary position</h1>
				<a href="${pageContext.request.contextPath }/CompanyListServlet?uid=<%=uid %>" target="main">View all jobs<i class="ion-ios-arrow-thin-right"></i></a>
			</div> <!-- end .section-top-content -->
			<div class="jobs-table">
				<div class="table-header">
					<div class="table-cells flex">
						<div class="job-title-cell"><h6> Company name</h6></div>
						<div class="job-type-cell"><h6>Position</h6></div>
						<div class="location-cell"><h6>Salary</h6></div>
						<div class="expired-date-cell"><h6>Details</h6></div>
						<div class="salary-cell"><h6>Operating</h6></div>					
					</div> <!-- end .table-cells -->
				</div> <!-- end .table-header -->
				<c:forEach items="${salarylist}" var="s">
				<div class="table-row">
					<div class="table-cells flex no-wrap">
						<div class="cell job-title-cell flex no-column no-wrap">
							<div class="cell-mobile-label">
								<h6>公司名称</h6>
							</div> <!-- end .cell-label -->
							<img src="${pageContext.request.contextPath}/test/images/company-logo02.jpg" alt="company-logo" class="img-responsive">
							<div class="content">
								<h4><a href="#">${s.cname}</a></h4>
								<p class="small">company name</p>
							</div> <!-- end .content -->
						</div> <!-- end .job-title-cell -->
						<div class="cell job-type-cell flex no-column">
							<div class="cell-mobile-label">
								<h6>岗位</h6>
							</div> <!-- end .cell-label -->
							<button type="button" class="button part-time">${s.rpost}</button>
						</div>
						<div class="cell location-cell flex no-column no-wrap">
							<div class="cell-mobile-label">
								<h6>薪水</h6>
							</div> <!-- end .cell-label -->
							<p><span>￥</span>${s.rsalary}</p>
						</div>
						<div class="cell expired-date-cell flex no-column no-wrap">
							<div class="cell-mobile-label">
								<h6>详情</h6>
							</div> <!-- end .cell-label -->
							<p><a href="CompanyDetailServlet?pid=${s.pid}&cid=${s.cid }">详情</a>&nbsp;&nbsp;</p>
						</div>
						<div class="cell salary-cell flex no-column no-wrap">
							<div class="cell-mobile-label">
								<h6>Salary</h6>
							</div> <!-- end .cell-label -->
							<p><%  if(ustatus.equals("0")) {%>
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
						<%} %></p>
						</div>
					</div> <!-- end .table-cells -->
				</div> <!-- end .table-row -->
               </c:forEach>
			</div> <!-- end .jobs-table -->
			<div class="jobs-table">
				<div class="table-header">
					<div class="table-cells flex">
						<div class="job-title-cell"><h6> Company name</h6></div>
						<div class="job-type-cell"><h6>Postion</h6></div>
						<div class="location-cell"><h6>Salary</h6></div>
						<div class="expired-date-cell"><h6>Detail</h6></div>
						<div class="salary-cell"><h6>Operating</h6></div>					
					</div> <!-- end .table-cells -->
				</div> <!-- end .table-header -->
		</div> <!-- end .container -->
	</div> <!-- end .inner -->
</div> <!-- end .section -->
<!-- Category Section -->


<!-- Latest Jobs Section -->
<div class="section Latest-jobs-section">
	<div class="inner">
		<div class="container">
			<div class="section-top-content flex items-center">
				<h1>Latest Jobs</h1>
				<a href="${pageContext.request.contextPath }/CompanyListServlet?uid=<%=uid %>" target="main">View all jobs<i class="ion-ios-arrow-thin-right"></i></a>
			</div> <!-- end .section-top-content -->
			
			
			<div class="jobs-table">
				<div class="table-header">
					<div class="table-cells flex">
						<div class="job-title-cell"><h6>Company name</h6></div>
						<div class="job-type-cell"><h6>Postion</h6></div>
						<div class="location-cell"><h6>Salary</h6></div>
						<div class="expired-date-cell"><h6>Detail</h6></div>
						<div class="salary-cell"><h6>Operating</h6></div>					
					</div> <!-- end .table-cells -->
				</div> <!-- end .table-header -->
				
				
				
				<c:forEach items="${timelist}" var="t">
				<div class="table-row">
					<div class="table-cells flex no-wrap">
						<div class="cell job-title-cell flex no-column no-wrap">
							<div class="cell-mobile-label">
								<h6>Company name</h6>
							</div> <!-- end .cell-label -->
							<img src="${pageContext.request.contextPath}/test/images/company-logo06.jpg" alt="company-logo" class="img-responsive">
							<div class="content">
								<h4><a href="#">${t.cname}</a></h4>
								<p class="small">company name</p>
							</div> <!-- end .content -->
						</div> <!-- end .job-title-cell -->
						<div class="cell job-type-cell flex no-column no-wrap">
							<div class="cell-mobile-label">
								<h6>Type</h6>
							</div> <!-- end .cell-label -->
							<button type="button" class="button full-time">${t.rpost}</button>
						</div>
						<div class="cell location-cell flex no-column no-wrap">
							<div class="cell-mobile-label">
								<h6>Location</h6>
							</div> <!-- end .cell-label -->
							<p><span>￥</span>${t.rsalary}</p>
						</div>
						<div class="cell expired-date-cell flex no-column no-wrap">
							<div class="cell-mobile-label">
								<h6>Expired date</h6>
							</div> <!-- end .cell-label -->
							<p><a href="CompanyDetailServlet?pid=${t.pid}&cid=${t.cid }">详情</a></p>
						</div>
						<div class="cell salary-cell flex no-column no-wrap">
							<div class="cell-mobile-label">
								<h6>Salary</h6>
							</div> <!-- end .cell-label -->
							<p><%  if(ustatus.equals("0")) {%>
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
						<%} %></p></p>
						</div>
					</div> <!-- end .table-cells -->
				</div> <!-- end .table-row -->						
				</c:forEach>
			</div> <!-- end .jobs-table -->
		</div> <!-- end .container -->
	</div> <!-- end .inner -->
</div> <!-- end .section -->

<!-- Latest News Section -->
<div class="section Latest-news-section">
	<div class="inner">
		<div class="container">
			<div class="section-top-content flex items-center">
				<h1>Latest News</h1>
			</div> <!-- end .section-top-content -->
			<div class="news-grid">
				<div class="news-grid-row flex space-between">
					<c:forEach items="${newslist }" var="n">
					  <div class="news-item">
						<img src="/static/${n.nimg}" />
						<div class="news-content">
							<div class="news-meta flex no-column">
								<h6><a href="#0" class="news-author">发布日期</a></h6>
								<h6 class="publish-date">${n.ntimes}</h6>
							</div> <!-- end .news-meta -->
							<h6><a href="#0" class="news-author">标题</a></h6>
							<h3 class="news-title">${n.ntitle}</h3>
							<h6><a href="#0" class="news-author">内容</a></h6>
							<p class="news-excerpt">${n.ncontent}</p>
							
						</div> <!-- end .news-content -->
					</div> <!-- end .news-item -->
					</c:forEach>
					
				</div>  <!-- end .news-grid-row -->						
			</div> <!-- end .news-grid -->
		</div> <!-- end .container -->	
	</div> <!-- end .inner -->
</div> <!-- end .section -->

<%-- <!-- Clients Section -->
<div class="section clients-section solid-grey-bg">
	<div class="inner">
		<div class="container">
			<h1 class="section-title">Clients & Partners</h1>
			<div class="logo-grid">
				<div class="logo-grid-row flex space-between">
					<div class="logo-item flex">
						<img src="${pageContext.request.contextPath}/test/images/client-logo01.png" alt="client-company-logo" class="img-responsive self-center">
					</div> <!-- end .logo-item -->
					<div class="logo-item flex">
						<img src="${pageContext.request.contextPath}/test/images/client-logo02.png" alt="client-company-logo" class="img-responsive self-center">
					</div> <!-- end .logo-item -->
					<div class="logo-item flex">
						<img src="${pageContext.request.contextPath}/test/images/client-logo03.png" alt="client-company-logo" class="img-responsive self-center">
					</div> <!-- end .logo-item -->							
					<div class="logo-item flex">
						<img src="${pageContext.request.contextPath}/test/images/client-logo04.png" alt="client-company-logo" class="img-responsive self-center">
					</div> <!-- end .logo-item -->
					<div class="logo-item flex">
						<img src="${pageContext.request.contextPath}/test/images/client-logo05.png" alt="client-company-logo" class="img-responsive self-center">
					</div> <!-- end .logo-item -->							
					<div class="logo-item flex">
						<img src="${pageContext.request.contextPath}/test/images/client-logo06.png" alt="client-company-logo" class="img-responsive self-center">
					</div> <!-- end .logo-item -->
				</div> <!-- end .logo-grid-row -->
			</div> <!-- end .logo-grid -->
		</div> <!-- end .container -->
	</div> <!-- end .inner -->
</div> <!-- end .section -->

<!-- CTA App Section -->
<div class="section cta-app-section solid-blue-bg">
	<div class="inner">
		<div class="container">
			<div class="cta-app-section-inner flex space-between items-center">
				<div class="left">
					<h2 class="light">Don't want to miss a thing?</h2>
					<p class="large">Just go to<span>AppStore</span>&<span>Google Play</span>to download<span>JobPress Mini</span></p>		
				</div> <!-- end .left -->
				<div class="button-group flex no-column">
					<a href="#0" class="button white">Google Play</a>
					<a href="#0" class="button white">Apple Store</a>
				</div> <!-- end .button-group -->
			</div> <!-- end .cta-app-section-inner -->
		</div> <!-- end .container -->
	</div> <!-- end .inner -->
</div> <!-- end .section -->

<!-- Footer -->
<div class="section footer transparent" style="background-image: url('${pageContext.request.contextPath}/test/images/background03.jpg');">
	<div class="container">
		<div class="top flex space-between items-center">
			<img src="${pageContext.request.contextPath}/test/images/footer-logo.png" alt="footer-logo" class="img-responsive">
			<ul class="list-unstyled footer-menu flex">
				<li><a href="#0">Home</a></li>
				<li><a href="#0">About</a></li>
				<li><a href="#0">Browse Jobs</a></li>
				<li><a href="#0">Browse candidates</a></li>
				<li><a href="#0">Contact</a></li>
			</ul> <!-- end .footer-menu -->				
		</div> <!-- end .top -->
		<div class="footer-widgets flex no-column space-between">					
			<div class="widget">
				<h6>About</h6>
				<ul class="list-unstyled">
					<li><a href="#0">Company</a></li>
					<li><a href="#0">Our Partners</a></li>
					<li><a href="#0">Blog</a></li>
					<li><a href="#0">FAQ</a></li>
					<li><a href="#0">Pricing</a></li>
					<li><a href="#0">Help Center</a></li>
					<li><a href="#0">Team</a></li>
					<li><a href="#0">Contact Us</a></li>
				</ul>
			</div> <!-- end .widget -->
			<div class="widget">
				<h6>For candidates</h6>
				<ul class="list-unstyled">
					<li><a href="#0">Browse Jobs</a></li>
					<li><a href="#0">Browse categories</a></li>
					<li><a href="#0">Submit Resume</a></li>
					<li><a href="#0">Candidate Dashboard</a></li>
					<li><a href="#0">Job Alerts</a></li>
					<li><a href="#0">My Bookmarks</a></li>
				</ul>
			</div> <!-- end .widget -->
			<div class="widget">
				<h6>For companies</h6>
				<ul class="list-unstyled">
					<li><a href="#0">Browse Candidates</a></li>
					<li><a href="#0">Company Dashboard</a></li>
					<li><a href="#0">Add A Job</a></li>
					<li><a href="#0">Packages</a></li>
				</ul>
			</div> <!-- end .widget -->
			<div class="widget">
				<h6>Follow us</h6>
				<ul class="list-unstyled social-icons flex no-column">
					<li><a href="#0"><i class="ion-social-twitter"></i></a></li>
					<li><a href="#0"><i class="ion-social-facebook"></i></a></li>
					<li><a href="#0"><i class="ion-social-youtube"></i></a></li>
					<li><a href="#0"><i class="ion-social-instagram"></i></a></li>
					<li><a href="#0"><i class="ion-social-linkedin"></i></a></li>
				</ul>				
				<h6>Subscribe Us</h6>
				<p>Morbi in ligula nibh. Maecenas ut mi at odio hendrerit eleifend tempor vitae augue.</p>
				<form class="form-inline subscribe-form flex no-column no-wrap items-center">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Your email">
					</div> <!-- end .form-group -->
					<button type="submit" class="button"><i class="ion-ios-arrow-thin-right"></i></button>
				</form>
			</div> <!-- end .widget -->
		</div> <!-- end .footer-widgets -->
		<div class="bottom flex space-between items-center">
			<p class="copyright-text small">Copyright &copy; 2017.Company name All rights reserved.<a target="_blank" href="http://www.aspku.com/moban/">&#x7F51;&#x9875;&#x6A21;&#x677F;</a></p>
			<ul class="list-unstyled copyright-menu flex no-column">
				<li><a href="#0">Privacy policy</a></li>
				<li><a href="#0">Terms of service</a></li>
				<li><a href="#0">Conditions</a></li>
			</ul> <!-- end .copyright-menu -->
		</div> <!-- end .bottom -->
	</div> <!-- end .container -->
</div> <!-- end .footer -->

 --%>
<!-- Scripts -->
<!-- jQuery -->		
<script src="${pageContext.request.contextPath}/test/js/jquery-3.1.1.min.js"></script>
<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/test/js/bootstrap.min.js"></script>
<!-- Owl Carousel -->
<script src="${pageContext.request.contextPath}/test/js/owl.carousel.min.js"></script>
<!-- Wow.js -->
<script src="${pageContext.request.contextPath}/test/js/wow.min.js"></script>
<!-- Typehead.js -->
<script src="${pageContext.request.contextPath}/test/js/typehead.js"></script>
<!-- Tagsinput.js -->
<script src="${pageContext.request.contextPath}/test/js/tagsinput.js"></script>
<!-- Bootstrap Select -->
<script src="${pageContext.request.contextPath}/test/js/bootstrap-select.js"></script>		
<!-- Waypoints -->
<script src="${pageContext.request.contextPath}/test/js/jquery.waypoints.min.js"></script>
<!-- CountTo -->
<script src="${pageContext.request.contextPath}/test/js/jquery.countTo.js"></script>
<!-- Isotope -->
<script src="${pageContext.request.contextPath}/test/js/isotope.pkgd.min.js"></script>
<script src="${pageContext.request.contextPath}/test/js/imagesloaded.pkgd.min.js"></script>
<!-- Magnific-Popup -->
<script src="${pageContext.request.contextPath}/test/js/jquery.magnific-popup.js"></script>
<!-- Scripts.js -->
<script src="${pageContext.request.contextPath}/test/js/scripts.js"></script>

</body>
</html>