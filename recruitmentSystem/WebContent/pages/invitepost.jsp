<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择邀请岗位</title>
	<style type="text/css">
	a {
	text-decoration: none;
	color: #b9b7c1;
	}
	</style>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript">
	 function invitesub(){
		 var v=$('input:radio[name="pid"]:checked').val();
		  if(v==null){
				 alert("请选择岗位");
		 }else{
			 $("#inviteform").submit();
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
			 <form id="inviteform" method="post" action="InviteServlet">
			  <c:forEach  items="${list}" var="l">
			  <li  style="margin-top:50px; margin-left:100px;">
			  <input type="radio" name="pid"  value="${l.pid}"/>${l.rpost}
			  </li>
			  </c:forEach>
			  <input type="text" name="uid" value="<%=uid%>" style="display:none"/>
			  <input type="text" name="rid"  value="${rid}" style="display:none"/>
			  <input type="text" name="dstatus" value="0" style="display:none"/>
			</form>
                <li  style="margin-top:70px; margin-left:300px;"> 
                 <input type="button" value="确认" onclick="invitesub();" style="width:60px;height:40px;border-style : none; color:blue;border-radius:20px;"/>
                 <input type="button" value="返回" onclick="window.history.go(-1)" style="width:60px;height:40px;margin-top:-40px; margin-left:100px;border-style : none; color:blue;border-radius:20px;"/>
                  </li>
			   </ul>
       </div>
    </div>
</div>


</body>
</html>