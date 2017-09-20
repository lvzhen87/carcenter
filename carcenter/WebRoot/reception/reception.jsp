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

	<script type="text/javascript" src="js/verify.js"></script>
<style type="text/css">
.toright{
	text-align: right;
}
tr{
	height: 25px;
}
.dbgrid{
			width: 1040px;
		}
</style>

  </head>
  
  <body style="padding: 0px;margin: 0px; width: 99%">
  <div id="man_zone">
	<!-- 检索订单区 -->  
	<div style="height: 40px;padding: 5px;margin: 0px 5px 0px 10px">
		<form id="searchorderform" name="searchorderform" action="./searchOrderAction" method="post">
			订单编号：<input type="text" id="orderID" name="orderID" value="${orderID}" style="width: 220px;height:25px; border: 1px solid #99D;"  />
			试验名称：<input type="text" id="orderName" name="orderName" value="${orderName}" style="width: 220px;height:25px; border: 1px solid #99D;"  />
			客户名称：<input type="text" id="customerName" name="customerName" value="${customerName }" style="width: 220px;height:25px; border: 1px solid #99D;"/>
			CPG牌照号：<input type="text" id="resaveds2" name="resaveds2" value="${resaveds2 }" style="width: 220px;height:25px; border: 1px solid #99D;"/>
			<img id="searchOrderFormBt" onclick="submitSearchForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
			<font color="red">${msg}</font>
		</form>
		<script type="text/javascript">
			function submitSearchForm(){
				//alert("查询指定编号订单");
				$("#searchorderform").submit();
			}
		</script>
	</div>
	<!-- 订单列表区 -->
	<div>
	<div style="margin:10px 0;"></div>
	
	<div class="easyui-accordion" data-options="multiple:true" >
		<!-- 判断有无记录 -->
		<c:choose>
			<c:when test="${empty OrderList}">
				查无记录！
			</c:when><c:otherwise>
			
		<c:forEach items="${OrderList}" var="orderlist">
		
			<div title="订单编号：${orderlist.orderID_s} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;试验名称：${orderlist.orderName_s}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;订单提交时间：${orderlist.reservationDate_s}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;预定试验日期：${orderlist.startDate_s} ~ ${orderlist.endDate_s}" style="padding:10px;">
				<div>
					<table width="100%" class="dbgrid">
					<tr>
						<td class="toright" width="10%">发票抬头：</td>
						<td width="10%">${orderlist.customer.invoiceOrder_s}</td>
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
						<td class="toright">客户助理电话：</td>
						<td>${orderlist.employee.telephone_s}</td>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td colspan="8" align="center">
							<a href="./prepareCardAction?orderId=${orderlist.orderID_s}&customerId=${orderlist.customer.customerID_s}&customerName=${orderlist.customer.customerName_s}" class="easyui-linkbutton">确认试验</a>
						</td>
					</tr>
					</table>
					
				</div>
			</div>
		</c:forEach>
		</c:otherwise>
		</c:choose>
	
	</div>
	
	</div>

  </div>
  </body>
</html>
