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
    
    <title>订单道路使用清单查询</title>
    
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
	<div style="height: 40px;padding: 5px;margin: 0px 5px 0px 10px">
		<!-- 根据条件，查询道闸信息 -->
		<form id="searchStationForm" name="searchStationForm" action="./searchPeriodCostAction?time=new Date().getTime()" method="post">
			<div>
				订单编号：<input type="text" id="orderID_s" name="orderID_s" value="${orderID_s }"  />
				试验名称：<input type="text" id="orderName_s" name="orderName_s" value="${orderName_s }"  />
				公司名称：<input type="text" id="customerName" name="customerName" value="${customerName }">
				订单开始时间：<input type="text" class="easyui-datebox" id="startDate"   name="startDate" 
				  data-options="formatter:myformatter,parser:myparser" value="${startDate}"/>
				~<input type="text" class="easyui-datebox" id="endDate" name="endDate"  
				data-options="formatter:myformatter,parser:myparser"  value="${endDate}"/>
				订单状态： <select name="states" id="states" class="easyui-combobox">
								<option value="-1" >请选择订单状态</option>								
								<option value="6" <c:if test="${states == 6 }">selected="selected" </c:if>>试验进行中</option>
								<option value="7" <c:if test="${states == 7 }">selected="selected" </c:if>>试验结束</option>								
						</select>
						
				<!--  
				进出流水号：<input type="text" id="serialNumber_s" name="serialNumber_s" value="${serialNumber_s }"  />
				设施编号：<input type="text" id="facilityID_s" name="facilityID_s" value="${facilityID_s }"  />
				车卡ID编号：<input type="text" id="vehicleID_s" name="vehicleID_s" value="${vehicleID_s }" />
				CPG牌照：<input type="text" id="vehicleCPG_s" name="vehicleCPG_s" value="${vehicleCPG_s }" />
				-->
				<img onclick="submitSearchForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				<!--  <img id="" onclick="addBarrier()" alt="添加" title="添加" src="images/icons/icon_add.png" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >-->
				
			</div>
			
			<div>
				统计开始时间：<input type="text" class="easyui-datebox" id="startComeDate_s"    name="startComeDate_s"
				  data-options="formatter:myformatter,parser:myparser" />
				统计结束时间：<input type="text" class="easyui-datebox" id="endComeDate_s" name="endComeDate_s"
				data-options="formatter:myformatter,parser:myparser"  />
				<input type="hidden" id="orderID_s"/>
				车贴号：<input type="text" id="carid" name="carid" value="${carid }">
			</div>
		</form>
	</div>
	<br/>
	<script type="text/javascript">
		function submitSearchForm(){
			document.getElementById("searchStationForm").submit();
		}
		function submitPeriodCostQuery(orderID_s){			
			startComeDate_s = $("#startComeDate_s").datebox('getValue')
			endComeDate_s = $("#endComeDate_s").datebox('getValue')
			
			  
			if(startComeDate_s.length==0){
				alert("请输入统计开始时间"); 
				startComeDate_s.focus(); 
				return false; 
			}
			if(endComeDate_s.length==0){ 
				alert("请输入统计结束时间"); 
				endComeDate_s.focus(); 
				return false; 
			}
			
			document.getElementById("orderID_s").value=orderID_s;
			document.getElementById("searchStationForm").action = "./periodCostQuery?time=new Date().getTime()";
		 	document.getElementById("searchStationForm").submit();
		}
	</script>

	<table  title="状态信息" id="manageordertab"  border="0" width="98%" style="margin: 0px 0px 0px 10px">
			<tr style="font-weight: bold;background-color: #E8F0FF">
				<td width="4%">序号</td>
				<td width="10%">订单编号</td>
				<td width="20%">试验名称</td>
				<td width="20%">公司名称</td>
				<td width="10%">试验开始日期</td>
				<td width="10%">试验结束日期</td>
				<td width="10%">订单状态</td>
				<td width="10%">上次清单日期</td>
				<td width="6%">详情</td>
			</tr>
		<c:choose>
		<c:when test="${empty OrderList}">
			<tr><td colspan="9">查无记录！</td></tr>
		</c:when><c:otherwise>
		<c:forEach items="${OrderList}" var="orderlist" varStatus="orderlistStatus">
			<c:set var="statusIndex" value="${orderlistStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
				<td>${statusIndex+1 }</td>
				<td>${orderlist.orderID_s}</td>
				<td>${orderlist.orderName_s}</td>
				<td>${orderlist.customer.customerName_s}</td>
				<td>${orderlist.startDate_s}</td>
				<td>${orderlist.endDate_s}</td>
				<td>
					<c:if test="${orderlist.status_i==1}">预订未确认</c:if>
					<c:if test="${orderlist.status_i==2}">预订已确认</c:if>
					<c:if test="${orderlist.status_i==3}">预订取消</c:if>
					<c:if test="${orderlist.status_i==4}">预订冲突</c:if>
					<c:if test="${orderlist.status_i==5}">已进场</c:if>
					<c:if test="${orderlist.status_i==6}">试验进行中</c:if>
					<c:if test="${orderlist.status_i==7}">试验结束</c:if>
					<c:if test="${orderlist.status_i==8}">订单已结算</c:if>
				</td>
				<td>${orderlist.resaveds1_s}</td>
				<td>
					<a id="passimg" class="passcheck" title="道路使用量确认清单" onclick="submitPeriodCostQuery('${orderlist.orderID_s}')">
            		<img src="images/icons/icon_info.png" style="cursor:hand;" />
           			 </a> 
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
							<a href="./searchPeriodCostAction?currentPage=0&orderID_s=${orderID_s}&orderName_s=${orderName_s}&customerName=${customerName}&startDate=${startDate}&endDate=${endDate}&states=${states}" target="manFrame" >首页</a>&nbsp;
							<a href="./searchPeriodCostAction?currentPage=${currentPage-1<=0?0:currentPage-1}&orderID_s=${orderID_s}&orderName_s=${orderName_s}&customerName=${customerName}&startDate=${startDate}&endDate=${endDate}&states=${states}">前一页</a>&nbsp;
							<a href="./searchPeriodCostAction?currentPage=${currentPage+1>=maxPage?totalPage-1:currentPage+1}&orderID_s=${orderID_s}&orderName_s=${orderName_s}&customerName=${customerName}&startDate=${startDate}&endDate=${endDate}&states=${states}">后一页</a>&nbsp;
							<a href="./searchPeriodCostAction?currentPage=${maxPage-1}&orderID_s=${orderID_s}&orderName_s=${orderName_s}&customerName=${customerName}&startDate=${startDate}&endDate=${endDate}&states=${states}">末页</a>&nbsp;&nbsp;
							<form id="changepage" style="display: inline;" action="./searchprocessorderAction?orderID_s=${orderID_s}&orderName_s=${orderName_s}&customerName=${customerName}&startDate=${startDate}&endDate=${endDate}&states=${states}" method="post">
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
</html>
