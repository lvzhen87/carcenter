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
    
    <title>维护常量信息</title>
    
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
	.tor{
		text-align: right;;
	}
	tr{
		height: 30px;
	}
	input{
		width: 300px;
		border:1px solid #36D;
		height: 25px;
	}
	</style>

  </head>
  
 <body style="margin: 0px;padding: 0px; width: 1100px">
 <div id="man_zone"  >

  	<table width="90%">
  		
  		<tr>
  			<td class="tor" width="30%">常量名称:</td>
  			<td > <input readonly="readonly" type="text" id="constantName_s" name="constantName_s" value="${constantInfo.constantName_s}" /> </td>
  		
  		</tr>
  		<tr>
  			 
  			<td class="tor">常量描述:</td>
  			<td > <input type="text" id="constantDescribe_s" name="constantDescribe_s" value="${constantInfo.constantDescribe_s}" /> </td>
  			
  		</tr>
  		<tr>
  			<td class="tor">常量值:</td>
  			<td> <input type="text" id="constantValues_s" name="constantValues_s" value="${constantInfo.constantValues_s}" /> </td>
  		 
  		</tr>
  	</table>
  
  	<center>
  		<input type="hidden" id="constantID_s" name="constantID_s" value="${constantInfo.constantID_s}"/>
  		<a id="addBt" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定</a>
  	</center>
  	<script type="text/javascript">
  		$("#addBt").click(function (){
  		
  		//校验略
  			
  			
  		//校验略
  		var str="提交操作？"
  		$.messager.confirm('确定', str, function(r){
  			if (r){
  			$.post(
  				"./modifyConstantAction",
  				{
  					constantID_s:$("#constantID_s").val(),
  					constantValues_s:$("#constantValues_s").val(),
  					constantDescribe_s:$("#constantDescribe_s").val(),  					
  					time:new Date().getTime()
  				},function(){
  					$.messager.alert('Success','常量信息操作成功！');
  					window.returnValue="refresh";
  		  			window.close();
  				}
  			);
  			
  			}
  		});
  			//document.getElementById("addroadinfoform").submit();
  	  	  	//window.returnValue="refresh";
	  	   // window.close();
  			
  		});
  	</script>
 
  </div>
  </body>
</html>