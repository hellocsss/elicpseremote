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
		<title>穷在闹市出品</title>

		<!-- 公共样式 开始 -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/fonts/iconfont.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/framework/jquery-1.11.3.min.js"></script>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
		<script src="${pageContext.request.contextPath}/framework/cframe.js"></script><!-- 仅供所有子页面使用 -->
		<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
  		<link rel="stylesheet" href="http://jqueryui.com/resources/demos/style.css">
  		<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
  

	</head>

	<body>
		<div class="cBody">
			<div class="console">
				<form class="layui-form" action="${pageContext.request.contextPath}/goods_shopSearchGood" method="post">
					<div class="layui-form-item">
						<div class="layui-input-inline">
							<input type="text" id="gname" name="gname" required lay-verify="required" placeholder="请输入药品名查询" autocomplete="off" class="layui-input">
						</div>
			
						<button class="layui-btn" lay-submit lay-filter="submitBut " type="submit">查询药品</button>
					  
						<a id="userbtn" class="layui-btn layui-btn-radius layui-btn-normal"  style="float:rigth"><i class="layui-icon"  style="font-size: 24px; color: #FFFFFF;" >&#xe770;</i>&nbsp;&nbsp;&nbsp;读取会员信息</a>
						<s:if test="#session.userlogin!=null">
						<%-- <span>会员：</span><s:property value="#session.userlogin.username"/> --%>
						</s:if>
						<span id="message"></span>
					</div>
				</form>
				
				 <script type="text/JavaScript">
		                 
		                 	$(function() {
	                		 
		                		setTimeout("callAjaxByjQuery()");
		                		 
		    				  }); 
		                 
		                	/**
		                	 * 用jQuery的方式发起AJAX请求
		                	 */
		                	function callAjaxByjQuery(){
		                		//alert("222");
		                		$.ajax({
		                			url:"goods_findTypeGoods",
		                			data: {"jsondata": $("input[name='gname']").val()},
		                			type:"post",
		                			dataType:"json",
		                			cache:false,
		                			success:function(msg){
		                				//$("#msg").append(msg);
		                				//alert("huidiao");
		                				//alert(msg);
		                				var availableTags1 = msg;
		                				//alert(availableTags1);
		                				
		                				$( "#gname" ).autocomplete({
		  		    				      source: availableTags1
		  		    				    });
		                				
		                			}
		                		});
		                		
		                	}
						 </script> 
				<script>			
				//下架ajax             
	            $("#userbtn").on("click", function (){           	
	            	//alert("344343");
					  //var that = this;
					  
					/*   var value = $(this).parent("form").find("input[name='count']").val();
					  var rid = $(this).parent("form").find("input[name='rid']").val();
					  
            			alert(value); */
            		
            		 $.ajax({
            			url:"user_findUserById",
            			type:"post",
            			dataType:"json",
            			cache:false,
            			success:function(msg){
            				//alert("成功！！"+msg.username);
            				$("#message").text("会员："+msg);
            				
            			}
            		 
            		});  
            		
            	} )
				
			
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
						<th>药品编号</th>
						<th>商品名称</th>
						<th>售价</th>
						<th>保质期</th>
						<th>类别</th>
						<th>可卖数量</th>
						<th>生产日期</th>
						<th>数量</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				<s:iterator value="pageBean.list" var="good">
					<tr>
						<td><s:property value="#good.gid"></s:property></td>
						<td><s:property value="#good.gname"></s:property></td>
						<td><s:property value="#good.price"></s:property>元</td>
						<td><s:property value="#good.qualitaDate"></s:property></td>
						<td><s:property value="#good.type"></s:property></td>
						<td><s:property value="#good.stock"></s:property></td>
						<td><s:property value="#good.date"></s:property></td>
						<form id="form01" action="${pageContext.request.contextPath}/shop_addShop" method="post">
						<div class="layui-form-item">
						<td>
							<input type="hidden" name="gid" value="<s:property value="#good.gid"></s:property>">
							<input type="hidden" name="price" value="<s:property value="#good.price"></s:property>">
							<div class="layui-input-inline">
							<input type="number" name="count" required lay-verify="required" placeholder="请输入购买数量" autocomplete="off" class="layui-input">
							</div>
						</td>
						
						<td>
							<button class="layui-btn layui-btn-sm layui-btn-warm" lay-submit  type="submit">加入结算</button>
						</td>
						</div>
						</form>	
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
[<a style="text-decoration:underline" href="${pageContext.request.contextPath}/goods_findAllShopGoods?currentPage=<s:property value="pageBean.currentPage-1"/>">前一页</a>]
</s:if> 

<s:if test="%{pageBean.currentPage!=pageBean.totalPage}"> 
[<a style="text-decoration:underline" href="${pageContext.request.contextPath}/goods_findAllShopGoods?currentPage=<s:property value="pageBean.currentPage+1"/>">后一页</a>]
</s:if> 
</div>
</body>
</html>