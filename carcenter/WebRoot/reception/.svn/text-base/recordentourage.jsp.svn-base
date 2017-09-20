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
	.h3bg{
	margin: 0px;
	padding: 2px;
}
	</style>
  </head>
  <body style="margin: 0px;padding: 0px;">
  <div style="height: 30px;padding-left: 10px;">
  	<h3 style="padding: 0px;margin: 0px;">
  		&gt;&gt;<a href="./grantCardAction?orderId=${orderId}&customerId=${customerId}" >人卡与油卡发放</a> &nbsp;&nbsp;&nbsp;
  		<!--  &gt;&gt;<a href="./grantInterphoneAction?orderId=${orderId}&customerId=${customerId}" >对讲机发放</a> &nbsp;&nbsp;&nbsp;-->
  		&gt;&gt;<a href="./prepareRecordVehicleAction?orderId=${orderId}&customerId=${customerId}" >车辆信息与车卡</a> &nbsp;&nbsp;&nbsp;
  		<!--  &gt;&gt;<a href="./recordDriverAction?customerId=${customerId}&orderId=${orderId}">驾驶员登记</a>&nbsp;&nbsp;&nbsp;-->
  		&gt;&gt;<a href="./recordEntourageAction?customerId=${customerId}&orderId=${orderId}" class="currentFont">随行人员登记</a></h3> 
  </div>
  <div id="man_zone" style="height: 510px;width: 1080px;">
	 <!-- 已经登记在册的随行人员数据区域 -->
  <h3 class="h3bg">当前随行人员记录：</h3>
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
		  					<c:if test="${item.userType_i==1}" > 客户负责人</c:if>
		  					<c:if test="${item.userType_i==2}" > 陪同人员</c:if>
		  					<c:if test="${item.userType_i==3}" > 驾驶员</c:if>
		  				</td>
		  				<td>${item.createDate_t}</td>
		  				<td>
		  					<a title="从订单移除" href="./deletereceptUserAction?orderID=${orderId}&customerUserID=${item.customerUserID_s}">
								<img src="images/icons/cross_circle.png" style="cursor:hand;"  alt="从订单移除" />
							</a>
		  				</td>
		  			</tr>
		  		</c:forEach>
		  		</table>
  			</c:otherwise>
  		</c:choose>
	<h3 class="h3bg">历史随行人员库：</h3>
	<!-- end已经登记在册的随行人员数据区域 -->
	
			<form id="entourageform" name="entourageform" action="./recordDriverUserAction?orderId=${orderId}&pagetype=4" method="post">
			<table width="100%" title="驾驶员信息" border="0" >
				<tr style="font-weight: bold;background-color: #E8F0FF">
					<td width="10%">人员编号</td>
					<td width="10%">人员名称</td>
					<td width="15%">公司名称</td>
					<td width="10%">人员类别</td>
					<td width="10%">驾照号</td>
					<td width="10%">CPG驾号</td>
					<td width="10%">CPG级别</td>
					<td width="10%">最后实验日期</td>
					<td width="10%">培训信息</td>
					<td width="5%"><input type="checkbox" name="selectAllPerson" id="selectAllPerson"  /></td>
				</tr>
		<c:choose>
		<c:when test="${empty mergeDriverUser}">
		 	<tr><td colspan="10">查无记录</td></tr>
		 </c:when>
		<c:otherwise>
				<c:forEach items="${mergeDriverUser}" var="mergelist" varStatus="mergeStatus">
	  				<c:set var="statusIndex" value="${mergeStatus.index}" />
					<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
					<c:if test="${(statusIndex % 2) == 0}">
						<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
					</c:if> 
				<tr style="${evenOddStyle}">
					<c:if test="${mergelist.isDriver==1}">
						<td id="customerUserID">${mergelist.customerUserID_s }</td>
						<td>${mergelist.customerUserName_s }</td>
						<td>${mergelist.customerName_s }</td>
						<td>${mergelist.identityCard_s }</td>
						<td>${mergelist.position_s }</td>
						<td>${mergelist.drivingLicenceCPG_s }</td>
						<td>${mergelist.levelCPG_s }</td>
						<td>${mergelist.lastTrainDate_t}</td>
							<c:if test="${mergelist.isTrain==0}">
							<td>	
								<a onclick="trainDriver('${mergelist.customerUserID_s }')" >参加培训</a>
							</td>
							<td></td>
							</c:if>
							<c:if test="${mergelist.isTrain==1}">
								<td>
								已培训
								</td>
							
								<td>
									<input type="checkbox" id="receptionCustomerUser" name="receptionCustomerUser" value="${mergelist.customerUserID_s},${mergelist.customerUserName_s},3"  />
								</td>
							</c:if>
					</c:if>
					<c:if test="${mergelist.isDriver==0}">
						<td>${mergelist.customerUserID_s}</td>
						<td>${mergelist.customerUserName_s}</td>
						<td>${mergelist.customerName_s}</td>
						<td>
							<c:if test="${mergelist.userType_i==1 }">客户负责人</c:if>
							<c:if test="${mergelist.userType_i==2 }">陪同人员</c:if>
						</td>
						<td></td><td></td><td></td><td></td><td></td>
						<td>
						<input type="checkbox" id="receptionCustomerUser" name="receptionCustomerUser" value="${mergelist.customerUserID_s},${mergelist.customerUserName_s},${mergelist.userType_i}"  />
						</td>
					
					</c:if>
						
				</tr>
				
			</c:forEach>
			<tr>
				<td colspan="10">
					<a href="#" onclick="return false" class="easyui-linkbutton" ><label  onclick="openDriver()">添加驾驶员</label></a>&nbsp;
					<a href="#" onclick="return false"  class="easyui-linkbutton"><label onclick="openUser()">添加新客户人员</label></a>&nbsp;
					<a href="#" onclick="return false" class="easyui-linkbutton"><label  onclick="queryuserbtn()">确认</label></a>
					<a id="freshtable" href="./recordEntourageAction?customerId=${customerId}&orderId=${orderId}" class="easyui-linkbutton" ><label >刷新客户人员信息</label></a>
				</td>
			</tr>
		
				
		</c:otherwise>
	</c:choose>
	</table>
	</form>	
	<div class="dbgrid" style="border: 1px solid #ddd; width: 1060px;">
		<!-- 分页 -->
			<table class="dbgrid" style="background-color: #FFF;width: 1055px;" >
				<tr>
					<td width="50%" style="text-align: left;" >
						<div style="display: inline; width: 380px; padding-left: 10px;" >
							共有记录${totalPages }条，分${maxPage}页，当前第${currentPage+1}页
						</div>
					</td>
					<td width="50%" style="text-align: right;">
						<div style="padding-right: 5px;">
							<a href="./recordEntourageAction?currentPage=0" target="manFrame" >首页</a>&nbsp;
							<a href="./recordEntourageAction?currentPage=${currentPage-1<=0?0:currentPage-1}">前一页</a>&nbsp;
							<a href="./recordEntourageAction?currentPage=${currentPage+1>=maxPage?totalPage-1:currentPage+1}">后一页</a>&nbsp;
							<a href="./recordEntourageAction?currentPage=${maxPage-1}">末页</a>&nbsp;&nbsp;
							<form style="display: inline;" action="./recordEntourageAction" method="post" id="changepage">
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
			
			
	<script type="text/javascript">
		function openUser(){
			var winPar=window.showModalDialog("./prepareAddUserAction?customerId=${customerId}", "newwindow", "dialogWidth=980px,dialogHeight=600px,toolbar=no,menubar=no,location=no,status=no");
			//alert(winPar);
			if(winPar=="refresh"){
				document.getElementById("freshtable").click();
			}
		}
	
		function queryuserbtn(){
			$("#entourageform").submit();
		}
		function openDriver(){
			var winPar=window.showModalDialog("./prepareAddDriverInfoAction?customerId=${customerId}", "newwindow", "dialogWidth=980px,dialogHeight=600px,toolbar=no,menubar=no,location=no,status=no");
			//alert(winPar);
			if(winPar=="refresh"){
				document.getElementById("freshtable").click();
			}
		}
		function trainDriver(s){	
			var winPar=window.showModalDialog("./prepareTrainDriverAction?customerUserID="+s, "newwindow", "dialogWidth=980px,dialogHeight=600px,toolbar=no,menubar=no,location=no,status=no");
			//alert(winPar);
			if(winPar=="refresh"){
				document.getElementById("freshtable").click();
			}
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
