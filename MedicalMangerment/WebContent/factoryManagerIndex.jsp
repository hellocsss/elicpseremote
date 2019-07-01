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
<meta name="author" content="穷在闹市" />
<!-- 作者 -->
<meta name="revised" content="穷在闹市.v3, 2019/05/01" />
<!-- 定义页面的最新版本 -->
<meta name="description" content="网站简介" />
<!-- 网站简介 -->
<meta name="keywords" content="搜索关键字，以半角英文逗号隔开" />

<title>药厂管理系统</title>

<!-- 公共样式 开始 -->
<link rel="shortcut icon" href="images/favicon.ico" />
<link rel="bookmark" href="images/favicon.ico" />
<link rel="stylesheet" type="text/css" href="css/base.css">
<link rel="stylesheet" type="text/css" href="fonts/iconfont.css">
<script type="text/javascript" src="framework/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/base.js"></script>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
<!--[if lt IE 9]>
	      	<script src="framework/html5shiv.min.js"></script>
	      	<script src="framework/respond.min.js"></script>
	    <![endif]-->
<script type="text/javascript" src="layui/layui.js"></script>
<script src="framework/cframe.js"></script>
<!-- 仅供所有子页面使用 -->
<!-- 公共样式 结束 -->

<link rel="stylesheet" type="text/css" href="css/frameStyle.css">
<script type="text/javascript" src="framework/frame.js"></script>
</head>
<body>
	<!-- 左侧菜单 - 开始 -->
	<div class="frameMenu">
		<div class="logo">
			<img src="images/logo.png" />
			<div class="logoText">
				<h1>药厂后台管理系统</h1>
			</div>
		</div>
		<div class="menu">
			<div class="hoverBox"></div>
			<ul>



				<li><a class="menuFA" href="javascript:void(0)"><i
						class="iconfont icon-shangpin left"></i><font>库存管理</font><i
						class="iconfont icon-dajiantouyou right"></i></a>
					<dl>
						<dt>
							<a href="javascript:void(0)"
								onclick="menuCAClick('${pageContext.request.contextPath}/type_findAllType',this, 'page10024')">药品分类列表</a>
						</dt>
						<dt>
							<a href="javascript:void(0)"
								onclick="menuCAClick('${pageContext.request.contextPath}/factory_getFactoryList',this, 'page10080')">基本药品库</a>
						</dt>

					</dl></li>
				<li><a class="menuFA" href="javascript:void(0)"><i
						class="iconfont icon-shangpin left"></i><font>订单管理</font><i
						class="iconfont icon-dajiantouyou right"></i></a>
					<dl>
						<dt>
							<a href="javascript:void(0)"
								onclick="menuCAClick('${pageContext.request.contextPath}/tgls/order/order_findAllOrder',this, 'page10077')">订单列表</a>
						</dt>
					</dl></li>
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
					<li><a href="javascript:void(0)" onclick="menuShrink(this)"
						onmouseenter="getTips(this, '收缩菜单')"
						onmouseleave="layer.closeAll('tips')"><i
							class="iconfont icon-caidan-shousuo"></i></a></li>
					<li><a href="javascript:void(0)" onclick="frameRefresh()"
						onmouseenter="getTips(this, '刷新')"
						onmouseleave="layer.closeAll('tips')"><i
							class="iconfont icon-htmal5icon23"></i></a></li>
				</ul>
			</div>
			<div class="topMenu">
				<div class="hoverBox"></div>
				<ul>
					<li><a href="javascript:void(0)"
						onclick="menuCAClick('factory_getEmailList',this, 'pageNotice', '通知公告')"
						onmouseenter="getTips(this, '通知公告')"
						onmouseleave="layer.closeAll('tips')"><i
							class="iconfont icon-tongzhigonggao1"></i><span id="newsNum" class="news" style="width:18px;height:18px;font-size:10px;line-height:18px;top: 30%;left: 50%;">
								</span></a></li>
					<li><a href="javascript:void(0)" id="fullScreenBut"
						onclick="fullScreen('fullScreenBut')"
						onmouseenter="getTips(this, '全屏')"
						onmouseleave="layer.closeAll('tips')"><i
							class="iconfont icon-full-screen"></i></a></li>

					<li><a href="javascript:void(0)"><font> <s:if
									test="#session.factoryManager!=null">
									<s:property value="#session.factoryManager.Fmname" />
								</s:if>


						</font><i class="iconfont icon-up-copy"></i></a>
					<li><a
						href="${pageContext.request.contextPath}/login_factoryManagerloginOut"
						onmouseenter="getTips(this, '退出系统')"
						onmouseleave="layer.closeAll('tips')"><i
							class="iconfont icon-084tuichu"></i></a></li>
				</ul>
			</div>
		</div>
		<!-- 头部栏 - 结束 -->

		<!-- 核心区域 - 开始 -->
		<div class="frameMain">
			<div class="title" id="frameMainTitle">
				<i class="iconfont icon-shuangzuojiantou- leftbut"
					onclick="pageShow('l')"></i>
				<div class="mainPageBox">
					<div class="mainPage">
						<span class="active" onclick="pageSwitch(this)">
							<div class="hoverBox"></div> <i class="iconfont icon-shouye"></i>
						</span>
					</div>
				</div>
				<i class="iconfont icon-shuangyoujiantou- rightbut"
					onclick="pageShow('r')"></i> <i
					class="iconfont icon-iconfontarrows1 rightbut pageAllBut">
					<dl>
						<dt>
							<a href="javascript:void(0)" onclick="nowpageClose()">关闭当前标签页</a>
						</dt>
						<dt>
							<a href="javascript:void(0)" onclick="otherpageClose()">关闭其它标签页</a>
						</dt>
						<dt>
							<a href="javascript:void(0)" onclick="allpageClose()">关闭全部标签页</a>
						</dt>
					</dl>
				</i>
			</div>
			<div class="con">
				<div class="mainPageCon">
					<iframe class="mainIframe" src="factory_getFactoryIndex"
						scrolling="not"></iframe>
				</div>
			</div>
		</div>
		<!-- 核心区域 - 结束 -->
	</div>
	<script>
		
			$(function(){
				
				$.ajax({
	       			url:"factory_upIsReadNum",
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
			})
		
			
			  
		 
		
		
		</script>
</body>
</html>