<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    
    <title>车辆入场超时查询</title>
    
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
#manageordertab td{
	text-align: center;
}

#trans td{
font-size: 12px;
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

<script type="text/javascript">
	$(function() {  
      //  startRequest();  
        setInterval("submitSearchForm()", 10000);  
    });
function myformatter(date) {
var y = date.getFullYear();
var m = date.getMonth() + 1;
var d = date.getDate();
return y + '-' + (m < 10 ? ('0' + m) : m) + '-'
+ (d < 10 ? ('0' + d) : d);
}
function myparser(s) {
if (!s)
return new Date();
var ss = (s.split('-'));
var y = parseInt(ss[0], 10);
var m = parseInt(ss[1], 10);
var d = parseInt(ss[2], 10);
if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
return new Date(y, m - 1, d);
} else {
return new Date();
}
}
</script>
  </head>
  
 <body style="padding: 0px;margin: 0px; width: 99%">
   <div id="man_zone" >
   <!-- 条件查询div -->
	<div style="height: 40px;padding: 5px;margin: 0px 0px 0px 10px">
		<!-- 根据条件，查询员工消费记录信息 -->
			<form id="searchVeRecordForm" name="searchVeRecordForm" action="./searchOvertimeAction" method="post">
			<!-- 订单名称：<input type="text" id="orderName_s" name="orderName_s" value="${orderName_s}"  />	
			订单编号：<input type="text" id="orderidS" name="orderidS" value="${orderidS}"  />			
			CPG牌照号：<input type="text" id="resaveds2_s" name="resaveds2_s" value="${resaveds2_s}"  /> -->
			道路名称：<select id="roadnameS" name="roadnameS" class="easyui-combobox">
		   				<option value="-1" >全部</option>
		   				<c:forEach items="${roadlist}" var="elist">				
			   				<option value="${elist.roadID_s }" <c:if test="${roadnameS == elist.roadID_s }">selected="selected" </c:if>>${elist.roadName_s }</option>
		   				</c:forEach>
		   			</select>	
		   
		   	 超时时间(分钟)： <input type="text" id="overtimemin" name="overtimemin" value="${overtimemin}"  />	
				<img onclick="submitSearchForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align:bottom;display: inline;cursor: hand;" >				
			</form>		
	</div>
	<script type="text/javascript">
		function submitSearchForm(){ 
		    document.getElementById("searchVeRecordForm").submit();
		}
		
		function updateSpeed(eventnumberS,speedtype_s){
  		
  			$.post(
  				"./updateSpeedAction",
  				{
  					eventnumberS:eventnumberS,  		
  					speedtype_s:speedtype_s,
  					time:new Date().getTime()
  				},function(){
  					submitSearchForm();			
  				}
  			);  			  			
  		};
	</script>
	

	<table title="在场车辆查询" id="manageordertab"  border="0" width="98%" style="margin: 0px 0px 0px 10px">
			<tr style="font-weight: bold;background-color: #E8F0FF">
				<td width="4%">序号</td>
				<td width="8%">订单编号</td>
				<td width="20%">订单名称</td>				
				<td width="22%">公司名称</td>
				<td width="7%">CPG牌照号</td>
				<td width="18%">进入时间</td>			 
				<td >道路名称</td>
				<td >超时时间(分钟)</td>
			</tr>
		<c:choose>
		<c:when test="${empty inoroutinfo}">
			<tr><td colspan="7">查无记录！</td></tr>
		</c:when><c:otherwise>
		<c:forEach items="${inoroutinfo}" var="erList" varStatus="erStatus">
			<c:set var="statusIndex" value="${erStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
				<td>${statusIndex+1 }</td>
				<td>${erList.orderidS}</td>
				<td>${erList.ordernameS}</td>
				<td>${erList.customernameS}</td>
				<td>${erList.resaveds3_s}</td>
				<td>${erList.editflagEndtimeS}</td>				
				<td>${erList.roadnameS}</td>
				<td>${erList.resaveds4_s}</td>
			</tr>
		</c:forEach>
		</table>
	</c:otherwise>
</c:choose>
<input type="hidden" id=roadnameS name="roadnameS" value="${roadnameS }">
<input type="hidden" id="motion_s" name="motion_s" value="${motion_s }">

		 
	</div>
  </body>
</html>