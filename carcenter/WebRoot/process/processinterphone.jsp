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
    
    <title>对讲机状态查询页面</title>
    
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


  </head>
  
 <body style="padding: 0px;margin: 0px; width: 99%">
   <div id="man_zone" >
   <!-- 条件查询div -->
	<div style="height: 40px;padding: 5px;margin: 0px 5px 0px 10px">
		<!-- 根据条件，查询道闸信息 -->
		<form id="searchInterphoneForm" name="searchInterphoneForm" action="./searchinterphoneAction?time=new Date().getTime()" method="post">
			<div>
				对讲机编号：<input type="text" id="interphoneID_s" name="interphoneID_s" value="${interphoneID_s }"  />
				<!--  
				操作：<select id="operation_i" name="operation_i">
						<option value="-1">请选择操作</option>
  						<option value="1">发放</option>
  						<option value="2">归还</option>
  				</select>-->
				<img onclick="submitSearchForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				<!--  <img id="" onclick="addBarrier()" alt="添加" title="添加" src="images/icons/icon_add.png" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >-->
				
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function submitSearchForm(){
			document.getElementById("searchInterphoneForm").submit();
		}
		
		//function addBarrier(){
		//	var winPar=window.showModalDialog("./?isUpdate=0", "", "dialogWidth=980px;dialogHeight=600px;toolbar=no;menubar=no;location=no;status=no;scroll=no;");
		// 	//alert(winPar);
		//	if(winPar=="refresh"){
		//		document.getElementById("searchInterphoneForm").submit();
		//	}
		//}
		
	</script>
	

	<table  title="状态信息" id="manageordertab"  border="0" width="98%" style="margin: 0px 0px 0px 10px">
			<tr style="font-weight: bold;background-color: #E8F0FF">
				<td width="4%">序号</td>
				<td width="10%">对讲机编号</td>
				<td width="10%">车卡编号</td>
				<td width="20%">发放人卡编号</td>
				 
				<td width="10%">借出时间</td>
				<td width="10%">归还时间</td>
			
			</tr>
		<c:choose>
		<c:when test="${empty processlist}">
			<tr><td colspan="9">查无记录！</td></tr>
		</c:when><c:otherwise>
		<c:forEach items="${processlist}" var="list" varStatus="processlistStatus">
			<c:set var="statusIndex" value="${processlistStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
				<td>${statusIndex+1 }</td>
				<td>${list.interphoneID_s}</td>
				<td>${list.vehiclecardidS}</td>
				<td>${list.usercardIDS}</td>
				
				<td><fmt:formatDate value="${list.createDate_t}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${list.resaveds1S}</td>
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
							<a href="./searchinterphoneAction?currentPage=0&&interphoneID_s=${interphoneID_s}&&operation_i=${operation_i}" target="manFrame" >首页</a>&nbsp;
							<a href="./searchinterphoneAction?currentPage=${currentPage-1<=0?0:currentPage-1}&&interphoneID_s=${interphoneID_s}&&operation_i=${operation_i}">前一页</a>&nbsp;
							<a href="./searchinterphoneAction?currentPage=${currentPage+1>=maxPage?totalPage-1:currentPage+1}&&interphoneID_s=${interphoneID_s}&&operation_i=${operation_i}">后一页</a>&nbsp;
							<a href="./searchinterphoneAction?currentPage=${maxPage-1}&&interphoneID_s=${interphoneID_s}&&operation_i=${operation_i}">末页</a>&nbsp;&nbsp;
							<form id="changepage" style="display: inline;" action="./searchinterphoneAction" method="post">
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
