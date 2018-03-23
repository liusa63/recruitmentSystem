<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人</title>
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
	table  td{
	  width:250px;
	}
	</style>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<%@include file="Top1.jsp"%>
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
					  window.location.href="${pageContext.request.contextPath}/UserListServlet?uid="+<%=uid%>+"&currentPage="+gopage;
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
				<c:forEach items="${mylist}" var="s">
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
							<p>
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
						</p>
						</div>
					</div> <!-- end .table-cells -->
				</div> <!-- end .table-row -->
               </c:forEach>
			</div> <!-- end .jobs-table -->
			<% String msg=(String)request.getAttribute("msg"); 
			if (msg!=null){
				%>
				
				<%=msg %>
				<%
			}
			%>
			
			
		  <%
	  }
	%>
	
	
	
<!-- 企业用户看到的信息	 -->
<%  if(ustatus.equals("1")){%>	
<div class="jobs-table">
				<div class="table-header">
					<div class="table-cells flex">
						<div class="job-title-cell"><h6> User name</h6></div>
						<div class="job-type-cell"><h6>Education</h6></div>
						<div class="location-cell"><h6>Job intention</h6></div>
						<div class="expired-date-cell"><h6>Details</h6></div>
						<div class="salary-cell"><h6>Operating</h6></div>					
					</div> <!-- end .table-cells -->
				</div> <!-- end .table-header -->
				<c:forEach items="${userPage.list}" var="s">
				<div class="table-row">
					<div class="table-cells flex no-wrap">
						<div class="cell job-title-cell flex no-column no-wrap">
							<div class="cell-mobile-label">
								<h6>姓名</h6>
							</div> <!-- end .cell-label -->
							<img src="${pageContext.request.contextPath}/test/images/company-logo02.jpg" alt="company-logo" class="img-responsive">
							<div class="content">
								<h4><a href="#">${s.rname}</a></h4>
								<p class="small">real  name</p>
							</div> <!-- end .content -->
						</div> <!-- end .job-title-cell -->
						<div class="cell job-type-cell flex no-column">
							<div class="cell-mobile-label">
								<h6>学历</h6>
							</div> <!-- end .cell-label -->
							<button type="button" class="button part-time">${s.reducation}</button>
						</div>
						<div class="cell location-cell flex no-column no-wrap">
							<div class="cell-mobile-label">
								<h6>求职意向</h6>
							</div> <!-- end .cell-label -->
							<p>${s.rwant}</p>
						</div>
						<div class="cell expired-date-cell flex no-column no-wrap">
							<div class="cell-mobile-label">
								<h6>详情</h6>
							</div> <!-- end .cell-label -->
							<p><a href="${pageContext.request.contextPath}/ResumeDetailServlet?uid=${s.uid}">详情</a>&nbsp;&nbsp;</p>
						</div>
						<div class="cell salary-cell flex no-column no-wrap">
							<div class="cell-mobile-label">
								<h6>操作</h6>
							</div> <!-- end .cell-label -->
							<p>
							<span style="color: white">|</span>&nbsp; 
							       <c:if  test="${s.dstatus==1}">
								       <a href="javascript:void(0);">已投递&nbsp;&nbsp;</a>&nbsp;&nbsp;
								    </c:if>
								    <c:if  test="${s.dstatus==0}">
								       <a href="javascript:void(0);">已邀请&nbsp;&nbsp;</a>&nbsp;&nbsp;
								    </c:if>
							        <c:if test="${s.dstatus==null}">
							            <a href="ChoosePostListServlet?uid=<%=uid%>&rid=${s.rid}">邀请</a>&nbsp;&nbsp;
							        </c:if>
							</p>
						</div>
					</div> <!-- end .table-cells -->
				</div> <!-- end .table-row -->
               </c:forEach>
               <div class="table-footer flex space-between items-center">
					<h6>Showing<span>1-5</span>of 23 jobs</h6>
					<div class="jobpress-custom-pager list-unstyled flex space-between no-column items-center">
						<a href="${pageContext.request.contextPath}/UserListServlet?currentPage=1&uid=<%=uid%>" class="button">首页</a>
						<c:if test="${userPage.currentPage>1}">
						<a href="${pageContext.request.contextPath}/UserListServlet?currentPage=${userPage.currentPage-1}&uid=<%=uid%>" class="button"><i class="ion-ios-arrow-left"></i>Prev</a>
						</c:if>
						<ul class="list-unstyled flex no-column items-center">
							<li>
							第
							${userPage.currentPage}
							页  &nbsp;&nbsp;
							</li>
							<li>
							共${userPage.totalNum }条 共${userPage.countPage}页 
		                    </li>
						</ul>
						<c:if test="${userPage.currentPage<userPage.countPage}">
						<a href="${pageContext.request.contextPath}/UserListServlet?currentPage=${userPage.currentPage+1}&uid=<%=uid%>" class="button">Next<i class="ion-ios-arrow-right"></i></a>
					    </c:if>
					    <a href="${pageContext.request.contextPath}/UserListServlet?currentPage=${userPage.countPage}&uid=<%=uid%>" class="button">尾页</a>
					    <input type="text" id="jump" style="margin-right: 10px; padding: 2px; width: 30px; height:30px; border-radius: 3px; border: 1px solid rgba(128, 128, 128, 0.46);" />
					    <a  onclick="jumpfun();" class="button" >跳转</a><br><br>
	                    
					</div> <!-- end .jobpress-custom-pager -->
					
				</div>
				<span id="pageError" style="color: red; margin-left: 1100px;"></span>
			</div> <!-- end .jobs-table -->
<% }%>


</body>
</html>