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
.currentFont{
	font-size: 14px;
	font-weight: bold;
}
</style>
  </head>
  <body style="margin: 0px;padding: 0px;">
  <div style="height: 30px;padding-left: 10px;">
  	<h3 style="padding: 0px;margin: 0px;">
  		&gt;&gt;<a href="./grantCardAction?orderId=${orderId}" >人卡与油卡发放</a> &nbsp;&nbsp;&nbsp;
  		<!--  &gt;&gt;<a href="./grantInterphoneAction?orderId=${orderId}&customerId=${customerId}" >对讲机发放</a> &nbsp;&nbsp;&nbsp;-->
  		&gt;&gt;<a href="./prepareRecordVehicleAction?orderId=${orderId}" >车辆信息与车卡</a> &nbsp;&nbsp;&nbsp;
  		&gt;&gt;<a href="./recordDriverAction?customerId=${customerId}&orderId=${orderId}" class="currentFont">驾驶员登记</a>&nbsp;&nbsp;&nbsp;
  		&gt;&gt;<a href="./recordEntourageAction?customerId=${customerId}&orderId=${orderId}">随行人员登记</a></h3> 
  </div>
  <div id="man_zone" style="height: 510px;">
  <!-- 已经登记在册的驾驶员数据区域 -->
  <h3>随行驾驶员记录</h3>
  	<c:choose>
  			<c:when test="${empty entourages}">
  				该订单没有随行人员记录！	
  			</c:when><c:otherwise>
  				<table width="100%"  >
  					<tr style="background-color:#E8F0FF">
			  			<td width="20%">人员编号</td>	
			  			<td width="20%">人员名称</td>	
			  			<td width="15%">类别</td>
			  			<td width="20%">添加日期</td>
			  			<td width="10%">操作</td>
			  		</tr>
		  		<c:forEach items="${entourages }" var="item" varStatus="entouragesStatus">
	  				<c:set var="statusIndex" value="${entouragesStatus.index}" />
					<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
					<c:if test="${(statusIndex % 2) == 0}">
						<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
					</c:if> 
		  			<tr style="${evenOddStyle}">
		  				<td>${item.customerUserID_s }</td>
		  				<td>${item.customerUserName_s}</td>
		  				<td> 
		  					<c:if test="${item.userType_i==3}" > 驾驶员</c:if>
		  				</td>
		  				<td>${item.createDate_t}</td>
		  				<td>
		  					<a title="从订单移除" href="./deletereceptCustomerUserAction?orderID=${orderId}&customerUserID=${item.customerUserID_s}">
								<img src="images/icons/cross_circle.png" style="cursor:hand;"  alt="从订单移除" />
							</a>
		  				</td>
		  			</tr>
		  		</c:forEach>
		  		</table>
  			</c:otherwise>
  		</c:choose>
  		<br/><br>
  		<hr>
  <!-- END 已经登记在册的驾驶员数据区域  -->
<!-- 驾驶员数据区域 -->
<!-- 判断有无记录 -->
		<c:choose>
			<c:when test="${empty driverList}">
				查无记录！
			</c:when><c:otherwise>
			<form id="driverform" name="driverform" action="./recordDriverUserAction?orderId=${orderId}&pagetype=4" method="post">
			<table width="100%" title="驾驶员信息" border="0" >
				<tr style="font-weight: bold;background-color: #E8F0FF">
					<td width="10%">驾驶员编号</td>
					<td width="15%">公司名称</td>
					<td width="10%">驾驶员</td>
					<td width="15%">身份证号</td>
					<td width="10%">驾照号</td>
					<td width="8%">CPG编号</td>
					<td width="7%">CPG级别</td>
					<td width="10%">最后培训日期</td>
					<td width="10%">培训信息</td>
					<td width="5%"><input type="checkbox" name="selectAllPerson" id="selectAllPerson"  /></td>
				</tr>
				<c:forEach items="${driverList}" var="driverlist" varStatus="driverStatus">
	  				<c:set var="statusIndex" value="${driverStatus.index}" />
					<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
					<c:if test="${(statusIndex % 2) == 0}">
						<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
					</c:if> 
				<tr style="${evenOddStyle}">
					<td id="customerUserID">${driverlist.customerUserID_s }</td>
					<td>${driverlist.customerName_s }</td>
					<td>${driverlist.customerUserName_s }</td>
					<td>${driverlist.identityCard_s }</td>
					<td>${driverlist.position_s }</td>
					<td>${driverlist.drivingLicenceCPG_s }</td>
					<td>${driverlist.levelCPG_s }</td>
					<td>${driverlist.lastTrainDate_t}</td>
						<c:if test="${driverlist.isTrain==0}">
						<td>	
							<a onclick="trainDriver('${driverlist.customerUserID_s }')" >参加培训</a>
						</td>
						<td></td>
						</c:if>
						<c:if test="${driverlist.isTrain==1}">
						<td>
						已培训
						</td>
							<td>
								<input type="checkbox" id="receptionCustomerUser" name="receptionCustomerUser" value="${driverlist.customerUserID_s},${driverlist.customerUserName_s},3"  />
							</td>
						</c:if>
				</tr>
				</c:forEach>
				
	</c:otherwise>
	</c:choose>	
			<tr>
				<td colspan="10">
					<a class="easyui-linkbutton" ><label onclick="openDriver()">添加新驾驶员</label></a>&nbsp;
					<a class="easyui-linkbutton"><label onclick="querydriverbtn()">确认</label></a>
					<a href="./recordDriverAction?customerId=${customerId}&orderId=${orderId}" class="easyui-linkbutton">刷新驾驶员信息</a>
				</td>
			</tr>
		</table>
		</form>
	<script type="text/javascript">
		function openDriver(){
			window.open("./prepareAddDriverInfoAction?customerId=${customerId}", "newwindow", "width=980,height=600,top=0,left=0,toolbar=no,menubar=no,location=no,status=no");
		}
		function trainDriver(s){	
			window.open("./prepareTrainDriverAction?customerUserID="+s, "newwindow", "width=980,height=600,top=0,left=0,toolbar=no,menubar=no,location=no,status=no");
		}
		
		function querydriverbtn(){
			$("#driverform").submit();
		}
		
		$("#selectAllPerson").click(function (){
  			var selAll=document.getElementById("selectAllPerson").checked;
  			if(selAll){
				var boxs=document.getElementsByName("receptionCustomerUser");
				for(i=0;i<boxs.length;i++){
					boxs[i].checked=true;
				}
  			}else {
				var boxs=document.getElementsByName("receptionCustomerUser");
				for(i=0;i<boxs.length;i++){
					boxs[i].checked=false;
				}
  			}
  		});
	</script>
  </div>
  </body>
</html>
