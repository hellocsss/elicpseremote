<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Inbox</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Novus Admin Panel Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Bootstrap Core CSS -->
<link href="${pageContext.request.contextPath}/email/css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/email/css/style.css" rel='stylesheet' type='text/css' />
<!-- font CSS -->
<!-- font-awesome icons -->
<link href="${pageContext.request.contextPath}/email/css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
 <!-- js-->
<script src="${pageContext.request.contextPath}/email/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/email/js/modernizr.custom.js"></script>
<!--webfonts-->
<link href='https://fonts.googleapis.com/css?family=Roboto+Condensed:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>
<!--//webfonts--> 
<!--animate-->
<link href="${pageContext.request.contextPath}/email/css/animate.css" rel="stylesheet" type="text/css" media="all">
<script src="${pageContext.request.contextPath}/email/js/wow.min.js"></script>
	<script>
		 new WOW().init();
	</script>
<!--//end-animate-->
<!-- Metis Menu -->
<script src="${pageContext.request.contextPath}/email/js/metisMenu.min.js"></script>
<script src="${pageContext.request.contextPath}/email/js/custom.js"></script>
<link href="${pageContext.request.contextPath}/email/css/custom.css" rel="stylesheet">
<!--//Metis Menu -->
</head> 
<body class="">
	<div class="main-content">
		
		
		<!-- //header-ends -->
		<!-- main content start-->
		<div id="page-wrapper">
			<!-- <table style="">
				<tr>
					<td><input type="button" value="全部删除"></td>
					<td><input type="button" value="全部标为已读"></td>
				</tr>
			</table> -->
				
				<div class="inbox-page">
					<h4>今日消息：</h4>
					<s:if test="showAllNotification.size()==0">
					<span style=""><h3>暂无邮件</h3></span>
					</s:if>
					<s:iterator value="showAllNotification" var="news"> 
					
					
					<div class="inbox-row widget-shadow" id="accordion" role="tablist" aria-multiselectable="true">
						<div class="mail "> <input type="checkbox" class="checkbox"> </div>
						
						
						<div class="mail mail-name" id="one"> <h6><s:property value="#news.isread"></s:property></h6> </div>
						
						<a id="<s:property value="#news.feid"></s:property>" class="btn_down" role="button" data-toggle="collapse" data-parent="#accordion" href="#<s:property value="#news.feid"></s:property><s:property value="#news.feid"></s:property>" aria-expanded="true" aria-controls="collapseOne">
							<div class="mail"><p id="news_name"><s:property value="#news.name"></s:property></p></div>
						</a>
						
						
						<div class="mail-right">
							<div class="dropdown">
								<a href="#"  data-toggle="dropdown" aria-expanded="false">
									<p><i class="fa fa-ellipsis-v mail-icon"></i></p>
								</a>
								<ul class="dropdown-menu float-right">
									<li>
										<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
											<i class="fa fa-reply mail-icon"></i>
											转发
										</a>
									</li>
									<li>
										<a href="#" title="">
											<i class="fa fa-download mail-icon"></i>
											下载
										</a>
									</li>
									<li>
										<a href="#" class="font-red" title="">
											<i class="fa fa-trash-o mail-icon"></i>
											删除
										</a>
									</li>
								</ul>
							</div> 
						</div>
						<div class="mail-right"><p id="news_Date"><s:property value="#news.Date"></s:property></p></div>
						<div class="clearfix"> </div>
						<div id="<s:property value="#news.feid"></s:property><s:property value="#news.feid"></s:property>" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
							<div class="mail-body">
								<div></div>
								<input class="new_date" type="hidden" value="#news.Date">
								<input class="new_tname" type="hidden" value="#news.tname">
								<p><h3><s:property value="#news.content"></s:property><a href="html/chart_pie.html?eid=<s:property value="#news.eid"></s:property>" >查看详情</a></h3></p>
								<!--href="${pageContext.request.contextPath}/notification_lookMore?eid=<s:property value="#news.eid"></s:property>"  -->
								<!-- class="look" id="<s:property value="#news.eid"></s:property>" -->
								
							</div>
						</div>
					</div>		
					</s:iterator>			
				</div>		
				<div class="inbox-page row">
					<h4>昨日消息</h4>
					<s:if test="showYesterday.size()==0">
					<span style=""><h3>暂无邮件</h3></span>
					</s:if>
					<s:iterator value="showYesterday" var="Yesterday"> 
					<div class="inbox-row widget-shadow">
						<div class="mail "> <input type="checkbox" class="checkbox"> </div>
						
						<div class="mail mail-name"><h6><s:property value="#Yesterday.isread"></s:property></h6></div>
						<a id="<s:property value="#Yesterday.feid"></s:property>" class="btn_down" role="button" data-toggle="collapse" data-parent="#accordion" href="#<s:property value="#Yesterday.feid"></s:property><s:property value="#Yesterday.feid"></s:property>" aria-expanded="true" aria-controls="collapseFive">
							<div class="mail"><p><s:property value="#Yesterday.name"></s:property></p></div>
						</a>
						<div class="mail-right">
							<div class="dropdown">
								<a href="#"  data-toggle="dropdown" aria-expanded="false">
									<p><i class="fa fa-ellipsis-v mail-icon"></i></p>
								</a>
								<ul class="dropdown-menu float-right">
									<li>
										<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFive" aria-expanded="true" aria-controls="collapseFive">
											<i class="fa fa-reply mail-icon"></i>
											转发
										</a>
									</li>
									<li>
										<a href="#" title="">
											<i class="fa fa-download mail-icon"></i>
											下载
										</a>
									</li>
									<li>
										<a href="#" class="font-red" title="">
											<i class="fa fa-trash-o mail-icon"></i>
											删除
										</a>
									</li>
								</ul>
							</div> 
						</div>
						<div class="mail-right"><p><s:property value="#Yesterday.Date"></s:property></p></div>
						<div class="clearfix"> </div>
						<div id="<s:property value="#Yesterday.feid"></s:property><s:property value="#Yesterday.feid"></s:property>" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFive">
							<div class="mail-body">
								<p><h3><s:property value="#Yesterday.content"></s:property><a href="html/chart_pie.html?eid=<s:property value="#Yesterday.eid"></s:property>" >查看详情</a></h3></p>
								
							</div>
						</div>
					</div>
					
					</s:iterator>
					
					</div>
					
					
				<div class="inbox-page row">
					<h4>更久之前</h4>
					<s:if test="showOld.size()==0">
					<span style=""><h3>暂无邮件</h3></span>
					</s:if>
					<s:iterator value="showOld" var="old"> 
					<div class="inbox-row widget-shadow">
						<div class="mail "> <input type="checkbox" class="checkbox"> </div>
						<div class="mail mail-name"><h6><s:property value="#old.isread"></s:property></h6></div>
						<a id="<s:property value="#old.feid"></s:property>" class="btn_down" role="button" data-toggle="collapse" data-parent="#accordion" href="#<s:property value="#old.feid"></s:property><s:property value="#old.feid"></s:property>" aria-expanded="true" aria-controls="collapse18">
							<div class="mail"><p><s:property value="#old.name"></s:property></p></div>
						</a>
						<div class="mail-right">
							<div class="dropdown">
								<a href="#"  data-toggle="dropdown" aria-expanded="false">
									<p><i class="fa fa-ellipsis-v mail-icon"></i></p>
								</a>
								<ul class="dropdown-menu float-right">
									<li>
										<a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse18" aria-expanded="true" aria-controls="collapse18">
											<i class="fa fa-reply mail-icon"></i>
											转发
										</a>
									</li>
									<li>
										<a href="#" title="">
											<i class="fa fa-download mail-icon"></i>
											下载
										</a>
									</li>
									<li>
										<a href="#" class="font-red" title="">
											<i class="fa fa-trash-o mail-icon"></i>
											删除
										</a>
									</li>
								</ul>
							</div> 
						</div>
						<div class="mail-right"><p><s:property value="#old.Date"></s:property></p></div>
						<div class="clearfix"> </div>
						<div id="<s:property value="#old.feid"></s:property><s:property value="#old.feid"></s:property>" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading18">
							<div class="mail-body">
								<p><h3><s:property value="#old.content"></s:property><a href="html/chart_pie.html?eid=<s:property value="#old.eid"></s:property>" >查看详情</a></h3></p>
								
							</div>
						</div>
					</div>
					
				</s:iterator>
				
				<script>
				
				
				
				
				
				 $(".btn_down").on("click", function (){
					 var that = this;			   
					 var value = $(this).prev(".mail").find("h6").html();
					 //var news =$(this).parent.document.getElementById('newsNum').innerText = 2
					 if(value === "未读"){
						 $.ajax({
			           			url:"factory_updateRead",
			           			data: {
			           				"feid": $(this).attr('id')
			           			},
			           			type:"post",
			           			dataType:"json",
			           			cache:false,
			           			success:function(msg){
			           				
			           				//alert(msg);
			           				$(that).prev(".mail").find("h6").text("已读");
			           				$(that).prev(".mail").find("h6").css("color","#A0A0B2");
			           				$("#news_Date").css("color","#A0A0B2");
			           				$(that).children().find("p").css("color","#A0A0B2");
			           				
			           				$(that).next('[div]').next('[div]').children().find("p").css("color","#A0A0B2");
			           				//$("#news_name").css("color","#A0A0B2");
			           				
			           				if(msg != 0)
			           					parent.$("#newsNum").show().text(msg);
			           				else 
			           					parent.$("#newsNum").hide();	
			           			}
			           		});  		 
					 }
           	} )	
           	
           	
           		/*  $(".send_btn").on("click", function (){
						 $.ajax({
			           			url:"notification_send",
			           			data: {
			           				"eid": $(this).attr('id')
			           			},
			           			type:"post",
			           			dataType:"json",
			           			cache:false,
			           			success:function(msg){
			           			}
			           		});  		 
        		   		})	
         	  	 */
				</script>
					
					
				</div>
			</div>
		</div>
		
	</div>
	<!-- Classie -->
		
	<!--scrolling js-->
	<script src="${pageContext.request.contextPath}/email/js/jquery.nicescroll.js"></script>
	<script src="${pageContext.request.contextPath}/email/js/scripts.js"></script>
	<!--//scrolling js-->
	<!-- Bootstrap Core JavaScript -->
   <script src="${pageContext.request.contextPath}/email/js/bootstrap.js"> </script>
</body>
</html>