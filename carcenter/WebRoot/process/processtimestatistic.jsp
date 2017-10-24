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
    
    <title>车辆进出查询页面</title>
    
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
form{
	margin: 0px;
	padding: 0px;
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
		<form id="searchStationForm" name="searchStationForm" action="./roadstaticticstatisticcacu?time=new Date().getTime()" method="post">
			<div>
				<%-- <b><label>订单名称：${orderNameShow}</label></b>&nbsp;&nbsp;&nbsp;&nbsp;<br>
				道路名称：
					<select name="roadID_s" id="roadID_s" class="easyui-combobox">
						<c:choose>
						<c:when test="${empty roadlist}"><option>暂无道路</option></c:when>
						<c:otherwise>
							<option value="-1">请选择道路</option>
						<c:forEach items="${roadlist}" var="r">
							<option value="${r.roadID_s}" <c:if test="${roadID_s==r.roadID_s}">selected="selected"</c:if>>${r.roadName_s}</option>
						</c:forEach></c:otherwise></c:choose>
					</select><!--  <input type="text" id="roadName_s" name="roadName_s" value="${roadName_s }"  />-->
				CPG牌照号：<input type="text" id="vehicleCPG_s" name="vehicleCPG_s" value="${vehicleCPG_s }" /> --%>
				统计时间：<input type="text" class="easyui-datebox" id="inputDate"   name="inputDate"
				  data-options="formatter:myformatter,parser:myparser" value="${inputDate}"/>
			<%-- 	~<input type="text" class="easyui-datebox" id="endDate" name="endDate"  
				data-options="formatter:myformatter,parser:myparser"  value="${endDate}"/> --%>
				
				<span style=" color:red;border:1">日使用率查询<img onclick="submitSearchForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				<img onclick="recsubmitSearchForm()" alt="重新计算" title="重新计算" src="images/redo.png" 
				style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" ></span>
			<span style=" color:red;border:1">月平均使用率查询(耗时较长，请勿在试验高峰时间使用此功能)</span>
			工作日天数:<input type="text"  id="workday"   name="workday"
				  data-options="formatter:myformatter,parser:myparser" value="${workday}"/>
				  <img onclick="submitSearchFormmonth()" alt="月平均使用率" title="月平均使用率" 
			src="images/search.gif" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
			<img onclick="resubmitSearchFormmonth()" alt="重新计算" title="重新计算" src="images/redo.png" 
				style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" ></span>
				<!--  <img id="" onclick="addBarrier()" alt="添加" title="添加" src="images/icons/icon_add.png" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >-->
			<%-- 	<input type="hidden" id="orderID_s" name="orderID_s" value="${orderID_s}"  /> --%>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function submitSearchForm(){
			//alert($("#inputDate").next().children("input").val());
			if($("#inputDate").next().children("input").val() == "")
			{
				$.messager.alert('Faild','请选择统计日期');
				return ;
			}
			//alert($("#inputDate").val());
			document.getElementById("searchStationForm").action="./roadstaticticstatisticcacu?time=new Date().getTime()";
			document.getElementById("searchStationForm").submit();
		}
		
		function submitSearchFormmonth(){
			//alert($("#inputDate").next().children("input").val());
			if($("#inputDate").next().children("input").val() == "")
			{
				$.messager.alert('Faild','请选择统计日期');
				return ;
			}
			if($("#workday").val() == "")
			{
				$.messager.alert('Faild','请输入工作日天数');
				return ;
			}
			if(!isInteger($("#workday").val()))
			{
				$.messager.alert('Faild','工作日天数格式需要是正整数');
				return ;
			}
			//alert($("#inputDate").val());
			document.getElementById("searchStationForm").action="./roadstaticticstatisticcacumonth?time=new Date().getTime()";
			document.getElementById("searchStationForm").submit();
		}
		
		function resubmitSearchFormmonth(){
			//alert($("#inputDate").next().children("input").val());
			if($("#inputDate").next().children("input").val() == "")
			{
				$.messager.alert('Faild','请选择统计日期');
				return ;
			}
			if($("#workday").val() == "")
			{
				$.messager.alert('Faild','请输入工作日天数');
				return ;
			}
			if(!isInteger($("#workday").val()))
			{
				$.messager.alert('Faild','工作日天数格式需要是正整数');
				return ;
			}
			//alert($("#inputDate").val());
			document.getElementById("searchStationForm").action="./reroadstaticticstatisticcacumonth?time=new Date().getTime()";
			document.getElementById("searchStationForm").submit();
		}
		
		function recsubmitSearchForm(){
			if($("#inputDate").next().children("input").val() == "")
			{
				$.messager.alert('Faild','请选择统计日期');
				return ;
			}
			document.getElementById("searchStationForm").action="./reroadstaticticstatisticcacu?time=new Date().getTime()";
			document.getElementById("searchStationForm").submit();
		}
		function isInteger(obj) {
			 return parseInt(obj, 10).toString() === obj.toString();
			}
		
		
	</script>

	<table  title="状态信息" id="manageordertab"  border="0" width="98%" style="margin: 0px 0px 0px 10px">
			<tr style="font-weight: bold;background-color: #E8F0FF">
				<td width="4%">序号</td>
				<!-- <td width="15%">道路编号</td> -->
				<td width="15%">道路名称</td>
				<!-- <td width="13%"></td> -->
				<td width="13%">道路容量</td>
				<td width="10%">道路使用时间</td>
				<td width="10%">试验日期</td>
				<td width="10%">试验时间(分钟)</td>
				<td width="10%">使用率</td>
				 
			</tr>
		<c:choose>
		<c:when test="${empty roaduselist}">
			<tr><td colspan="9">查无记录！</td></tr>
		</c:when><c:otherwise>
		<c:forEach items="${roaduselist}" var="roaduse" varStatus="stationlistStatus">
			<c:set var="statusIndex" value="${stationlistStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
				<td>${statusIndex+1 }</td>
			<%-- 	<td>${roaduselist.roadName_s}</td> --%>
				<td>${roaduse.roadName_s}</td>
				<!-- <td>${stationlist.receptionOrder.orderName_s}</td> -->
				<td>${roaduse.maxcapacity_s}</td>
				<td>${roaduse.usefultime_s}</td>
				<td>${roaduse.createdate_s} </td>
				<%-- <td><fmt:formatDate value="${roaduselist.recordDate_d }" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
				<td>${roaduse.runtime_s}</td>
				<td>${roaduse.rate_s}%</td>
<%-- 				<td>
					<c:if test="${roaduselist.action_s==1}">入</c:if>
					<c:if test="${roaduselist.action_s==2}">出</c:if>
				</td> --%>
				 
				
			</tr>
		</c:forEach>
		
	</c:otherwise>
</c:choose>
	</table>
		<%-- <!-- 分页 -->
			<table id="trans" class="dbgrid" style="background-color: #FFF;margin: 0px 0px 0px 10px" width="98%"  >
				<tr>
					<td width="50%" align="left" >
						<div style="display: inline; width: 380px; padding-left: 10px;" >
							共有记录${totalPages }条，分${maxPage}页，当前第${currentPage+1}页
						</div>
					</td>
					<td width="50%" style="text-align: right;">
						<div style="display: inline;width: 300px;float: right;padding-right: 5px;">
							<a href="./searchprocessAction?currentPage=0&orderID_s=${orderID_s}&roadID_s=${roadID_s}&roadName_s=${roadName_s}&vehicleCPG_s=${vehicleCPG_s}&startDate=${startDate}&endDate=${endDate}" target="manFrame" >首页</a>&nbsp;
							<a href="./searchprocessAction?currentPage=${currentPage-1<=0?0:currentPage-1}&orderID_s=${orderID_s}&roadID_s=${roadID_s}&roadName_s=${roadName_s}&vehicleCPG_s=${vehicleCPG_s}&startDate=${startDate}&endDate=${endDate}">前一页</a>&nbsp;
							<a href="./searchprocessAction?currentPage=${currentPage+1>=maxPage?totalPage-1:currentPage+1}&orderID_s=${orderID_s}&roadID_s=${roadID_s}&roadName_s=${roadName_s}&vehicleCPG_s=${vehicleCPG_s}&startDate=${startDate}&endDate=${endDate}">后一页</a>&nbsp;
							<a href="./searchprocessAction?currentPage=${maxPage-1}&orderID_s=${orderID_s}&roadID_s=${roadID_s}&roadName_s=${roadName_s}&vehicleCPG_s=${vehicleCPG_s}&startDate=${startDate}&endDate=${endDate}">末页</a>&nbsp;&nbsp;
							<form id="changepage" style="display: inline;" action="./searchprocessAction?orderID_s=${orderID_s}&roadID_s=${roadID_s}&roadName_s=${roadName_s}&vehicleCPG_s=${vehicleCPG_s}&startDate=${startDate}&endDate=${endDate}" method="post">
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
			</table> --%>
	</div>
  </body>
</html>
