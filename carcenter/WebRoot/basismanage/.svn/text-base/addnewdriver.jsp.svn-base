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
    
    <title>添加驾驶员</title>
    
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
  
 <body style="margin: 0px;padding: 0px;">
 <div id="man_zone" style="height: 520px;">
  	<form action="./addDriverInfoAction" method="post" id="adddriverform" >
  	<table width="90%">
  		<tr>
  			<td class="tor" width="10%">公司名称：</td>
  			<td width="30%"> 
  				<select id="customer" class="easyui-combobox" >
  					<c:forEach items="${customerListForDriver}" var="cuslist">
  						<option value="${cuslist.customerID_s }">${cuslist.customerName_s}</option>
  					</c:forEach>
  				</select>
  			</td>
  			<td class="tor" width="10%">部门名称：</td>
  			<td width="30%"> <input type="text" id="department_s" name="department_s" value="${driver.department_s}"  onblur="Checkfun.isNull(this,'部门名称')"/> </td>
  		</tr>
  		<tr>
  			<td class="tor">驾驶员姓名：</td>
  			<td> <input type="text" id="customerUserName_s" name="customerUserName_s" value="${driver.customerUserName_s }"  onblur="Checkfun.isNull(this,'驾驶员姓名')"/> </td>
  			<td class="tor">身份证号：</td>
  			<td > <input type="text" id="identityCard_s" name="identityCard_s" value="${driver.identityCard_s }"  onblur="Checkfun.isNull(this,'身份证号')"/> </td>
  		</tr>
  		<tr>
  			<td class="tor">手机号码：</td>
  			<td> <input type="text" id="telephone_s" name="telephone_s" value="${driver.telephone_s }"  onblur="Checkfun.isNull(this,'手机号码')"/> </td>
  			<td class="tor">驾照号：</td>
  			<td > <input type="text" id="position_s" name="position_s" value="${driver.position_s }"  onblur="Checkfun.isNull(this,'驾照号')"/> </td>
  		</tr>
  		<tr>
  			<td colspan="4" align="center"">
  				<a id="addDriverBt" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定</a>
  			</td>
  		</tr>
  	</table>
  	<script type="text/javascript">
  		$("#addDriverBt").click(function (){
  			alert("添加驾驶员");
  			//校验略
  			alert($("#customer option:selected").val());
  			alert($("#customer option:selected").text());
  			//$("#adddriverform").submit();
  			$.post(
  				"./addDriverAction",
  				{
  					customerId:$("#customer option:selected").val(),
  					customerName:$("#customer option:selected").text(),
  					department:$("#department_s").val(),
  					customerUserName:$("#customerUserName_s").val(),
  					identityCard:$("#identityCard_s").val(),
  					telephone:$("#telephone_s").val(),
  					position:$("#position_s").val()
  				},function(){
  					alert("驾驶员信息添加成功！");
  				}
  			);
  		});
  	</script>
  	</form>
  </div>
  </body>
</html>
