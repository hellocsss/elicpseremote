<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>后台模板</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/amazeui.css" />
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/core.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/menu.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/index.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/page/typography.css" />
		
		
		<!-- 公共样式 开始 -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/fonts/iconfont.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/framework/jquery-1.11.3.min.js"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
		<script src="${pageContext.request.contextPath}/framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<script src="${pageContext.request.contextPath}/assets/js/charts/charts.js?6"></script>
		<!-- 公共样式 结束 -->
		
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reportForm.css">
		
	</head>
		
	
	
	<body>
		<!-- Begin page -->
		
		<div class="cBody">
			<div class="console">
				<div class="layui-input-inline">
				     <input type="text" class="layui-input" id="time" placeholder=" 选择日期 " autocomplete="off">
				</div>
				<button class="layui-btn" id="btnSelect">查询</button>
				<a href="${pageContext.request.contextPath}/statistics_findAllSetting"><button class="layui-btn" id="btnSetting">设置反馈</button>
				</a>
				
			
               <!-- <div class="layui-input-inline">
                   <select name="one" id="provid" lay-filter="provid" required>
                       <option value="0">未选择</option>
                       <option value="1">3天</option>
                       <option value="2">7天</option>
                       <option value="3">3天/7天</option>
                   </select>
				</div> -->
				
				<script type="text/JavaScript">
					$(function(){
						$("#provid").change(function (){
							
							//alert($("#provid").val());
							//选择天数value的值
							var value = $("#provid").val();
							
							$.ajax({
	                			url:"statistics_feedback",
	                			data: {
	                				"count": value,
	                			},
	                			type:"post",
	                			dataType:"json",
	                			cache:false,
	                			success:function(msg){
	                				//$(that).parents("tr").find("#rtotal").text(msg);
	                				
	                				
	                			}
	                		}); 
						});
						
						
						
					});
				</script> 
			
				
				<script type="text/JavaScript">
					$(function(){
						line("statistics_showDate", "", "Stack");
						$("#btnSelect").on("click", function (){
							line("statistics_showDate", $("#time").val(), "Stack");
				        });
					});
				</script> 
				
			</div>
		</div>
			
		
		
		<div class="admin">
			
		<div class="content-page">
			<!-- Start content -->
			<div class="content">
				<div class="am-g">
					<div class="am-u-md-12" >
						<!-- 折线图堆叠 -->
						<div class="card-box">
							<div  id="Stack" style="width: 100%;height: 570px;"></div>
						</div>
					</div>
					
					
				</div>
				
				
			</div>
		</div>
		<!-- end right Content here -->
		<!--</div>-->
		</div>
		<script>
		
		
		
		
		
		
				layui.use(['form','laydate', 'layer', 'laypage'], function() {
					var form = layui.form;
					var laydate = layui.laydate;
					var laypage = layui.laypage,
						layer = layui.layer;
			
					//监听提交
					form.on('submit(submitBut)', function(data) {
						layer.msg(JSON.stringify(data.field));
						return false;
					});
					laydate.render({
					    elem: '#time' 
				    	,range: true
					});
					//select监听
					form.on('select(reportType)', function(data){
					  console.log(data.elem); //得到select原始DOM对象
					  console.log(data.value); //得到被选中的值
					  console.log(data.othis); //得到美化后的DOM对象
					});
					
				
					//总页数大于页码总数
					laypage.render({
					    elem: 'pages'
					    ,count: 5
					    ,layout: ['prev', 'page', 'next', 'limit', 'skip']
					    ,jump: function(obj){
					      console.log(obj)
					    }
					});
				});
			</script>
			
		
		</div>
		
		<!-- navbar -->
		
		
		
		<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>
	</body>
		<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-2.1.0.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/amazeui.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/app.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/blockUI.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/charts/echarts.min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/charts/lineChart.js?time=1234"></script>
</html>

<script>


			function myFunction() {
			  var txt;
			  var day = prompt("请输入需要检测的间隔天数：", "");
			  var ratio = prompt("请输入提醒比例：", "");
			  
			  if (day == null || ratio == null || day == "" || ratio == "") {
			    	alert("输入为空！");
			    	
			  } else {
				  
				  $.ajax({
          			url:"statistics_feedbackNum",
          			data: {
          				"day": day,
          				"ratio": ratio
          			},
          			type:"post",
          			dataType:"json",
          			cache:false,
          			success:function(msg){
          				
          				//$(that).parents("tr").find("#rtotal").text(msg);
          				
          				
          			}
          		}); 
				  
			  }
			  document.getElementById("demo").innerHTML = txt;
			}
			
			$(function(){
				var ele = parent.$("#newsNum");
				$.ajax({
	       			url:"notification_upIsReadNum",
	       			type:"post",
	       			dataType:"json",
	       			cache:false,
	       			success:function(msg){
	       				
	       				//alert(msg);
	       				if(msg != 0)
	       					ele.show().text(msg);
	       				else
	       					ele.hide();	
	       			}
	       		});    	
			});
		
		</script>
		
		

