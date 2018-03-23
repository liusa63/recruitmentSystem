<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工作经历</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript">
	  function expsub(){
		  
		  var ecompany=$("#ecompany").val();
		  var etimes=$("#etimes").val();
		  var epost=$("#epost").val();
		  if(ecompany!=null && ecompany != "" && etimes!=null && etimes != "" && epost!=null && epost != ""){
			  $("#expform").submit();
			  
		  }else{
			  
			  alert("请完成带*项");
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
			<% 
			
			String msg=(String)request.getAttribute("msg");
			if(msg!=null){
				%>
				<%=msg %>
				<% 
			}
			%>
				<li>
					<form  id="expform" action="AddExperienceSuccessServlet?uid=<%=uid %>" method="post">
					<table  width="500px;" height="400px;" style="margin-top: 20px; text-align: left; ">
						<tr>
							<td><span style="color:red;">*</span>曾&nbsp;任&nbsp;职&nbsp;公&nbsp;司:<input type="text" name="ecompany" id="ecompany" /></td>
						</tr>
						<tr>
							<td><span style="color:red;">*</span>任&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;期:<input type="text" name="etimes" id="etimes" /></td>
						</tr>
						<tr>
						    <td><span style="color:red;">*</span>职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位:<input type="text" name="epost" id="epost" /></td>
						</tr>
						<tr>
							<td>介&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;绍:<input type="text" name="edes" id="edes" /></td>
						</tr>
						<tr>
							<td><input type="button" value="提交" onclick="expsub();"  style="border-style : none; color:blue;border-radius:20px;width:60px;  margin-left: 500px;" />
							<input type="button" value="返回" onclick="window.history.go(-1);" style="border-style : none; color:blue;border-radius:20px;width:60px;height:50px; margin-left:600px; margin-top:-50px; "/></td>
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