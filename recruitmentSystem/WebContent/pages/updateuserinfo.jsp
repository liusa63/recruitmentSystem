<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改简历</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript">
	  function updateUser(){
		  
		  
		  var name=$("#relname").val();
		  if(name != null && name !=""){
			  $("#updateform").submit();
		  }else{
			  alert("请至少填写姓名");
		  }
		 
	  }
	  
	  
	</script>
	</head>
	<body>
	<%@include file="Top1.jsp"%>
		
		
		
	<ul class="animate-box fadeInUp animated-fast" style="margin-left:200px;">
				<li>
					<form  id="updateform" action="UpdateResumeServlet?rid=${resume.rid}&uid=<%=uid %>" method="post" enctype="multipart/form-data">
					<table  width="500px;" height="400px;" style="margin-top: 20px; text-align: left; ">
						<tr>
							<td>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:<input type="text" name="relname" id="relname" value="${resume.rname }" /></td>
						</tr>
						<tr>
							<td>照&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;片:
							<img  src="/static/${resume.rpic }"  style="width:80px; height:80px;" />
							<input type="file"  id="upload" name="changepic"/>
							</td>
						</tr>
						<tr>
							<td>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄:<input type="text" name="rage" id="rage" value="${resume.rage }"/></td>
						</tr>
						<tr>
						    <td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:<input type="text" name="rsex" id="rsex" value="${resume.rsex }"/></td>
						</tr>
						<tr>
							<td>手&nbsp;&nbsp;&nbsp;机&nbsp;&nbsp;号:<input type="text" name="rphone" id="rphone" value="${resume.rphone }"/></td>
						</tr>
						<tr>
							<td>电&nbsp;子&nbsp;邮&nbsp;箱:<input type="text" name="remail" id="remail" value="${resume.remail }"/></td>
						</tr>	
						<tr>
							<td>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;历:<input type="text" name="reducation" id="reducation" value="${resume.reducation}"/></td>
						</tr>
						<tr>
							<td>岗&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位:<input type="text" name="rwant" id="rwant" value="${resume.rwant}"/></td>
						</tr>
					</table>
					</form>
				</li>
			</ul>	
	<ul>
		<li><input type="button" value="保存"  onclick="updateUser();" style="border-style : none; color:blue;border-radius:20px;   width:60px;margin-left: 750px;margin-top:-50px; " /></li>
		<li><input type="button" value="返回"  onclick="window.history.go(-1);" style="border-style : none; color:blue;border-radius:20px; width:60px;margin-top:-73px;  margin-left: 850px;" /></li>
		</ul>
		<div  style="height:200px; width:200px;">
		</div>
		
	</body>
</html>