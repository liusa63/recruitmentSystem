<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改工作经验</title>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript">
	  function expsub(){
		
		  $("#expform").submit();
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
					<form  id="expform" action="UpdateExperienceSuccessServlet?uid=<%=uid %>&eid=${exp.eid}" method="post">
					<table  width="500px;" height="400px;" style="margin-top: 20px; text-align: left; ">
						<tr>
							<td>曾&nbsp;任&nbsp;职&nbsp;公&nbsp;司:<input type="text" name="ecompany" id="ecompany"  value="${exp.ecompany }"/></td>
						</tr>
						<tr>
							<td>任&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;期:<input type="text" name="etimes" id="etimes" value="${exp.etimes }" /></td>
						</tr>
						<tr>
						    <td>职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位:<input type="text" name="epost" id="epost" value="${exp.epost }" /></td>
						</tr>
						<tr>
							<td>介&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;绍:<input type="text" name="edes" id="edes" value="${exp.edes }"/></td>
						</tr>
						<tr>
							<td><input type="button" value="完成" onclick="expsub();"  style="border-style : none; color:blue;border-radius:20px;width:60px; margin-left: 500px;" /></td>
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