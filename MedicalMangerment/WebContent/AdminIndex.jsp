<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">

		<meta name="renderer" content="webkit">
		<!--国产浏览器高速模式-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
	
		<title>药店管理系统</title>

		<!-- 公共样式 开始 -->
		<link rel="shortcut icon" href="images/favicon.ico"/>
		<link rel="bookmark" href="images/favicon.ico"/>
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link rel="stylesheet" type="text/css" href="fonts/iconfont.css">
		<script type="text/javascript" src="framework/jquery-1.11.3.min.js" ></script>
		<script type="text/javascript" src="js/base.js"></script>
		<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
	    <!--[if lt IE 9]>
	      	<script src="framework/html5shiv.min.js"></script>
	      	<script src="framework/respond.min.js"></script>
	    <![endif]-->
		<script type="text/javascript" src="layui/layui.js"></script>
		<script src="framework/cframe.js?12"></script><!-- 仅供所有子页面使用 -->
		<!-- 公共样式 结束 -->
		
		<link rel="stylesheet" type="text/css" href="css/frameStyle.css">
		<script type="text/javascript" src="framework/frame.js" ></script>
</head>
<body>
	<!-- 左侧菜单 - 开始 -->
		<div class="frameMenu">
		    <div class="logo">
		        <img src="images/logo.png"/>
		        <div class="logoText">
		            <h1>药店后台管理系统</h1>
		        </div>
		    </div>
		    <div class="menu">
		    	<div class="hoverBox"></div>
		        <ul>
		        	<li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-liuliangyunpingtaitubiao03 left" onmouseenter="getLeftTips(this, '代理商管理')" onmouseleave="layer.closeAll('tips')"></i><font>订单管理</font><i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath}/tgls/shop/indent_findIndent',this, 'page10023')">购买记录</a></dt>
		                
		                </dl>
		            </li>
		        	<li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-shangpin left" onmouseenter="getLeftTips(this, '商品管理')" onmouseleave="layer.closeAll('tips')"></i><font>药品管理</font><i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath}/type_findAllType',this, 'page10024')">药品分类列表</a></dt>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath}/goods_findAllGoods',this, 'page1002554')">基本商品库</a></dt>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath}/goods_addGoodsPage',this, 'page10026')">手动添加药品</a></dt>
		                </dl>
		            </li>
		        	<li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-yunying left" onmouseenter="getLeftTips(this, '基础库内容')" onmouseleave="layer.closeAll('tips')"></i><font>顾客管理</font><i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl> 
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath}/user_findAllUserList',this, 'page10028')">顾客列表</a></dt>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath}/tgls/user/user_add.jsp',this, 'page10027')">添加顾客</a></dt>

		                </dl>
		           	</li>
		        
		        	
		        	<li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-icon left" onmouseenter="getLeftTips(this, '出入库管理')" onmouseleave="layer.closeAll('tips')"></i><font>库存管理</font><i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                	<!-- <dt><a href="javascript:void(0)" onclick="menuCAClick('tgls/into_out/outData.html',this, 'page10071')">库存查询</a></dt> -->
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath}/repertory_LsitPage?currentPage=1',this, 'page10074')">入库管理</a></dt>
<!-- 		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('tgls/into_out/intoData.html',this, 'page10072')">出库管理</a></dt>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('tgls/into_out/intoData.html',this, 'page10073')">库存警报</a></dt>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('tgls/into_out/outPrintData.html',this, 'page10075')">打印单</a></dt> -->
		                </dl>
		           </li>
		           
		           	<li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-icon left" onmouseenter="getLeftTips(this, '打印模板')" onmouseleave="layer.closeAll('tips')"></i><font>采购管理</font><i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		               <%--  <dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath}/order_importGoods',this, 'page10075')">采购药品</a></dt> --%>
		                <dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath}/tgls/into_out/Factory.jsp',this, 'page1003343')">采购药品</a></dt> 
		  <%--               <dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath}/tgls/order/order_addList.jsp',this, 'page10076')">采购药品结算</a></dt> --%>
		               	<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath}/tgls/order/order_addList2.jsp',this, 'page1007834')">采购药品结算</a></dt>
		                <dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath}/tgls/order/order_findAllOrder',this, 'page1007743')">采购订单列表</a></dt>
		                <!-- <dt><a href="javascript:void(0)" onclick="menuCAClick('tgls/print/outPrintData.html',this, 'page10033')">供应商管理</a></dt>  -->
		                </dl>
		           	</li>
		           
		           <li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-icon left" onmouseenter="getLeftTips(this, '报表模块')" onmouseleave="layer.closeAll('tips')"></i><font>报表中心</font><i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
<%-- 		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath}/statistics_showDate',this, 'page100356767')">统计分析图</a></dt> --%>
		                	<dt class="btn_down1"><a  href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath}/html/chart_line.jsp',this, 'page10088878')">统计分析图</a></dt>
		                	<!-- <dt><a href="javascript:void(0)" onclick="menuCAClick('html/chart_pie.html',this, 'page1008978')">扇形图</a></dt> -->
		                <!-- 	<dt><a href="javascript:void(0)" onclick="menuCAClick('html/form_basic.html',this, 'page1009087657')">订单统计报表</a></dt>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('html/form_validate.html',this, 'page10035565')">订单统计报表</a></dt>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('html/chart_pie.html',this, 'page10035565')">订单统计报表</a></dt> -->
		                </dl>
		           	</li>
		           	
		        </ul>
		    </div>
		</div>
		<!-- 左侧菜单 - 结束 -->
		
		<div class="main">
			<!-- 头部栏 - 开始 -->
			<div class="frameTop">
				<div class="shrinkBut">
		    		<div class="hoverBox"></div>
					<ul>
						<li><a href="javascript:void(0)" onclick="menuShrink(this)" onmouseenter="getTips(this, '收缩菜单')" onmouseleave="layer.closeAll('tips')"><i class="iconfont icon-caidan-shousuo"></i></a></li>
						<li><a href="javascript:void(0)" onclick="frameRefresh()" onmouseenter="getTips(this, '刷新')" onmouseleave="layer.closeAll('tips')"><i class="iconfont icon-htmal5icon23"></i></a></li>
					</ul>
				</div>
				<div class="topMenu">
		    		<div class="hoverBox"></div>
					<ul>
						<li><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath}/notification_showNotification',this, 'pageNotice', '消息邮件')" onmouseenter="getTips(this, '消息邮件')" onmouseleave="layer.closeAll('tips')"><i class="iconfont icon-tongzhigonggao1"></i>
						<span id="newsNum" class="news" style="width:18px;height:18px;font-size:10px;line-height:18px;top: 30%;left: 50%;">
						</span>
						
						</a></li>
						<li><a href="javascript:void(0)" id="fullScreenBut" onclick="fullScreen('fullScreenBut')" onmouseenter="getTips(this, '全屏')" onmouseleave="layer.closeAll('tips')"><i class="iconfont icon-full-screen"></i></a></li>
						<!-- 店员和店长 -->
						<li>
							<a href="javascript:void(0)"><font>
				
						
						<s:if test="#session.adminlogin!=null">
							管理员:<s:property value="#session.adminlogin.name"/>
						</s:if> 
						
		
							</font><i class="iconfont icon-up-copy"></i></a>
							<dl>
							<s:if test="#session.adminlogin!=null">
							<dt><a href="${pageContext.request.contextPath}/login.jsp" onclick="menuCAClick('',this, 'pageModifyPassword')">店员登录</a></dt>
							</s:if>
							<dt><a href="${pageContext.request.contextPath}/login_loginOut" onclick="menuCAClick('',this, 'pageUserInfo')">退出登录</a></dt>
			                </dl>
						
						<li><a href="${pageContext.request.contextPath}/login_loginOut" onmouseenter="getTips(this, '退出系统')" onmouseleave="layer.closeAll('tips')"><i class="iconfont icon-084tuichu"></i></a></li>
					</ul>
				</div>
			</div>
			<!-- 头部栏 - 结束 -->
			
			<!-- 核心区域 - 开始 -->
			<div class="frameMain">
				<div class="title" id="frameMainTitle">
					<i class="iconfont icon-shuangzuojiantou- leftbut" onclick="pageShow('l')"></i>
					<div class="mainPageBox">
						<div class="mainPage">
							<span class="active" onclick="pageSwitch(this)">
			    				<div class="hoverBox"></div>
								<i class="iconfont icon-shouye"></i>
							</span>
						</div>
					</div>
					<i class="iconfont icon-shuangyoujiantou- rightbut" onclick="pageShow('r')"></i>
					<i class="iconfont icon-iconfontarrows1 rightbut pageAllBut">
						<dl>
		                	<dt><a href="javascript:void(0)" onclick="nowpageClose()">关闭当前标签页</a></dt>
		                	<dt><a href="javascript:void(0)" onclick="otherpageClose()">关闭其它标签页</a></dt>
		                	<dt><a href="javascript:void(0)" onclick="allpageClose()">关闭全部标签页</a></dt>
		                </dl>
					</i>
				</div>
				<div class="con">
					<div class="mainPageCon">
						<iframe class="mainIframe" src="showData_showIndexData" scrolling="not"></iframe>
					</div>
				</div>
			</div>
			<!-- 核心区域 - 结束 -->
		</div>
		
		<script>
		
			$(function(){
				
				$.ajax({
	       			url:"notification_upIsReadNum",
	       			data: {
	       				
	       			},
	       			type:"post",
	       			dataType:"json",
	       			cache:false,
	       			success:function(msg){
	       				
	       				//alert(msg);
	       				if(msg != 0)
	       					$("#newsNum").show().text(msg);
	       				else
	       					$("#newsNum").hide();	
	       			}
	       		});    	
			});
		
			
			  $(".btn_down1").on("click", function (){
				  $.ajax({
		       			url:"notification_upIsReadNum",
		       			data: {
		       				
		       			},
		       			type:"post",
		       			dataType:"json",
		       			cache:false,
		       			success:function(msg){
			           				
			           		
			           				if(msg != 0)
			           					$("#newsNum").show().text(msg);
			           				else 
			           					$("#newsNum").hide();	
		       			}
			           		});  		 
					
           	} )	
		 
		
		
		</script>
		
		
		
</body>
</html>