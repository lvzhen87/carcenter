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
tr{
	height: 20px;
}
th{
	background-color: #E8F0FF;
}
td{
	text-align: center;
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
	<font style="color: red; font-size: 12px; margin-left: 10px;">${errmsg } </font>
	
</h3>
	<!-- 概要说明区域 -->
	<div id="description" style="border: none;">
		<table width="100%" style="border: none;">
			<tr>
				<th width="15%">订单编号</th>
				<th width="35%">${orderID }<input type="hidden" id="orderID" value="${orderID}" > </th>
				<th width="15%">日期</th>
				<th width="35%"></th>
			</tr>
			<tr>
				<td>公司名称：</td>
				<td style="text-align: left;">${receptionorder.customer.customerName_s }</td>
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
		<table width="100%" style="border: none;"  id="dataTable">
			<tr>
				<th width="10%">道路名称</th>
				<th width="19%">精确预定单价(万元/时)</th>
				<th width="19%">包场预订单价(万元/时)</th>
				<th width="15%">活动包场(万元/半天)</th>
				<th width="10%">单价(元/分钟)</th>
				<th width="10%">起步分钟</th>
				<th width="10%">起步价</th>
				<th width="7%"></th>
			</tr>
			<c:forEach items="${costRoads}" var ="costRoad" varStatus="status">
			<tr>
				<td>${costRoad.roadName}</td>
				<td><input type="text" name="costRoad.unitprieI"  value="${costRoad.unitprieI}"  /> </td>
				<td><input type="text" name="costRoad.wholeunitprieI"  value="${costRoad.wholeunitprieI}"  /> </td>
				<td><input type="text" name="costRoad.activityUnitPrie_i"  value="${costRoad.activityUnitPrie_i}"  /> </td>
				<td><input type="text" name="costRoad.minuteUnitPrie_i"  value="${costRoad.minuteUnitPrie_i}"  /> </td>
				<td><input type="text" name="costRoad.resaveds1_s"  value="${costRoad.resaveds1_s}"  /> </td>
				<td><input type="text" name="costRoad.resaveds2_s"  value="${costRoad.resaveds2_s}"  /> </td>
				
				<td>
					<a title="保存" href="" id="upRoadCostLink" onclick="return updateRoadCost(this,'${costRoad.roadidS}');" >
						<img alt="保存" src="images/icons/icon_success.png" style="cursor: hand;" >
					</a>
				</td>
			</tr>			
			</c:forEach>
		</table>
		<script type="text/javascript">
			function updateRoadCost(link,roadid){
				//alert("更新 道路费用 "+link);
				var hang = $(link).parent().parent().prevAll().length;
				var lie = $(link).parent().prevAll().length;
				//alert(" 当前  行列  "+ hang  +"  "+lie);
				//var cells= $(link).parent().parent();
				//alert($(cells[0][0]).html());
				var orderID=$("#orderID").val();
				//var roadID=document.getElementById('dataTable').rows[hang].cells[0].innerHTML;
				var c1=document.getElementById('dataTable').rows[hang].cells[1].childNodes[0].value;
				var c2=document.getElementById('dataTable').rows[hang].cells[2].childNodes[0].value;
				var c3=document.getElementById('dataTable').rows[hang].cells[3].childNodes[0].value;
				var c4=document.getElementById('dataTable').rows[hang].cells[4].childNodes[0].value;
				var c5=document.getElementById('dataTable').rows[hang].cells[5].childNodes[0].value;
				var c6=document.getElementById('dataTable').rows[hang].cells[6].childNodes[0].value;
				//var remark=document.getElementById('dataTable').rows[hang].cells[5].childNodes[0].value;
				//alert(orderID);
				//alert(document.getElementById('dataTable').rows[hang].cells[0].childNodes[1].value);
				//alert(document.getElementById('dataTable').rows[hang].cells[1].childNodes[0].value);
				$(link).attr("href","updateRoadCostAction?costRoad.roadidS="+roadid+
						"&costRoad.orderidS="+orderID+
						"&costRoad.unitprieI="+c1+
						"&costRoad.wholeunitprieI="+c2+
						"&costRoad.activityUnitPrie_i="+c3+
						"&costRoad.minuteUnitPrie_i="+c4+
						"&costRoad.resaveds1_s="+c5+
						"&costRoad.resaveds2_s="+c6+
						"&orderID="+orderID+
						"&type=1");
				return true;
			}
		</script>
	</div>
</div>
</body>
</html>
