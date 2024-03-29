<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
		<!-- Google Chrome Frame也可以让IE用上Chrome的引擎: -->
		<meta name="renderer" content="webkit">
		<!--国产浏览器高速模式-->
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<!-- 公共样式 开始 -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/fonts/iconfont.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/framework/jquery-1.11.3.min.js"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
		<script src="${pageContext.request.contextPath}/framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->

	</head>

	<body>
		<div class="cBody">
		
			<div class="console">
				<script>
					layui.use(['form','laydate'], function() {
						var form = layui.form;
						var laydate = layui.laydate;
				
						//监听提交
						form.on('submit(submitBut)', function(data) {
							layer.msg(JSON.stringify(data.field));
							return false;
						});
						
						var newDate = new Date();
						nowTime = newDate.getFullYear()+"-"+(newDate.getMonth()+1)+"-"+newDate.getDate();
						laydate.render({
						    elem: '#time' 
					    	,range: '~'
//					    	,type: 'datetime'	//开启时分秒
					    	,format: 'yyyy-MM-dd'
					    	,max: nowTime	//min/max - 最小/大范围内的日期时间值
						});
					});
				</script>
			</div>
			
			<table class="layui-table">
				<thead>
					<tr>
						<th>商品名称</th>
						<th>售价</th>
						<th>商品数量</th>
						<th>类别</th>
						<th>小计</th>
						<th>操作</th>
					</tr>
				</thead>
				<s:if test="#session.shop.shopItems.size()!=0">
				<tbody>
				<s:iterator value="#session.shop.shopItems" var="shopItem">
					<tr>
						<td><s:property value="#shopItem.good.gname"></s:property></td>
						<td><s:property value="#shopItem.good.price"></s:property></td>
						<td><s:property value="#shopItem.count"></s:property></td>
						<td><s:property value="#shopItem.good.type"></s:property></td>
						<td><s:property value="#shopItem.subtotal"></s:property></td>
						
						<td>
							<a href="${pageContext.request.contextPath}/shop_removeShopItem?gid=<s:property value="#shopItem.good.gid"/>"><button class="layui-btn layui-btn-xs">删除此药品</button></a>
						</td>
					</tr>
				</s:iterator> 
				
				</tbody>
				</s:if>	
				
			</table>
			<s:else>
			<p></p><br><br><br>
			<p style="font-size: 50px;padding-left: 400px">还没有选购任何药品！</p>
			</s:else>
			
			<table class="layui-table" style="margin-top: 100px">
				<tr>
				<td>
				<p  style="height: 50px;font-size: 20px;float: right;text-align: center; " width="40%">本次消费赠送积分：<span style="color: #FE941B" ><s:property value="#session.shop.total"></s:property>&nbsp;&nbsp;&nbsp;&nbsp;</span>药品总金额：<b><span style="color: red; font-size: 25px;">￥<s:property value="#session.shop.total"></s:property>元</span></b></p>
				</td>
				</tr>
				<tr>
				<td >
				<a href="${pageContext.request.contextPath}/shop_commit"><button style="float: right" class="layui-btn layui-btn-danger"  type="submit">提交订单</button></a>
				<a href="${pageContext.request.contextPath}/shop_clearShop"><button style="float: right" class="layui-btn layui-btn-primary" >清空药品</button></a>
				</td>
				</tr>
			</table>	
			
			<!-- layUI 分页模块 -->
			<div class="h_55"></div>
			<div id="pages"></div>
			<script>
				layui.use(['laypage', 'layer'], function() {
					var laypage = layui.laypage,
						layer = layui.layer;
				
					//总页数大于页码总数
					laypage.render({
					    elem: 'pages'
					    ,count: 100
					    ,layout: ['count', 'prev', 'page', 'next', 'limit', 'skip']
					    ,jump: function(obj){
					      console.log(obj)
					    }
					});
				});
			</script>
		</div>
	</body>
</html>