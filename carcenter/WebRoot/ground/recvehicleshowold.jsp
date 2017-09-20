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
    
    <title>在场车辆息查询页面</title>
    
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
	vertical-align:bottom;
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
		
			<div style="vertical-align:bottom;">
			<table class="dbgrid" style="background-color: #FFF;margin: 0px 0px 0px 10px" width="98%">
			<tr>
			<td style="width: 60%">
			<form id="searchVeRecordForm" name="searchVeRecordForm" action="./searchVeRecordShowAction" method="post">
			车卡号：<input type="text" id="vehicleID_s" name="vehicleID_s" value="${vehicleID_s}"  />
			道路名称<select id="orderName_s" name="orderName_s" class="easyui-combobox">
		   				<option value="-1" >全部</option>
		   				<c:forEach items="${roadlist}" var="elist">				
			   					<option value="${elist.roadID_s }" <c:if test="${orderName_s == elist.roadID_s }">selected="selected" </c:if>>${elist.roadName_s }</option>
		   				</c:forEach>
		   			</select>	
		   			进场时间：<input type="text" class="easyui-datebox" id="startDate" name="startDate"
				  data-options="formatter:myformatter,parser:myparser" value="${startDate}"/>
				<img onclick="submitSearchForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align:bottom;display: inline;cursor: hand;" >
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<td style="font-size:30px">当前在场车辆共：${totalPages } 辆</td>
			</form>
			</td>
			</tr>
			</table>
			</div>
		
	</div>
	<script type="text/javascript">

		function submitSearchForm(){ 
		    document.getElementById("searchVeRecordForm").submit();
		}
	</script>
	

	<table title="在场车辆查询" id="manageordertab"  border="0" width="98%" style="margin: 0px 0px 0px 10px">
			<tr style="font-weight: bold;background-color: #E8F0FF">
				<td width="4%">序号</td>
				<td width="18%">订单名称</td>
				<td width="20%">车卡编号</td>
				<td width="10%">进场时间</td>
				<td >道路名称</td>
			</tr>
		<c:choose>
		<c:when test="${empty station}">
			<tr><td colspan="7">查无记录！</td></tr>
		</c:when><c:otherwise>
		<c:forEach items="${station}" var="erList" varStatus="erStatus">
			<c:set var="statusIndex" value="${erStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
				<td>${statusIndex+1 }</td>
				<td>${erList.orderName}</td>
				<td>${erList.vehicleID_s}</td>
				<td><fmt:formatDate value="${erList.recordDate_d}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${erList.facilityName}</td>
				
			</tr>
		</c:forEach>
		</table>
	</c:otherwise>
</c:choose>
	
	<!-- 分页 
		<table id="trans" class="dbgrid" style="background-color: #FFF;margin: 0px 0px 0px 10px" width="98%"  >
			<tr>
				<td width="40%" align="left" >
					<div style="display: inline; width: 380px; padding-left: 5px;" >
						共有记录${totalPages }条，分${maxPage}页，当前第${currentPage+1}页
					</div>
				</td>
				<td style="text-align: right;">
					<div style="display: inline;width: 300px;float: right;padding-right: 10px;">
						<a href="./searchRecuserShowAction?currentPage=0&&deptName=${deptName}" target="manFrame" >首页</a>&nbsp;
						<a href="./searchRecuserShowAction?currentPage=${currentPage-1<=0?0:currentPage-1}&&deptName=${deptName}">前一页</a>&nbsp;
						<a href="./searchRecuserShowAction?currentPage=${currentPage+1>=maxPage?totalPage-1:currentPage+1}&&deptName=${deptName}">后一页</a>&nbsp;
						<a href="./searchRecuserShowAction?currentPage=${maxPage-1}&&deptName=${deptName}">末页</a>&nbsp;&nbsp;
						<form id="changepage" style="display: inline;" action="./searchRecuserShowAction" method="post">
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
	</table>-->
	</div>
  </body>
</html>