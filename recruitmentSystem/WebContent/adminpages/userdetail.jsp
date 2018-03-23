<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<style type="text/css">
.tab1 {
	width: 400px;
	height: 500px;
	float: left;
}

</style>
</head>
<body>
	<div id="home" class="banner">
		<div class="container">
			<div id="top" class="callbacks_container">
				<!-- <div class="test"
					style="margin-left: 800px; background-color: red; width: 200px; height: 40px;">

					个人信息</div> -->
				<ul class="rslides">
					<div class="tab1">
						<table style="margin: 35px 50px;" id="userDetail">
							<tr>
								<td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</td>
								<td>${user.uname}</td>
							</tr>
							<tr>
								<td>用户身份：</td>
								<td>${user.ustatus eq 1?"企业":"个人"}</td>
							</tr>
							<tr>
								<td>照&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;片：</td>
								<td><img src="/static/${resume.rpic}" style="width:80px; height:80px;"/></td>
							</tr>
							<tr>
								<td>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：</td>
								<td>${resume.rage}</td>
							</tr>
							<tr>
								<td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</td>
								<td>${resume.rsex}</td>
							</tr>
							<tr>
								<td>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历：</td>
								<td>${resume.reducation}</td>
							</tr>
							<tr>
								<td>工作意向：</td>
								<td>${resume.rwant}</td>
							</tr>
							<tr>
								<td>手&nbsp;&nbsp;机&nbsp;&nbsp;号：</td>
								<td>${user.uphone}</td>
							</tr>
							<tr>
								<td>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</td>
								<td>${resume.remail}</td>
							</tr>
							<tr>
								<td>状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：</td>
								<td>${user.ubehave eq 1?"禁用":"启用"}</td>
							</tr>
							<tr>
								<td colspan="2"><input type="button" value="返回"
									onclick="window.history.go(-1);" /></td>
							</tr>
						</table>
					</div>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>