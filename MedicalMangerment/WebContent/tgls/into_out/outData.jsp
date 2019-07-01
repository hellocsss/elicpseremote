<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
<title>穷在闹市出品</title>

<!-- 公共样式 开始 -->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/base.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/fonts/iconfont.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/framework/jquery-1.11.3.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/layui/css/layui.css">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/framework/cframe.js"></script>
<!-- 仅供所有子页面使用 -->
<!-- 公共样式 结束 -->

<script src="${pageContext.request.contextPath}/js/out_intoData.js"></script>

</head>

<body>
	<div class="cBody">
	<p>&nbsp;</p>
		<a class="layui-btn  layui-btn-lg layui-btn-warm  layui-btn-radius" style=" color: #333333";
						href="${pageContext.request.contextPath}/tgls/into_out/increase.jsp"><i class="layui-icon " style="font-size: 30px; color: #333333;">&#xe654;</i>新增订单入库 </a>
		<p>&nbsp;</p>
		<div class="layui-form">
			<div class="console">
				<div class="layui-form-item ">
					<form action="${pageContext.request.contextPath}/repertory_mohuselect" method="post">
						<div class="layui-form-item">
							<label class="layui-form-label">开始时间</label>
							<div class="layui-input-block">
								<input type="datetime-local" name="begintime"
									style="width: 500px" lay-verify="required" autocomplete="off"
									class="layui-input">
							</div>
						</div>
						<div class="layui-form-item">
							<label class="layui-form-label">结束时间</label>
							<div class="layui-input-block">
								<input type="datetime-local" name="endtime" style="width: 500px"
									lay-verify="required" autocomplete="off" class="layui-input">
							</div>
						</div>


						<div class="layui-form-item">
							<div class="layui-input-block">
								<input class="layui-btn " type="submit" value="立即查询">
								<button type="reset" class="layui-btn layui-btn-primary">重置</button>
							</div>
						</div>

					</form>

				</div>
			</div>

		</div>
		<table id="customList" class="layui-table">
			<thead>
				<tr>
					<th>订单单号</th>
					<th>药品名称</th>
					<th>入库时间</th>
					<th>药品类别</th>
					<th>供应商</th>
					<!-- <th>商品</th> -->

					<th id="one11">单价</th>
					<th>仓库数量</th>
					<th>生产日期</th>
					<th>保质期</th>
					<th>距离过期</th>
					
				
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="pagebean.list" var="reper">
				
					<tr>
						<td><s:property value="#reper.rnumber" />
						<td><s:property value="#reper.rproduct" /></td>
						<td><s:property value="#reper.rdate" /></td>
						<td><s:property value="#reper.rtype" /></td>
						<td><s:property value="#reper.rput" /></td>
						<td><s:property value="#reper.runit" /></td>
						<td id="rtotal"><s:property value="#reper.rtotal" /></td>
						<td><s:property value="#reper.rbrithdate" /></td>
						<td><s:property value="#reper.rbdate" /></td>
						<td><s:property value="#reper.rtext" /></td>
						
						
					
						<td>
							<form id="form01" action="" method="post">
								<div class="layui-input-inline">
									<input type="number" name="count" required lay-verify="required" placeholder="请输入上/下架数量" autocomplete="off" class="layui-input">
								</div>
								<input type="hidden" name="rid" value="<s:property value="#reper.rid"></s:property>">
								<input type="hidden" name="rnumber" value="<s:property value="#reper.rnumber"></s:property>">
								<input type="hidden" name="rproduct" value="<s:property value="#reper.rproduct"></s:property>">
								<input type="hidden" name="rtype" value="<s:property value="#reper.rtype"></s:property>">
								<input type="hidden" name="rput" value="<s:property value="#reper.rput"></s:property>">
								<input type="hidden" name="rdate" value="<s:property value="#reper.rdate"></s:property>">		
								<input type="hidden" name="runit" value="<s:property value="#reper.runit"></s:property>">
								<input type="hidden" name="rtotal" value="<s:property value="#reper.rtotal"></s:property>">
								<input type="hidden" name="rname" value="<s:property value="#reper.rname"></s:property>">
								<input type="hidden" name="rbrithdate" value="<s:property value="#reper.rbrithdate"></s:property>">
								<input type="hidden" name="rbdate" value="<s:property value="#reper.rbdate"></s:property>">
								<a class="btn_on"><input id="btn01" class="layui-btn layui-btn-xs" type="button" value="上架"></a>
								
								<a class="btn_down" href="javascript:void;">
									<input class="layui-btn layui-btn-xs" type="button" value="下架" />
								</a>
						
							</form>	
						</td>
					</tr>

				</s:iterator>
				<script>
				

				//上架ajax
				  
	            $(".btn_on").on("click", function (){
	            	
	            	
					  var that = this;
					  
					  var value = $(this).parent("form").find("input[name='count']").val();//上架数量
					  
					  
					  var rid = $(this).parent("form").find("input[name='rid']").val();//上架药品id
					  var rproduct = $(this).parent("form").find("input[name='rproduct']").val();//上架商品名
					  var rtotal = $(this).parent("form").find("input[name='rtotal']").val();//
					  
					  value = parseInt(value);
					  rtotal = parseInt(rtotal);
					  
					  if(value<=0){
						  
						  alert("无效输入！请输入正整数");
						  
						  
					  }else if(value > rtotal){
						  
						  alert("上架数量不能大于库存数量！");
						  
					  }else if(value<=rtotal && value>0){
						  
						  $.ajax({
	                			url:"repertory_onshowGoods",
	                			data: {
	                				"count": value,
	                				"rid":rid,
	                				"rproduct":rproduct
	                				
	                				
	                			},
	                			type:"post",
	                			dataType:"json",
	                			cache:false,
	                			success:function(msg){
	                				
	                				alert("成功上架"+value+"件药品！");
	                				//alert(msg);
	                				//var one = $(that).parent("form").find("input[name='rtotal']").val();
	                				//var newnum = one - value;
	                				
	                				$(that).parents("tr").find("#rtotal").text(msg);
	                				
	                				
	                			}
	                		});  
						  
					  }
					  
            		 
            		
            	} )
	
	
				//下架ajax
	                
	            $(".btn_down").on("click", function (){
	            	
					  var that = this;
					  
					  var value = $(this).parent("form").find("input[name='count']").val();
					  var rid = $(this).parent("form").find("input[name='rid']").val();
					  
					  var rtotal = $(this).parent("form").find("input[name='rtotal']").val();//
					  
            			//alert(value);
            		value = parseInt(value);
					rtotal = parseInt(rtotal);
					
					if(value<=0){
						  
						  alert("无效输入！请输入正整数");
						  
						  
					  }else{
						  
						  $.ajax({
		            			url:"repertory_outshowGoods",
		            			data: {
		            				"count": value,
		            				"rid":rid
		            			},
		            			type:"post",
		            			dataType:"json",
		            			cache:false,
		            			success:function(msg){
		            				
		            				alert("成功下架"+value+"件药品！");
		            				//alert(msg);
		            				$(that).parents("tr").find("#rtotal").text(msg);
		            				
		            				//alert("药品已成功下架！");
		            				
		            			}
		            		});  
						  
						  
					  }
            			
            		
            		
            		
            	} )
	               	
									
					</script>	
			</tbody>
		</table>

	</div>
	<div style="LINE-HEIGHT:30px;height: 30px;text-align: right">

    共[<b><s:property value="pagebean.totalCount" /></b>]条记录,共[<b><s:property value="pagebean.totalPage"/></b>]页,
    当前第[<b><s:property value="pagebean.currentPage"/></b>]页
    <!--  判断为第一页 没有第一页
     判断为最后一页就没有最后一页
    -->
      <%-- <s:if test="<s:property value="pagebean.currentPage"/>!=1">  --%> 
      <s:if test="%{pagebean.currentPage!=1}"> 
[<a style="text-decoration:underline" href="${pageContext.request.contextPath}/repertory_LsitPage?currentPage=<s:property value="pagebean.currentPage-1"/>">前一页</a>]
</s:if> 

 <%-- <s:if test="<s:property value="pagebean.currentPage" />!=<s:property value="pagebean.totalPage" />">   这中为啥不行--%>
<s:if test="%{pagebean.currentPage!=pagebean.totalPage}"> 
[<a style="text-decoration:underline" href="${pageContext.request.contextPath}/repertory_LsitPage?currentPage=<s:property value="pagebean.currentPage+1"/>">后一页</a>]

 </s:if> 
</div>
</body>
</html>