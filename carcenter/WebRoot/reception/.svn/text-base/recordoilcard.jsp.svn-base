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
    
    <title>油卡发放查询页面</title>
    
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
<script type="text/javascript" src="js/verify.js" ></script>
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
.currentFont{
	font-size: 16px;
	font-weight: bold;
	color: #03038a;
}
.h3bg{
	background-color: #E8E8FF;
	margin: 0px;
	padding: 2px;
}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		$(".cardDiv").mousemove(function(){
			$(this).css("border","1px solid #c71717");
		});
		$(".cardDiv").mouseout(function(){
			$(this).css("border","1px solid #c7c7c7");
		});
	});
</script>
  </head>
<body style="margin: 0px;padding: 0px; width: 99%;height: 400px">
  <div style="height: 30px;padding-left: 10px;">
  	<h3 style="padding: 0px;margin: 0px;">
  		&gt;&gt;<a href="./grantPrecardAction?orderId=${orderId}&customerId=${customerId}"  style="font-weight: normal;">人卡发放</a> &nbsp;&nbsp;&nbsp;
  		<!-- &gt;&gt;<a href="./searchOilcardAction?orderId=${orderId}&customerId=${customerId}" class="currentFont">油卡发放</a>&nbsp;&nbsp;&nbsp; -->
  		<!-- &gt;&gt;<a href="./grantInterphoneAction?orderId=${orderId}&customerId=${customerId}" >对讲机发放</a> &nbsp;&nbsp;&nbsp; -->
  		&gt;&gt;<a href="./prepareRecordVehicleAction?orderId=${orderId}&customerId=${customerId}"  style="font-weight: normal;">车辆信息与车卡</a> &nbsp;&nbsp;&nbsp;
  		<!--  &gt;&gt;<a href="./recordDriverAction?customerId=${customerId}&orderId=${orderId}">驾驶员登记</a>&nbsp;&nbsp;&nbsp;
  		&gt;&gt;<a href="./recordEntourageAction?customerId=${customerId}&orderId=${orderId}">随行人员登记</a>--></h3> 
  </div>
   <div id="man_zone" style="height: 515px;width: 100%;">
 <div style="padding: 5px;margin: 0px 5px 0px 10px">
	  		<h3 class="h3bg" style="margin: 0px 5px 0px 10px;">试验申请人：</h3>
	  		<div style="margin: 5px 5px 0px 10px;">
  				<form id="oilcardform" name="oilcardform" action="./grantOilCardAction?orderId=${orderId}" method="post" style="padding: 0px;margin: 0px;" >
				  	<div id="personCardDiv" >
				  		油卡一维码：<input type="text"  name="oilCard" id="oilCard"  >
				  	</div>
<script type="text/javascript">
$("#oilCard").keydown(function(){
	if(event.keyCode==13){
		if( $("#oilCard").val()==null || $("#oilCard").val().length<1){
			$.messager.alert('Error','请输入油卡编号！');
			return false;
			
		}else{
			$(this).after("<br/>油卡一维码：<input type='text' id='oilCard' name='oilCard' value='"+$(this).val()+"'  > ");
			$(this).val("");
		}
	}
});

</script>				  	
				  	<div align="center" style="margin-top: 10px;">
				  		<a href="#"  onclick="return false" class="easyui-linkbutton"><label onclick="oilcardbtn()">确认发放</label></a>
				  	</div>
			  	</form>
		  	</div>
	<script type="text/javascript">
  		function oilcardbtn(){
  			alert($("#oilCard").val());
  			if( $("#oilCard").val()==null || $("#oilCard").val().length<1){
  				$.messager.alert('Error','请输入油卡编号！');
  				return false;
  			}
  			$("#oilcardform").submit();
  		}
  	</script>	  	
		  	
<h3 class="h3bg" style="margin: 0px 5px 0px 10px;">已发放油卡：</h3>
	<div style="margin: 0px 5px 0px 10px;" >
		<table style="width: 97%;"  id="manageordertab"  >
  			<tr style="font-weight: bold;">
  				<td width="4%">序号</td>
	  			<td width="50%">油卡编号</td>
	  			<td width="10%">操作</td>
	  		</tr>
	  		<c:choose>
	  		<c:when test="${empty searchOilCard}">
				<tr><td colspan="5">查无记录！</td></tr>
			</c:when><c:otherwise>
				<c:forEach items="${searchOilCard}" var="oillist" varStatus="oillistStatus">
					<c:set var="statusIndex" value="${oillistStatus.index}" />
						<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
						<c:if test="${(statusIndex % 2) == 0}">
							<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
						</c:if> 
					<tr style="${evenOddStyle}">
						<td>${statusIndex+1 }</td>
						<td>${oillist}</td>
						<td>
							<a title="删除" href="./deleteOilCardAction?orderId=${orderId}&cardId=${oillist}">
								<img src="images/icons/icon_missing.png" style="cursor:hand;"  alt="删除" />
							</a>
						</td>
					</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>			
	</div>
  	
</div>
</div>
</body>
</html>
