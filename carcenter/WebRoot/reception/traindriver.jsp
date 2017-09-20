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
 	<c:choose>
			<c:when test="${empty drivers}">
				查无该驾驶员记录！
			</c:when><c:otherwise>
			<c:forEach items="${drivers}" var="driverlist">
		<table width="90%">
	  		<tr>
	  			<td class="tor" width="10%">公司名称：</td>
	  			<td width="30%"> <input type="text" id="customerName_s" name="customerName_s" onblur="Checkfun.isNull(this,'公司名称')" disabled value="${driverlist.customerName_s}"/></td>
	  			<td class="tor" width="10%">部门名称：</td>
	  			<td width="30%"> <input type="text" id="department_s" name="department_s" onblur="Checkfun.isNull(this,'部门名称')" disabled value="${driverlist.department_s}" /> </td>
	  		</tr>
	  		<tr>
	  			<td class="tor">驾驶员姓名：</td>
	  			<td> <input type="text" id="customerUserName_s" name="customerUserName_s" onblur="Checkfun.isNull(this,'驾驶员姓名')" disabled value="${driverlist.customerUserName_s}"/> </td>
	  			<td class="tor">身份证号：</td>
	  			<td > <input type="text" id="identityCard_s" name="identityCard_s" onblur="Checkfun.isNull(this,'身份证号')" disabled value="${driverlist.identityCard_s}"/> </td>
	  		</tr>
	  		<tr>
	  			<td class="tor">手机号码：</td>
	  			<td> <input type="text" id="telephone_s" name="telephone_s" onblur="Checkfun.isNull(this,'手机号码')" disabled value="${driverlist.telephone_s}"/> </td>
	  			<td class="tor">驾照号：</td>
	  			<td > <input type="text" id="position_s" name="position_s" onblur="Checkfun.isNull(this,'驾照号')" disabled value="${driverlist.position_s}"/> </td>
	  		</tr>
	  		<tr>
	  			<td class="tor">CPG编号：</td>
	  			<td> <input type="text" id="drivingLicenceCPG_s" name="drivingLicenceCPG_s" onblur="Checkfun.isNull(this,'CPG编号')" disabled value="${driverlist.drivingLicenceCPG_s}"/> </td>
	  			<td class="tor">CPG级别：</td>
	  			<td > <input type="text" id="levelCPG_s" name="levelCPG_s" onblur="Checkfun.isNull(this,'CPG级别')" disabled value="${driverlist.levelCPG_s}"/> </td>
	  		</tr>
	  		<tr>
	  			<td class="tor">创建人：</td>
	  			<td><input disabled id="createUser" name="createUser"  value="${driverlist.createUser_s}"/></td>
	  			<td class="tor">创建时间：</td>
	  			<td><input disabled id="createDate" name="createDate"  value="${driverlist.createDate_t}"/></td>	
	  			
	  		</tr>
	  		<tr>
	  			<td class="tor"></td>
	  			<td><input type="hidden" id="customerUserId" name="customerUserId"  value="${driverlist.customerUserID_s}"/></td>
	  			<td class="tor"></td>
	  			<td><input type="hidden" id="customerId" name="customerId"  value="${driverlist.customerID_s}"/> </td>
	  		</tr>
	  		<tr>
	  			<td colspan="4" align="center">
	  				<a id="DriverBt" class="easyui-linkbutton" data-options="iconCls:'icon-add'">培训</a>
	  			</td>
	  		</tr>
  	</table>
			</c:forEach>
			

  	<script type="text/javascript">
  		$("#DriverBt").click(function (){
  			
  			//校验略
  			//$("#adddriverform").submit();
  			$.post(
  				"./trainDriverAction",
  				{
  					customerId:$("#customerId").val(),
  					customerName:$("#customerName_s").val(),
  					department:$("#department_s").val(),
  					customerUserID:$("#customerUserId").val(),
  					customerUserName:$("#customerUserName_s").val(),
  					identityCard:$("#identityCard_s").val(),
  					telephone:$("#telephone_s").val(),
  					position:$("#position_s").val(),
  					drivingLicenceCPG:$("#drivingLicenceCPG_s").val(),
  					levelCPG:$("#levelCPG_s").val(),
  					createUser:$("#createUser").val(),
  					createDate:$("#createDate").val()
  				},function(){
  					$.messager.alert('Success',"驾驶员培训成功！");
  					window.returnValue="refresh";
  		  	  	    window.close();
  				}
  			);
  		});
  	</script>
  
			
	</c:otherwise>
	</c:choose>
 	
  	
  </div>
  </body>
</html>
