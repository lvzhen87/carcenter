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
    
    <title>订单车辆信息页面</title>
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
				<li><a href="./ordervehicleAction"  class="tab-content default-tab" >试验车辆</a></li>
				<li><a href="./sharingroadAction" >共享试验道路</a></li>
				<li><a href="./wholeroadAction"  >包场试验道路</a></li>
				<li><a href="./preroadAction" >精确预订道路</a></li>
				<li><a href="./orderworkshopAction" >车间办公设施预约</a></li>
				<!-- <li><a href="./orderhotelAction"  >酒店预约</a></li> -->
				<li><a href="./regcustomerUserAction" >试验人员管理</a></li>
			</ul>
			<div class="clear"></div>
		</div> <!-- End .content-box-header -->
		<form action="./ordervehicleAction" id="vehicleform" name="vehicleform" method="post"></form>
	<div class="content-box-content">
	<!-- start tab1 试验路面预订信息 -->	
		
	<div> <!-- This is the target div. id must match the href of this div's tab -->
	<form action="" method="post" name="checkRoadForm" id="checkRoadForm">
	<table class="dbgrid">
	 <c:if test="${orderStatus <= 3}">
		<thead>
			<tr bgcolor="#E8F0FF">
			   <th width="4%">序号</th>
			   <th width="15%">CPG号</th>
			   <th width="10%">类型</th>
			   <th width="8%">车轴数</th>
			   <th width="8%">燃料需求</th>
			   <th width="10%">预计消耗量</th>
			   <th width="8%">品牌型号</th>
			   <th width="8%">最高车速</th>
			  <!--   <th width="20%">授权道路</th>-->
			   <th >
			  
			   		<a title="添加" onclick="addItem('${orderId}')">
            			<img src="images/icons/add.png" style="cursor:hand;"  alt="添加" />
           			</a> 
           		</th>
			</tr>
		</thead>
		<tbody>
		<!-- 遍历mapSess中存入的相应数据 -->
		<c:choose>
		<c:when test="${empty vehiclelist}">
			<tr><td colspan="12">查无记录！</td></tr>
		</c:when><c:otherwise>
	       <c:forEach items="${vehiclelist}" var="vlist" varStatus="vlistStatus">
			<c:set var="statusIndex" value="${vlistStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
			   <td>${statusIndex+1 }</td>
	           <td>${vlist.vehicleCPG_s}</td>
	 		   <td>${vlist.model_s}</td>
	 		   <td>${vlist.axleNumber_i }</td>
			   <td>${vlist.fuelDemand_s}</td>
	 		   <td>${vlist.fuelConsumption_s }</td>
			   <td>${vlist.brandType_s } </td>
			   <td>${vlist.maxSpeed_s } </td>
			   <td>
			   <!--  
			   		<c:if test="${orderStatus >3}">
			   		<a title="修改" onclick="modifyrec('${vlist.orderID_s }','${vlist.vehicleCPG_s}')">
            			<img src="images/icons/icon_edit.png" style="cursor:hand;"  alt="修改" />
           			</a> 
           			<a title="删除" onclick="deleterecvehicle('${vlist.orderID_s }','${vlist.vehicleCPG_s}')" >
            			<img src="images/icons/icon_missing.png" style="cursor:hand;"  alt="删除" />
           			</a> 
           			</c:if>
           			<c:if test="${orderStatus <3 }">-->
           			<a title="修改" onclick="modify('${vlist.orderID_s }','${vlist.vehicleCPG_s}')">
            			<img src="images/icons/icon_edit.png" style="cursor:hand;"  alt="修改" />
           			</a> 
           			<a title="删除" onclick="deletevehicle('${vlist.orderID_s }','${vlist.vehicleCPG_s}')" >
            			<img src="images/icons/icon_missing.png" style="cursor:hand;"  alt="删除" />
           			</a> 	
           		<!-- 	</c:if> -->
			   </td>
			</tr>
			
	       	</c:forEach>	
	       </c:otherwise>
	       </c:choose>
		</tbody>
	</c:if>  
	<c:if test="${orderStatus >3}">
		<thead>
			<tr bgcolor="#E8F0FF">
			   <th width="4%">序号</th>
			   <th width="15%">车卡号</th>
			   <th width="10%">类型</th>
			   <th width="8%">车轴数</th>
			   <th width="8%">燃料需求</th>
			   <th width="10%">预计消耗量</th>
			   <th width="8%">品牌型号</th>
			   <th width="8%">最高车速</th>
			   <th width="20%">授权道路</th>
			   <th >
			  
			   		<a title="添加" onclick="addItem('${orderId}')">
            			<img src="images/icons/add.png" style="cursor:hand;"  alt="添加" />
           			</a> 
           		</th>
			</tr>
		</thead>
		<tbody>
		<!-- 遍历mapSess中存入的相应数据 -->
		<c:choose>
		<c:when test="${empty vehiclelist}">
			<tr><td colspan="12">查无记录！</td></tr>
		</c:when><c:otherwise>
	       <c:forEach items="${vehiclelist}" var="vlist" varStatus="vlistStatus">
			<c:set var="statusIndex" value="${vlistStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
			   <td>${statusIndex+1 }</td>
	           <td>${vlist.vehicleID_s}</td>
	 		   <td>${vlist.model_s}</td>
	 		   <td>${vlist.axleNumber_i }</td>
			   <td>${vlist.fuelDemand_s}</td>
	 		   <td>${vlist.fuelConsumption_s }</td>
			   <td>${vlist.brandType_s } </td>
			   <td>${vlist.maxSpeed_s } </td>
			   <td>${vlist.roadNames_s }</td>
			   <td>
			   	<!--  <c:if test="${orderStatus >3}">-->
			   		<a title="修改" onclick="modifyrec('${vlist.orderID_s }','${vlist.vehicleCPG_s}')">
            			<img src="images/icons/icon_edit.png" style="cursor:hand;"  alt="修改" />
           			</a> 
           			<a title="删除" onclick="deleterecvehicle('${vlist.orderID_s }','${vlist.vehicleCPG_s}','${vlist.vehicleID_s}')" >
            			<img src="images/icons/icon_missing.png" style="cursor:hand;"  alt="删除" />
           			</a>
           		<!-- </c:if>
           			<c:if test="${orderStatus <3 }">
           			<a title="修改" onclick="modify('${vlist.orderID_s }','${vlist.vehicleCPG_s}')">
            			<img src="images/icons/icon_edit.png" style="cursor:hand;"  alt="修改" />
           			</a> 
           			<a title="删除" onclick="deletevehicle('${vlist.orderID_s }','${vlist.vehicleCPG_s}')" >
            			<img src="images/icons/icon_missing.png" style="cursor:hand;"  alt="删除" />
           			</a> 	
           			</c:if>
           		-->
			   </td>
			</tr>
	       	</c:forEach>	
	       </c:otherwise>
	       </c:choose>
		</tbody>
		
	</c:if>
	</table>
	</form>
	<script type="text/javascript">
		function modify(id,cpg){
			//alert(id+"+"+cpg);
			var winPar=window.showModalDialog("./initvehicleAction?orderId="+id+"&vehicleCPG="+cpg, "", "dialogWidth=980px;dialogHeight=600px;toolbar=no;menubar=no;location=no;status=no;scroll=no;");
		 	//alert(winPar);
			if(winPar=="refresh"){
				document.getElementById("vehicleform").submit();
			}
		}
		
		function modifyrec(id,cpg){
			//alert(id+"+"+cpg);
			var winPar=window.showModalDialog("./initrecvehicleAction?orderId="+id+"&vehicleCPG="+cpg, "", "dialogWidth=980px;dialogHeight=600px;toolbar=no;menubar=no;location=no;status=no;scroll=no;");
		 	//alert(winPar);
			if(winPar=="refresh"){
				document.getElementById("vehicleform").submit();
			}
		}
		
		function deletevehicle(id,cpg){
			var str="确定要删除？"
				$.messager.confirm('删除', str, function(r){
				    if (r){
					
						$.post(
			  				"./deleteVehicleAction",
			  				{
			  					orderId:id,
			  					vehicleCPG:cpg,
			  					time:new Date().getTime()
			  				},function(msg){
			  					document.getElementById("vehicleform").submit();
			  				}
			  			);
					}
			    });
		}
		
		
		function deleterecvehicle(id,cpg,vehicleid){
			var str="确定要删除？"
				$.messager.confirm('删除', str, function(r){
				    if (r){
					
						$.post(
			  				"./delorderrecvehicleAction",
			  				{
			  					orderId:id,
			  					vehicleCPG:cpg,
			  					vehicleID_s:vehicleid,
			  					time:new Date().getTime()
			  				},function(msg){
			  					if(msg.length > 4){
			  						$.messager.alert("Error",msg);
			  					}else{
			  						document.getElementById("vehicleform").submit();
			  					}
			  				}
			  			);
					}
			    });
		}
		
		function addItem(){
			var winPar=window.showModalDialog("./initvehicleAction", "", "dialogWidth=980px;dialogHeight=600px;toolbar=no;menubar=no;location=no;status=no;scroll=no;");
		 	//alert(winPar);
			if(winPar=="refresh"){
				document.getElementById("vehicleform").submit();
			}
		}
	</script>
	
	
</div> <!-- End #tab1 -->


	</div> <!-- End .content-box-content -->
				
	</div> <!-- End .content-box -->
 
  </body>
</html>
