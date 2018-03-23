<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜查岗位</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<%@include file="Top1.jsp"%>
	
<script type="text/javascript">
 function searchsub(){
	 
	  var searchtype=$("#searchtype>option:selected").val();
	  var rpost=$("#rpost").val();
	  if(rpost != null && rpost!=""){
		
		window.location.href="${pageContext.request.contextPath}/SearchPostServlet?uid="+<%=uid%>+"&searchtype="+searchtype+"&rpost="+rpost;
	  }
 }
	 </script>

</head>
<body>

			
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
						<input type="text" class="form-control" name="rpost"  id="rpost" style="width: 476px;z-index: 999; position: absolute;right: 260px;"><!--  placeholder="city / province "> -->
						<i class="ion-ios-location-outline"></i>
					<input type="button"  class="button" onclick="searchsub();" value="搜索" style="margin-right:180px; width:70px;height:50px;">
				</form>
			</div> <!-- end .job-search-form -->	

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
				
				<%String msg=(String) request.getAttribute("msg");
				if(msg!=null){
					%>
					<%=msg %>
					<% 
				}
				%>
				
				<c:forEach items="${searchlist}" var="s">
				<div class="table-row">
					<div class="table-cells flex no-wrap">
						<div class="cell job-title-cell flex no-column no-wrap">
							<div class="cell-mobile-label">
								<h6>公司名称</h6>
							</div> <!-- end .cell-label -->
							<img src="${pageContext.request.contextPath}/test/images/company-logo02.jpg" alt="company-logo" class="img-responsive">
							<div class="content">
								<h4><a href="#">${s.cname}</a></h4>
								<p class="small">Conpany Name</p>
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
							<a href="SearchDeliveryResumeServlet?uid=<%=uid%>&pid=${s.pid}&dstatus=1">投递简历</a>
						</c:if>
						<%} %></p>
						</div>
					</div> <!-- end .table-cells -->
				</div> <!-- end .table-row -->
               </c:forEach>
</div> <!-- end .jobs-table -->
<div class="section hero-section transparent" style="background-image: url('${pageContext.request.contextPath}/test/images/background01.jpg');">
	<div class="inner">
		<div class="container">
			<div class="job-search-form">
				<h2>Over<span>100,000<sup>+</sup></span>jobs are waiting for you</h2>
				
				
				
				
			
				
				
				
				
				
				
				
				
				
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




</body>
</html>