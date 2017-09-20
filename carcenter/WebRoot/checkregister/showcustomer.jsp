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
    
    <title>客户基本信息页面</title>
    
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
	padding-right: 10px;
}
tr{
	height: 25px;
}
#manageordertab td{
	text-align: center;
}

#trans td{
font-size: 12px;
}

input{
	width: 120px;
	border:1px solid #36D;
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
</head>

 <body style="padding: 0px;margin: 0px; width: 99%">
<div id="man_zone">

	
	<!--数据区域 -->
  <table id="showcustomer" width="80%" style="margin:0px 0px 0px 5px;">
		<tbody>
		<!-- 判断有无记录 -->
		<c:choose>
			<c:when test="${empty customer}">
				<tr><td>查无记录！</td></tr>
			</c:when><c:otherwise>		
		<!-- 遍历mapSess中存入的相应数据 -->
        <c:forEach items="${customer }" var="customer" varStatus="userStatus">  
			<c:set var="statusIndex" value="${userStatus.index}" />
			<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
			<c:if test="${(statusIndex % 2) == 0}">
				<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
			</c:if>             
        <tr style="height:20px; border-bottom: 1px solid #666; ${evenOddStyle}">
           <td width="20%" class="toright">注册编号:</td>
           <td width="40%" style="padding-left: 10px">${customer.customerID_s }</td>
		</tr>
		<tr >
           <td width="20%" class="toright">自定义用户名:</td>
           <td width="40%" style="padding-left: 10px">${customer.customerLoginName_s}</td>
		</tr>
		<tr >
           <td width="20%" class="toright">公司名称:</td>
           <td width="40%" style="padding-left: 10px">${customer.customerName_s }</td>
		</tr>
		<tr >
           <td width="20%" class="toright">部门名称:</td>
           <td width="40%" style="padding-left: 10px" >${customer.department_s }</td>
		</tr>
		<tr >
           <td width="20%" class="toright">联系人:</td>
           <td width="40%" style="padding-left: 10px">${customer.customerUserName_s }</td>
		</tr>
		<tr >
           <td width="20%" class="toright">公司注册地址:</td>
           <td width="40%" style="padding-left: 10px">${customer.registerAddress_s }</td>
		</tr>
		<tr >
           <td width="20%" class="toright">公司地址:</td>
           <td width="40%" style="padding-left: 10px">${customer.customerAddress_s }</td>
		</tr>
		<tr >
           <td width="20%" class="toright">公司电话:</td>
           <td width="40%" style="padding-left: 10px">${customer.customerUserPhone_s }</td>
		</tr>
		
		<tr >
           <td width="20%" class="toright">公司邮箱:</td>
           <td width="40%" style="padding-left: 10px">${customer.customerUserEmail_s }</td>
		</tr>
		<tr >
           <td width="20%" class="toright">发票抬头:</td>
           <td width="40%" style="padding-left: 10px">${customer.invoiceOrder_s }</td>
		</tr>
		<tr >
           <td width="20%" class="toright">增值税号:</td>
           <td width="40%" style="padding-left: 10px">${customer.addedValueTax_s }</td>
		</tr>
		<tr >
           <td width="20%" class="toright">发票接收人:</td>
           <td width="40%" style="padding-left: 10px">${customer.invoiceUserID_s }</td>
		</tr>
		<tr >
           <td width="20%" class="toright">发票接收地址:</td>
           <td width="40%" style="padding-left: 10px">${customer.invoiceAddress_s }</td>
		</tr>
       	</c:forEach>
			</c:otherwise>
		</c:choose>
		</tbody>					
	</table>
	
</div>
</body>
</html>