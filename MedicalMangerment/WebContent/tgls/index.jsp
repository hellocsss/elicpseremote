<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>后台模板</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/amazeui.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/core.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/menu.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/index.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/page/typography.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/page/form.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/component.css" />
		<script src="${pageContext.request.contextPath}/framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		
		
	</head>
	<body>

		
	<!--	<div class="am-g">-->
		<!-- ============================================================== -->
		<!-- Start right Content here -->
		<div class="content-page">
			<!-- Start content -->
			<div class="content">
				<div class="am-g">
					<!-- Row start -->
						<div class="am-u-md-3">
							<div class="card-box">
								<h4 class="header-title m-t-0 m-b-30">月总收入</h4>
								<div class="widget-chart-1 am-cf">
                                    <div id="widget-chart-box-1" style="height: 100px;width: 100px;float: left;">
                                    </div>

                                    <div class="widget-detail-1" style="float: right;">
                                        <h2 class="p-t-10 m-b-0"><s:property value="[3].top"/>元</h2>
                                        <p class="text-muted">店铺总销售</p>
                                    </div>
                                </div>
							</div>
						</div>
						<!-- col end -->
						<div class="am-u-md-3">
							<div class="card-box">
								<h4 class="header-title m-t-0 m-b-30">月销售订单</h4>
								<div class="widget-box-2">
                                    <div class="widget-detail-2">
                                        <span class="badge  pull-left m-t-20  am-round" style="color: #fff; background: #0e90d2;">80% <i class="zmdi zmdi-trending-up"></i> </span>
                                        <h2 class="m-b-0"><s:property value="[2].top"/></h2>
                                        <p class="text-muted m-b-25">Revenue today</p>
                                    </div>
                                    <div class="am-progress am-progress-xs am-margin-bottom-0">
									    <div class="am-progress-bar" style="width: 80%"></div>
									</div>
                                </div>
							</div>
						</div>
						<!-- col end -->
						<div class="am-u-md-3">
							<div class="card-box">
								<h4 class="header-title m-t-0 m-b-30">今日总收入</h4>
								<div class="widget-chart-1 am-cf">
                                    <div id="widget-chart-box-2" style="height: 110px;width: 110px;float: left;">
                                    </div>

                                    <div class="widget-detail-1" style="float: right;">
                                        <h2 class="p-t-10 m-b-0"><s:property value="[1].top"/>元</h2>
                                        <p class="text-muted">今日收入</p>
                                    </div>
                                </div>
							</div>
						</div>
						<!-- col end -->
						<div class="am-u-md-3">
							<div class="card-box">
								<h4 class="header-title m-t-0 m-b-30">今日销售订单</h4>
								<div class="widget-box-2">
                                    <div class="widget-detail-2">
                                        <span class="badge  pull-left m-t-20  am-round progress-bar-pink" style="color: #fff;">32% <i class="zmdi zmdi-trending-up"></i> </span>
                                        <h2 class="m-b-0"><s:property value="[0].top"/></h2>
                                        <p class="text-muted m-b-25">Revenue today</p>
                                    </div>
                                    <div class="am-progress am-progress-xs am-margin-bottom-0" style="background: rgba(255, 138, 204, 0.2);">
									    <div class="am-progress-bar progress-bar-pink" style="width: 80%"></div>
									</div>
                                </div>
							</div>
						</div>
					<!-- Row end -->
				</div>
				
				<div class="am-g">
					<!-- Row start -->
					<div class="am-u-md-4">
						<div class="card-box">
							<h4 class="header-title m-t-0">今日各类别销售量</h4>
							<div id="index-pie-1" style="height: 345px;height: 300px;"></div>
						</div>
					</div>
					
					<div class="am-u-md-8">
						<div class="card-box">
							<h4 class="header-title m-t-0">近7天收入</h4>
							<div id="index-bar-1" style="height: 345px;height: 300px;"></div>
						</div>
					</div>
					
					<!-- Row end -->
				</div>
				
				
			
				
			</div>
		</div>
		<!-- end right Content here -->
		<!--</div>-->
		</div>
		</div>
		
		<!-- navbar -->
		<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery-2.1.0.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/amazeui.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/app.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/blockUI.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/charts/echarts.min.js" ></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/charts/indexChart.js?time=1234" ></script>

	</body>
	
</html>
