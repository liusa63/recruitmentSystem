<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>


<title>注册(register)</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="stylesheet" href="assets/css/reset.css">
<link rel="stylesheet" href="assets/css/supersized.css">
<link rel="stylesheet" href="assets/css/style.css">
<script type="text/javascript">
	//验证用户名，用户手机号，密码和确认密码不为空
	var ids = "username,userphone,password,repassword";
	var msgs = "请输入您的用户名,请输入您的手机号,请输入您的密码,请确认密码";

	function checkNulls(ids, msgs) {
		var idArray = ids.split(",");
		var msgArray = msgs.split(",");
		for ( var i = 0; i < idArray.length; i++) {
			var v = $("#" + idArray[i]).val();
			if (v == "") {
				$("#" + idArray[i] + "Error").html(msgArray[i]);
				return false;
			}
		}
		return true;
	}

	//验证用户名不能重复
	function ajaxcheckName() {
		var username = $("#username").val();
		var flag = true;
		$.ajax({
			type : "POST",//请求方式
			//异步刷新
			async : false,
			url : "AjaxCheckUsernameServlet",//访问地址
			data : "username=" + username,//传递参数
			success : function(data) {//请求成功后的回调函数，Servlet中通过out.print
				/* alert( data );  */
				if (data == "fail") {
					$("#usernameError").html("用户名已经存在，请重新输入");
					flag = false;
				}
			}
		});
		return flag;
	}
	//验证手机号的正确格式
	function checkPhone() {
		var reg = /^[1][3-8][0-9]{9}$/;
		var userphone = $("#userphone").val();
		if (reg.test(userphone)) {
			return true;
		} else {
			$("#userphoneError").html("请输入正确格式的手机号");
			return false;
		}
	}

	//验证手机号不能重复
	function ajaxcheckUserPhone() {
		var userphone = $("#userphone").val();
		var flag = true;
		$.ajax({
			type : "POST",//请求方式
			//异步刷新
			async : false,
			url : "AjaxCheckUserPhoneServlet",//访问地址
			data : "userphone=" + userphone,//传递参数
			success : function(data) {//请求成功后的回调函数，Servlet中通过out.print
				/* alert( data );  */
				if (data == "fail") {
					$("#userphoneError").html("该手机号已被注册，请重新输入");
					flag = false;
				}
			}
		});
		return flag;
	}
	
	//验证两次密码一致
	function checkDoupwd(){
		var pwd=$("#password").val();
		var repwd=$("#repassword").val();
		if(pwd==repwd){
			return true;
		}else{
			$("#repasswordError").html("两次密码不一致，请重新输入");
			return false;
		}
		
	}

	//验证用户状态
	function checkStatus() {
		var flag=false;
		var status = $(":radio:checked").val();
		if (status == undefined) {
			$("#statusError").html("请选择用户的状态");
		}else{
			flag=true;
		}
		return flag;
	}
	
	function register() {
		 if (checkNulls(ids, msgs) && ajaxcheckName() && checkPhone()
				&& ajaxcheckUserPhone() && checkDoupwd() && checkStatus()) {
			$("#registerFrom").submit();
		}
	}

	function testFocus(id) {
		$("#" + id).val("");
		$("#" + id + "Error").html("");
	}

	function testBlur(id, msg) {
		if ($("#" + id).val() == "") {
			$("#" + id + "Error").html(msg);
		}
	}
</script>
</head>

<body>

	<div class="page-container">
		<h1>注册(register)</h1>
		<form action="RegisterServlet" method="post" id="registerFrom">
			<input type="text" name="username" id="username" class="username"value="请输入您的用户名！"
			    onfocus="testFocus('username')"onblur="testBlur('username','请输入您的用户名')"> 
			<span style="color=red" id="usernameError"></span>
			<input type="text" name="userphone" id="userphone" class="username" value="请输入您的手机号！"
				onfocus="testFocus('userphone')" onblur="testBlur('userphone','请输入您的手机号')">
			<span style="color=red" id="userphoneError"></span> 
			<input type="password" name="password" id="password" class="password" value="请输入您的密码！"
				onfocus="testFocus('password')" onblur="testBlur('password','请输入您的密码')">
			<span style="color=red" id="passwordError"></span> 
			<input type="password"name="repassword" id="repassword" value="请确认密码！"
				onfocus="testFocus('repassword')" onblur="testBlur('repassword','请确认密码')"> 
			<span style="color=red" id="repasswordError"></span>
			 <br>
			<input type="radio" name="status"  value="0" class="ra" style="height:20px;">
			<input type="radio" name="status"  value="1" class="ra" style="height:20px;">
		           个人用户&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 企业用户
			<br>
			<span style="color=red" id="statusError"></span>
			<!-- 提示消息没法清除 -->
			<button type="button" class="button"  onclick="register()">注册</button>
			<button type="reset" >重置</button>
		</form>
	</div>

	<!-- Javascript -->
	<script src="assets/js/jquery-1.8.2.min.js"></script>
	<script src="assets/js/supersized.3.2.7.min.js"></script>
	<script src="assets/js/supersized-init.js"></script>
	<script src="assets/js/scripts.js"></script>
</html>