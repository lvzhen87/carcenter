<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
	    
		<title>试验场管理信息页面</title>
	    
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
	
	</head>
  
	<body style="padding: 0px;margin: 0px; width: 99%">
		<div id="man_zone" >
			<script type="text/javascript">
			 
			 function doClick(){  
				window.location.href="./setExportBalenceAction";  
			} 
		
			 function ExportBalence()
			 {
			 	$.post("./setExportBalenceAction?time="+new Date());
			 }
			 
			function submitSearchForm(){
				document.getElementById("expendRecordForm").submit();
			}		
			</script>
	

		<table title="详细" id="manageordertab"  border="0" width="98%" style="margin: 10px 0px 0px 10px">
			<tr style="font-weight: bold;background-color: #E8F0FF;height: 45px">
				<td style="width: 80%;font-size: 30">&nbsp;&nbsp;&nbsp;&nbsp;试验场注册客户数量：${customerCount }&nbsp;&nbsp;家</td>
				<td style="width: 20%; "><a href="./registerCustomerSearchAction">详细</a></td>
			</tr>
			<tr style="font-weight: bold;background-color: #FFFFFF;height: 45px">
				<td style="width: 80%;font-size: 30">&nbsp;&nbsp;&nbsp;&nbsp;试验场当前订单数量：${orderCount }&nbsp;&nbsp;件</td>
				<td style="width: 20%;"><a href="./searchRecorderShowAction">详细</a></td>
			</tr>
			<tr style="font-weight: bold;background-color: #E8F0FF;height: 45px">
				<td style="width: 80%;font-size: 30">&nbsp;&nbsp;&nbsp;&nbsp;试验场注册职员数量：${emplyCount }&nbsp;&nbsp;人</td>
				<td style="width: 20%;"><a href="./searchemployeeInfoAction">详细</a></td>
			</tr>
			<tr style="font-weight: bold;background-color: #FFFFFF;height: 45px">
				<td style="width: 80%;font-size: 30">&nbsp;&nbsp;&nbsp;&nbsp;试验场注册试验道路数量：${roadCount }&nbsp;&nbsp;条</td>
				<td style="width: 20%;"><a href="./searchroadAction">详细</a></td>
			</tr>
			<tr style="font-weight: bold;background-color: #E8F0FF;height: 45px">
				<td style="width: 80%;font-size: 30">&nbsp;&nbsp;&nbsp;&nbsp;试验场注册道路道闸数量：${barrierGateCount}&nbsp;&nbsp;对</td>
				<td style="width: 20%;"><a href="./searchbarrierAction">详细</a></td>
			</tr>
			<tr style="font-weight: bold;background-color: #FFFFFF;height: 45px">
				<td style="width: 80%;font-size: 30">&nbsp;&nbsp;&nbsp;&nbsp;试验场注册对讲机数量：${interPhoneCount }&nbsp;&nbsp;台</td>
				<td style="width: 20%;"><a href="./initinterphoneAction">详细</a></td>
			</tr>
			<tr style="font-weight: bold;background-color: #E8F0FF;height: 45px">
				<td style="width: 80%;font-size: 30">&nbsp;&nbsp;&nbsp;&nbsp;试验场注册门禁数量：${entranceCount }&nbsp;&nbsp;个</td>
				<td style="width: 20%;"><a href="./initDoorinfoAction">详细</a></td>
			</tr>
			<tr style="font-weight: bold;background-color: #FFFFFF;height: 45px">
				<td style="width: 80%;font-size: 30">&nbsp;&nbsp;&nbsp;&nbsp;试验场退订、预定时间、精确预定规则共计：
					<c:if test="${unsubscribeRule > 0 || subscribeTimeRule > 0 || accurateSubRule > 0 }">${unsubscribeRule + subscribeTimeRule + accurateSubRule}&nbsp;&nbsp;条 </c:if>
					<c:if test="${(unsubscribeRule + subscribeTimeRule + accurateSubRule) == 0}">暂无 </c:if>
				</td>
				<td style="width: 20%;"></td>
			</tr>
			<tr style="font-weight: bold;background-color: #E8F0FF;height: 40px">
				<td style="width: 80%;font-size: 30">&nbsp;&nbsp;&nbsp;&nbsp;试验场试验管理系统流程数量：55&nbsp;&nbsp;个</td>
				<td style="width: 20%;"></td>
			</tr>
		</table>
	
	</div>
  </body>
</html>