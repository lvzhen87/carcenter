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
    
    <title>添加客户</title>
    
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
  
 <body style="padding: 0px;margin: 0px; width: 99%">
 <div id="man_zone" >
 	<font color="red" style="margin:0px 0px 0px 10px; font-size: 25px; font-weight:bold;">${sucessmsg}</font>
 	<font color="red" style="margin:0px 0px 0px 10px; font-size: 25px; font-weight:bold;">${errmsg}</font><br/>
    <form id="registform" method="post" action="./registerCustomerAction" enctype="multipart/form-data" >
  	<table width="95%" style="margin:0px 0px 0px 5px;">
		<tr>
		   	<td width="15%" id="customerName">&nbsp;&nbsp;公司名称：</td>
			<td width="35%"><input id="customerName_s" name="customerName_s" type="text" value="${customer.customerName_s }"  onblur="Checkfun.isNull(this,'公司名称',80)"/>&nbsp;&nbsp;<font color="red">*</font></td>
			<td width="15%">&nbsp;&nbsp;自定义用户名(登陆名)：</td>
		    <td width="35%"><input id="customerLoginName_s" name="customerLoginName_s" type="text" value="${customer.customerLoginName_s}" onblur="Checkfun.isNull(this,'自定义用户名',80)"/>&nbsp;&nbsp;<font color="red">*</font></td>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;公司注册地址：</td>
		    <td><input id="registerAddress_s" name="registerAddress_s" type="text" value="${customer.registerAddress_s}" onblur="Checkfun.isNull(this,'公司注册地址',80)"/>&nbsp;&nbsp;<font color="red">*</font></td>
		   	<td width="10%">&nbsp;&nbsp;公司驻地：</td>
		    <td width="20%"><input id="customerAddress_s" name="customerAddress_s" type="text" value="${customer.customerAddress_s }" onblur="Checkfun.isNull(this,'公司驻地',80)"/>&nbsp;&nbsp;<font color="red">*</font></td>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;部门名称：</td>
		    <td><input id="department_s" name="department_s" type="text" value="${customer.department_s }" onblur="Checkfun.isNull(this,'部门名称',80)"/>&nbsp;&nbsp;<font color="red">*</font></td>
			<td>&nbsp;&nbsp;发票抬头：</td>
		    <td><input id="invoiceOrder_s" name="invoiceOrder_s" type="text" value="${customer.invoiceOrder_s}" onblur="Checkfun.isNull(this,'发票抬头',80)"/>&nbsp;&nbsp;<font color="red">*</font></td>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;增值税号：</td>
		    <td><input id="addedValueTax_s" name="addedValueTax_s" type="text" value="${customer.addedValueTax_s}" onblur="Checkfun.isNull(this,'增值税号',80)"/>&nbsp;&nbsp;<font color="red">*</font></td>
			<td>&nbsp;&nbsp;登录密码：</td>
		    <td><input id="password" name="password" type="password" value="" onblur="Checkfun.isNull(this,'账户密码',80)"/>&nbsp;&nbsp;<font color="red">*</font></td>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;确认密码：</td>
		    <td><input id="password2" name="password2" type="password" value="" onblur="Checkfun.isNull(this,'确认密码')"/>&nbsp;&nbsp;<font color="red">*</font></td>
			<td>&nbsp;&nbsp;客户联系人：</td>
		    <td><input id="customerUserName_s" name="customerUserName_s" type="text" value="${customer.customerUserName_s}" onblur="Checkfun.isNull(this,'客户联系人',80)"/>&nbsp;&nbsp;<font color="red">*</font></td>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;联系人电话：</td>
		    <td><input id="customerUserPhone_s" name="customerUserPhone_s" type="text" value="${customer.customerUserPhone_s}" onblur="Checkfun.IsPhone(this,'客户电话')">&nbsp;&nbsp;<font color="red">*</font></td>
			<td>&nbsp;&nbsp;联系人邮箱：</td>
		    <td><input id="customerUserEmail_s" name="customerUserEmail_s" type="text" value="${customer.customerUserEmail_s}" onblur="Checkfun.IsEmail(this,'联系人邮箱')"/>&nbsp;&nbsp;<font color="red">*</font></td>
		</tr>
		<tr>
			<td>&nbsp;&nbsp;联系人身份证号：</td>
		    <td><input id="identifyCard_s" name="identifyCard_s" type="text" value="${identifyCard_s}" onblur="Checkfun.isNull(this,'身份证号',80)"/>&nbsp;&nbsp;<font color="red">*</font></td>
			<td>&nbsp;&nbsp;发票接收人：</td>
		    <td><input id="invoiceUserID_s" name="invoiceUserID_s" type="text" value="${customer.invoiceUserID_s}" onblur="Checkfun.isNull(this,'发票接收人',80)"/>&nbsp;&nbsp;<font color="red">*</font></td>			
		</tr>
		<tr>
			<td>&nbsp;&nbsp;发票接收地址：</td>
		    <td><input id="invoiceAddress_s" name="invoiceAddress_s" type="text" value="${customer.invoiceAddress_s}" onblur="Checkfun.isNull(this,'发票接收地址',80)"/>&nbsp;&nbsp;<font color="red">*</font></td>	
			<td>&nbsp;&nbsp;发票接收人电话：</td>
		    <td><input id="resaveds1_s" name="resaveds1_s" type="text" value="${customer.resavedes1}"  onblur="Checkfun.IsPhone(this,'发票接收人电话')">&nbsp;&nbsp;<font color="red">*</font></td>
		</tr>
		 <!-- 
		<tr>
	       	<td>&nbsp;&nbsp;上传执照：</td>
	        <td> <input name="uploadfile" type="file"/>&nbsp;&nbsp;<font color="red">*（请上传压缩包）</font></td>
		</tr>
		--> 
		<tr>
			<td colspan="4" align="center"">
				<a id="addCustomerUserBt" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
			</td>
		</tr>
  	</table>
  	</form>
  	<script type="text/javascript" src="js/verify.js"></script>
  	
  	<script type="text/javascript">
       	$("#addCustomerUserBt").click(function(){
       		if(!Checkfun.isNull($("#customerName_s"),'公司名称',80)){
       			return false;
       		}
       		if(!Checkfun.isNull($("#customerLoginName_s"),'自定义用户名',80)){
       			return false;
       		}
       		
       		if(!Checkfun.isNull($("#registerAddress_s"),'公司注册地址',80)){
       			return false;
       		}
       		if(!Checkfun.isNull($("#customerAddress_s"),'公司驻地',80)){
       			return false;
       		}
       		
       		if(!Checkfun.isNull($("#department_s"),'部门名称',80)){
       			return false;
       		}
       		if(!Checkfun.isNull($("#invoiceOrder_s"),'发票抬头',80)){
       			return false;
       		}
       		
       		if(!Checkfun.isNull($("#addedValueTax_s"),'增值税号',80)){
       			return false;
       		}
       		

       		if($("#password").val()!=$("#password2").val() ){
       			$("#password").css("border","solid 2px #E33");
       			$("#password2").css("border","solid 2px #E33");					
				return;
       		}
       		if(!Checkfun.isNull($("#customerUserName_s"),'客户联系人',80)){
       			return false;
       		}
       		if(!Checkfun.IsPhone($("#customerUserPhone_s"),'联系人电话')){
       			return false;
       		}
       		if(!Checkfun.IsEmail($("#customerUserEmail_s"),'联系人邮箱')){
       			return false;
       		}
       		if(!Checkfun.isNull($("#invoiceUserID_s"),'发票接收人',80)){
       			return false;
       		}
       		if(!Checkfun.isNull($("#invoiceAddress_s"),'发票接收地址',80)){
       			return false;
       		}
       		 
       		if(!Checkfun.isNull($("#identifyCard_s"),'联系人身份证号')){
       			return false;
       		}
       		
       		if(!Checkfun.isNull($("#resaveds1_s"),'发票接收人电话')){
       			return false;
       		}
			$("#registform").submit();	
		});
       	
  	</script>
  </div>
  </body>
</html>
