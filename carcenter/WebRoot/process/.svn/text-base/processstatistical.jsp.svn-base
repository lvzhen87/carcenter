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
    
    <title>订单车辆总用时查询页面</title>
    
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
	<div style="height: 50px;padding: 5px;margin: 0px 5px 0px 10px">
		<!-- 根据条件，查询道闸信息 -->
		<form id="searchStationForm" name="searchStationForm" action="./searchstatisticAction?time=new Date().getTime()" method="post">
			<div>
			<!--  
				进出流水号：<input type="text" id="serialNumber_s" name="serialNumber_s" value="${serialNumber_s }"  />
				订单编号：<input type="text" id="orderID_s" name="orderID_s" value="${orderID_s }"  />
				设施编号：<input type="text" id="facilityID_s" name="facilityID_s" value="${facilityID_s }"  />
				车卡ID编号：<input type="text" id="vehicleID_s" name="vehicleID_s" value="${vehicleID_s }" />
				CPG牌照：<input type="text" id="vehicleCPG_s" name="vehicleCPG_s" value="${vehicleCPG_s }" />
				<img onclick="submitSearchForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
			-->	<!--  <img id="" onclick="addBarrier()" alt="添加" title="添加" src="images/icons/icon_add.png" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >-->
				<b><label>订单名称：${orderNameShow}</label></b>&nbsp;&nbsp;&nbsp;&nbsp;<br>
				道路名称：<select name="roadID_s" id="roadID_s" class="easyui-combobox">
						<c:choose>
						<c:when test="${empty roadlist}"><option>暂无道路</option></c:when>
						<c:otherwise>
							<option value="-1">请选择道路</option>
						<c:forEach items="${roadlist}" var="r">
							<option value="${r.roadID_s}" <c:if test="${roadID_s==r.roadID_s}">selected="selected"</c:if>>${r.roadName_s}</option>
						</c:forEach></c:otherwise></c:choose>
					</select><!--<input type="text" id="roadName_s" name="roadName_s" value="${roadName_s }"  />  -->
				CPG牌照号：<input type="text" id="vehicleCPG_s" name="vehicleCPG_s" value="${vehicleCPG_s }" />
				进道时间：<input type="text" class="easyui-datebox" id="startSDate"  name="startSDate"  data-options="formatter:myformatter,parser:myparser" value="${startSDate}"/>
				~<input type="text" class="easyui-datebox" id="startEDate"   name="startEDate"  data-options="formatter:myformatter,parser:myparser" value="${startEDate}"/>
				出道时间：<input type="text" class="easyui-datebox" id="endSDate" name="endSDate"  data-options="formatter:myformatter,parser:myparser"  value="${endSDate}"/>
				~<input type="text" class="easyui-datebox" id="endEDate"   name="endEDate"  data-options="formatter:myformatter,parser:myparser" value="${endEDate}"/>
				<img onclick="submitSearchForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
			    <img id="" onclick="addBarrierGateInorOutinfo()" alt="添加" title="添加" src="images/icons/icon_add.png" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				<input type="hidden" id="orderID_s" name="orderID_s" value="${orderID_s}"  />
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function submitSearchForm(){
			document.getElementById("searchStationForm").submit();
		}
		
		
	</script>
	

	<table  title="状态信息" id="manageordertab"  border="0" width="98%" style="margin: 0px 0px 0px 10px">
			<tr style="font-weight: bold;background-color: #E8F0FF">
				<td width="3%">序号</td>
				<td width="10%">CPG牌照号</td>
				<td width="15%">道路名称</td>
				<td width="15%">进道路时间</td>
				<td width="15%">出道路时间</td>				
				<td width="15%">总用时(分钟)</td>
				<td width="15%">共享用时</td>
				<td width="15%">包场及精确用时</td>
				 
				
			</tr>
		<c:choose>
		<c:when test="${empty stationlist}">
			<tr><td colspan="9">查无记录！</td></tr>
		</c:when><c:otherwise>
		<c:forEach items="${stationlist}" var="stationlist" varStatus="stationlistStatus">
			<c:set var="statusIndex" value="${stationlistStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
				<td>${statusIndex+1}</td>
				<td>${stationlist.resaveds5_s}</td>
				<td>${stationlist.roadInfo.roadName_s}</td>
				<!-- <td>${stationlist.orderID_s}</td> -->
				<td><fmt:formatDate value="${stationlist.recordDate_d}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${stationlist.resaveds3_s}</td>
				<td>
					<c:if test="${stationlist.resaveds1_s != 'null'}">
						${stationlist.resaveds1_s}
					</c:if>
				</td>
				<td>
					<c:if test="${stationlist.spanMinute_i != null}">
						${stationlist.spanMinute_i }
					</c:if>
				</td>
				<td>
				<c:if test="${stationlist.resaveds1_s  != null && stationlist.spanMinute_i != null}">
					${stationlist.resaveds1_s-stationlist.spanMinute_i}"
				</c:if>
				</td>
				 
			</tr>
		</c:forEach>
		</table>
	</c:otherwise>
</c:choose>
	
		<!-- 分页 -->
			<table id="trans" class="dbgrid" style="background-color: #FFF;margin: 0px 0px 0px 10px" width="98%"  >
				<tr>
					<td width="50%" align="left" >
						<div style="display: inline; width: 380px; padding-left: 10px;" >
							共有记录${totalPages }条，分${maxPage}页，当前第${currentPage+1}页
						</div>
					</td>
					<td width="50%" style="text-align: right;">
						<div style="display: inline;width: 300px;float: right;padding-right: 5px;">
							<a href="./searchstatisticAction?currentPage=0&orderID_s=${orderID_s}&roadID_s=${roadID_s}&vehicleCPG_s=${vehicleCPG_s}&startSDate=${startSDate}&startEDate=${startEDate}&endSDate=${endSDate}&endEDate=${endEDate}" target="manFrame" >首页</a>&nbsp;
							<a href="./searchstatisticAction?currentPage=${currentPage-1<=0?0:currentPage-1}&orderID_s=${orderID_s}&roadID_s=${roadID_s}&vehicleCPG_s=${vehicleCPG_s}&startSDate=${startSDate}&startEDate=${startEDate}&endSDate=${endSDate}&endEDate=${endEDate}">前一页</a>&nbsp;
							<a href="./searchstatisticAction?currentPage=${currentPage+1>=maxPage?totalPage-1:currentPage+1}&orderID_s=${orderID_s}&roadID_s=${roadID_s}&vehicleCPG_s=${vehicleCPG_s}&startSDate=${startSDate}&startEDate=${startEDate}&endSDate=${endSDate}&endEDate=${endEDate}">后一页</a>&nbsp;
							<a href="./searchstatisticAction?currentPage=${maxPage-1}&orderID_s=${orderID_s}&roadID_s=${roadID_s}&vehicleCPG_s=${vehicleCPG_s}&startSDate=${startSDate}&startEDate=${startEDate}&endSDate=${endSDate}&endEDate=${endEDate}">末页</a>&nbsp;&nbsp;
							<form id="changepage" style="display: inline;" action="./searchstatisticAction?orderID_s=${orderID_s}&roadID_s=${roadID_s}&vehicleCPG_s=${vehicleCPG_s}&startSDate=${startSDate}&startEDate=${startEDate}&endSDate=${endSDate}&endEDate=${endEDate}" method="post">
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
  </body>
  <script type="text/javascript">
  		var timer;
		var winOpen;
  		function IfWindowClosed() {
			if (winOpen.closed == true) {
			 
			    document.getElementById("searchStationForm").submit();
				window.clearInterval(timer)
			}
		}
		function addBarrierGateInorOutinfo(){
			winOpen=window.open("./initAddInorOutBarrierGateAction?orderID_s=${orderID_s}", "newwindow", "width=980,height=300,top=0,left=0,toolbar=no,menubar=no,location=no,status=no");		 		 
			 
			
			timer=window.setInterval("IfWindowClosed()",500);
			
		}
	</script>
</html>
