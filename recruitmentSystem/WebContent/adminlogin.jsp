<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html lang="en" class="no-js">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>招聘系统---登录页面</title>
<link rel="stylesheet" href="assets/css/reset.css">
<link rel="stylesheet" href="assets/css/supersized.css">
<link rel="stylesheet" href="assets/css/style.css">
<script src="assets/js/jquery-1.8.2.min.js"></script>
<script src="assets/js/supersized.3.2.7.min.js"></script>
<script src="assets/js/supersized-init.js"></script>
<script src="assets/js/scripts.js"></script>
<script src="assets/js/html5.js"></script>
<script type="text/javascript">
	var ids = "username,password";
	var msg = "请输入用户名,请输入密码";

	//非空验证
	function checkNull(ids, msg) {
		var idArray = ids.split(",");
		var msgArray = msg.split(",");
		for ( var i = 0; i < idArray.length; i++) {
			var id = $("#" + idArray[i]).val();
			//如果为空，给出错误提示
			if (id == "") {
				$("#" + idArray[i] + "Error").html(msgArray[i]);
				return false;
			}
		}
		return true;
	}//登录
	function loginfun() {
		//判断用户名和密码是否为空
		if (checkNull(ids, msg)) {
			$("#loginform").submit();
		}
	}

	//页面加载完成触发的事件
	$(document).ready(function() {
		//设置获取焦点触发的事件：错误提示消失
		$("#username").focus(function() {
			$("#username").val("");
			$("#usernameError").html("");
		});
		$("#password").focus(function() {
			$("#password").val("");
			$("#passwordError").html("");
		});

		//失去焦点触发的事件：判断内容是否为空，若为空给出错误提示
		$("#username").blur(function() {
			var u = $("#username").val();
			if (u == "") {
				$("#usernameError").html("用户名不能为空");
			}
		});
		$("#password").blur(function() {
			var u = $("#password").val();
			if (u == "") {
				$("#passwordError").html("密码不能为空");
			}
		});
	});
</script>

</head>

<body>

	<div class="page-container">
		<h1>管理员登录(AdminLogin)</h1>

		<form action="${pageContext.request.contextPath}/AdminLoginServlet"
			method="post" id="loginform">
			<input type="text" name="username" id="username" class="username" value="请输入管理员名称！"> <span id="usernameError"></span>
			 <input type="password" name="password" id="password" class="password" value="请输入密码！"> <span id="passwordError"></span>
			<%
				String msg = (String) request.getAttribute("msg");
				if (msg != null) {
			%>
			<%=msg%>
			<%
				}
			%>
			<button type="button" class="submit_button" onclick="loginfun();" />
			登录
			</button>
		</form>
	</div>

</body>

</html>
