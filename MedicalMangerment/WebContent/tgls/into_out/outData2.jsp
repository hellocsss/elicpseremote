<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>


<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
<!-- Google Chrome Frame也可以让IE用上Chrome的引擎: -->
<meta name="renderer" content="webkit">
<!--国产浏览器高速模式-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="穷在闹市" />
<!-- 作者 -->
<meta name="revised" content="穷在闹市.v3, 2019/05/01" />
<!-- 定义页面的最新版本 -->
<meta name="description" content="网站简介" />
<!-- 网站简介 -->
<meta name="keywords" content="搜索关键字，以半角英文逗号隔开" />
<title>药店管理系统出品</title>



<!-- 公共样式 开始 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/base.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/fonts/iconfont.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/framework/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/layui/css/layui.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/framework/cframe.js"></script>

<!-- 仅供所有子页面使用 -->

<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://jqueryui.com/resources/demos/style.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">

<!-- 公共样式 结束 -->

<style>
.layui-table img {
	max-width: none;
}
</style>


<script>
	$(function(){
		

		layui.use('table', function() {
			var table = layui.table;
			
			//第一个实例
			table.render({
				elem : '#demo',
				height : 312,
				
				//url : '/MedicalMangerment/test2.json' //数据接口
				url : '${pageContext.request.contextPath}/repertory_repertoryall2' 
				, 
				page : true //开启分页 
				,
				cols : [[ 
					{
						field : 'rid',
						title : '入库编号',
						width : 80,
						sort: true,
						fixed : 'left'
					}, {
						field : 'rnumber',
						title : '入库订单编号',
						sort: true,
						width : 80
					}, {
						field : 'rproduct',
						title : '入库产品',
						sort: true,
						width : 80,
						
					}, {
						field : 'rdate',
						title : '入库总数 ',
						sort: true,
						width : 80
					}, {
						field : 'rtotal',
						title : '单价',
						sort: true,
						width : 177
					}, {
						field : 'runit',
						title : '类型',
						sort: true,
						width : 80,
						
					}, {
						field : 'rtype',
						title : '保质期',
						sort: true,
						width : 80,
						
					}, {
						field : 'rbdate',
						title : '生产日期',
						sort: true,
						width : 80
						
					}, {
						field : 'rbrithdate',
						title : '供应商',
						sort: true,
						width : 135,
						
					} ,{field: 'rput', title: '入库', width: 135,sort: true}
					,{field: 'rname', title: '入库名字', width: 135,sort: true}
				]]
			});

		});
	})
	</script>


</head>

<body>
	<table id="demo" ></table>

</body>

</html>