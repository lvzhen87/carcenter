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
    
    <title>修改客户</title>
    
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
		text-align: right;
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
  
 <body style="margin: 0px;padding: 0px;">
 <div id="man_zone" style="height: 520px;">
  	<table width="90%">
  		<tr>
  			<td class="tor" width="10%">公司名称：</td>
  			<td width="30%"> 
  				<input id="customerName_s" name="customerName_s" type="text" value="${customer.customerName_s }"  onblur="Checkfun.isNull(this,'公司名称')"/>&nbsp;&nbsp;<font color="red">*</font>
  			</td>
  			<td class="tor" width="10%">自定义用户名：</td>
  			<td width="30%"> 
  				<input id="customerLoginName_s" name="customerLoginName_s" type="text" value="${customer.customerLoginName_s}" onblur="Checkfun.isNull(this,'自定义用户名')"/>&nbsp;&nbsp;<font color="red">*</font>
  			</td>
  		</tr>
  		<tr>
  			<td class="tor" width="10%">公司注册地址：</td>
  			<td width="30%"> <input id="registerAddress_s" name="registerAddress_s" type="text" value="${customer.registerAddress_s}" onblur="Checkfun.isNull(this,'公司注册地址')"/>&nbsp;&nbsp;<font color="red">*</font></td>
  			<td class="tor">公司驻地：</td>
  			<td > <input id="customerAddress_s" name="customerAddress_s" type="text" value="${customer.customerAddress_s }" onblur="Checkfun.isNull(this,'公司驻地')"/>&nbsp;&nbsp;<font color="red">*</font> </td>

  		</tr>
  		<tr>
  			<td class="tor">部门名称：</td>
  			<td> <input id="department_s" name="department_s" type="text" value="${customer.department_s }" onblur="Checkfun.isNull(this,'部门名称')"/>&nbsp;&nbsp;<font color="red">*</font> </td>
  			<td class="tor">发票抬头：</td>
  			<td > <input id="invoiceOrder_s" name="invoiceOrder_s" type="text" value="${customer.invoiceOrder_s}" onblur="Checkfun.isNull(this,'发票抬头')"/>&nbsp;&nbsp;<font color="red">*</font> </td>
  		</tr>
  		<tr>
  			<td class="tor">增值税号：</td>
  			<td> <input id="addedValueTax_s" name="addedValueTax_s" type="text" value="${customer.addedValueTax_s}" onblur="Checkfun.isNull(this,'增值税号')"/>&nbsp;&nbsp;<font color="red">*</font> </td>
  			<td class="tor">客户电话：</td>
  			<td> <input id="customerUserPhone_s" name="customerUserPhone_s" type="text" value="${customer.customerUserPhone_s}" onblur="Checkfun.IsPhone(this,'客户电话')"/>&nbsp;&nbsp;<font color="red">*</font> </td>
  		</tr>
  		<tr>
			<td class="tor">发票接收人：</td>
		    <td><input id="invoiceUserID_s" name="invoiceUserID_s" type="text" value="${customer.invoiceUserID_s}" onblur="Checkfun.isNull(this,'发票接收人')"/>&nbsp;&nbsp;<font color="red">*</font></td>
			<td class="tor">发票接收地址：</td>
		    <td><input id="invoiceAddress_s" name="invoiceAddress_s" type="text" value="${customer.invoiceAddress_s}" onblur="Checkfun.isNull(this,'发票接收地址')"/>&nbsp;&nbsp;<font color="red">*</font></td>
		</tr>
		<tr>
			<td class="tor">发票接收人电话：</td>
		    <td><input id="resavedes1" name="resavedes1" type="text" value="${customer.resavedes1}"  />&nbsp;&nbsp;</td>
			<td class="tor">客户联系人：</td>
		    <td>
				<select id="customerUserID_s" name="customerUserID_s" class="easyui-combobox">
  					<c:forEach items="${customerlist}" var="cuslist">
  						<option value="${cuslist.customerUserID_s }" <c:if test="${customer.customerUserID_s==cuslist.customerUserID_s}">selected</c:if>>${cuslist.customerUserName_s}-${cuslist.telephone_s}</option>
  					</c:forEach>
  				</select>
			</td>
		</tr>
		<tr>
			
			<td class="tor">负责人：</td>
		    <td>
		    	<select id="responsibleUserID_s" name="responsibleUserID_s" class="easyui-combobox">
  					<c:forEach items="${customerlist}" var="cuslist">
  						<option value="${cuslist.customerUserID_s }" <c:if test="${customer.responsibleUserID_s==cuslist.customerUserID_s}">selected</c:if>>${cuslist.customerUserName_s}-${cuslist.telephone_s}</option>
  					</c:forEach>
  				</select>
		    </td>
		 
  			<td class="tor" width="10%">密码：</td>
  			<td width="30%"> 
  				<input id="password_s" name="password_s" type="text" value=""  onblur="Checkfun.isNull(this,'密码')"/>&nbsp;&nbsp;<font color="red">*</font>
  			</td>
  			 
  		</tr>
  		<tr>
  			<td colspan="4" align="center"">
  				<input id="customerId" name="customerId" value="${customer.customerID_s }" type="hidden"/>
  				<input type="hidden" id="customerUserID" name="customerUserID"  value=""/>
  				<input type="hidden" id="responsibleUserID" name="responsibleUserID"  value=""/>
  				<a id="addUserBt" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定</a>
  			</td>
  		</tr>
  			
  		
  	</table>
  	</form>
  	<script type="text/javascript">
  		
  	
  		$("#addUserBt").click(function (){
  			
  			if(!Checkfun.isNull($("#customerName_s"),'公司名称','80')){
  				//alert("公司名称不能为空！");
  				return;
  			}
  			//if(!Checkfun.isNull($("#customerUserName_s"),'人员名称','80')){
  				//
  			//	return;
  			//}
  			if(!Checkfun.isNull($("#department_s"),'部门','80')){
  				//alert("部门不能为空！");
  				return;
  			}
  			
  			if(!Checkfun.isNull($("#password_s"),'密码','80')){
  				//alert("密码不能为空！");
  				return;
  			}
  			 	
  			//校验略
  			$("#customerUserID").val($("#customerUserID_s").combobox('getValue'));
  			$("#responsibleUserID").val($("#responsibleUserID_s").combobox('getValue'));
  			//$("#addcustomeruserform").submit();
		  			var str="提交操作？"
		  				$.messager.confirm('确定', str, function(r){
		  				    if (r){
			  				$.post(
			  					"./modifyCustomerAction",
			  	  				{
			  	  					customerId:$("#customerId").val(),
			  	  					customerName_s:$("#customerName_s").val(),
			  	  					customerLoginName_s:$("#customerLoginName_s").val(),
			  	  					registerAddress_s:$("#registerAddress_s").val(),
			  	  					customerAddress_s:$("#customerAddress_s").val(),
			  	  					department_s:$("#department_s").val(),
			  	  					invoiceOrder_s:$("#invoiceOrder_s").val(),
			  	  					addedValueTax_s:$("#addedValueTax_s").val(),
			  	  					customerUserPhone_s:$("#customerUserPhone_s").val(),
			  	  					invoiceUserID_s:$("#invoiceUserID_s").val(),
			  	  					invoiceAddress_s:$("#invoiceAddress_s").val(),
			  	  					responsibleUserID_s:$("#responsibleUserID").val(),
			  	  					customerUserID_s:$("#customerUserID").val(),
			  	  					password_s:$("#password_s").val(),
			  	  					resavedes1:$("#resavedes1").val(),
			  	  					time:new Date().getTime()
			  	  				},function(){
			  	  					$.messager.alert("Success","操作成功！");
				  					window.returnValue="refresh";
				  		  			window.close();
			  	  				}
			  			);
		  			}
  				
  				});
  			
  		
  		});
  	</script>
  	
  	</form>
  </div>
  </body>
</html>
