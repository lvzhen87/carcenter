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
    
    <title>订单酒店信息页面</title>
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
     
	<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
     <link href="css/hover.css" rel="stylesheet" media="all">
    	<!-- jQuery -->
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
		
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
			<!--  
			<div style="padding-top: 10px;padding-left: 10px;margin: 0px;font-size: 12px;">
				
				<input type="button"  value="【打开道路占用详情】" onclick="openRoadAccupy()" />
				&nbsp;
				<input type="button"  value="【打开车间占用详情】" onclick="openRoadAccupy()" />
				<script type="text/javascript">
					function openRoadAccupy(){
						window.open("./roadOccupationAction", "newwindow", "width=980,height=600,top=0,left=0,toolbar=no,menubar=no,location=no,status=no");
					}
				</script>
				
			</div>
			-->
			<ul class="content-box-tabs" >
				<li><a href="./searchInfoDetailAction" >试验基础信息</a></li> <!-- href must be unique and match the id of target div -->
				<li><a href="./ordervehicleAction"  >试验车辆</a></li>
				<li><a href="./sharingroadAction" >共享试验道路</a></li>
				<li><a href="./wholeroadAction"  >包场试验道路</a></li>
				<li><a href="./preroadAction" >精确预订道路</a></li>
				<li><a href="./orderworkshopAction" >车间办公设施预约</a></li>
				<!--<li><a href="./orderhotelAction"   class="tab-content default-tab">酒店预约</a></li>  -->
				<li><a href="./regcustomerUserAction" >试验人员管理</a></li>
			</ul>
			<div class="clear"></div>
			<form action="./orderhotelAction" id="hotelform" name="hotelform" method="post"></form>
		</div> <!-- End .content-box-header -->
				
	<div class="content-box-content">
	<!-- start tab1 试验路面预订信息 -->	
		
	<div > <!-- This is the target div. id must match the href of this div's tab -->
	
	<table class="dbgrid">
		<thead>
			<tr bgcolor="#E8F0FF">
				<th width="4%">序号</th>
			   <!--  <th width="20%">订单编号</th>
			  
			   <th width="10%">标准房数</th>
			   <th width="10%">大床房数</th>
			   <th width="10%">豪华套房数</th>
			   <th width="10%">是否需要租车服务</th>
			    -->
			    <th width="40%">备注信息</th>
			   <th width="10%">租用驾驶员</th>
			   <th width="20%">其他特殊服务</th>
			   <th width="6%">
			   		<a title="添加" onclick="addItem()"  >
           				<img src="images/icons/add.png" style="cursor:hand;"  alt="添加" />
        			</a> 
        		</th>
			</tr>
		</thead>
		<c:choose>
		<c:when test="${empty hotelotherlist}">
			<tr><td colspan="6">查无记录！</td></tr>
		</c:when><c:otherwise>
	       <c:forEach items="${hotelotherlist}" var="hlist" varStatus="hlistStatus">
			<c:set var="statusIndex" value="${hlistStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
				<td>${statusIndex+1 }</td>
	           <!-- <td>${hlist.orderID_s}</td>
	           
	           <td>${hlist.standardRoomNumber_i}</td>
	           <td>${hlist.doubleRoomNumber_i}</td>
	           <td>${hlist.deluxeRoomNUmber_i}</td>
	 		   <td>
					<c:if test="${hlist.isRentalCar_i==1 }">需要</c:if>
	 		   		<c:if test="${hlist.isRentalCar_i==0 }">不需要</c:if>
				</td>
			    <td>
					<c:if test="${hlist.isRentalDriver_i==1 }">需要</c:if>
	 		   		<c:if test="${hlist.isRentalDriver_i==0 }">不需要</c:if>
				</td>
				 -->
				<td>${hlist.type_s}</td>
				<td>
					<c:if test="${hlist.isRentalDriver_i==1}">是</c:if>
				</td>
			    <td>
					${hlist.otherService_s }
				</td>
			   <td>
			   		<a title="修改" onclick="modify('${hlist.orderID_s}')">
            			<img src="images/icons/icon_edit.png" style="cursor:hand;"  alt="修改" />
           			</a>
           			<a title="删除" onclick="deletehotel('${hlist.orderID_s}')"  >
            			<img src="images/icons/icon_missing.png" style="cursor:hand;"  alt="删除" />
           			</a>  
			   </td>
			</tr>
	       	</c:forEach>	
	       </c:otherwise>
	       </c:choose>
	</table>
	
	<script type="text/javascript">
	function modify(t){
		var winPar=window.showModalDialog("./inithotelAction?orderID_s="+t, "", "dialogWidth=980px;dialogHeight=600px;toolbar=no;menubar=no;location=no;status=no;scroll=no;");
	 	//alert(winPar);
		if(winPar=="refresh"){
			document.getElementById("hotelform").submit();
		}
	}
	
	function deletehotel(s){
		var str="确定要删除？";
			$.messager.confirm('删除', str, function(r){
			    if (r){
				
					$.post(
		  				"./delorderhotelAction",
		  				{
		  					orderID_s:s,
		  					time:new Date().getTime()
		  				},function(msg){
		  					document.getElementById("hotelform").submit();
		  				}
		  			);
				}
		    });
	}
	
	function addItem(){
		var winPar=window.showModalDialog("./inithotelAction","","dialogWidth=980px;dialogHeight=600px;toolbar=no;menubar=no;location=no;status=no;scroll=no;");
		if(winPar="refresh"){
			document.getElementById("hotelform").submit();
		}
	}
	</script>
	<br/><br/>
	
</div> <!-- End #tab1 -->


	</div> <!-- End .content-box-content -->
				
	</div> <!-- End .content-box -->
 
  </body>
</html>
