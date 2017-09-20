<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>权限设置页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<link rel="stylesheet" href="css/common.css" type="text/css" />	
<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
<link rel="stylesheet" type="text/css" href="css/demo.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/verify.js"></script>
<style type="text/css">
.toright{
	text-align: right;
}
tr{
	height: 25px;
}
td{
	text-align: center;
}
input{
	margin:0;
	padding:0;
	filter:chroma(color=#000000);
	border:none; 
	outline:none;
}
 
h4{
	text-align: center;
	font-size: 13px;
	font-weight: bold;
	color: #222;
}
li{
	
}
</style>

<!--  -->
<script type="text/javascript">
	var nodeSelect;
	$(function() {   
		
		$.ajax({
		        type : "GET",   //提交的方式 
		        url : '\initLimitAction.action',   //提交的action 地址
		        data :time=new Date().getTime(), //这里是要传的action的 需要的参数 没有可以不需要
		        success : function(msg) {
		        	 var Obj = eval("(" + msg + ")");
		        	 $('#tree').tree({
		                 data:Obj,
		 				animate: true,
		 				onClick:function(node){
		 					nodeSelect = node;
		 					//alert(nodeSelect.id);
		 					//alert(nodeSelect.text);
		 				}
		            });
		        },error: function(msg){
		        	
		        	$.messager.alert("Error","ajax 请求错误！");
		            }
		    });
	 
	});
	
	 
		function getChecked(){
			var nodes = $('#tree').tree('getChecked');
			//var text = '';
			//var id= '';
			var limitstr='';
			for(var i=0; i<nodes.length; i++){
				if (limitstr != '') limitstr +='vv';
				limitstr += nodes[i].id+","+ nodes[i].text;
				//if (text != '') text += ',';
				//text += nodes[i].text;
				
				//if (id != '') id += ',';
				//id += nodes[i].id;
			}
			//alert(limitstr);
		}
	</script>
  </head>
 
<body  style="padding: 0px;margin: 0px;width: 99%">
<div id="man_zone" >
   <table style="border:0px #FFF;width: 100%; height: 545px">
	<tr>
	<td width="30%" style="vertical-align: top;">
	<div  class="easyui-panel" style="padding:5px;height: 520px; overflow: scroll; " >
	
	<table width="100%" >
			<tr style="font-weight: bold;background-color: #E8F0FF">
				<td width="25%">岗位信息</td>
			</tr>
		<c:choose>
		<c:when test="${empty oplist}">
			<tr><td>查无记录！</td></tr>
		</c:when><c:otherwise>
		<c:forEach items="${oplist}" var="oplist" varStatus="oplistStatus">
			<c:set var="statusIndex" value="${oplistStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
				<td style="${evenOddStyle}">
					<label onclick="checkorgbtn('${oplist.postName_s}','${oplist.organizationPost_s}',this)"> ${oplist.postName_s} </label>
					<input type="hidden" id="organizationPost_s" name="organizationPost_s"  value="${oplist.organizationPost_s}"/>
				</td>
			</tr>
			</c:forEach>
		</c:otherwise>
		</c:choose>	
		<tr>
			<td><label id="postlab" style="color: red"></label><input type="hidden" id="Post_s" name="Post_s"  value=""/></td>
		</tr>
		<tr>
			<td> 
			 	<a id="addlimitBtn" class="easyui-linkbutton" data-options="iconCls:'icon-add'" >确认授权</a>
			</td>
		</tr>
	</table>
<script type="text/javascript">
	function checkorgbtn(postname,postid,lab){
		$("td").css("background-color","white");
		$(lab).parent().css("background-color","#FFCC66");
		if(postname != ""){
			//alert(postid);
			$.ajax({
		        type : "GET",   //提交的方式 
		        url : '\initLimitAction.action',   //提交的action 地址
		        data : "post="+postid+"& time="+new Date().getTime(), //这里是要传的action的 需要的参数 没有可以不需要
		        success : function(msg) {
		        	 var Obj = eval("(" + msg + ")");
		        	 $('#tree').tree({
		                 data:Obj
		            });
		        },error: function(msg){
		        	
		        	$.messager.alert("Error","ajax 请求错误！");
		        }
		    });
			
			$("#postlab").text("请为"+postname+"授权");
			$("#Post_s").val(postname+","+postid);
		}
	}
	$("#addlimitBtn").click(function(){
		var nodes = $('#tree').tree('getChecked');
		var parentNode ;
		var limitstr='';
		for(var i=0; i<nodes.length; i++){
			if (limitstr != '') limitstr +='vv';
			parentNode = $('#tree').tree('getParent', nodes[i].target);
			if(limitstr.indexOf(parentNode.text) > 0){
				//如果权限中包含一级标题，直接跳过
			}else{
				limitstr += parentNode.id +","+ parentNode.text +"vv";
			}
			limitstr += nodes[i].id+","+ nodes[i].text;
			
		}
		//alert(limitstr);
		
		$.post(
			"./setPostAction",
			{
				post:$("#Post_s").val(),
				limit:limitstr,
				time:new Date().getTime()
			},function(){
				$.messager.alert("Success","授权成功！");
			}
		);
	});
	
</script>
		</div>
	</td> 
	<td  style="vertical-align: top;">

<!-- 右侧表单数据显示区域 -->	
<div id = "dg_div" style="width: 420px">

	<div class="easyui-panel" style="padding:5px ;height: 520px; overflow: scroll;">
		<ul id="tree" class="easyui-tree" data-options="animate:true,checkbox:true"></ul>
	</div>
	

</div>
	</td>
</tr> 
</table>
</div>
</body>
</html>
