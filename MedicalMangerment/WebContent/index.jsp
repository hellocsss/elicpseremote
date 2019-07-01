<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
		<!-- Google Chrome Frame也可以让IE用上Chrome的引擎: -->
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
		<script src="framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
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
		            <h1>理工大药房前台销售</h1>
		        </div>
		    </div>
		    <div class="menu">
		    	<div class="hoverBox"></div>
		        <ul>
		        	<li>
		                <a class="menuFA" href="javascript:void(0)"><i class="iconfont icon-liuliangyunpingtaitubiao03 left" onmouseenter="getLeftTips(this, '代理商管理')" onmouseleave="layer.closeAll('tips')"></i><font>前台零售</font><i class="iconfont icon-dajiantouyou right"></i></a>
		                <dl>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath}/goods_findAllShopGoods',this, 'page10021')">药品查询</a></dt>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath}/tgls/shop/shop_addList.jsp',this, 'page10022')">药品结算</a></dt>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath}/tgls/shop/user_login.jsp',this, 'page10027')">会员登录</a></dt>
		                	<dt><a href="javascript:void(0)" onclick="menuCAClick('${pageContext.request.contextPath}/tgls/shop/indent_findIndent',this, 'page10023')">购买记录</a></dt>
		                
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
						<%-- <li><a href="javascript:void(0)" onclick="menuCAClick('tgls/modify_password.html',this, 'pageNotice', '通知公告')" onmouseenter="getTips(this, '通知公告')" onmouseleave="layer.closeAll('tips')"><i class="iconfont icon-tongzhigonggao1"></i><span class="news"></span></a></li> --%>
						<li><a href="javascript:void(0)" id="fullScreenBut" onclick="fullScreen('fullScreenBut')" onmouseenter="getTips(this, '全屏')" onmouseleave="layer.closeAll('tips')"><i class="iconfont icon-full-screen"></i></a></li>
						<!-- 店员和店长 -->
						<li>
							<a href="javascript:void(0)"><font>
						<s:if test="#session.clerklogin!=null">
							您好：<s:property value="#session.clerklogin.cname"/>
						</s:if> 
	
		
							</font><i class="iconfont icon-up-copy"></i></a>
							<dl>
							<s:if test="#session.clerklogin!=null">
							<dt><a href="${pageContext.request.contextPath}/AdminLogin.jsp" onclick="menuCAClick('',this, 'pageModifyPassword')">管理员登录</a></dt>
							</s:if>
							<dt><a href="${pageContext.request.contextPath}/login_loginOut" onclick="menuCAClick('',this, 'pageUserInfo')">退出登录</a></dt>
			                </dl>
						</li>
						
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
						<iframe class="mainIframe" src="goods_findAllShopGoods" scrolling="not"></iframe> 
					</div>
				</div>
			</div>
			<!-- 核心区域 - 结束 -->
		</div>
</body>
</html>