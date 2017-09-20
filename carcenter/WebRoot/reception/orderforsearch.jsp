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
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/common.css" type="text/css" />
    <script src="js/script.js"></script> 
    <script src="js/query-1.9.1.js"></script>
    <script src="js/html5shiv.js"></script>
    <script src="forms.js"></script>
	
<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
<link rel="stylesheet" type="text/css" href="css/demo.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<style type="text/css">
.toright{
	text-align: right;
}
tr{
	height: 25px;
}
</style>

  </head>
  
  <body style="margin: 0px;padding: 0px;">
  <div id="man_zone">
	
	<!-- 订单列表区 -->
	<div>
	<div style="margin:10px 0;"></div>
	
	<div class="easyui-accordion" data-options="multiple:true" >
			
		<c:forEach items="${OrderList}" var="orderlist">
		
			<div title="订单编号：${orderlist.orderID_s} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;订单提交时间：${orderlist.createDate_t}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;预定试验日期：${orderlist.startDate_t} ~ ${orderlist.endDate_t}" style="padding:10px;">
				<div>
					<table width="100%" style="border: 0px;">
					<tr>
						<td class="toright" width="10%">客户编号：</td>
						<td width="10%">${orderlist.customer.customerID_s}</td>
						<td class="toright" width="10%">公司名称：</td>
						<td width="20%">${orderlist.customer.customerName_s}</td>
						<td class="toright" width="10%">部门名称：</td>
						<td width="15%">${orderlist.customer.department_s}</td>
						<td class="toright" width="10%">客户电话：</td>
						<td width="10%">${orderlist.customer.customerUserPhone_s}</td>
					</tr>
					<tr>
						<td class="toright">客户联系人：</td>
						<td>${orderlist.customer.customerUserName_s}</td>
						<td class="toright">客户助理：</td>
						<td>${orderlist.employee.customerUserName_s}</td>
						<td class="toright">联系电话：</td>
						<td>${orderlist.employee.telephone_s}</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					</table>
					
				</div>
			</div>
		</c:forEach>
	
	</div>
	
	</div>

  </div>
  </body>
</html>
