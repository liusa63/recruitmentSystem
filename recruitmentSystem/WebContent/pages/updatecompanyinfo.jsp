<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改企业信息</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript">
	  function comsub(){
		  $("#comform").submit();
	  }
	</script>
	
	</head>
	<body>
	<%@include file="Top1.jsp"%>
		<div id="home" class="banner">
	<div class="container">
		<div  id="top" class="callbacks_container">
			<ul class="rslides">
				<li>
				<!-- 获取到session中用户的id值 -->
					<form  id="comform" action="${pageContext.request.contextPath}/UpdateCompanySuccessServlet?uid=<%=uid %>" method="post">
					<table  width="1000px;" height="400px;" style="margin-top: 20px; text-align: left; ">
						<tr>
							<td>公&nbsp;&nbsp;&nbsp;司&nbsp;&nbsp;名:<input type="text" name="cname" id="cname" value="${com.cname}" style="width:800px;"/></td>
						</tr>
						<tr>
							<td>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址:<input type="text" name="caddress" id="caddress" value="${com.caddress}" style="width:800px;" /></td>
						</tr>
						<tr>
							<td>介&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;绍:<textarea cols="5" rows="5"  name="cintroduce" id="cintroduce" style="width:800px; color:black;">${com.cintroduce}</textarea></td>
						</tr>
						<tr>
						    <td>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话:<input type="text" name="cphone" id="cphone" value="${com.cphone}"style="width:800px;"/></td>
						</tr>
						<tr>
							<td>
							<input type="button" value="保存" onclick="comsub();" style="margin-top:30px; margin-left: 600px; width:60px;height:40px;border-style : none; color:blue;border-radius:20px; " />
							<input type="button" value="返回" onclick="window.history.go(-1);" style="margin-top:-40px; margin-left:800px; width:60px;height:40px;border-style : none; color:blue;border-radius:20px;" />
							</td>
						</tr>
					</table>
					</form>
				</li>
			</ul>
		  </div>
	  </div>
   </div>
		
	</body>
</html>