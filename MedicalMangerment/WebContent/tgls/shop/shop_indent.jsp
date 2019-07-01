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
				<form class="layui-form" action="${pageContext.request.contextPath}/indent_SearchIndent" method="post">
					<div class="layui-form-item">
						<div class="layui-input-inline">
							<input type="text" name="phone" required lay-verify="required" placeholder="请输入手机号码" autocomplete="off" class="layui-input">
						</div>
						<button class="layui-btn" lay-submit lay-filter="submitBut " type="submit">查询订单</button>
					</div>
				</form>

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
						<th>订单编号</th>
						<th>会员名称</th>
						<th>会员电话</th>
						<th>订单总金额</th>
						<th>购买时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				<s:iterator value="pageBean.list" var="indent">
					<tr>
						<td><s:property value="#indent.indentid"></s:property></td>
						<td><s:property value="#indent.user.username"></s:property></td>
						<td><s:property value="#indent.user.phone"></s:property></td>
						<td><s:property value="#indent.indentPrice"></s:property></td>
						<td><s:property value="#indent.indentDate"></s:property></td>
						<td>
							<a href="${pageContext.request.contextPath}/indent_findIndentDetail?indentid=<s:property value="#indent.indentid"></s:property>"><button class="layui-btn layui-btn-sm layui-btn-warm" lay-submit  type="submit">订单详情</button></a>
						</td>
					</tr>
				</s:iterator>
				</tbody>
			</table>
		</div>
		<div style="LINE-HEIGHT:30px;height: 30px;text-align: right">

    共[<b><s:property value="pageBean.totalCount" /></b>]条记录,共[<b><s:property value="pageBean.totalPage"/></b>]页,
    当前第[<b><s:property value="pageBean.currentPage"/></b>]页
    <!--  判断为第一页 没有第一页
     判断为最后一页就没有最后一页
    -->
      <s:if test="%{pageBean.currentPage!=1}"> 
[<a style="text-decoration:underline" href="${pageContext.request.contextPath}/indent_findIndent?currentPage=<s:property value="pageBean.currentPage-1"/>">前一页</a>]
</s:if> 

<s:if test="%{pageBean.currentPage!=pageBean.totalPage}"> 
[<a style="text-decoration:underline" href="${pageContext.request.contextPath}/indent_findIndent?currentPage=<s:property value="pageBean.currentPage+1"/>">后一页</a>]
</s:if> 
</div>
</body>
</html>