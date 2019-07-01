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
	</head>
	<body>
		<div class="admin">
			<div class="content-page">
				<div class="content">
					<div class="am-g">
						<div class="am-u-md-12">
							<!-- 大数据面积图  -->
							<div class="card-box">
								<div  id="pie4" style="width: 100%;height: 700px;"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- navbar -->
		<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>
		<script>
			GetQueryString = function (name)
			{
			     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
			     var r = window.location.search.substr(1).match(reg);
			     if(r!=null)return  unescape(r[2]); return null;
			}
		</script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-2.1.0.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/amazeui.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/app.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/blockUI.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/charts/echarts.min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/charts/pieChart.js?33" ></script>
	</body>
	
</html>
