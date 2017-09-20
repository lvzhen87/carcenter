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
    
    <title>车辆查询页面</title>
    
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
		<form id="cardSearchForm" name="cardSearchForm" action="./cardSearchAction" method="post">
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
	<div class="easyui-panel" title="已发放卡片信息" style="padding:10px;height: 440px;vertical-align: top;padding: 0px;display: inline;">
  		
  		<table width="100%">
			<tr>
				<td width="33%">
				<div style="width: 300px;height:380px;margin: 0px;padding: 10px;">
		  			
			  			<h4> <img alt="" src="images/card_person.gif" style="vertical-align: middle;" > 人卡信息【${personcardnum}】</h4>
			  			<ul>
				  			<c:choose>
								<c:when test="${empty personCardList}">
									查无记录！
								</c:when><c:otherwise>
					  				<c:forEach items="${personCardList}" var="percardlist">
				  					<li>${percardlist}</li>
				  					</c:forEach>
				  				</c:otherwise>
			  				</c:choose>
			  		</ul>
			  		
		  		</div>
				</td>
				<td width="33%">
					<div style="width: 300px;height:380px;vertical-align: top;margin: 0px;padding: 10px;">
			  			
			  			<h4><img alt="" src="images/card_oil.gif" style="vertical-align: middle;" >油卡信息【${oilcardnum}】</h4>
			  			<ul>
				  			<c:choose>
								<c:when test="${empty oilCardList}">
									查无记录！
								</c:when><c:otherwise>
					  				<c:forEach items="${oilCardList}" var="oilcardlist">
					  					<li>${oilcardlist}</li>
					  				</c:forEach>
				  				</c:otherwise>
			  				</c:choose>
			  			</ul>
			  			
			  		</div>
				</td>
				<td width="30%">
					<div style="width: 300px;height:380px;vertical-align: top;margin: 0px;padding: 10px;">
			  			
			  			<h4><img alt="" src="images/card_vehicle.gif" style="vertical-align: middle;" >车卡信息【${vehiclecardnum}】</h4>
			  			<ul>
					  		<c:choose>
								<c:when test="${empty vehicleCardList}">
									查无记录！
								</c:when><c:otherwise>
					  				<c:forEach items="${vehicleCardList}" var="vehcardlist">
					  					<li>${vehcardlist}</li>
					  				</c:forEach>
				  				</c:otherwise>
			  				</c:choose>
			  			</ul>
			  		
			  		</div>
				</td>
			</tr>
  		</table>
	</div>
   
   </div>
  </body>
</html>
