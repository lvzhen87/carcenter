<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订单道路信息页面</title>
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
<script type="text/javascript">
	function unclick(){
		return false;
	}
</script>
  </head>
  
  <body style="padding: 0px;margin: 0px; width: 99%">
   <div class="content-box"><!-- Start Content Box -->
				
		<div class="content-box-header" style="width: 1040px;">
			<!--<div style="padding-top: 10px;padding-left: 10px;margin: 0px;font-size: 12px;">
				  
				<input type="button"  value="【打开道路占用详情】" onclick="openRoadAccupy()" />
				&nbsp;
				<input type="button"  value="【打开车间占用详情】" onclick="openRoadAccupy()" />
				<script type="text/javascript">
					function openRoadAccupy(){
						window.open("./roadOccupationAction", "newwindow", "width=980,height=600,top=0,left=0,toolbar=no,menubar=no,location=no,status=no");
					}
				</script>
				
			</div>-->
			<ul class="content-box-tabs" >
				<li><a href="./searchInfoDetailAction">试验基础信息</a></li> <!-- href must be unique and match the id of target div -->
				<li><a href="./ordervehicleAction"  >试验车辆</a></li>
				<li><a href="./sharingroadAction" >共享试验道路</a></li>
				<li><a href="./wholeroadAction"   >包场试验道路</a></li>
				<li><a href="./preroadAction" class="tab-content default-tab">精确预订道路</a></li>
				<li><a href="./orderworkshopAction" >车间办公设施预约</a></li>
				<!-- <li><a href="./orderhotelAction"  >酒店预约</a></li> -->
				<li><a href="./regcustomerUserAction" >试验人员管理</a></li>
			</ul>
			<div class="clear"></div>
			<form action="./preroadAction" id="preroadform" name="preroadform" method="post"></form>

		</div> <!-- End .content-box-header -->
				
	<div class="content-box-content">
	<!-- start tab1 试验路面预订信息 -->	
		
	<div> <!-- This is the target div. id must match the href of this div's tab -->
	<form action="" method="post" name="checkRoadForm" id="checkRoadForm">
	<table class="dbgrid">
		<thead>
			<tr bgcolor="#E8F0FF">
				<th width="4%">序号</th>
			   <th width="10%">道路名称</th>
			   <th width="15%">开始日期</th>
			   <th width="15%">预定时间段</th>
			   <th width="10%">车辆数</th>
			   <th width="10%">是否退订</th>
			   <th width="6%">
					<a title="添加" href="./addPreRoadAction"  >
           				<img src="images/icons/add.png" style="cursor:hand;"  alt="添加" />
        			</a> 
			   		<a title="刷新" href="./preroadAction" >
            			<img src="images/icons/arrow_rotate.png" style="cursor:hand;"  alt="刷新" />
           			</a> 
			  </th>
			</tr>
		</thead>
		<tbody>
		<!-- 遍历mapSess中存入的相应数据 -->
		<c:choose>
		<c:when test="${empty preroadlist}">
			<tr><td colspan="7">查无记录！</td></tr>
		</c:when><c:otherwise>
	       <c:forEach items="${preroadlist}" var="preroadlist" varStatus="preroadlistStatus">
			<c:set var="statusIndex" value="${preroadlistStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
				<td>${statusIndex+1 }</td>			
	           <td>${preroadlist.roadName_s}</td>
	 		   <td> <fmt:formatDate value="${preroadlist.startDate_t}" type="date" pattern="yyyy-MM-dd" /> </td>
	 		   <td>${preroadlist.timeQuantum_s}</td>
	 		   <td>${preroadlist.carNumber_i}</td>
	 		    <td>
	 		   		<c:choose>
	 		   			<c:when test="${preroadlist.resaveds3_s== 1}">是</c:when>
	 		   			<c:otherwise>否</c:otherwise>
	 		   		</c:choose>
	 		   </td>
			   <td>
			   		<a title="退订" onclick="conf('${preroadlist.orderPrepaymentRoadID_s}')"  >
            			<img src="images/icons/icon_missing.png" style="cursor:hand;"  alt="退订" />
           			</a> 
			   </td>
			</tr>
	       	</c:forEach>	
	       </c:otherwise>
	       </c:choose>
		</tbody>
	</table>
	</form>
	<script type="text/javascript">
	function modify(t){
		var winPar=window.showModalDialog("./initpreroadAction?orderPrepaymentRoadID_s="+t, "", "dialogWidth=980px;dialogHeight=600px;toolbar=no;menubar=no;location=no;status=no;scroll=no;");
	 	//alert(winPar);
		if(winPar=="refresh"){
			//document.getElementById("searchBarrierForm").submit();
		}
	}
	function conf(s){
		var winPar=window.showModalDialog("./PreRoadRulesAction?orderPrepaymentRoadID_s="+s, "", "dialogWidth=980px;dialogHeight=600px;toolbar=no;menubar=no;location=no;status=no;scroll=no;");
		if(winPar=="refresh"){
			document.getElementById("preroadform").submit();
		}
		// if(window.confirm('你确定要删除该记录！')){
            //alert("确定");
         //   return true;
         //}else{
            //alert("取消");
        //    return false;
        //}
	}
	</script>
	
	
</div> <!-- End #tab1 -->


	</div> <!-- End .content-box-content -->
				
	</div> <!-- End .content-box -->
 
  </body>
</html>