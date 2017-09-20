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
    
    <title>试验场设施查询页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
<link rel="stylesheet" type="text/css" href="css/demo.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>




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
  
  <body>
    <div id="man_zone">
   <!-- 条件查询div -->
	<div style="height: 40px;padding: 5px;margin-top: 0px;">
		<!-- 根据条件，查询该信息 -->
		<form id="searchorderForm" name="searchorderForm" action="./setOccupationalAction?time=new Date().getTime()" method="post">
			<div>
				<!--  订单编号：<input type="text" id="orderID" name="orderID" value=""/>-->
				<img onclick="submitSearchForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				<img onclick="updateState()" alt="添加" title="添加" src="images/icons/icon_add.png" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function submitSearchForm(){
			document.getElementById("searchorderForm").submit();
		}
		function updateState(){
			var winPar=window.showModalDialog("./PrepareUpdatestateAction", "newwindow", "dialogWidth=980px,dialogHeight=600px,toolbar=no,menubar=no,location=no,status=no");
			//alert(winPar);
			if(winPar=="refresh"){
				document.getElementById("searchorderForm").submit();
			}
		}
		
	</script>
	
	<table width="100%" title="试验场订单" border="0" >
			<tr style="font-weight: bold;background-color: #E8F0FF">
				<td width="10%">订单编号</td>
				<td width="20%">设施编号</td>
				<td width="20%">状态</td>
				<td width="20%">特殊信息</td>
				<td width="20%">指定日期</td>
				<td width="10%">操作</td>
			</tr>
		<c:choose>
		<c:when test="${empty facilityStateList }">
			<tr><td colspan="8">查无记录！</td></tr>
		</c:when><c:otherwise>
		<c:forEach items="${facilityStateList }" var="list" varStatus="listStatus">
			<c:set var="statusIndex" value="${listStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
				<td>${list.serialNumber_s }</td>
				<td>${list.facilityID_s }</td>
				<td>
					<c:if test="${list.state_s ==1}">使用</c:if>
					<c:if test="${list.state_s ==2}">闲置</c:if>
				</td>
				<td>${list.specialInfo_s }</td>
				<td>${list.appointDate_d }</td>
				<td>
					<a title="修改" onclick="updatestate('${list.serialNumber_s }')" >
            			<img src="images/icons/icon_edit.png" style="cursor:hand;"  alt="修改" />
           			</a> 
					<a title="删除" href="">
						<img src="images/icons/cross_circle.png" style="cursor:hand;"  alt="删除" />
					</a> 
				</td>
			</tr>
		</c:forEach>
	</c:otherwise>
	</c:choose>	
	<script type="text/javascript">
		function updatestate(s){
			var winPar=window.showModalDialog("./PrepareUpdatestateAction?serialNumber_s="+s, "newwindow", "dialogWidth=980px,dialogHeight=600px,toolbar=no,menubar=no,location=no,status=no");
			//alert(winPar);
			if(winPar=="refresh"){
				document.getElementById("searchorderForm").submit();
			}
		}
	</script>
	</table>
		 <div class="dbgrid" style="border: 1px solid #ddd;">
		<!-- 分页 -->
			<table class="dbgrid" style="background-color: #FFF;" >
				<tr>
					<td width="50%" >
						<div style="display: inline; width: 380px; padding-left: 10px;" >
							共有记录${totalPages }条，分${maxPage}页，当前第${currentPage+1}页
						</div>
					</td>
					<td width="50%" style="text-align: right;">
						<div style="display: inline;width: 300px;float: right;padding-right: 5px;">
							<!--  <a href="./searchworkshopAction?currentPage=0&&workShopID=${workShopID}&&workShopName=${workShopName}&&useInfosearch=${useInfosearch}" target="manFrame" >首页</a>&nbsp;
							<a href="./searchworkshopAction?currentPage=${currentPage-1<=0?0:currentPage-1}&&workShopID=${workShopID}&&workShopName=${workShopName}&&useInfosearch=${useInfosearch}">前一页</a>&nbsp;
							<a href="./searchworkshopAction?currentPage=${currentPage+1>=maxPage?totalPage-1:currentPage+1}&&workShopID=${workShopID}&&workShopName=${workShopName}&&useInfosearch=${useInfosearch}">后一页</a>&nbsp;
							<a href="./searchworkshopAction?currentPage=${maxPage-1}&&workShopID=${workShopID}&&workShopName=${workShopName}&&useInfosearch=${useInfosearch}">末页</a>&nbsp;&nbsp;
							-->
							<form id="changepage" style="display: inline;" action="" method="post">
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
