<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.js"></script>
<style type="text/css">
.tab1 {
	width: 400px;
	height: 500px;
	float: left;
}
</style>
</head>
<body>
	<div id="home" class="banner">
		<div class="container">
			<div id="top" class="callbacks_container">
				
			<ul class="rslides">
					<div class="tab1">
						<table style="margin: 35px 50px;" id="newsDetail">
							<tr>
								<td>新闻标题：<input type="text" value="${news.ntitle}"/></td>
							</tr>
							<tr>
								<td>新闻内容：<textarea>${news.ncontent}</textarea></td>
							</tr>
							<tr>
								<td>新闻图片：<img src="/static/${news.nimg}">
								<input type="file" value=""></td>
							</tr>
							<tr>
								<td>发布时间：<input type="text" value="${news.ntimes}"/></td>
							</tr>
							<tr>
							    <td><a href="${pageContext.request.contextPath}/NewsDetailServlet?nid=${news.nid}">
							    <button type="button" >确定</button></a></td>
								<td><input type="button" value="返回"
									onclick="window.history.go(-1);" /></td>
							</tr>
						</table>
					</div>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>