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

 <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  

<!-- 公共样式 开始 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/base.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/fonts/iconfont.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/framework/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/layui/css/layui.css" media="all">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/framework/cframe.js"></script>
<script
	src="${pageContext.request.contextPath}/js/jquery.serializejson.min.js"></script>
<script
	src="${pageContext.request.contextPath}/js/jquery.serializejson.js"></script>
<script
	src="https://cdn.bootcss.com/jquery.serializeJSON/2.9.0/jquery.serializejson.js"></script>
<!-- 仅供所有子页面使用 -->

<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://jqueryui.com/resources/demos/style.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css" media="all">

<!-- 公共样式 结束 -->

<style>
.layui-table img {
	max-width: none;
}
</style>


<script>
	$(function() {
		layui.use('table', function() {
			var table = layui.table;
			//第一个实例
			table.render({
				elem : '#demoo',
				height : 700,
				//url : '/MedicalMangerment/test2.json' //数据接口
				url : '${pageContext.request.contextPath}/factory_factoryall'
				//	url : '${pageContext.request.contextPath}/repertory_repertoryall2' 
				,
				page : true //开启分页 
				,
				id : "listdate",
				cols : [ [ {
					field : 'fid',//1
					title : '编号',
					width : 100,

					sort : true,
					fixed : 'left'
				}, {
					field : 'fname',//2
					title : '药品名称',
					sort : true,
					width : 100
				}, {
					field : 'fprice',//3
					title : '单价',
					sort : true,
					width : 100,

				}, {
					field : 'fvalDate',//4
					title : '保质期 ',
					sort : true,
					width : 100
				}, {
					field : 'fproductDate',//5
					title : '生产日期',
					sort : true,
					//width : 100
				}, {
					field : 'fnum',//6
					title : '数量',
					sort : true,
					width : 80,
					

				}, {
					field : 'fgongying',//7
					title : '供应商',
					sort : true,
					//width : 80,

				}, {
					field : 'fchufang',//8
					title : '类别',
					sort : true,
					//width : 80
				}, /* {
					fixed : 'right',
					title : '采购数量',
					width : 178,
					align : 'center',
					toolbar : '#order'
				}, */ {
					fixed : 'right',
					title : '操作',
					//width : 178,
					align : 'center',
					toolbar : '#barDemo'
				} ] ]
			});

		});

		//序列化
		/* $("#btnSearch").click(function () {
				alert("sss");
				var formData=$('#searchForm').serializeJSON();
				alert("ss");
				alert(JSON.stringify(formData));
				alert("sws");
				$.ajax({
					url:'factory_factoryall',
					data:formData,
					dataType:'json'
					type:'post'
					success:function(rtn){//rtn 为打印的值
						//加载数据
						
						
					}
				})
			}); */

	})
</script>
<script type="text/html" id="barDemo">
			  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">批量进货</a>
			
	</script>
<%-- <script type="text/html" id="order">
            <input class="layui-btn layui-btn-primary layui-btn-xs"  lay-event="shuru" />
	</script> --%>
<script>
	layui.use('table', function() {
		var bb;
		var table = layui.table;
		//监听工具条
		table.on('tool(test)', function(obj) {
			var date = obj.data;
			var that=this;
			 var tr = obj.tr; //获得当前行 tr 的DOM对象
			if (obj.event === 'detail') {
				//layer.msg('ID：' + date.fid + '采购操作');
				//layer.msg('ID：' + date.fnum + '采购操作');
				//var th = document.querySelector("[data-field]=8");
				
				layer.prompt({
					formType : 0,
					value : '1',
					title : '请输入采购数量，这是当前编号 '+date.fid+",这是当前总数: "+date.fnum,
					area: ['100px', '150px'] 
				}, function(value, index) {
					//alert(value); //得到value
					
					if(value>0&&value!=null&&value<=date.fnum){
					$.ajax({
						url : 'factory_shopping',
						data : {
							'fid' : date.fid,
							'num' : value
						},
						type : 'post',
						success : function(msg) {//rtn 为打印的值
							//加载数据
							alert(msg+"我的");
					
							$(that).parents("tr").children(".layui-table-cell laytable-cell-1-fnum").test(msg);; 
						  /*  $("obj").parents("tr").find($("layui-table-cell laytable-cell-1-fnum")).test(msg);  */
							 /*   $("tr").children(" .layui-table-cell laytable-cell-1-fnum").test(msg); */
						}
					}) 
					layer.close(index);
					}else{
						alert("请输入数量大于0的值不超过总数的数量");
					}
				});


			} else if (obj.event === 'del') {
				layer.confirm('真的删除行么', function(index) {
					alert(date.fid);

					$.ajax({
						url : 'factory_delesct',
						data : {
							'fid' : date.fid
						},
						type : 'post',
						success : function(rtn) {//rtn 为打印的值
							//加载数据

						}
					})
					obj.del();
					layer.close(index);

				});
			} else if (obj.event === 'edit') {
				layer.alert('编辑行：<br>' + JSON.stringify(date))
			}
		});

	});
</script>
</head>

<body>
	<div class="cBody">
		<%-- 	<div class="demoTable"> --%>

		<table id="demoo" lay-filter="test"></table>
	</div>
</body>

</html>