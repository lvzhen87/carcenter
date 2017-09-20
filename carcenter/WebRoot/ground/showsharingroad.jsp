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
    
    <title>订单共享试验道路信息页面</title>
<!-- Reset Stylesheet -->
		<link rel="stylesheet" href="css/resources/reset.css" type="text/css" media="screen" />
	  
		<!-- Main Stylesheet -->
		<link rel="stylesheet" href="css/resources/style.css" type="text/css" media="screen" />
		
		<!-- Invalid Stylesheet. This makes stuff look pretty. Remove it if you want the CSS completely valid -->
		<link rel="stylesheet" href="css/resources/invalid.css" type="text/css" media="screen" />	
     
     
     <link  rel="stylesheet" media="screen" href="css/style.css">
     <link  rel="stylesheet" href="css/font-awesome.css">
     
     <link href="css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
     <link rel="stylesheet" href="css/jquery.ui.all.css">
     <link rel="stylesheet" href="css/demos.css">
     <link href="css/hover.css" rel="stylesheet" media="all">
    	<!-- jQuery -->
		<script type="text/javascript" src="js/showjs/jquery-1.3.2.min.js"></script>
		
		<!-- jQuery Configuration -->
		<script type="text/javascript" src="js/showjs/simpla.jquery.configuration.js"></script>
		
		<!-- Facebox jQuery Plugin -->
		<script type="text/javascript" src="js/showjs/facebox.js"></script>
		
		<!-- jQuery WYSIWYG Plugin -->
		<script type="text/javascript" src="js/showjs/jquery.wysiwyg.js"></script>
		
		<!-- jQuery Datepicker Plugin -->
		<script type="text/javascript" src="js/showjs/jquery.datePicker.js"></script>
		<script type="text/javascript" src="js/showjs/jquery.date.js"></script>
	<style type="text/css">
		workshopquery{}
		workshopconflict{}
		.dbgrid{
			width: 1040px;
		}
		th{
			text-align: center;
			font-weight: bold;
			font-size: 14px;
			height: 30px;
			vertical-align: middle;
		}
		td{
			text-align: center;
			height: 25px;
			vertical-align: middle;
		}
		.row0{
			background-color: #EEEEEE;
		}
		.row1{
			background-color: #FFFFFF;
		}
	</style>

  </head>
  
  <body style="padding: 0px;margin: 0px; width: 99%">
   <div class="content-box"><!-- Start Content Box -->
				
		<div class="content-box-header" style="width: 1040px;">
			
			<ul class="content-box-tabs" >
				<li><a href="./showInfoAction">试验基础信息</a></li>
				<li><a href="./showVehicleAction"  >试验车辆</a></li>
				<li><a href="./showSharingroadAction" class="tab-content default-tab">共享试验道路</a></li>
				<li><a href="./showWholeroadAction"  >包场试验道路</a></li>
				<li><a href="./showPreroadAction" >精确预订道路</a></li>
				<li><a href="./showWorkshopAction" >车间办公设施预约</a></li>
				<!-- <li><a href="./showHotelAction"   >酒店预约</a></li> -->
				<li><a href="./showReceptionUserAction" >试验人员管理</a></li>
			</ul>
			<div class="clear"></div>
		</div> <!-- End .content-box-header -->
				
	<div class="content-box-content">
	<!-- start tab1 试验路面预订信息 -->	
		
	<div > <!-- This is the target div. id must match the href of this div's tab -->
	<form action="" method="post" name="checkRoadForm" id="checkRoadForm">
	<table class="dbgrid">
		<thead>
			<tr bgcolor="#E8F0FF">
			   <th width="4%">序号</th>
			   <th width="15%">订单子编号</th>
			   <th width="20%">道路名称</th>
			   <th width="15%">测试车辆数</th>
			   <th width="20%">是否危险</th>
			   <th width="20%">摄影/摄像</th>
			  
			</tr>
		</thead>
		<tbody>
		<!-- 遍历mapSess中存入的相应数据 -->
		<c:choose>
		<c:when test="${empty sharingroadlist}">
			<tr><td colspan="7">查无记录！</td></tr>
		</c:when><c:otherwise>
	       <c:forEach items="${sharingroadlist}" var="roadlist" varStatus="roadlistStatus">
			<c:set var="statusIndex" value="${roadlistStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
			   <td>${statusIndex+1 }</td>
	           <td>${roadlist.orderSharingRoadID_s}</td>
	 		   <td>${roadlist.roadName_s }</td>
	 		   <td>${roadlist.carNumber_i}</td>
			   <td>
			   		<c:if test="${roadlist.isHighRiskTest_i==1}">是</c:if>
			   		<c:if test="${roadlist.isHighRiskTest_i==0}">否</c:if>
			   </td>
			   <td>
					<c:if test="${roadlist.isCamera_i==1}">是</c:if>
			   		<c:if test="${roadlist.isCamera_i==0}">否</c:if>
			   </td>
			  
			  
			</tr>
	       	</c:forEach>	
	       </c:otherwise>
	       </c:choose>
		</tbody>
	</table>
	</form>
	
</div> <!-- End #tab1 -->


	</div> <!-- End .content-box-content -->
				
	</div> <!-- End .content-box -->
 
  </body>
</html>
