<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
	String path = request.getContextPath();
	request.setAttribute("path", path);
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	request.setAttribute("basePath", basePath);
%>

<!-- 分页处理 ：样式-->
<%--分页表单对象 --%>
<form name="frombar" id="frombar">

	<div style="align:center;">
		<label>每页显示</label>
		<select name="pageSize" onchange="goSizePage()" id="goSize" >
			<option value="10" <c:if test="${page.showCount==10}">selected</c:if>>10</option>
			<option value="25" <c:if test="${page.showCount==25}">selected</c:if>>25</option>
			<option value="50" <c:if test="${page.showCount==50}">selected</c:if>>50</option>
			<option value="100" <c:if test="${page.showCount==100}">selected</c:if>>100</option>
		</select>      
		    <label>共${page.totalResult}条记录</label>
		          			
	 	
	 		<c:choose>
			<c:when test="${page.currentPage==1}">
			<input id="btn02" class="layui-btn layui-btn-xs" type="button" value="首页" />
			<input id="btn02" class="layui-btn layui-btn-xs" type="button" value="上一页" />
	     		
	 		</c:when>
			<c:otherwise>
			<input id="btn02" class="layui-btn layui-btn-xs" type="button" value="首页" onclick="location.href='javascript:firstPage()'"/>
			<input id="btn02" class="layui-btn layui-btn-xs" type="button" value="上一页" onclick="location.href='javascript:prePage()'" />
	 	  		
	 		</c:otherwise>
			</c:choose>
	 		   <label>共${page.totalPage}页</label>
	 		<label>转到</label>
	 		<select name="currentPage" onchange="goPage()" id="currentPage">
				<c:forEach var="i" begin="1" end="${page.totalPage}" step="1">
					<option value="${i}" ${i==page.currentPage?"selected":"" }>
						${i}
					</option>
				</c:forEach>
			</select>页 </span>
	 		 		
	 		<c:choose>
			<c:when test="${page.currentPage==page.totalPage}">
			<input id="btn02" class="layui-btn layui-btn-xs" type="button" value="下一页" />
			<input id="btn02" class="layui-btn layui-btn-xs" type="button" value="尾页" />
	 		</c:when>
			<c:otherwise>
			<input id="btn02" class="layui-btn layui-btn-xs" type="button" value="下一页" onclick="location.href='javascript:nextPage()'"/>
			<input id="btn02" class="layui-btn layui-btn-xs" type="button" value="尾页" onclick="location.href='javascript:lagePage()'" />
	
	 		</c:otherwise>
			</c:choose>
				 		 

	
		</div>
</form>

<script>
	/**根据pagebar_bool表单，封装查询的条件、URL=〉frombar分页提交表单中**/
	function copyCondition() {
        var cform =document.getElementById('pagebar_bool'); //分页查询的表单（每个不同的查询表单不同）
        var pform =document.getElementById('frombar');  //frombar 分页提交的表单
        pform.action =cform.action; //分页查询的地址
        pform.method =cform.method; 
        pform.target =cform.target;
        var cels =cform.elements;   
        for(var i=0;i<cels.length;i++){
          var newcel=document.createElement("input");
          newcel.type ="hidden";
          newcel.name =cels[i].name;
          newcel.value =cels[i].value;
          pform.appendChild(newcel); //分页查询的各个条件加入frombar分页提交表单中
        }    
	}
	
	
	/**首页**/
	function firstPage() {
		copyCondition(); //取查询条件
		document.getElementById('currentPage').value = 1;
		var fromTool =document.getElementById('frombar');
		fromTool.submit(); //提交请求
	}
	
	function prePage() {
		copyCondition();
		document.getElementById('currentPage').value = ${page.currentPage - 1};//前一页=当前分页-1
		var fromTool =document.getElementById('frombar');
		fromTool.submit();
	}
		
	function nextPage() {
		copyCondition();
		document.getElementById('currentPage').value = ${page.currentPage + 1};//下一页=当前分页+1
		var fromTool =document.getElementById('frombar');
		fromTool.submit();
	}
	
	function lagePage() {
		copyCondition();
		document.getElementById('currentPage').value = ${page.totalPage};//最后页=总页数
		var fromTool =document.getElementById('frombar');
		fromTool.submit();
	}
	
	function goSizePage() {
		copyCondition();
		document.getElementById('currentPage').value = 1;
		var fromTool =document.getElementById('frombar');
		fromTool.submit();
	}
	
	function goPage() {
		copyCondition();
		var fromTool =document.getElementById('frombar');
		fromTool.submit();
	}
	
</script>
