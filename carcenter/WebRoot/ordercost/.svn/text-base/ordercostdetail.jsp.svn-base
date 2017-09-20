<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>订单费用明细</title>
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
}
tr{
	height: 20px;
}
input{
	width: 120px;
	border:1px solid #36D;
}
#description td{
	text-align: center;
}
</style>
  </head>
<body style="margin: 0px;padding: 0px;">
<jsp:useBean id="now" class="java.util.Date" />
<div id="man_zone" style="width: 1080px;">
	<!-- 概要说明区域 -->
	<div id="description" style="border: none;">
		<table width="100%" style="border: none;">
			<tr>
				<th width="15%">订单编号</th>
				<th width="35%">${orderDetail.orderID_s }</th>
				<th width="15%">日期</th>
				<th width="35%"><fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" /></th>
			</tr>
			<tr>
				<td>公司名称：</td>
				<td>${orderDetail.customer.customerName_s }</td>
				<td>起始日期：</td>
				<td><fmt:formatDate value="${orderDetail.startDate_t}" type="date" pattern="yyyy-MM-dd"/> </td>
			</tr>
			<tr>
				<td>负责人：</td>
				<td>${orderDetail.customerUser.customerUserName_s }</td>
				<td>截止日期：</td>
				<td><fmt:formatDate value="${orderDetail.endDate_t}" type="date" pattern="yyyy-MM-dd"/></td>
			</tr>
			<tr>
				<td>试验场客服：</td>
				<td>${orderDetail.employee.customerUserName_s }</td>
				<td>车辆数目：</td>
				<td>${carNum}(审核通过时)</td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td>共计天数：</td>
				<td>
					<c:set  value="${orderDetail.endDate_t.time-orderDetail.startDate_t.time}" var="interval"></c:set>
					<fmt:formatNumber value="${interval/1000/60/60/24+1}" pattern="#"  />
					天
				</td>
			</tr>
			
		</table>
	</div>
	<!-- 概要说明区域 end -->
	<!-- 估算 明细  start -->
	<h3 style="margin: 0px;padding: 0px;text-align: center;background-color:#E8F0FF; ">中汽中心盐城汽车试验场服务列表</h3>
	<div id="roadcostlist">
		<table width="100%" style="border: none;">
			 
			<c:forEach items="${roadcostlist}" var="item"  varStatus="status">
			<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
			<c:if test="${(status.index % 2) == 0}">
				<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
			</c:if> 
			<tr style="${evenOddStyle}">				
				<td>${item.cardId}</td>
				<c:forEach items="${item.roadInfo}" var="item1"  varStatus="status1">
					<td>${item1}</td>
				</c:forEach>
			</tr>
			</c:forEach>
			 
		</table>	
	</div>
	
	<div id="costDetail">
		<table width="100%" style="border: none;">
			<tr>
				<th width="30%">项目</th>
				<th width="20%">收费类型</th>
				<th width="15%">单价</th>
				<th width="15%">数量</th>
				<th width="20%">总计</th>
			</tr>
			<c:forEach items="${orderCostInfos}" var="item"  varStatus="status">
			<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
			<c:if test="${(status.index % 2) == 0}">
				<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
			</c:if> 
			<tr style="${evenOddStyle}">
				<td>${item.facilityName }</td>
				<td>${item.type }</td>
				<td>${item.unitPrie_i }(${item.unit })</td>
				<td>${item.number }</td>
				<td><fmt:formatNumber value="${item.totalprice }" pattern="#,#00.00#"/></td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="5" class="toright" >试验场服务共计费用 ：<fmt:formatNumber value="${totalMoney}" pattern="#,#00.00#"  />元&nbsp;&nbsp;&nbsp;</td>
			</tr>
		</table>	
	</div>
	
	<div id="orderOtherlist">
		<table width="100%" style="border: none;">
			<tr>
				<th width="30%">项目</th>
				<th width="20%">收费类型</th>
				<th width="15%">单价</th>
				<th width="15%">数量</th>
				<th width="20%">总计</th>
			</tr>
			<c:forEach items="${orderOtherlist}" var="item"  varStatus="status">
			<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
			<c:if test="${(status.index % 2) == 0}">
				<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
			</c:if> 
			<tr style="${evenOddStyle}">
				<td>${item.facilityName }</td>
				<td>${item.type }</td>
				<td>${item.unitPrie_i }(${item.unit })</td>
				<td>${item.number }</td>
				<td><fmt:formatNumber value="${item.totalprice }" pattern="#,#00.00#"/></td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="5" class="toright" >试验场服务共计费用 ：<fmt:formatNumber value="${totalMoney}" pattern="#,#00.00#"  />元&nbsp;&nbsp;&nbsp;</td>
			</tr>
		</table>	
	</div>
	
	<div id="costDetail">
		<table width="100%" style="border: none;">
			<tr>
				<th width="50%">中汽中心盐城汽车试验场提供的其他服务</th>
				<th width="15%">单价</th>
				<th width="15%">数量</th>
				<th width="20%">总计</th>
			</tr>
			<c:forEach begin="0" end="2" varStatus="status">
			<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
			<c:if test="${(status.index % 2) == 0}">
				<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
			</c:if> 
			<tr style="${evenOddStyle}">
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="4" class="toright" >其他服务费用共计：00.00元</td>
			</tr>
		</table>	
	</div>
	<h3 style="margin: 0px;text-align: right;background-color:#E8F0FF; ">费用估算共计:<fmt:formatNumber value="${totalMoney}" pattern="#,#00.00#"  />元&nbsp;&nbsp;&nbsp;&nbsp;</h3>
	
</div>
</body>
</html>
