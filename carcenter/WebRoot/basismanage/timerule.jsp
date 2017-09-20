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
    
    <title>禁用时间段查询页面</title>
    
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
<script type="text/javascript" src="js/verify.js"></script>
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
input{
	width: 120px;
	border:1px solid #36D;
}
h4{
	text-align: center;
	font-size: 13px;
	font-weight: bold;
	color: #222;
}
li{
	
}
</style>


  </head>
  
 <body style="padding: 0px;margin: 0px; width: 99%">
   <div id="man_zone">
   <!-- 条件查询div -->
	<div style="height: 40px;padding: 5px;margin: 0px 5px 0px 10px">
		<!-- 根据条件，查询预定时间规则信息 -->
		<form id="searchTimeruleForm" name="searchTimeruleForm" action="./searchTimeruleAction?time=new Date().getTime()" method="post">
			<div>
				<img id="" onclick="addTimerule()" alt="添加" title="添加" src="images/icons/icon_add.png" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function submitSearchForm(){
			document.getElementById("searchTimeruleForm").submit();
		}
		
		function addTimerule(){
			var winPar=window.showModalDialog("./prepareTimeruleAction", "newwindow", "dialogWidth=1000px;dialogHeight=600px;status=no;help=no;scroll=no;");
		 	//alert(winPar);
			if(winPar=="refresh"){
				document.getElementById("searchTimeruleForm").submit();
			}
		}
		
		function deleteTimerule(s){
			var str="确定要删除？"
				$.messager.confirm('删除', str, function(r){
				    if (r){
				    	$.post(
				  				"./deleteTimeruleAction",
				  				{
				  					timeQuantum_s:s,
				  					time:new Date().getTime()
				  				},function(msg){
									
			  						//$.messager.alert('删除','操作成功!');
			  						document.getElementById("searchTimeruleForm").submit();
				  				}
				  			);
				    }
				});
		}
	</script>
	

	<table  title="规则" id="manageordertab"  border="0" 
	width="95%" style="margin: 0px 0px 0px 10px" >
			<tr style="font-weight: bold;background-color: #E8F0FF">
				<td width="4%">序号 </td>
				<td width="40%">禁用时间段</td>
				<td width="26%">操作</td>
			</tr>
		<c:choose>
		<c:when test="${empty timerulelist}">
			<tr><td colspan="3">查无记录！</td></tr>
		</c:when><c:otherwise>
		<c:forEach items="${timerulelist}" var="timerulelist" varStatus="timeruleStatus">
			<c:set var="statusIndex" value="${timeruleStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
				<td>${statusIndex+1 }</td>
				<td>
					<c:if test="${timerulelist.timeQuantum_s ==1}">0:00~1:00</c:if>
  					<c:if test="${timerulelist.timeQuantum_s ==2}">1:00~2:00</c:if>
  					<c:if test="${timerulelist.timeQuantum_s ==3}">2:00~3:00</c:if>
  					<c:if test="${timerulelist.timeQuantum_s ==4}">3:00~4:00</c:if>
  					<c:if test="${timerulelist.timeQuantum_s ==5}">4:00~5:00</c:if>
  					<c:if test="${timerulelist.timeQuantum_s ==6}">5:00~6:00</c:if>
  					<c:if test="${timerulelist.timeQuantum_s ==7}">6:00~7:00</c:if>
  					<c:if test="${timerulelist.timeQuantum_s ==8}">7:00~8:00</c:if>
  					<c:if test="${timerulelist.timeQuantum_s ==9}">8:00~9:00</c:if>
  					<c:if test="${timerulelist.timeQuantum_s ==10}">9:00~10:00</c:if>
  					<c:if test="${timerulelist.timeQuantum_s ==11}">10:00~11:00</c:if>
  					<c:if test="${timerulelist.timeQuantum_s ==12}">11:00~12:00</c:if>
  					<c:if test="${timerulelist.timeQuantum_s ==13}">12:00~13:00</c:if>
  					<c:if test="${timerulelist.timeQuantum_s ==14}">13:00~14:00</c:if>
  					<c:if test="${timerulelist.timeQuantum_s ==15}">14:00~15:00</c:if>
  					<c:if test="${timerulelist.timeQuantum_s ==16}">15:00~16:00</c:if>
  					<c:if test="${timerulelist.timeQuantum_s ==17}">16:00~17:00</c:if>
  					<c:if test="${timerulelist.timeQuantum_s ==18}">17:00~18:00</c:if>
  					<c:if test="${timerulelist.timeQuantum_s ==19}">18:00~19:00</c:if>
  					<c:if test="${timerulelist.timeQuantum_s ==20}">19:00~20:00</c:if>
  					<c:if test="${timerulelist.timeQuantum_s ==21}">20:00~21:00</c:if>
  					<c:if test="${timerulelist.timeQuantum_s ==22}">21:00~22:00</c:if>
  					<c:if test="${timerulelist.timeQuantum_s ==23}">22:00~23:00</c:if>
  					<c:if test="${timerulelist.timeQuantum_s ==24}">23:00~24:00</c:if>
				
				</td>
				<td><!--  
					<a title="修改" onclick="updateBarrier('${barriergatelist.gateID_s}','${barriergatelist.gateNumber_s}')" >
            			<img src="images/icons/icon_edit.png" style="cursor:hand;"  alt="修改" />
           			</a> -->
					<a title="删除" onclick="deleteTimerule('${timerulelist.timeQuantum_s}')">
						<img src="images/icons/cross_circle.png" style="cursor:hand;"  alt="删除" />
					</a> 
				</td>
			</tr>
		</c:forEach>
		</table>
	</c:otherwise>
</c:choose>
	
	
	 
	</div>
  </body>
</html>
