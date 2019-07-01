<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>


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
			.layui-form-label{
				width: 100px;
			}
			.layui-input-block{
				margin-left: 130px;
			}
			.layui-form{
				margin-right: 30%;
			}
		</style>

	</head>

	<body>
		<div class="cBody">
			<form id="addForm" class="layui-form" method="post" action="${pageContext.request.contextPath}/goods_updateGoods" onsubmit="return checkform()">
				<div class="layui-form-item">
					<label class="layui-form-label">药品名称</label>
					<div class="layui-input-block">
						<input type="text" name="gname" required lay-verify="required" autocomplete="off" class="layui-input" placeholder="请输入药品名" value="<s:property value="goods.gname"/>">
					</div>
				</div>
				 <!-- <div class="layui-form-item">
					<label class="layui-form-label">商品图片</label>
					<div class="layui-upload-drag" id="goodsPic">
					  <i class="layui-icon"></i>
					  <p>点击上传，或将文件拖拽到此处</p>
					</div>
				</div> -->
				
				
				<input type="hidden" name="gid" value="<s:property value="goods.gid"/>">
				
				<div class="layui-form-item">
					<label class="layui-form-label">售价</label>
					<div class="layui-input-block">
						<input type="number" name="price" lay-verify="required|number" autocomplete="off" class="layui-input" placeholder="请输入数字" value="<s:property value="goods.price"/>">
					</div>
				</div>
			
				
				<!-- <div class="layui-form-item">
					<label class="layui-form-label">是否上架</label>
					<div class="layui-input-block">
						<input type="radio" name="sfpfsp" value="nan" title="是">
						<input type="radio" name="sfpfsp" value="nv" title="否" checked>
					</div>
				</div> -->
				
	                <%-- <div class="layui-input-inline">
	                    <select name="cityid" id="cityid" lay-filter="cityid">
	                        <option value="">二级分类</option>
					        <option value="0">北京</option>
					        <option value="1">上海</option>
					        <option value="2">广州</option>
					        <option value="3">深圳</option>
					        <option value="4">杭州</option>
	                    </select>
	                </div> --%>
				</div>
				
				
				
				
				<!-- <div class="layui-form-item">
					<label class="layui-form-label">状态</label>
					<div class="layui-input-block">
						<input type="radio" name="sex" value="nan" title="启用">
						<input type="radio" name="sex" value="nv" title="禁用" checked>
					</div>
				</div> -->
				
				<div class="layui-form-item">
					<div class="layui-input-block">
						<input class="layui-btn" type="submit" value="立即提交">
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
			</form>
			
			
			<script>
				layui.use(['upload','form'], function() {
					var form = layui.form;
					var upload = layui.upload;
					var layer = layui.layer;
					//监听提交
					form.on('submit(submitBut)', function(data) {
						return false;
					});
					form.verify({
						//数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
					  	ZHCheck: [
						    /^[\u0391-\uFFE5]+$/
						    ,'只允许输入中文'
					  	] 
					});
					//拖拽上传
					upload.render({
						elem: '#goodsPic',
						url: '/upload/',
						done: function(res) {
						  	console.log(res)
						}
					});
				});
				
				//
				function checkform(){
					
					var one = document.getElementById("provid");
					var two = document.getElementById("two");
					if(one.value==-1){
						alert("请选择药品类别！");
					}else if(two.value == -1){
						alert("请选择供应商和药品类别！");
					}else{
						return true;
					}
					
				
					
				}
				
				
				
				
				
			</script>

		</div>
	</body>

</html>