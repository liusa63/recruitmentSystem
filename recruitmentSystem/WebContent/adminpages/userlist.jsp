<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="JavaScript"
	src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-easyui-1.4.2/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-easyui-1.4.2/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-easyui-1.4.2/locale/easyui-lang-zh_CN.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/jquery-easyui-1.4.2/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/js/jquery-easyui-1.4.2/themes/icon.css">
<script type="text/javascript">
	$(function() {
		$('#dg').datagrid({
			url : '${pageContext.request.contextPath}/UserListServlet',//数据请求地址  
			toolbar : [ {
				id : 'btnAdd',
				text : "添加",
				iconCls : 'icon-add',
				handler : function() {
					alert(添加);
				}
			}, {
				id : 'btnEdit',
				text : "修改",
				iconCls : 'icon-edit',
				handler : function() {
					alert($('#dg').datagrid('getSelected').uid);
				}
			} ], // 数据网格工具栏 比如添加 修改  
			pagination : true,//分页显示  
			fitColumns : true,//自动适应宽度  
			autoRowHeight : true,//自动行高度  
			loadMsg : '正在加载数据请稍后...',
			idField : 'rid',//idField这个就像列表数据中的主键意思，一般绑定的是唯一键字段
			rownumbers : true,//显示行号  
			singleSelect : true,//只允许选择一行  
			pageSize : 2,//初始化显示条数  
			pageList : [ 2, 4, 6 ],//分页列表  
			columns : [ [ {
				field : 'rname',
				title : '姓名',
				width : 100
			}, {
				field : 'rage',
				title : '年龄',
				width : 100
			} , {
				field : 'rphone',
				title : '手机号',
				width : 100
			} , {
				field : 'remail',
				title : '邮箱',
				width : 100
			} , {
				field : 'reducation',
				title : '学历',
				width : 100
			}, {
				field : 'rwant',
				title : '职业意向',
				width : 100
			} ] ]
		});
	});
</script>

</head>
<body>
	<table id="dg" class="easyui-datagrid" style="width: 100%;"></table>

</body>
</html>