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
td{
	text-align: center;
	vertical-align: middle;
}
input{
	width: 200px;
	border:1px solid #36D;
}
.currentFont{
	font-size: 14px;
	font-weight: bold;
}
</style>
  </head>
  <body style="margin: 0px;padding: 0px;">
   <!-- 条件查询div -->
	<div style="height: 40px;padding: 5px;margin-top: 0px;">
		<!-- 根据订单号，查询该订单的车辆信息 -->
		<form id="vehicleSearchForm" name="vehicleSearchForm" action="./searchVehicleInfoAction" method="post">
			<div>
				订单编号：<input type="text" name="orderID" value="${orderID}" style="width: 220px;height:25px; border: 1px solid #99D;"  onblur="Checkfun.isNull(this,'订单编号')" />
				<img id="cardSearchFormBt" onclick="submitSearchForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				<font>${msg}</font>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function submitSearchForm(){
			document.getElementById("vehicleSearchForm").submit();
		}
	</script>
	
  <div id="man_zone" style="height: 480px;">
  	
	  	<div style="height: 25px;padding-left: 10px;">
	  		订单【${orderID }】试验车型
	  	</div>
	  	<!-- 车信息 呈现区域 -->
	  	<div>
	  	
	  		<table width="100%">
	  			<tr style="font-weight: bold; background-color:#E8F0FF">
	  				<td width="20%">车辆型号</td>
	  				<td width="20%">车辆颜色</td>
	  				<td width="20%">CPG牌照</td>
	  				<td width="30%">车卡编号</td>
	  				<!-- <td width="10%">&nbsp;</td> -->
	  			</tr>
	  			<c:choose>
			<c:when test="${empty recVehicleList}">
				<tr><td colspan="4">查无记录！</td></tr>
			</c:when><c:otherwise>
	  			<c:forEach items="${recVehicleList}" var="vehiclelist" varStatus="vehicleStatus">
	  				<c:set var="statusIndex" value="${vehicleStatus.index}" />
					<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
					<c:if test="${(statusIndex % 2) == 0}">
						<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
					</c:if> 
	  				<tr style="${evenOddStyle}">
		  				<td>${vehiclelist.model_s}</td>
		  				<td>${vehiclelist.color_s}</td>
		  				<td>${vehiclelist.vehicleCPG_s}</td>
		  				<td>${vehiclelist.vehicleID_s}</td>
		  				<!-- <td></td> -->
	  				</tr>
	  			</c:forEach>
	  	
  	</c:otherwise>
	</c:choose>	
  	</table>
  </div>
  <div class="dbgrid" style="border: 1px solid #ddd;">
		<!-- 分页 -->
			<table class="dbgrid" style="background-color: #FFF;" >
				<tr>
					<td width="50%" >
						<div style="display: inline; width: 380px; padding-left: 10px;" >
							共有记录${totalPages }条，分${maxPage}页，当前第${currentPage+1}页
						</div>
					</td>
					<td width="50%" style="text-align: right;">
						<div style="display: inline;width: 300px;float: right;padding-right: 5px;">
							<a href="./searchVehicleInfoAction?flag=page&&currentPage=0&&orderID=${orderID}" target="manFrame" >首页</a>&nbsp;
							<a href="./searchVehicleInfoAction?flag=page&&currentPage=${currentPage-1<=0?0:currentPage-1}&&orderID=${orderID}">前一页</a>&nbsp;
							<a href="./searchVehicleInfoAction?flag=page&&currentPage=${currentPage+1>=maxPage?totalPage-1:currentPage+1}&&orderID=${orderID}">后一页</a>&nbsp;
							<a href="./searchVehicleInfoAction?flag=page&&currentPage=${maxPage-1}&&orderID=${orderID}">末页</a>&nbsp;&nbsp;
							<form style="display: inline;" action="./registerCustomerSearchAction" method="post" id="changepage">
								转到第<c:if test="${maxPage==0}">1</c:if>
								<c:if test="${maxPage>0}">
								<select class="easyui-combobox" id="currentPage" name="currentPage" onchange="submitPage()" required="true">
									<c:forEach begin="1" end="${maxPage}" step="1" var="item" >
									<option value="${item-1}" <c:if test="${currentPage+1 == item}">selected="selected" </c:if>>${item }</option>
									</c:forEach>
								</select>
								</c:if>页
							</form>
							<script type="text/javascript">
								$(document).ready(function(){
							        $('#currentPage').combobox({
							            onChange:function(){
							                //alert("准备翻页");
											document.getElementById("changepage").submit();
							            }
							        });
							    });
							</script>
						</div>
					</td>
				</tr>
			</table>
		</div>
	</div>
  </body>
</html>
