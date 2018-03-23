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
		  var cname=$("#cname").val();
		  var caddress=$("#caddress").val();
		  var cintroduce=$("#cintroduce").val();
		  var cphone=$("#cphone").val();
		  if((cname!=null && cname!="")&&(caddress!=null && caddress!="")&&(cintroduce!=null && cintroduce!="")&&(cphone!=null && cphone!="")){
			  
			  $("#comform").submit();
			  
		  }else{
			  alert("请完善信息后再提交");
		  }
	  }
	</script>
	
	</head>
	<body>
	<%@include file="Top1.jsp"%>
		<div id="home" class="banner">
	<div class="container">
		<div  id="top" class="callbacks_container">
		
		
			<ul class="rslides">
			<% String msg=(String)request.getAttribute("msg"); 
			 if(msg!=null){
				 %>
				 <%=msg %>
				 <%
			 }
			%>
				<li>
					<form  id="comform" action="${pageContext.request.contextPath}/AddCompanyServlet?uid=<%=uid %>" method="post">
					<table  width="500px;" height="400px;" style="margin-top: 20px; text-align: left; ">
						<tr>
							<td><span style="color:red;">*</span>公&nbsp;&nbsp;&nbsp;司&nbsp;&nbsp;名:<input type="text" name="cname" id="cname" /></td>
						</tr>
						<tr>
							<td><span style="color:red;">*</span>地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;址:<input type="text" name="caddress" id="caddress" /></td>
						</tr>
						<tr>
							<td><span style="color:red;">*</span>介&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;绍:<textarea cols="5" rows="5"  name="cintroduce" id="cintroduce"  style="width:800px; color:black;"></textarea></td>
						</tr>
						<tr>
						    <td><span style="color:red;">*</span>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话:<input type="text" name="cphone" id="cphone" /></td>
						</tr>
						<tr>
							<td><input type="button" value="提交" onclick="comsub();" style="width:60px;height:40px;border-style : none; color:blue;border-radius:20px; margin-left: 400px;" /></td>
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