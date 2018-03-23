<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>填写个人简历</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript">
	  function usersub(){
		  var name=$("#relname").val();
		  if(name != null && name !=""){
			  $("#resumeform").submit();
		  }else{
			  alert("请至少填写姓名");
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
			<%String msg=(String)request.getAttribute("msg");
			if(msg!=null){
				%>
				<%=msg %>
				<%
			}
			%>
				<li>
					<form  id="resumeform" action="AddResumeServlet?uid=<%=uid %>" method="post" enctype="multipart/form-data">
					<table  width="500px;" height="400px;" style="margin-top: 20px; text-align: left; ">
						<tr>
							<td><span style="color:red;">*</span>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:
							<input class="fontColor" type="text" name="relname" id="relname" style="width:500px;"/></td>
						</tr>
						<tr>
							<td>照&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;片:<input type="file" name="rpic" id="upload" style="width:500px;"/></td>
						</tr>
						<tr>
							<td>照&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;片:<input type="file" name="rpic" id="upload" multiple="multiple" style="width:500px;"/></td>
						</tr>
					
						<tr>
							<td>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄:<input type="text" name="rage" id="rage" style="width:500px;"/></td>
						</tr>
						<tr>
						    <td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:<input type="text" name="rsex" id="rsex" style="width:500px;"/></td>
						</tr>
						<tr>
							<td>手&nbsp;&nbsp;&nbsp;机&nbsp;&nbsp;号:<input type="text" name="rphone" id="rphone" style="width:500px;"/></td>
						</tr>
						<tr>
							<td>电&nbsp;子&nbsp;邮&nbsp;箱:<input type="text" name="remail" id="remail" style="width:500px;"/></td>
						</tr>	
						<tr>
							<td>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历:<input type="text" name="reducation" id="reducation"style="width:500px;" /></td>
						</tr>
						<tr>
							<td>岗&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位:<input type="text" name="rwant" id="rwant" style="width:500px;"/></td>
						</tr>
						<tr>
							<td>
							<input type="button" value="保存" onclick="usersub();"  style="border-style : none; color:blue;border-radius:20px;width:140px; margin-left:600px;" />
							</td>
						</tr>
					</table>
					
					</form>
					<div style="height:100px">
					
					</div>
				</li>
			</ul>
		  </div>
	  </div>
   </div>
</body>
</html>