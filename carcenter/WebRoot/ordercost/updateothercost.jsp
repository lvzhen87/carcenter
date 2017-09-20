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
th{
	background-color: #E8F0FF;
}
td{
	text-align: center;
}
input{
	width: 120px;
	border:1px solid #36D;
}
#description td{
	text-align: right;
}
.currentLink{
	text-decoration: underline;
	font-size: 14px;
}
</style>
  </head>
<body style="margin: 0px;padding: 0px;">
<div id="man_zone" style="padding-right: 10px;">
<h3 style="margin: 0px;padding: 0px 5px;height: 30px;">
	<img alt="修改道路费用" src="images/pencil.png" style="cursor: hand;" >
	<a href="./initUpdateCostAction?type=1&orderID=${orderID}"  <c:if test="${type==1}" >class="currentLink"</c:if>   >道路费用修改</a>   
	<img alt="修改车间费用" src="images/edit_remove.png" style="cursor: hand;" >
	<a href="./initUpdateCostAction?type=2&orderID=${orderID}" <c:if test="${type==2}" >class="currentLink"</c:if> >车间费用修改</a>
	<img alt="修改其他费用" src="images/redo.png" style="cursor: hand;" >
	<a href="./initUpdateCostAction?type=3&orderID=${orderID}" <c:if test="${type==3}" >class="currentLink"</c:if> >其他费用修改</a>
</h3>
	<!-- 概要说明区域 -->
	<div id="description" style="border: none;">
		<table width="100%" style="border: none;">
			<tr>
				<th width="15%">订单编号</th>
				<th width="35%">${orderID }</th>
				<th width="15%">日期</th>
				<th width="35%"></th>
			</tr>
			<tr>
				<td>公司名称：</td>
				<td style="text-align: left;" >${receptionorder.customer.customerName_s }</td>
				<td>起始日期：</td>
				<td style="text-align: left;">${receptionorder.startDate_s }</td>
				
			</tr>
			<tr>
				<td>负责人：</td>
				<td style="text-align: left;">${receptionorder.customerUser.customerUserName_s }</td>
				<td>截止日期：</td>
				<td style="text-align: left;">${receptionorder.endDate_s }</td>
				
			</tr>
			<!--  
			<tr>
				<td>试验场客服：</td>
				<td></td>
				<td>车辆数目：</td>
				<td></td>
				<td></td>
			</tr>-->
		</table>
	</div>
	<!-- 概要说明区域 end -->
	<div id="costDetail">
		<form action="updateOtherCostAction" name="updateOtherCostForm" id="updateOtherCostForm" method="post">
		<input type="hidden" name="costOther.orderidS"  value="${costOther.orderidS}" >
		<input type="hidden" name="costOther.idI"  value="${costOther.idI}" >
		<input type="hidden" name="orderID"  value="${orderID}" >
		<table width="100%" style="border: none;">
			<tr>
				<th width="30%" >项目</th>
				<th width="20%" >费用（元）</th>
				<th width="40%" >备注</th>
				<th width="10%" >
				更新费用<img alt="保存" title="保存" onclick="submitForm()" src="images/icons/icon_success.png" style="cursor: hand;" >
				</th>
			</tr>
			<tr>
				<td>耗电费：</td>
				<td><input type="text"  name="costOther.electricchargeI" value="${costOther.electricchargeI}" />  </td>
				<td colspan="2" >（RMB/KW/h，估计每天）</td>
			</tr>
			<tr>
				<td>场地管理费：</td>
				<td><input type="text"  name="costOther.administrativefeeI" value="${costOther.administrativefeeI}" />  </td>
				<td colspan="2" >百分比</td>
			</tr>
			<tr>
				<td>电话费：</td>
				<td><input type="text"  name="costOther.telephonebillI" value="${costOther.telephonebillI}" />  </td>
				<td colspan="2" >（预计每天）</td>
			</tr>
			<tr>
				<td>租用技工费：</td>
				<td><input type="text"  name="costOther.artisanchargeI" value="${costOther.artisanchargeI}" />  </td>
				<td colspan="2" >（每小时，6：00-22：00）每天16小时</td>
			</tr>
		</table>	
		</form>
		<script type="text/javascript">
			function submitForm(){
				$("#updateOtherCostForm").submit();
			}
		</script>
	</div>
	
</div>
</body>
</html>
