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
    
    <title>接待模块，查询随行人员</title>
    
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
}
input{
	width: 300px;
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
  
  <body style="padding: 0px;margin: 0px;">
   <div id="man_zone">
   <!-- 条件查询div -->
	<div style="height: 40px;padding: 5px;margin-top: 0px;">
		<!-- 根据订单号，查询该订单的卡片 -->
		<form id="cardSearchForm" name="cardSearchForm" action="./searchEntourageInfoAction" method="post">
			<div>
				订单编号：<input type="text" name="orderID" value="${orderID}" style="width: 220px;height:25px; border: 1px solid #99D;"  onblur="Checkfun.isNull(this,'订单编号')" />
				<img id="cardSearchFormBt" onclick="submitSearchForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				<font>${msg}</font>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function submitSearchForm(){
			document.getElementById("cardSearchForm").submit();
		}
	</script>
   <hr/>
   <!-- 数据区域 -->
	<div class="easyui-panel" title="随行人员信息：" style="padding:10px;height: 440px;vertical-align: top;padding: 0px;display: inline;">
  		
  				<table width="995px"  >
  					<tr style="background-color:#E8F0FF">
			  			<td width="25%">人员编号</td>	
			  			<td width="20%">人员名称</td>	
			  			<td width="25%">类别</td>
			  			<td width="30%">添加日期</td>
			  			<!--  <td width="10%">操作</td>-->
			  		</tr>
			<c:choose>
  			<c:when test="${empty entourages }">
  				<c:if test="${orderID!=null && orderID!=''}">
  				该订单没有随行人员记录！
  				</c:if>
  			</c:when><c:otherwise>
		  		<c:forEach items="${entourages }" var="item" varStatus="entouragesStatus">
	  				<c:set var="statusIndex" value="${entouragesStatus.index}" />
					<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
					<c:if test="${(statusIndex % 2) == 0}">
						<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
					</c:if> 
		  			<tr style="${evenOddStyle}">
		  				<td>${item.customerUserID_s }</td>
		  				<td>${item.customerUserName_s}</td>
		  				<td> 
		  					<c:if test="${item.userType_i==1}" > 客户负责人</c:if>
		  					<c:if test="${item.userType_i==2}" > 陪同人员</c:if>
		  					<c:if test="${item.userType_i==3}" > 驾驶员</c:if>
		  				</td>
		  				<td>${item.createDate_t}</td>
		  				<!--<td>
		  					 <a title="从订单移除" href="./deletereceptCustomerUserAction?orderID=${orderID}&customerUserID=${item.customerUserID_s}">
								<img src="images/icons/cross_circle.png" style="cursor:hand;"  alt="从订单移除" />
							</a>
		  				</td>-->
		  			</tr>
		  		</c:forEach>
		  		
  			</c:otherwise>
  		</c:choose>
  		</table>
	</div>
   </div>
  </body>
</html>
