<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<%@include file="Top1.jsp"%>
<script type="text/javascript">
function  onsub(){
	
	  var name=$("#contact-name").val();
	  var email=$("#contact-email").val();
	  var msg=$("#contact-message").val();
	  
	if((name!=null && name != "")&& (email!=null && email != "")&&(msg!=null && msg != "")){
		alert("提交成功，请等待管理员回复");
		
		window.location.href="${pageContext.request.contextPath}/ContactServlet?uid="+<%=uid%>+"&fname="+name+"&femail="+email+"&fmsg="+msg;
		
		
	}
	
	
	
}

</script>

</head>
<body>
<!-- Contact-Us Section -->
<div class="section contact-us-section">
	<div class="inner">
		<div class="container">
			<div class="contact-us-section-inner flex space-between no-wrap">
				<div class="left">
					<h1>Contact Us</h1>
					<p class="ultra-light">Pellentesque a massa risus. Cras convallis finibus porta. Integer in ligula leo. Cras quis consequat nisl, at malesuada sapien. Mauris ultricies nisi eget velit bibendum, sit amet euismod mi gravida.<br><br>Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Pellentesque non laoreet risus, id elementum purus.</p>
					<div class="follow-us flex no-column items-center">
						<h6>Follow us via:</h6>
						<ul class="list-unstyled social-icons flex no-column">
							<li><a href="#0"><i class="ion-social-twitter"></i></a></li>
							<li><a href="#0"><i class="ion-social-facebook"></i></a></li>
						</ul> <!-- end .social-icons -->
					</div> <!-- end .follow-us -->
				</div> <!-- end .left -->
				
				<div class="right">

					<form action="#" method="post" id="contact-form" class="contact-form">
						<div class="form-group-wrapper flex space-between items-center">
							<div class="form-group">
								<p class="label">Your Name*</p>
								<input type="text" id="contact-name" name="contact-name" placeholder="Enter your name" required="">
							</div> <!-- end .form-group -->
							<div class="form-group">
								<p class="label">Your Email*</p>
								<input type="email" id="contact-email" name="contact-email" placeholder="Enter your email" required="">
							</div> <!-- end .form-group -->
						</div> <!-- end .form-group-wrapper -->

							<div class="form-group textarea">
								<p class="label">Your Message*</p>
								<textarea name="contact-message" id="contact-message" required="" rows="6" placeholder="Here goes your message"></textarea>
							</div> <!-- end .form-group -->
							<button type="submit" class="button" onclick="onsub();">Send us</button>
														
						<div id="contact-loading" class="alert alert-info form-alert">
							<span class="message">Loading...</span>
						</div>
						<div id="contact-success" class="alert alert-success form-alert">
							<span class="message">Success!</span>
						</div>
						<div id="contact-error" class="alert alert-danger form-alert">
							<span class="message">Error!</span>
						</div>
					</form> <!-- end .contact-form -->
					
				</div> <!-- end .right -->
			</div>	<!-- end .contact-us-section-inner -->
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
				<form class="form-inline subscribe-form flex no-column no-wrap items-center" role="subscribe">
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


<!-- Scripts -->
<!-- jQuery -->		
<script src="${pageContext.request.contextPath}/test/js/jquery-3.1.1.min.js"></script>
<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/test/js/bootstrap.min.js"></script>
<!-- google maps -->
<script src="http://ditu.google.cn/maps/api/js?key=AIzaSyAy-PboZ3O_A25CcJ9eoiSrKokTnWyAmt8"></script>
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