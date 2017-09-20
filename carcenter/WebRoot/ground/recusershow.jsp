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
    
    <title>在场人员信息查询页面</title>
    
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


  </head>
  
 <body style="padding: 0px;margin: 0px; width: 99%">
   <div id="man_zone" >
   <!-- 条件查询div -->
	<div style="height: 40px;padding: 5px;margin: 0px 0px 0px 10px">
		<!-- 根据条件，查询在场人员信息 -->
		
			<div style="vertical-align:bottom;">
			<table class="dbgrid" style="background-color: #FFF;margin: 0px 0px 0px 10px" width="98%">
			<tr>
			<td style="width: 35%">
			<form id="customeruserForm" name="customeruserForm" action="./searchRecuserShowAction" method="post">
			部门名称：<input type="text" id="deptName" name="deptName" value="${deptName}"  /> 
			人员姓名：<input type="text" id="emplyName" name="emplyName" value="${emplyName}"  />	
				<img onclick="submitSearchForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align:bottom;display: inline;cursor: hand;" >
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<td style="font-size:30px">当前在场人数为：${totalPages }  人</td>
			</form>
			</td>
			</tr>
			</table>
			</div>
		
	</div>
	<script type="text/javascript">
	function submitSearchForm(){
		document.getElementById("customeruserForm").submit();
	}
	setTimeout("submitSearchForm()",20000);
	</script>
	

	<table title="在场人员信息" id="manageordertab"  border="0" width="98%" style="margin: 0px 0px 0px 10px">
			<tr style="font-weight: bold;background-color: #E8F0FF">
				<td width="4%">序号</td>
				<td width="18%">卡号</td>
				<td width="20%">进场人员</td>
				<td width="10%">公司名称</td>
				<td width="20%">部门名称</td>
				<td width="10%">进场时间</td>
			</tr>
		<c:choose>
		<c:when test="${empty customerustlist}">
			<tr><td colspan="7">查无记录！</td></tr>
		</c:when><c:otherwise>
		<c:forEach items="${customerustlist}" var="erList" varStatus="erStatus">
			<c:set var="statusIndex" value="${erStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
				<td>${statusIndex+1 }</td>
				<td>${erList.card_s}</td>
				<td>${erList.customerUserName_s}</td>
				<td>${erList.customerName_s}</td>
				<td>${erList.department_s}</td>
				<td><fmt:formatDate value="${erList.iodate}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				
			</tr>
		</c:forEach>
		</table>
	</c:otherwise>
</c:choose>
	
	<!-- 分页 -->
		<table id="trans" class="dbgrid" style="background-color: #FFF;margin: 0px 0px 0px 10px" width="98%"  >
			<tr>
				<td width="40%" align="left" >
					<div style="display: inline; width: 380px; padding-left: 5px;" >
						共有记录${totalPages }条，分${maxPage}页，当前第${currentPage+1}页
					</div>
				</td>
				<td style="text-align: right;">
					<div style="display: inline;width: 300px;float: right;padding-right: 10px;">
						<a href="./searchRecuserShowAction?currentPage=0&&deptName=${deptName}&&emplyName=${emplyName}" target="manFrame" >首页</a>&nbsp;
						<a href="./searchRecuserShowAction?currentPage=${currentPage-1<=0?0:currentPage-1}&&deptName=${deptName}&&emplyName=${emplyName}">前一页</a>&nbsp;
						<a href="./searchRecuserShowAction?currentPage=${currentPage+1>=maxPage?totalPage-1:currentPage+1}&&deptName=${deptName}&&emplyName=${emplyName}">后一页</a>&nbsp;
						<a href="./searchRecuserShowAction?currentPage=${maxPage-1}&&deptName=${deptName}&&emplyName=${emplyName}">末页</a>&nbsp;&nbsp;
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
	</table>
	</div>
  </body>
</html>