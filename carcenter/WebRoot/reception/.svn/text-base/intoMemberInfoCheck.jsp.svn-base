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
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/common.css" type="text/css" />
    <script src="js/script.js"></script> 
    <script src="js/query-1.9.1.js"></script>
    <script src="js/html5shiv.js"></script>
    <script src="forms.js"></script>
	
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
.dbgrid{
			width: 1040px;
		}
</style>

  </head>
  
  <body style="padding: 0px;margin: 0px; width: 99%">
  <div id="man_zone">
	<!-- 检索订单区 -->  
	<div style="height: 40px;padding: 5px;margin: 10px 5px 0px 10px">
		<form id="doSearchForm" name="doSearchForm" action="./intoMemberInfoCheckAction" method="post">
			人员卡卡号：<input type="text" id="sysNo" name="sysNo" value="${sysNo}" style="width: 220px;height:35px; border: 1px solid #99D;"/>
			<input type="hidden" id="btnFlag" name="btnFlag" value="${btnFlag}"/>
			<img id="searchOrderFormBt" onclick="readCardInfo()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
		</form>
		<object classid="clsid:0b6ed426-9e67-4cf3-99da-8a346a98e5c6" codebase="Setup1.msi" width="0" height="0" id="helloBossma"></object>
		<script type="text/javascript">
			function readCardInfo() {
		         var demo = document.getElementById("helloBossma");
		         var result = demo.GetCardNum();
		         
		         document.getElementById("sysNo").value = result;
		         document.getElementById("btnFlag").value = "searchBtn";
		         
		         $("#doSearchForm").submit();
			}
			function inOrOutBtn(inOrOut){
				if(inOrOut == 1){
					//	参数为1，进道闸
					document.getElementById("btnFlag").value = "inBtn";
			        $("#doSearchForm").submit();
				} else {
					//	参数不为1，出道闸
					document.getElementById("btnFlag").value = "outBtn";
		         	$("#doSearchForm").submit();
				}
			}
			
		</script>
	</div>
	<!-- 订单列表区 -->
	<div>
	<div style="margin:10px 0;"></div>
	<div>
		<div>
			<div>
				<table style="margin: 0px 5px 0px 10px; width: 80%">
				<tr>
					<td class="toright" style="font-weight: bold;background-color: #E8F0FF;width: 10%;height: 45px">人员姓名：</td>
					<td width="15%">${memberName}</td>
					<td class="toright" style="font-weight: bold;background-color: #E8F0FF;width: 10%">公司名称：</td>
					<td width="15%">${companyName}</td>
					<td class="toright" style="font-weight: bold;background-color: #E8F0FF;width: 10%">部门名称：</td>
					<td width="15%">${deptName}</td>
					<td class="toright" style="font-weight: bold;background-color: #E8F0FF;width: 10%">电话：</td>
					<td width="10%">${tellPhone}</td>
				</tr>
				<tr>
					<td class="toright" style="font-weight: bold;background-color: #E8F0FF;width: 10%;height: 45px">驾照号：</td>
					<td>${position}</td>
					<td class="toright" style="font-weight: bold;background-color: #E8F0FF;width: 10%">CPG驾驶证编号：</td>
					<td>${cpgDrivingLicence}</td>
					<td class="toright" style="font-weight: bold;background-color: #E8F0FF;width: 10%">CPG准驾级别：</td>
					<td>${cpgLevel}</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr style="height: 45px">
					<td colspan="4" align="center">
						<a id="inButton" class="easyui-linkbutton" name="inButton" onclick="inOrOutBtn(1)" >&nbsp;&nbsp;&nbsp;&nbsp;进&nbsp;&nbsp;&nbsp;&nbsp;</a>
					</td>
					<td colspan="4" align="center">
						<a id="outButton" class="easyui-linkbutton" name="outButton" onclick="inOrOutBtn(2)" >&nbsp;&nbsp;&nbsp;&nbsp;出&nbsp;&nbsp;&nbsp;&nbsp;</a>
					</td>					
				</tr>
				</table>
			</div>
		</div>
		<p id="inOutMsg" style="font-size: 20;color: red;padding-left: 15px">${inOutMsg }</p>
	</div>
	
	</div>

  </div>
  </body>
</html>
