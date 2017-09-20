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
    <title>审核区域</title>
    <link rel="stylesheet" href="css/common.css" type="text/css" />
    <script src="js/script.js"></script> 
    <script src="js/query-1.9.1.js"></script>
    <script src="js/html5shiv.js"></script>
    <script src="forms.js"></script>
	
    <style type="text/css">
    	passcheck{}
		unpasscheck{}
		#checkusertab td{
		font-size: 13px;
		padding: 2px;
		text-align: center;
		}
		#checkusertab th{
		font-size: 14px;
		}
		td a{
			text-decoration: underline;
		}
    </style>
</head>

<body>
<div id="man_zone">
  <table id="checkusertab" border="0px" width="100%">
		<tbody>
		<!-- 判断有无记录 -->
		
		<thead>
			<tr style="background-color:#E8F0FF">
			   <th width="4%">序号</th>
			   <th width="10%" >注册编号</th>
			   <th width="15%" >公司名称</th>
			   <th width="15%" >部门名称</th>
               <th width="5%">联系人</th>
			   <th width="10%">公司电话</th>
               <th width="11%">邮箱</th>
			   <th width="5%">操作</th>
			</tr>
			<tr>
				
			</tr>
		</thead>	
		<c:choose>
			<c:when test="${empty customerList}">
				<tr><td colspan="8">没有待审核注册用户！</td></tr>
			</c:when><c:otherwise>	
		<!-- 遍历mapSess中存入的相应数据 -->
        <c:forEach items="${customerList }" var="customerlist" varStatus="userStatus"> 
			<c:set var="statusIndex" value="${userStatus.index}" />
			<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
			<c:if test="${(statusIndex % 2) == 0}">
				<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
			</c:if>  
        <tr style="height:20px; border-bottom: 1px solid #666; ${evenOddStyle}">
           <td>${statusIndex+1 }</td>
           <td>${customerlist.customerID_s }</td>
           <td>${customerlist.customerName_s }</td>
		   <td>${customerlist.department_s }</td>
		   <td>${customerlist.customerUserName_s }</td>
		   <td>${customerlist.customerUserPhone_s}</td>
		   <td>${customerlist.customerUserEmail_s }</td>
			<td>
			<!-- Icons -->
            <a id="passimg" class="passcheck" title="通过" href="./preorderCheckAction?customerstatus=2&userID=${customerlist.customerID_s }" >
            	<img src="images/icons/tick_circle.png" style="cursor:hand;"  alt="审核通过" />
            </a> 
			<a id="unpassimg" class="unpasscheck" title="不通过" href="./preorderCheckAction?customerstatus=0&userID=${customerlist.customerID_s }">
				<img src="images/icons/cross_circle.png" style="cursor:hand;"  alt="审核不过" />
			</a> 
			</td>
		</tr>
		<tr style="${evenOddStyle}">
			<td style="text-align: left;" colspan="4">公司驻地:&nbsp;&nbsp;${customerlist.customerAddress_s }</td>
			<td style="text-align: left;" colspan="5">资质文件:&nbsp;&nbsp;<a href="./downloadFileAction?filePath=${customerlist.uploadFilePath_s }">${customerlist.uploadFilePath_s }</a></td>
		</tr>
		
       	</c:forEach>
			</c:otherwise>
		</c:choose>
		</tbody>					
	</table>
	
</div>
</body>
</html>