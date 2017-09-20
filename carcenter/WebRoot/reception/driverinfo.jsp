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
    
    <title>驾驶员查询</title>
    
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
		<form id="driverSearchForm" name="driverSearchForm" action="./searchDriverAction" method="post">
			<div>
				驾驶员编号：<input type="text" id="customerUserID" name="customerUserID" value="${customerUserID}"  onblur="Checkfun.isNull(this,'驾驶员编号')"/>
				公司名称：<input type="text" id="customerName" name="customerName" value="${customerName}"  onblur="Checkfun.isNull(this,'公司名称')"/>
				驾驶员姓名：<input type="text" id="customerUserName" name="customerUserName" value="${customerUserName}"  onblur="Checkfun.isNull(this,'驾驶员姓名')"/>
				身份证：<input type="text" id="identityCard" name="identityCard" value="${identityCard}"  onblur="Checkfun.isNull(this,'身份证')"/>
				驾照：<input type="text" id="position" name="position" value="${position}"  onblur="Checkfun.isNull(this,'驾照')"/>
				<img id="driverSearchFormBt" onclick="submitSearchForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function submitSearchForm(){
			document.getElementById("driverSearchForm").submit();
		}
	</script>
	<table width="100%" title="驾驶员信息" border="0" >
			<tr style="background-color:#E8F0FF">
				<td width="10%">驾驶员编号</td>
				<td width="15%">公司名称</td>
				<td width="10%">驾驶员</td>
				<td width="15%">身份证号</td>
				<td width="10%">驾照号</td>
				<td width="10%">CPG编号</td>
				<td width="10%">CPG级别</td>
				<td width="15%">最后培训日期</td>
				<!-- <td width="5%">&nbsp;</td> -->
			</tr>
			<c:choose>
				<c:when test="${empty drivers}">
					<tr>
						<td colspan="9">
							查无驾驶员信息.
						</td>
					</tr>
				</c:when><c:otherwise>
					<c:forEach items="${drivers }" var="item" varStatus="driverStatus">
						<c:set var="statusIndex" value="${driverStatus.index}" />
						<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
						<c:if test="${(statusIndex % 2) == 0}">
							<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
						</c:if>   
						<tr style="height:20px; border-bottom: 1px solid #666; ${evenOddStyle}">
							<td >${item.customerUserID_s }</td>
							<td >${item.customerName_s }</td>
							<td >${item.customerUserName_s }</td>
							<td >${item.identityCard_s }</td>
							<td >${item.position_s }</td>
							<td >${item.drivingLicenceCPG_s }</td>
							<td >${item.levelCPG_s }</td>
							<td >${item.lastTrainDate_t }</td>
							<!--<td >
								<a title="修改" href="./updateDriverAction?customerUserID_s=${item.customerUserID_s}" >
	            				<img src="images/icons/icon_edit.png" style="cursor:hand;"  alt="修改" />
	           					</a> 
								<a title="删除" href="./preorderCheckAction?customerUserID_s=${item.customerUserID_s}">
									<img src="images/icons/cross_circle.png" style="cursor:hand;"  alt="删除" />
								</a> 
							</td>-->
						</tr>					
					</c:forEach>
				</c:otherwise>
			</c:choose>
			
	</table>
		<div class="dbgrid" style="border: 1px solid #ddd;">
		<!-- 分页 -->
			<table class="dbgrid" style="background-color: #FFF;" >
				<tr>
					<td width="50%" style="text-align: left;" >
						<div style="display: inline; width: 380px; padding-left: 10px;" >
							共有记录${totalPages }条，分${maxPage}页，当前第${currentPage+1}页
						</div>
					</td>
					<td width="50%" style="text-align: right;">
						<div style="display: inline;width: 300px;padding-right: 5px;">
							<a href="./searchDriverAction?flag=page&&currentPage=0&&customerUserID=${customerUserID}&&customerName=${customerName}&&customerUserName=${customerUserName}&&identityCard=${identityCard}&&position=${position}" target="manFrame" >首页</a>&nbsp;
							<a href="./searchDriverAction?flag=page&&currentPage=${currentPage-1<=0?0:currentPage-1}&&customerUserID=${customerUserID}&&customerName=${customerName}&&customerUserName=${customerUserName}&&identityCard=${identityCard}&&position=${position}">前一页</a>&nbsp;
							<a href="./searchDriverAction?flag=page&&currentPage=${currentPage+1>=maxPage?totalPage-1:currentPage+1}&&customerUserID=${customerUserID}&&customerName=${customerName}&&customerUserName=${customerUserName}&&identityCard=${identityCard}&&position=${position}">后一页</a>&nbsp;
							<a href="./searchDriverAction?flag=page&&currentPage=${maxPage-1}&&customerUserID=${customerUserID}&&customerName=${customerName}&&customerUserName=${customerUserName}&&identityCard=${identityCard}&&position=${position}">末页</a>&nbsp;&nbsp;
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
