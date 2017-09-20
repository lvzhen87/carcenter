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
  			<td class="tor" width="20%">耗电费用(元/KW/h):</td>
  			<td width="25%"> <input type="text" id="electricCharge_i" name="electricCharge_i" value="${chargeinfo.electricCharge_i}" onblur="Checkfun.IsDouble(this,'包场费用',20)"/> </td>
  		
  			<td class="tor" width="20%">道路使用场地管理费(百分比):</td>
  			<td width="25%"> <input type="text" id="administrativeFee_i" name="administrativeFee_i" value="${chargeinfo.administrativeFee_i}" onblur="Checkfun.IsDouble(this,'费用单价',20)"/> </td>
  			
  		</tr>
  		<tr>
  			<td class="tor">电话费(元):</td>
  			<td> <input type="text" id="telephoneBill_i" name="telephoneBill_i" value="${chargeinfo.telephoneBill_i}" onblur="Checkfun.IsDouble(this,'费用系数',20)"/> </td>
  		
  			<td class="tor">技工(小时/元):</td>
  			<td > <input type="text" id="artisanCharge_i" name="artisanCharge_i" value="${chargeinfo.artisanCharge_i}" onblur="Checkfun.IsDouble(this,'活动包场费用',20)"/> </td>
  			
  		</tr>
  	
  	</table>
  
  	<center>
  		<input type="hidden" id="id_i" name="id_i" value="${chargeinfo.id_i}"/>
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
  				"./modifyChargeAction",
  				{
  					id_i:$("#id_i").val(),
  					electricCharge_i:$("#electricCharge_i").val(),
  					administrativeFee_i:$("#administrativeFee_i").val(),
  					telephoneBill_i:$("#telephoneBill_i").val(),
  					artisanCharge_i:$("#artisanCharge_i").val(),
  					time:new Date().getTime()
  				},function(){
  					$.messager.alert('Success','费用信息操作成功！');
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