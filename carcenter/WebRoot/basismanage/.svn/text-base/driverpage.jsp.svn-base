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
    
    <title>驾驶员信息</title>
    
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
  
 <body style="padding: 0px;margin: 0px;">
   <div id="man_zone">
   <!-- 条件查询div -->
	<div style="height: 40px;padding: 5px;margin-top: 0px;">
		<!-- 根据条件，查询该驾驶员信息 -->
		<form id="driverSearchForm" name="driverSearchForm" action="./searchdriverInfoAction" method="post">
			<div>
				驾驶员编号：<input type="text" id="customerUserID" name="customerUserID" value=""  onblur="Checkfun.isNull(this,'驾驶员编号')"/>
				公司名称：<input type="text" id="customerName" name="customerName" value=""  onblur="Checkfun.isNull(this,'公司名称')"/>
				驾驶员姓名：<input type="text" id="customerUserName" name="customerUserName" value=""  onblur="Checkfun.isNull(this,'驾驶员姓名')"/>
				身份证：<input type="text" id="identityCard" name="identityCard" value=""  onblur="Checkfun.isNull(this,'身份证')"/>
				驾照：<input type="text" id="position" name="position" value=""  onblur="Checkfun.isNull(this,'驾照')"/>
				<img id="driverSearchFormBt" onclick="submitSearchForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				<img onclick="addDriver()" alt="添加" title="添加" src="images/icons/icon_add.png" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >			
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function submitSearchForm(){
			document.getElementById("driverSearchForm").submit();
		}
		
		function addDriver(){
			window.open("./preparedriverInfoAction", "newwindow", "width=980,height=600,top=0,left=0,toolbar=no,menubar=no,location=no,status=no");
		}
	</script>
	<table width="100%" title="驾驶员信息" border="0" >
			<tr>
				<td width="10%">驾驶员编号</td>
				<td width="15%">公司名称</td>
				<td width="10%">驾驶员</td>
				<td width="15%">身份证号</td>
				<td width="10%">驾照号</td>
				<td width="10%">CPG编号</td>
				<td width="10%">CPG级别</td>
				<td width="15%">最后培训日期</td>
				<td width="5%">操作</td>
			</tr>
		<c:choose>
		<c:when test="${empty driverlist}">
			<tr><td colspan="9">查无记录！</td></tr>
		</c:when><c:otherwise>
		<c:forEach items="${driverlist}" var="driverlist" varStatus="driverStatus">
			<c:set var="statusIndex" value="${driverStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
				<td>${driverlist.customerUserID_s}</td>
				<td>${driverlist.customerName_s}</td>
				<td>${driverlist.customerUserName_s }</td>
				<td>${driverlist.identityCard_s }</td>
				<td>${driverlist.position_s }</td>
				<td>${driverlist.drivingLicenceCPG_s}</td>
				<td>${driverlist.levelCPG_s}</td>
				<td>${driverlist.lastTrainDate_t }</td>
				<td>
					<a title="修改" onclick="updateDriver('${driverlist.customerUserID_s}')" >
            				<img src="images/icons/icon_edit.png" style="cursor:hand;"  alt="修改" />
           			</a> 
					<a title="删除" href="./deleteDriverAction?customerUserID=${driverlist.customerUserID_s}">
						<img src="images/icons/cross_circle.png" style="cursor:hand;"  alt="删除" />
					</a> 
				</td>
			</tr>
			</c:forEach>
	</c:otherwise>
	</c:choose>
	<script type="text/javascript">
		function updateDriver(s){
			window.open("./preparedriverInfoAction?customerUserID="+s, "newwindow", "width=980,height=600,top=0,left=0,toolbar=no,menubar=no,location=no,status=no");
		}
	</script>
	</table>
		
	</div>
  </body>
</html>
