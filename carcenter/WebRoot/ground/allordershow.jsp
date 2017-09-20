<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>试验场订单管理</title>
    
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
#ordertab td{
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
#trans td{
font-size: 12px;
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
   <div id="man_zone">
   <!-- 条件查询div -->
	<div style="height: 40px;padding: 5px;margin: 0px 5px 0px 10px">
		<!-- 根据条件，查询该信息 -->
		<form id="searchorderForm" name="searchorderForm" action="./searchRecorderShowAction?time=new Date().getTime()" method="post">
			<div>
				订单编号：<input type="text" id="orderID" name="orderID" value="${orderID }"  />
				试验名称：<input type="text" id="orderName" name="orderName" value="${orderName }"  />
				公司名称：<input type="text" id="customerName" name="customerName" value="${customerName }">
				订单开始时间：<input type="text" class="easyui-datebox" id="startDate"   name="startDate" 
				  data-options="formatter:myformatter,parser:myparser" value="${startDate}"/>
				~<input type="text" class="easyui-datebox" id="endDate" name="endDate" 
				data-options="formatter:myformatter,parser:myparser"  value="${endDate}"/>
				订单状态： <select name="states" id="states" class="easyui-combobox">
								<option value="-1" >请选择订单状态</option>
								<option value="1" <c:if test="${states == 1 }">selected="selected" </c:if>>订单未确认</option>
								<option value="2" <c:if test="${states == 2 }">selected="selected" </c:if>>订单已确认</option>
								<option value="3" <c:if test="${states == 3 }">selected="selected" </c:if>>订单取消</option>
								<option value="4" <c:if test="${states == 4 }">selected="selected" </c:if>>订单冲突</option>
								<option value="5" <c:if test="${states == 5 }">selected="selected" </c:if>>已进场</option>
								<option value="6" <c:if test="${states == 6 }">selected="selected" </c:if>>试验进行中</option>
								<option value="7" <c:if test="${states == 7 }">selected="selected" </c:if>>试验结束</option>
								<option value="8" <c:if test="${states == 8 }">selected="selected" </c:if>>订单已结算</option>
						</select>
				<img onclick="submitSearchForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				<!--  <img onclick="addWorkshop()" alt="添加" title="添加" src="images/icons/icon_add.png" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >-->
				
			</div>
		</form>
	</div>
	<script type="text/javascript">
		var startTime;
		var endTime;
		var states;
		var orderID;
		var orderName;
		var customerName;
	//   action="./searchRecorderAction?time='+new Date().getTime()'&startDate=startTime&endDate=endTime" method="post"
		function submitSearchForm(){
			//alert($("#startDate").datebox("getValue")+","+$("#endDate").datebox("getValue"));
			startTime=$("#startDate").datebox("getValue"); //获得系统日期的文本值  
			endTime=$("#endDate").datebox("getValue"); //获得用户选择的日期文本值  
			states=$("#states").combobox("getValues");
			orderName=$("#orderName").val();
			orderID=$("#orderID").val();
			customerName=$("#customerName").val();
			
			if(endTime.length==0){
				//Checkfun.checkDate($("#startdatepicker"),$("#enddatepicker"));
				//window.location.href="./searchRecorderShowAction?time="+new Date().getTime()+"&startDate="+startTime +"&endDate="+ endTime+"&orderID="+orderID+"&orderName="+orderName+"&customerName="+customerName+"&states="+states; 
				document.getElementById("searchorderForm").submit();
		    }else
	    	{
		    	var aStart=startTime.split('-'); //转成成数组，分别为年，月，日，下同  
			    var aEnd=endTime.split('-');  
			    var startDate =new Date( aStart[0], aStart[1], aStart[2]);  
			    var endDate = new Date(aEnd[0], aEnd[1], aEnd[2]); 
			   if (startDate > endDate) {   
			    $.messager.alert("Error","对不起，开始日期必须小于结束日期！");
			    return false;  
			   } else{
				 //Checkfun.checkDate($("#startdatepicker"),$("#enddatepicker"));
				// alert("./searchRecorderAction?time="+new Date().getTime()+"&startDate="+startTime +"&endDate= "+ endTime);
				 //window.location.href="./searchRecorderShowAction?time="+new Date().getTime()+"&startDate="+startTime +"&endDate="+ endTime+"&orderID="+orderID+"&orderName="+orderName+"&customerName="+customerName+"&states="+states; 
	 			 document.getElementById("searchorderForm").submit();
			   }
				
	    	}
		    
		}
		
	</script>
	
	<table id="ordertab" width="98%" title="试验场订单" border="0" style="margin: 0px 0px 0px 10px">
			<tr style="font-weight: bold;background-color: #E8F0FF;">
				<td width="4%">序号</td>
				<td width="8%">订单编号</td>
				<td width="20%">试验名称</td>
				<td width="18%">公司名称</td>
				<td width="10%">试验开始日期</td>
				<td width="10%">试验结束日期</td>
				<!--<td width="10%">联系人</td>
				<td width="10%">客户助理</td> -->
				<td width="8%">订单状态</td>
				<td width="6%">详情</td> 
			</tr>
		<c:choose>
		<c:when test="${empty orderlist}">
			<tr><td colspan="10">查无记录！</td></tr>
		</c:when><c:otherwise>
		<c:forEach items="${orderlist}" var="olist" varStatus="olistStatus">
			<c:set var="statusIndex" value="${olistStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
				<td>${statusIndex+1}</td>
				<td>${olist.orderid_s}</td>
				<td>${olist.ordername_s }</td>
				<td>${olist.customerName_s}</td>
				<td><fmt:formatDate value="${olist.startdate_d }" type="date" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${olist.enddate_d}" type="date" pattern="yyyy-MM-dd"/></td>
				
				<td>
					<c:if test="${olist.status_i==1}">预订未确认</c:if>
					<c:if test="${olist.status_i==2}">预订已确认</c:if>
					<c:if test="${olist.status_i==3}">预订取消</c:if>
					<c:if test="${olist.status_i==4}">预订冲突</c:if>
					<c:if test="${olist.status_i==5}">已进场</c:if>
					<c:if test="${olist.status_i==6}">试验进行中</c:if>
					<c:if test="${olist.status_i==7}">试验结束</c:if>
					<c:if test="${olist.status_i==8}">订单已结算</c:if>
				</td>
				
				 <td>
					<a title="订单详情" href="./ShowGOrderApplyAction?orderId=${olist.orderid_s}&status=${olist.status_i}">
            			<img src="images/icons/icon_info.png" style="cursor:hand;"  alt="订单详情" />
           			</a> 
				</td> 
			</tr>
		</c:forEach>
	</c:otherwise>
	</c:choose>	
	
	</table>

		<!-- 分页 -->
	<table id="trans"  style="background-color: #FFF;margin: 0px 0px 0px 10px" width="98%"  >
				<tr>
					<td width="50%" align="left" >
							共有记录${totalPages }条，分${maxPage}页，当前第${currentPage+1}页
					</td>
					<td  style="text-align: right;">
						<div style="display: inline;width: 300px;float: right;padding-right: 5px;">
							<a href="./searchRecorderShowAction?currentPage=0&orderID=${orderID}&orderName=${orderName}&customerName=${customerName}&startDate=${startDate}&endDate=${endDate}&states=${states}" target="manFrame" >首页</a>&nbsp;
							<a href="./searchRecorderShowAction?currentPage=${currentPage-1<=0?0:currentPage-1}&orderID=${orderID}&orderName=${orderName}&customerName=${customerName}&startDate=${startDate}&endDate=${endDate}&states=${states}">前一页</a>&nbsp;
							<a href="./searchRecorderShowAction?currentPage=${currentPage+1>=maxPage?totalPage-1:currentPage+1}&orderID=${orderID}&orderName=${orderName}&customerName=${customerName}&startDate=${startDate}&endDate=${endDate}&states=${states}">后一页</a>&nbsp;
							<a href="./searchRecorderShowAction?currentPage=${maxPage-1}&orderID=${orderID}&orderName=${orderName}&customerName=${customerName}&startDate=${startDate}&endDate=${endDate}&states=${states}">末页</a>&nbsp;&nbsp;
							
							<form id="changepage" style="display: inline;" action="./searchRecorderShowAction?orderID=${orderID}&orderName=${orderName}&customerName=${customerName}&startDate=${startDate}&endDate=${endDate}&states=${states}" method="post">
								转到第
								
								<select class="easyui-combobox" id="currentPage" name="currentPage" onchange="submitPage()" required="true">
									<c:if test="${maxPage==0}"><option>1</option></c:if>
									<c:if test="${maxPage>0}">
									<c:forEach begin="1" end="${maxPage}" step="1" var="item" >
									<option value="${item-1}" <c:if test="${currentPage+1 == item}">selected="selected" </c:if>>${item }</option>
									</c:forEach>
									</c:if>
								</select>
								页
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
  </body>
</html>