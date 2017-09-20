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
    
    <title>添加收费信息</title>
    
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
 <div id="man_zone" style="height: 520px; width: 1080px;">

  	<table width="90%">
  	 
  		<tr>
  			<td class="tor">新密码:</td>
  			<td> <input type="password" id="password_s" name="password_s"  /> </td>
  		
  			<td class="tor">新密码确认:</td>
  			<td > <input type="password" id="newpwd1" name="newpwd1" /> </td>
  			
  		</tr>
  	
  	</table>
  
  	<center>
  		<input type="hidden" id="id_i" name="id_i" value="${chargeinfo.id_i}"/>
  		<a id="addBt" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定</a>
  	</center>
  	<script type="text/javascript">
  		$("#addBt").click(function (){
  		 newwpd = $("#password_s").val()
 		 if(newwpd.length!=6){
 		 	
 		 	alert('密码长度应为6位');
 		 	 $("#password_s").val("");
 		 	document.getElementById("password_s").focus();
 		 	return
 		 }
   		 newpwd1 = $("#newpwd1").val()
   		 
  		 if(newwpd!=newpwd1){
  		 
  		 	alert('两次输入的密码不同');
  		 	 
  		 	$("#password_s").val("");  		 	
  		 	$("#newpwd1").val("")
  		 	document.getElementById("password_s").focus();
  		 	return;
  		 }
   		//校验略
  		var str="提交操作？"
  		$.messager.confirm('确定', str, function(r){
  			if (r){
  			$.post(
  				"./changepwdAction",
  				{
  					password_s:$("#password_s").val(),  					 
  					time:new Date().getTime()
  				},function(){
  					$.messager.alert('Success','密码修改成功！');
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