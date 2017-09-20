<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.freshen.entity.process.*"   %>
<%@ page import="com.freshen.entity.process.RoadEmployInventory.*"   %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>订单道路使用清单</title>
    
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
h4{
	text-align: center;
	font-size: 13px;
	font-weight: bold;
	color: #222;
}
li{
	
}
</style>
<script type="text/javascript">
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

  </head>
  
 <body style="padding: 0px;margin: 0px; width: 99%">
   <div id="man_zone" >
   <!-- 条件查询div -->
	 
	<script type="text/javascript">
		function submitSearchForm(){
			document.getElementById("searchStationForm").submit();
		}
		
	</script>
	

	<table  title="订单道路使用清单" id="manageordertab"  border="0" width="98%" style="margin: 0px 0px 0px 10px">
			<!--<tr style="font-weight: bold;background-color: #E8F0FF">
				<td width="10%">车卡号</td>
				<td width="10%">CPG牌照号</td>
				<td width="10%">车辆</td>
				<td width="10%">道路及场地</td>
				<td width="10%">进道闸时间</td>
				<td width="10%">出道闸时间</td>
				<td width="10%">用时<br/>(min)</td>
				<td width="10%">总计<br/>(min)</td>
				<td width="10%">共享用时<br/>(min)</td>
				<td width="5%">精确用时<br/>(min)</td>
				<td width="5%">包场用时<br/>(min)</td>
			</tr>
		--><!--<c:choose>
		<c:when test="${empty roadEmployInventoryList}">
			<tr><td colspan="9">查无记录q！</td></tr>
		</c:when><c:otherwise>
		<c:forEach items="${roadEmployInventoryList}" var="roadEmployInventory" varStatus="orderlistStatus">
			<c:set var="statusIndex" value="${orderlistStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}" >
				
				<td	rowspan="${roadEmployInventory.stationDetailModelsize}">${roadEmployInventory.cardId_s}</td>
				<td rowspan="${roadEmployInventory.stationDetailModelsize}">${roadEmployInventory.handworkCpg}</td>
				<td rowspan="${roadEmployInventory.stationDetailModelsize}">${roadEmployInventory.brandType_s}</td>
				<c:forEach items="${roadEmployInventory.stationDetailModelList}" var="stationDetailModel" >
	 
					<td rowspan="${stationDetailModel.stationDetailTimeModelSize}">${stationDetailModel.roadName_s}</td>
					<c:forEach items="${stationDetailModel.stationDetailTimeModelList}" var="stationDetailTimeModel" begin="0" end="0" > 
					 
						<td>${stationDetailTimeModel.enterTime}</td>
						<td>${stationDetailTimeModel.comeTime}</td>
						<td>${stationDetailTimeModel.timeCount}</td>
					</c:forEach>
					<td rowspan="${stationDetailModel.stationDetailTimeModelSize}">${stationDetailModel.employTimeCount}</td>
					<td rowspan="${stationDetailModel.stationDetailTimeModelSize}">${stationDetailModel.shareTimeCount}</td>
					<td rowspan="${stationDetailModel.stationDetailTimeModelSize}">${stationDetailModel.preTimeCount}</td>
					<td rowspan="${stationDetailModel.stationDetailTimeModelSize}">${stationDetailModel.wholeTimeCount}</td>
				</c:forEach>
				
			</tr>
					<c:forEach items="${roadEmployInventory.stationDetailModelList}" var="stationDetailModel"  >
					 
						 
						 
								<c:forEach items="${stationDetailModel.stationDetailTimeModelList}" var="stationDetailTimeModel" >
									<tr>
										<td>${stationDetailTimeModel.enterTime}</td>
										<td>${stationDetailTimeModel.comeTime}</td>
										<td>${stationDetailTimeModel.timeCount}</td>
									 </tr>
								</c:forEach>
						 
						
					 
					</c:forEach>
 				 
	 
		</c:forEach>
		</table>
	</c:otherwise>
</c:choose>	
	-->
		<% 
			List<RoadEmployInventory> roadEmployInventoryList = (List<RoadEmployInventory>)request.getAttribute("roadEmployInventoryList");
			for(int i=0;i<roadEmployInventoryList.size();i++){
				RoadEmployInventory  m = roadEmployInventoryList.get(i);
		%>
			<tr>
			    <td rowspan="<%=m.getStationDetailModelsize() %>"><%=m.getCardId_s()%></td>
			    <td rowspan="<%=m.getStationDetailModelsize() %>"><%=m.getHandworkCpg()%></td>
			    <td rowspan="<%=m.getStationDetailModelsize() %>"><%=m.getBrandType_s()%></td>
			    <%
			    	List<StationDetailModel> stationDetailModelList= m.getStationDetailModelList();
			    	for(int j=0;j<stationDetailModelList.size();j++){
			    		StationDetailModel sm = stationDetailModelList.get(j);
			    		if(j==0){
			    %>
			    <td><%=sm.getRoadName_s()%></td>
			    
			    
			    <td><%=sm.getEmployTimeCount()%></td>
				<td><%=sm.getShareTimeCount()%></td>
			 	<td><%=sm.getPreTimeCount()%></td>
			 	<td><%=sm.getWholeTimeCount()%></td>
			    <%
			    		}else{
				%>			   
					<tr>
						<td><%=sm.getRoadName_s()%></td>
						<td><%=sm.getEmployTimeCount()%></td>
						<td><%=sm.getShareTimeCount()%></td>
					 	<td><%=sm.getPreTimeCount()%></td>
					 	<td><%=sm.getWholeTimeCount()%></td>
					</tr> 		
			    <%
			    		}
			    	}
			    %>
		    </tr>
		<%
			}
		%>
		</table>
	</div>
  </body>
</html>
