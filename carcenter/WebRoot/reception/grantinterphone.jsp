<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
	font-size: 14px;
	font-weight: bold;
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
		
		$("#driveCPG").hide();
	});
	function myformatter(date) {
			var y = date.getFullYear();
			var m = date.getMonth() + 1;
			var d = date.getDate();
			return y + '-' + (m < 10 ? ('0' + m) : m) + '-'
			+ (d < 10 ? ('0' + d) : d);
		}
		function myparser(s) {
			if (!s)
			return new Date();
			var ss = (s.split('-'));
			var y = parseInt(ss[0], 10);
			var m = parseInt(ss[1], 10);
			var d = parseInt(ss[2], 10);
			if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
			return new Date(y, m - 1, d);
			} else {
			return new Date();
			}
		}
</script>

<script type="text/javascript">
	function readVCardInfo(box) {
	    var demo = document.getElementById("helloBossma");
	    var result = demo.GetInterfacceSafyOptions();
	    box.value=result;
	}
	function readPCardInfo(box) {
        
        var demo = document.getElementById("helloBossma");
        var result = demo.GetCardNum();
       
        box.value=result;
       
    }
	</script>

  </head>
<body style="margin: 0px;padding: 0px; width: 99%;height: 400px">
  <div style="height: 30px;padding-left: 10px;">
  	<h3 style="padding: 0px;margin: 0px;">
  		<!--  &gt;&gt;<a href="./grantCardAction?orderId=${orderId}&customerId=${customerId}" >人卡与油卡发放</a> &nbsp;&nbsp;&nbsp;-->
  		&gt;&gt;<a href="./prepareInterphoneAction?orderId=${orderId}&customerId=${customerId}" class="currentFont">对讲机发放</a> &nbsp;&nbsp;&nbsp;
  		<!--&gt;&gt;<a href="./prepareRecordVehicleAction?orderId=${orderId}&customerId=${customerId}" >车辆信息与车卡</a> &nbsp;&nbsp;&nbsp;
  		&gt;&gt;<a href="./recordDriverAction?customerId=${customerId}&orderId=${orderId}">驾驶员登记</a>&nbsp;&nbsp;&nbsp;
  		&gt;&gt;<a href="./recordEntourageAction?customerId=${customerId}&orderId=${orderId}">随行人员登记</a>-->
  		<!--  <font>${interphoneerrmsg}</font>-->
  	</h3> 
  </div>
  <div id="man_zone" style="height: 515px;width: 100%;">
 <div style="padding: 5px;margin: 0px 5px 0px 10px"">
	<!-- 对讲机 -->				
  	<form id="cardinfoform" name="cardinfoform" action="./grantInterphoneAction?orderId=${orderId}" method="post" style="padding: 0px;margin: 0px;" >
				<h3 class="h3bg" style="margin: 0px 5px 0px 10px;">对讲机发放：</h3>
	  			<div style="margin: 5px 5px 0px 10px;">
				  		对讲机编号：<input type="text"  name="interphoneID" id="interphoneID"  onblur="Checkfun.isNull(this,'对讲机编号',80)" >&nbsp;&nbsp;<font color="red">*</font>
				  		人卡绑定：<input type="text"  name="userCardID" id="userCardID" onclick="readPCardInfo(this)"  >&nbsp;&nbsp;<font color="red">*</font>
				  		车卡绑定：<input type="text"  name="vehicleCardID" id="vehicleCardID"  onclick="readVCardInfo(this)"  >
				  		<!-- <img id="bang" alt="确定" src="images/icons/ok.gif"> -->
				  		<font style="color: red;">${interphoneerrmsg}</font>
				 </div>
	<object  classid="clsid:0b6ed426-9e67-4cf3-99da-8a346a98e5c6" codebase="Setup1.msi"
			width="0" height="0" id="helloBossma">
	</object>
<script type="text/javascript">
$("#bang").click(function(){
	if($("#interphoneID").val()!="" && $("#userCardID").val()!="" && $("#vehicleCardID").val()!=""){
		$("#bang").before("<br/>对讲机编号：<input type='text' id='interphoneID'  name='interphoneID' value='"+$(this).val()+"'  /> 人卡绑定：<input type='text' name='userCardID' id='userCardID' value='"+$(this).val()+"' />车卡绑定：<input type='text'  name='vehicleCardID' id='vehicleCardID'  value='"+$(this).val()+"'/>");
		$(this).val("");
	}else{
		$.messager.alert('Error',"请将信息填写完整！");
		return ;
	}
});
</script>
				  	<div align="center" style="margin-top: 10px;">
				  		<a href="#"  onclick="return false" class="easyui-linkbutton"><label onclick="cardbtn()" >确认发放</label></a>
				  	</div>
				
			  	</form>
			  	
			  
  	<script type="text/javascript">
  		function cardbtn(){
  			if(!Checkfun.isNull($("#interphoneID"),'对讲机编号',80)){
  				return false;
  			}
  			if(!Checkfun.isNull($("#userCardID"),'人卡绑定',80)){
  				return false;
  			}
  			
  			$("#cardinfoform").submit();
  		}
  		
  		function callback(s,s1){
  	 		document.getElementById("processID").value=s;
  	 		document.getElementById("interphoneID_s").value=s1;
  			$("#returnform").submit();
// 				document.getElementById("cardinfoform").submit();
  			
  		}
  	</script>
		
<!-- 记录已经发放的对讲机 -->
 <h3 class="h3bg" style="margin: 0px 5px 0px 10px;">已经发放的对讲机记录：</h3>
<div style="margin: 0px 5px 0px 10px;" >
	<table width="97%"  id="manageordertab"  >
				<tr  style="font-weight: bold;">
					<td width="4%">序号</td>
					<td width="20%">对讲机编号	</td>
					<td width="20%">绑定车卡	</td>
					<td width="15%">绑定人卡</td>
					<td width="20%">发放时间	</td>
					<td width="6%">操作	</td>
				</tr>
		<c:choose>
			<c:when test="${empty processInterphonelist}">
					<tr><td colspan="6">该订单没有对讲机发放记录！	</td></tr>
			</c:when>
			<c:otherwise>
		
			<c:forEach items="${processInterphonelist }" var="item"
				varStatus="processInterphoneStatus">
				<c:set var="statusIndex" value="${processInterphoneStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if>
				<tr style="${evenOddStyle}">
					<td>${statusIndex+1 }</td>
					<td>${item.interphoneID_s}</td>
					<td>
						${item.vehiclecardidS}
					</td>
					<td>
						${item.usercardIDS}
					</td>
					<td>
						<fmt:formatDate value="${item.createDate_t}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>
					</td>
					<td>
						<!--  
						<a title="从订单移除" onclick="callback('${item.interphoneID_s}')">
							<img src="images/icons/cross_circle.png" style="cursor: hand;"
								alt="从订单移除" /> 
						</a>-->
						<input id="okbtn" type="submit" onclick="callback('${item.processID}','${item.interphoneID_s}','${orderId}')" 
						 src="images/icons/tick_circle.png" style="cursor:hand;width: 35px" value="收回" />
					</td>
				</tr>
			</c:forEach>
		
	</c:otherwise>
</c:choose>
<form id="returnform" name="returnform" action="./predeliphoneAction?orderId=${orderId}" method="post" style="padding: 0px;margin: 0px;" >
	<input type="hidden" name=processID id="processID"  />
	<input type="hidden" name=interphoneID_s id="interphoneID_s"  />
</form>
</table>
</div>
</div>
</div>
  </body>
</html>
