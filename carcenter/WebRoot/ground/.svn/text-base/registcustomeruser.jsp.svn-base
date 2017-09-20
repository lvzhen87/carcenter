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
    
    <title>注册客户页面</title>
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
				
			</div>-->
			<ul class="content-box-tabs" >
				<li><a href="./searchInfoDetailAction" >试验基础信息</a></li> <!-- href must be unique and match the id of target div -->
				<li><a href="./ordervehicleAction"  >试验车辆</a></li>
				<li><a href="./sharingroadAction" >共享试验道路</a></li>
				<li><a href="./wholeroadAction"  >包场试验道路</a></li>
				<li><a href="" >精确预订道路</a></li>
				<li><a href="./orderworkshopAction" >车间办公设施预约</a></li>
				<!--  <li><a href="./orderhotelAction"  >酒店预约</a></li>-->
				<li><a href="./regcustomerUserAction"  class="tab-content default-tab">试验人员管理</a></li>
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
			   <th width="25%">人员编号</th>
			   <th width="15%">姓名</th>
			   <th width="20%">人员类别</th>
			   <th width="15%">人卡号码</th>
			   <th width="15%">卡面编号</th>
			   <th width="6%">  </th>
			</tr>
		</thead>
		<tbody>
		<!-- 遍历mapSess中存入的相应数据 -->
		<c:choose>
		<c:when test="${empty registerlist}">
			<tr><td colspan="7">查无记录！</td></tr>
		</c:when><c:otherwise>
	       <c:forEach items="${registerlist}" var="rlist" varStatus="rlistStatus">
			<c:set var="statusIndex" value="${rlistStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
			   <td>${statusIndex+1 }</td>
	           <td>${rlist.customerUserID_s}</td>
	           <td> <c:if test="${orderState>3}" >  ${rlist.customerUserName_s} </c:if>
	           		<c:if test="${orderState<3}" >  ${rlist.vcustomeuser.customerusername_s} </c:if>
	           </td>
	 		   <td>
	 		   		<c:if test="${rlist.userType_i==1 }">客户负责人</c:if>
	 		   		<c:if test="${rlist.userType_i==2 }">陪同人员</c:if>
	 		   		<c:if test="${rlist.userType_i==3 }">驾驶员</c:if>
	 		   </td>
	 		   <td>
					<c:if test="${orderState>2}" >  ${rlist.card_s} </c:if>
				</td>
			    <td>
					<c:if test="${orderState>2}" >  ${rlist.serialface_s} </c:if>
				</td>
			   <td>
			   		<a title="删除" onclick="return conf()" href="delUserRegisterAction?userID=${rlist.customerUserID_s}" >
            			<img src="images/icons/icon_missing.png" style="cursor:hand;"  alt="删除" />
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
		function conf(){
			 if(window.confirm('你确定要删除该记录！')){
                //alert("确定");
                return true;
             }else{
                //alert("取消");
                return false;
            }
		}
	</script>
</div> <!-- End #tab1 -->


	</div> <!-- End .content-box-content -->
				
	</div> <!-- End .content-box -->
 
  </body>
</html>
