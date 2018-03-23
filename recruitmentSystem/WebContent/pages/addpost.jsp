<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加岗位</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript">
	  function postsub(){
		 /*  $("#input").val(id); */
		 var rpost=$("#rpost").val();
		 var rask=$("#rask").val();
		 var rsalary=$("#rsalary").val();
		 if((rpost != null && rpost !="")&&(rask != null && rask !="")&&(rsalary != null && rsalary !="")){
			 $("#postform").submit(); 
		 }else{
			 alert("请完善信息再提交");
		 }
		 
	  }
	</script>
	
	</head>
<body>
<%@include file="Top1.jsp"%>

<%-- <form action="${pageContext.request.contextPath}/AddPostServlst" method="post" id="addpostform" style="display:none">
  <input type="text" name="uid" id="input" >
</form>  --%>

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
					<form  id="postform" action="${pageContext.request.contextPath }/AddPostServlet?uid=<%=uid %>" method="post">
					<table  width="1000px;" height="400px;" style="margin-top: 20px; text-align: left; ">
						<tr>
							<td><span style="color:red;">*</span>职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位:<input type="text" name="rpost" id="rpost" style="width:800px;"/></td>
						</tr>
						<tr>
							<td><span style="color:red;">*</span>要&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;求:<input type="text" name="rask" id="rask"  style="width:800px;"/></td>
						</tr>
						<tr>
							<td><span style="color:red;">*</span>薪&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;资:<input type="text" name="rsalary" id="rsalary" style="width:800px;" /></td>
						</tr>
						<tr>
							<td><input type="button" value="提交" onclick="postsub();" style="width:60px;height:40px;border-style : none; color:blue;border-radius:20px; margin-left: 700px;" />
							<input type="button" value="返回" onclick="window.history.go(-1);" style="border-style : none; color:blue;border-radius:20px;margin-top:-40px; margin-left:800px; width:60px;height:40px;" />
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