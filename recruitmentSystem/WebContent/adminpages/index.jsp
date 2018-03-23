<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="JavaScript"
	src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript">
	function gotoPage() {
		//获取输入的页码
		var inpage = $("#inputPage").val();
		var countPage = ${fbPage.countPage};
		if (inpage != "") {
			//是否为正整数
			var reg = /^\d+$/;
			if (reg.test(inpage)) {
				//是否小于总页数
				if (inpage > 0 && inpage <= countPage) {
					//提交到Servlet上，并且把页码传到Servlet上
					window.location.href = "${pageContext.request.contextPath }/FeedbackServlet?currentPage="
							+ inpage;
				} else {
					alert("最大的页码为" + conutPage);
				}
			} else {
				alert("请输入正整数");
			}
		} else {
			alert("请输入页码");
		}
	}
</script>
</head>
<body>
     <table border="1" width="800px" cellspacing="0" style="margin: 35px 50px; text-align:center;">
		<tr>
			<td>用户名</td>
			<td>用户邮箱</td>
			<td>反馈信息</td>
			<td>操作</td>
		</tr>

		<c:forEach items="${fbPage.list}" var="f">
			<tr>
				<td>${f.fname}</td>
				<td>${f.femail}</td>
				<td>${f.fmsg}</td>
				<td>
				<a href="${pageContext.request.contextPath }/FeedbackDetailServlet?fid=${f.fid}">详情</a>
				<a href="${pageContext.request.contextPath }/DeleteFeedbackServlet?fid=${f.fid}">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	 <table>
		<div style="float: right; margin-right: 55px;" class="pageDiv">

			<a
				href="${pageContext.request.contextPath }/FeedbackServlet?currentPage=1">首页</a>
			<c:if test="${fbPage.currentPage>1}">
				<a
					href="${pageContext.request.contextPath }/FeedbackServlet?currentPage=${fbPage.currentPage-1}">上一页</a>
			</c:if>
			${fbPage.currentPage}
		<c:if test="${fbPage.currentPage<fbPage.countPage}"> 
				<a
					href="${pageContext.request.contextPath }/FeedbackServlet?currentPage=${fbPage.currentPage+1}">下一页</a>
		</c:if>
			<a
				href="${pageContext.request.contextPath }/FeedbackServlet?currentPage=${fbPage.countPage}">尾页</a>
			共${fbPage.totalNum}条，共${fbPage.countPage}页 <input id="inputPage"
				type="text"
				style="margin-right: 10px; padding: 2px; width: 30px; border-radius: 3px; border: 1px solid rgba(128, 128, 128, 0.46);" />
			<input type="button" value="跳转" onclick="gotoPage();" />
		</div>
	</table> 
</body>
</html>