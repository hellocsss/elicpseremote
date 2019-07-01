<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="refresh" content="10">
<title>后台模板</title>

<!-- 时间轴样式-->
<link href="css/style.css" rel="stylesheet" />


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/amazeui.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/core.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/menu.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/index.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/page/typography.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/page/form.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/component.css" />
<script src="${pageContext.request.contextPath}/framework/cframe.js"></script>
<!-- 仅供所有子页面使用 -->


</head>
<body style="overflow-y: scroll;">


	<!--	<div class="am-g">-->
	<!-- ============================================================== -->
	<!-- Start right Content here -->
	<div class="cBody">
		<div class="console">


			<!-- Start content -->
			<div class="content">
                 
				<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6" >
					<div class="panel panel-transparent" style="width:50%;float: left">
						<div class="panel-heading">
							<h6>
								<strong>今日订单消息</strong>
							</h6>
							<div class="panel-actions">
								<a href="#" class="btn-minimize"><i class="fa fa-caret-up"></i>
								</a> <a href="#" class="btn-close"><i class="fa fa-times"></i> </a>
							</div>
						</div>
						<div class="panel-body">
							<div class="timelineProfile timeline-profile">
								<div class="timeline-body">
									<div class="timeline-title">
										<h5 class="text-uppercase">今日订单</h5>
									</div>
									<ol class="timeline-items">
										<s:iterator value="orderList" var="order">

											<li>
												<div class="timeline-box">
													<p class="text-muted">
														<s:property value="#order.orderDate"></s:property>
													</p>
													<p>
														<s:property value="#order.orderCode"></s:property>
														<br /> ￥
														<s:property value="#order.orderSum"></s:property>
														<br />
														<s:property value="#order.orderName"></s:property>
														<br /> <a href="${pageContext.request.contextPath}/order_findOrderDetail?orderCode=<s:property value="#order.orderCode"></s:property>"
															class="text-primary">#详情</a>
													</p>
												</div>
											</li>
										</s:iterator>

									</ol>
								</div>
							</div>
						</div>
					</div>
					<div class="panel panel-transparent" style="width:50%;float: left">
						<div class="panel-heading">
							<h6>
								<strong>最新邮件</strong>
							</h6>
							<div class="panel-actions">
								<a href="#" class="btn-minimize"><i class="fa fa-caret-up"></i>
								</a> <a href="#" class="btn-close"><i class="fa fa-times"></i> </a>
							</div>
						</div>
						<div class="panel-body">
							<div class="timelineProfile timeline-profile">
								<div class="timeline-body">
									<div class="timeline-title">
										<h5 class="text-uppercase">今日邮件</h5>
									</div>
									<ol class="timeline-items">
										<s:iterator value="factoryEmailList" var="factoryEmail">

											<li>
												<div class="timeline-box">
													<p class="text-muted">
														<s:property value="#factoryEmail.Date"></s:property>
													</p>
													<p>
														<s:property value="#factoryEmail.name"></s:property>
														<br />发送人：
														<s:property value="#factoryEmail.sendName"></s:property>
														<br /> <p style="color:red;">
														<s:property value="#factoryEmail.isread"></s:property></p>
														
														<br /> <a href="factory_getEmailList"
															class="text-primary">#详情</a>
													</p>
												</div>
											</li>
										</s:iterator>

									</ol>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				
					





			</div>

		</div>
		<!-- end right Content here -->
		<!--</div>-->
	</div>


	<!-- navbar -->
	<a href="admin-offcanvas"
		class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu"
		data-am-offcanvas="{target: '#admin-offcanvas'}"> <!--<i class="fa fa-bars" aria-hidden="true"></i>-->
	</a>

	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/js/jquery-2.1.0.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/js/amazeui.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/js/app.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/js/blockUI.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/js/charts/echarts.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/js/charts/indexChart.js"></script>

</body>

</html>
