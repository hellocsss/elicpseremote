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
<title>药厂管理系统出品</title>
<!-- 添加编辑div的弹框样式 -->
<style>
.layui-table img {
	max-width: none;
}

.black_overlay {
	display: none;
	position: absolute;
	top: 0%;
	left: 0%;
	width: 100%;
	height: 100%;
	background-color: black;
	z-index: 1001;
	-moz-opacity: 0.8;
	opacity: .80;
	filter: alpha(opacity =             80);
}

.white_content {
	display: none;
	position: absolute;
	top: 10%;
	left: 15%;
	width: 70%;
	height: 70%;
	padding: 16px;
	border: 0px;
	background-color: white;
	z-index: 1002;
	overflow: auto;
}

.select_per {
	
}
</style>


<!-- 公共样式 开始 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/base.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/fonts/iconfont.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/framework/jquery-3.4.0.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/layui/css/layui.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/framework/cframe.js"></script>
<script language="JavaScript" src="./js/jquery-1.4.1.min.js"></script>

<script language="javascript">
	//展示编辑界面信息
	function showFactory(fid, fname, fprice, fvalDate, fproductDate, fnum,
			fgongying, fchufang) {
		document.getElementById('light').style.display = 'block';
		document.getElementById('fade').style.display = 'block';
		$('#fid').val(fid);
		$('#fname').val(fname);
		$('#fprice').val(fprice);
		$('#fvalDate').val(fvalDate);
		$('#fproductDate').val(fproductDate);
		$('#fnum').val(fnum);
		$('#fchufang').val(fchufang);
		$('#fgongying').val(fgongying);
	}
	function showAdd() {
		document.getElementById('light_add').style.display = 'block';
		document.getElementById('fade_add').style.display = 'block';

	}

	function deleteFactory(factoryid) {

		if (confirm("确顶要删除吗？")) {
			location.href = "${pageContext.request.contextPath}/factory_deleteFactory?factoryid="
					+ factoryid;
		}

	}
</script>

<!-- 仅供所有子页面使用 -->
<!-- 公共样式 结束 -->



</head>

<body>
	<!-- 隐藏编辑信息div -->
	<div id="light" class="white_content">
		<div style="text-align: right">
			<a href="javascript:void(0)"
				onclick="document.getElementById('light').style.display='none';document.getElementById('fade').style.display='none'"><img
				src="./images/close1.png" style="height: 20px; float: right;">
			</a>
		</div>
		<div class="row">
			<div style="font-size: 23px">编辑信息</div>
			<br>
			<hr>
			<br>
			<form id="addForm" class="layui-form" method="post"
				action="${pageContext.request.contextPath}/factory_updateFactory">
				<div class="layui-form-item">
					<label class="layui-form-label">药品名称</label>
					<div class="layui-input-block">
						<!-- 传一个要修改的id -->
						<input type="text" id="fid" name="fid" hidden="hidden"> <input
							type="text" id="fname" name="fname" required autocomplete="off"
							class="layui-input" placeholder="请输入药品名">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">药品库存</label>
					<div class="layui-input-block">
						<input type="number" id="fnum" name="fnum" required
							autocomplete="off" class="layui-input" placeholder="请输入数字">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">价格</label>
					<div class="layui-input-block">
						<input type="number" id="fprice" name="fprice" required
							autocomplete="off" class="layui-input" placeholder="请输入数字">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">生产日期</label>
					<div class="layui-input-block">
						<input type="date" required id="fproductDate" name="fproductDate"
							autocomplete="off" class="layui-input" />
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">保质期</label>
					<div class="layui-input-block">
						<input type="number" required id="fvalDate" name="fvalDate"
							autocomplete="off" class="layui-input" placeholder="请输入数字" />
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">药品类别</label>
					<div class="layui-input-block">
						<input type="text" id="fchufang" name="fchufang"
							autocomplete="off" class="layui-input" readonly />
					</div>

				</div>

				<div class="layui-form-item">

					<label class="layui-form-label">供应商</label>
					<div class="layui-input-block">
						<input type="text" id="fgongying" name="fgongying"
							autocomplete="off" class="layui-input" readonly>
					</div>
				</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<input class="layui-btn" type="submit" value="修改">
						<!--<button type="reset" class="layui-btn layui-btn-primary">重置</button>-->
					</div>
				</div>
			</form>
			<script>
				layui.use([ 'upload', 'form' ], function() {
					var form = layui.form;
					var upload = layui.upload;
					var layer = layui.layer;
					//监听提交
					form.on('submit(submitBut)', function(data) {
						return false;
					});
					form.verify({
						//数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
						ZHCheck : [ /^[\u0391-\uFFE5]+$/, '只允许输入中文' ]
					});
					//拖拽上传
					upload.render({
						elem : '#goodsPic',
						url : '/upload/',
						done : function(res) {
							console.log(res)
						}
					});
				});
			</script>
		</div>
	</div>
	<div id="fade" class="black_overlay"></div>

	<!-- 增加药品div -->
	<div id="light_add" class="white_content">
		<div style="text-align: right">
			<a href="javascript:void(0)"
				onclick="document.getElementById('light_add').style.display='none';document.getElementById('fade_add').style.display='none'"><img
				src="./images/close1.png" style="height: 20px; float: right;">
			</a>
		</div>
		<div class="row">
			<div style="font-size: 23px">添加药品</div>
			<br>
			<hr>
			<br>
			<form id="addForm" class="layui-form" method="post"
				action="${pageContext.request.contextPath}/factory_addFactory"
				onsubmit="return checkform()">
				<div class="layui-form-item">
					<label class="layui-form-label">药品名称</label>
					<div class="layui-input-block">
						<input type="text" id="fname" name="fname" required
							autocomplete="off" class="layui-input" placeholder="请输入药品名">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">药品库存</label>
					<div class="layui-input-block">
						<input type="number" id="fnum" name="fnum" required
							autocomplete="off" class="layui-input" placeholder="请输入数字">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">价格</label>
					<div class="layui-input-block">
						<input type="number" id="fprice" name="fprice" autocomplete="off"
							required class="layui-input" placeholder="请输入数字">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">生产日期</label>
					<div class="layui-input-block">
						<input type="date" id="fproductDate" name="fproductDate" required
							autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">保质期</label>
					<div class="layui-input-block">
						<input type="number" id="fvalDate" name="fvalDate" required
							autocomplete="off" class="layui-input" placeholder="请输入数字">
					</div>
				</div>

				<div class="layui-form-item">
					<label class="layui-form-label">药品类别</label>
					<div class="layui-input-inline">
						<select name="fchufang" id="fchufang_add" required>
							<option value="0">选择分类</option>
							<s:iterator value="findAllType" var="type">
								<option value="<s:property value="#type.tname"></s:property>"><s:property
										value="#type.tname"></s:property></option>
							</s:iterator>
						</select>
					</div>

				</div>

				<div class="layui-form-item">

					<label class="layui-form-label">供应商</label>
					<div class="layui-input-inline">
						<select name="fgongying" id="fgongying_add" required>
							<option value="0">选择供应商</option>
							<s:iterator value="allSuppliers" var="Suppliers">
								<option
									value="<s:property value="#Suppliers.sname"></s:property>"><s:property
										value="#Suppliers.sname"></s:property></option>
							</s:iterator>
						</select>
					</div>
				</div>

				<div class="layui-form-item">
					<div class="layui-input-block">
						<input class="layui-btn" type="submit" value="添加">
						<!--<button type="reset" class="layui-btn layui-btn-primary">重置</button>-->
					</div>
				</div>
			</form>
			<script>
				function checkform() {

					if ($('#fchufang_add').val() == "0") {
						alert("请选择药品类别！");
						return false;
					} else if ($('#fgongying_add').val() == "0") {
						alert("请选择供应商！");
						return false;
					} else {
						return true;
					}

				}
			</script>
		</div>
	</div>
	<div id="fade_add" class="black_overlay"></div>
	<div class="cBody">
		<div class="console">
			<!-- layui-form -->
			<form id="queryForm" class="layui-form" method="post"
				action="${pageContext.request.contextPath}/factory_getFactoryList">
				<div class="layui-form-item">
					<div class="layui-input-inline">
						<input type="text" id="fname" name="fname" placeholder="请输入药品名"
							autocomplete="off" class="layui-input"
							value="${factoryPageCondition.fname}"
							onChange="callAjaxByjQuery()">
					</div>
					<div class="layui-input-inline">
						<select name="fchufang" id="fchufang">
							<option value="">选择药品类型</option>
							<s:iterator value="findAllType" var="type">
								<option value="<s:property value="#type.tname"></s:property>"><s:property
										value="#type.tname"></s:property></option>
							</s:iterator>
						</select>
					</div>



					<div class="layui-input-inline">
						<select name="fgongying" id="fgongying">
							<option value="">选择供应商</option>
							<s:iterator value="allSuppliers" var="Suppliers">
								<option
									value="<s:property value="#Suppliers.sname"></s:property>"><s:property
										value="#Suppliers.sname"></s:property></option>
							</s:iterator>
						</select>
					</div>
					<button class="layui-btn" type="submit">检索</button>
					<!-- lay-submit lay-filter="submitBut" -->
					<a class="layui-btn" onclick="showAdd()">添加药品</a>

				</div>

			</form>

		</div>

		<table class="layui-table">
			<thead>
				<tr>
					<th>药品编号</th>
					<th>商品名称</th>
					<th>商品价格</th>
					<th>保质期</th>
					<th>生产日期</th>
					<th>库存数量</th>
					<th>供应商</th>
					<th>药品类型</th>
					<th>操作</th>
					<!--  <th>操作<button onclick="myFunction()">点我</button></th>-->
				</tr>
			</thead>
			<tbody>

				<s:iterator value="factoryList" var="factory">
					<tr>
						<td><s:property value="#factory.fid"></s:property></td>
						<td><s:property value="#factory.fname"></s:property></td>
						<td><s:property value="#factory.fprice"></s:property></td>
						<td><s:property value="#factory.fvalDate"></s:property></td>
						<td><s:property value="#factory.fproductDate"></s:property></td>
						<td><s:property value="#factory.fnum"></s:property></td>
						<td><s:property value="#factory.fgongying"></s:property></td>
						<td><s:property value="#factory.fchufang"></s:property></td>
						<td><a><input id="btn01" class="layui-btn layui-btn-xs"
								type="submit"
								onclick="showFactory('<s:property value="#factory.fid"></s:property>',
								'<s:property value="#factory.fname"></s:property>',
								'<s:property value="#factory.fprice"></s:property>',
								'<s:property value="#factory.fvalDate"></s:property>',
								'<s:property value="#factory.fproductDate"></s:property>',
								'<s:property value="#factory.fnum"></s:property>',
								'<s:property value="#factory.fgongying"></s:property>',
								'<s:property value="#factory.fchufang"></s:property>')"
								value="编辑"></a> <input id="btn02"
							class="layui-btn layui-btn-xs" type="button"
							onclick="deleteFactory('<s:property value="#factory.fid"></s:property>')"
							value="删除" /></td>
					</tr>
				</s:iterator>


			</tbody>
		</table>


		<script>
			layui.use('laypage', function() {
				var laypage = layui.laypage;

				laypage
						.render({
							elem : 'pages',
							limit : 10,
							count : 50,
							layout : [ 'count', 'prev', 'page', 'next',
									'limit', 'skip' ],
							jump : function(obj) {
								//					      console.log(obj)
								//alert(obj.curr);
							}
						});
			});
		</script>
	</div>
	<!--  分页模块 -->
	<div style="text-align: center;">
		<form
			action="${pageContext.request.contextPath}/factory_getFactoryList"
			id="pagebar_bool" method="post">

			<input type="hidden" name="fname" id="fname"
				value="${factoryPageCondition.fname}" /> <input type="hidden"
				name="fgongying" id="fgongying"
				value="${factoryPageCondition.fgongying}" />
			<input type="hidden" name="fchufang" id="fchufang"
				value="${factoryPageCondition.fchufang}" />
		</form>
		<%@ include file="PageBarBool.jsp"%>
	</div>

</body>

</html>