<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags"  prefix="s"%>
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
		<title>穷在闹市出品</title>

		<!-- 公共样式 开始 -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/fonts/iconfont.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/framework/jquery-1.11.3.min.js"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
		<script src="${pageContext.request.contextPath}/framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->
		
		<style>
			.layui-form{
				margin-right: 30%;
			}
			.layui-form-label{
				width: 100px;
			}
			.layui-input-block{
				margin-left: 130px;
			}
		</style>

	</head>

	<body>
		<div class="cBody">
			<s:if test="#session.userlogin!=null">
			恭喜您:<s:property value="#session.userlogin.username"></s:property>
			<a href="${pageContext.request.contextPath}/indent_findIndentById?uid=<s:property value="#session.userlogin.uid"></s:property>">查看购买记录</a>
			<%-- <a href="${pageContext.request.contextPath}/indent_findIndentById?uid=<s:property value="#session.userlogin.uid"></s:property>">退出</a> --%>
			</s:if>
			<s:else>
			<form id="addForm" class="layui-form" action="${pageContext.request.contextPath}/user_login" method="post">
				<div class="layui-form-item">
					<label class="layui-form-label">会员名称</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="username" required lay-verify="required" placeholder="请输入名称" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">电话号码</label>
					<div class="layui-input-inline shortInput">
						<input type="text" name="phone" required lay-verify="required|phone" placeholder="请输入电话号码 " autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit  type="submit">立即登录</button>
						
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
				
			</form>
			</s:else>

		</div>
	</body>

</html>