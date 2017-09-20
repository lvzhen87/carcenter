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
    
    <title>洗车信息管理</title>
    
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
		<form id="searchorderForm" name="searchorderForm" action="./initWashcarAction?time=new Date().getTime()" method="post">
			<div>
				订单编号：<input type="text" id="orderID" name="orderID" value="${orderID }"  />
				订单名称：<input type="text" id="orderName" name="orderName" value="${orderName }"  />
				洗车开始时间：<input type="text" class="easyui-datebox" id="startDate"   name="startDate" 
				  data-options="formatter:myformatter,parser:myparser" value="${startDate}"/>
				  ~<input type="text" class="easyui-datebox" id="endDate" name="endDate"  
				data-options="formatter:myformatter,parser:myparser"  value="${endDate}"/>
				作废状态:<select name="status" id="status" class="easyui-combobox">
						<option value="0" <c:if test="${status==0}">selected = "selected"</c:if>>否</option>
						<option value="1" <c:if test="${status==1}">selected = "selected"</c:if>>是</option>
					</select>
				<!-- 
				洗车结束时间：<input type="text" class="easyui-datebox" id="endDate" name="endDate"  
				data-options="formatter:myformatter,parser:myparser"  value="${endDate}"/>
				 -->
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
			orderName=$("#orderName").val();
			orderID=$("#orderID").val();
			
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

	
<c:if test="${empty status }">
	<table id="ordertab" width="98%" title="试验场订单" border="0" style="margin: 0px 0px 0px 10px">
			<tr style="font-weight: bold;background-color: #E8F0FF;">
				<td width="4%">序号</td>
				<td width="8%">订单编号</td>
				<td width="20%">试验名称</td>
				<td width="18%">公司名称</td>
				<td width="18%">CPG牌照号</td>
				<td width="10%">洗车时间</td>
				<!-- <td width="10%">洗车结束日期</td> -->
				<td width="6%">操作</td> 
			</tr>
	<tr><td colspan="10">请先选择【作废状态】再查询！</td></tr>
	</table>	
</c:if>	

<c:if test="${status==0 }">
	<table id="ordertab" width="98%" title="试验场订单" border="0" style="margin: 0px 0px 0px 10px">
			<tr style="font-weight: bold;background-color: #E8F0FF;">
				<td width="4%">序号</td>
				<td width="8%">订单编号</td>
				<td width="20%">试验名称</td>
				<td width="18%">公司名称</td>
				<td width="18%">CPG牌照号</td>
				<td width="10%">洗车时间</td>
				<!-- <td width="10%">洗车结束日期</td> -->
				<td width="6%">操作</td> 
			</tr>
	<c:choose>
		<c:when test="${empty stationlist}">
			<tr><td colspan="10">查无记录！</td></tr>
		</c:when><c:otherwise>
		<c:forEach items="${stationlist}" var="slist" varStatus="slistStatus">
			<c:set var="statusIndex" value="${slistStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
				<td>${statusIndex+1}</td>
				<td>${slist.orderID_s}</td>
				<td>${slist.orderName}</td>
				<td>${slist.customerName_s}</td>
				<td>${slist.resaveds5_s}</td>
				<td><fmt:formatDate value="${slist.recordDate_d }" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>
					<a onclick="del('${slist.serialNumber_s}','${slist.orderID_s}','${slist.facilityID_s}','${slist.recordDate_s}','${slist.resaveds5_s}','${slist.vehicleCPG_s}')" title="作废" >
            			<img src="images/icons/icon_missing.png" style="cursor:hand;"  alt="作废" />
           			</a>
				</td> 
			</tr>
		</c:forEach>
		
	</c:otherwise>
	</c:choose>	
	</table>
	<script>
		function del(num,id,fid,rdate,cpg,vehicleCPG_s){
			var str="确定要删除？"
		
				$.messager.confirm('删除', str, function(r){
				    if (r){
						$.post(
			  				"./delWashcarAction",
			  				{
			  					serialNumber:num,
			  					orderID:id,
			  					facilityID:fid,
			  					recordDates:rdate,
			  					cpg:cpg,
			  					time:new Date().getTime(),
			  					vehicleCPG_s:vehicleCPG_s
			  				},function(msg){
			  					//alert(msg);
			  					
			  					if(msg.length > 4){
			  						$.messager.alert("Error",msg);
			  					}else{
			  			 
			  						//$.messager.alert("删除","操作成功！");
			  						//document.getElementById("roadSearchForm").submit();
			  						submitSearchForm();
			  						//submitSearchForm();
			  					}
			  				}
			  			);
					}
			    });
		}
	</script>
	
		<!-- 分页 -->
	<table id="trans"  style="background-color: #FFF;margin: 0px 0px 0px 10px" width="98%"  >
				<tr>
					<td width="50%" align="left" >
							共有记录${totalPages }条，分${maxPage}页，当前第${currentPage+1}页
					</td>
					<td  style="text-align: right;">
						<div style="display: inline;width: 300px;float: right;padding-right: 5px;">
							<a href="./initWashcarAction?currentPage=0&status=${status}&orderID=${orderID}&orderName=${orderName}&startDate=${startDate}&endDate=${endDate}" target="manFrame" >首页</a>&nbsp;
							<a href="./initWashcarAction?currentPage=${currentPage-1<=0?0:currentPage-1}&status=${status}&orderID=${orderID}&orderName=${orderName}&startDate=${startDate}&endDate=${endDate}">前一页</a>&nbsp;
							<a href="./initWashcarAction?currentPage=${currentPage+1>=maxPage?totalPage-1:currentPage+1}&status=${status}&orderID=${orderID}&orderName=${orderName}&startDate=${startDate}&endDate=${endDate}">后一页</a>&nbsp;
							<a href="./initWashcarAction?currentPage=${maxPage-1}&status=${status}&orderID=${orderID}&orderName=${orderName}&startDate=${startDate}&endDate=${endDate}">末页</a>&nbsp;&nbsp;
							
							<form id="changepage" style="display: inline;" action="./initWashcarAction?status=${status}&orderID=${orderID}&orderName=${orderName}&startDate=${startDate}&endDate=${endDate}" method="post">
								转到第
								
								<select class="easyui-combobox" id="currentPage" name="currentPage" onchange="submitPage()" required="true">
									<c:if test="${maxPage==0}"><option value="0">1</option></c:if>
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
		
</c:if>			

<c:if test="${status==1}">
	<table id="ordertab" width="98%" title="试验场订单" border="0" style="margin: 0px 0px 0px 10px">
			<tr style="font-weight: bold;background-color: #E8F0FF;">
				<td width="4%">序号</td>
				<td width="8%">订单编号</td>
				<td width="20%">试验名称</td>
				<td width="18%">公司名称</td>
				<td width="18%">CPG牌照号</td>
				<td width="10%">洗车开始日期</td>
				<!-- <td width="10%">洗车结束日期</td> -->
				<td width="6%">操作</td> 
			</tr>
	<c:choose>
		<c:when test="${empty twlist}">
			<tr><td colspan="10">查无记录！</td></tr>
		</c:when><c:otherwise>
		<c:forEach items="${twlist}" var="twlist" varStatus="twlistStatus">
			<c:set var="statusIndex" value="${twlistStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
				<td>${statusIndex+1}</td>
				<td>${twlist.receptionOrder.orderID_s}</td>
				<td>${twlist.receptionOrder.orderName_s}</td>
				<td>${twlist.receptionOrder.customer.customerName_s}</td>
				<td>${twlist.resaveds2S}</td>
				<td><fmt:formatDate value="${twlist.recorddateT}" type="date" pattern="yyyy-MM-dd"/></td>
				<td>
					已作废
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
							<a href="./initWashcarAction?currentPage=0&status=${status}&orderID=${orderID}&orderName=${orderName}&startDate=${startDate}&endDate=${endDate}" target="manFrame" >首页</a>&nbsp;
							<a href="./initWashcarAction?currentPage=${currentPage-1<=0?0:currentPage-1}&status=${status}&orderID=${orderID}&orderName=${orderName}&startDate=${startDate}&endDate=${endDate}">前一页</a>&nbsp;
							<a href="./initWashcarAction?currentPage=${currentPage+1>=maxPage?totalPage-1:currentPage+1}&status=${status}&orderID=${orderID}&orderName=${orderName}&startDate=${startDate}&endDate=${endDate}">后一页</a>&nbsp;
							<a href="./initWashcarAction?currentPage=${maxPage-1}&status=${status}&orderID=${orderID}&orderName=${orderName}&startDate=${startDate}&endDate=${endDate}">末页</a>&nbsp;&nbsp;
							
							<form id="changepage" style="display: inline;" action="./initWashcarAction?status=${status}&orderID=${orderID}&orderName=${orderName}&startDate=${startDate}&endDate=${endDate}" method="post">
								转到第
								
								<select class="easyui-combobox" id="currentPage" name="currentPage" onchange="submitPage()" required="true">
									<c:if test="${maxPage==0}"><option value="0">1</option></c:if>
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
		
</c:if>	
	
	

		<!-- 分页
	<table id="trans"  style="background-color: #FFF;margin: 0px 0px 0px 10px" width="98%"  >
				<tr>
					<td width="50%" align="left" >
							共有记录${totalPages }条，分${maxPage}页，当前第${currentPage+1}页
					</td>
					<td  style="text-align: right;">
						<div style="display: inline;width: 300px;float: right;padding-right: 5px;">
							<a href="./initWashcarAction?currentPage=0&status=${status}&orderID=${orderID}&orderName=${orderName}&startDate=${startDate}&endDate=${endDate}" target="manFrame" >首页</a>&nbsp;
							<a href="./initWashcarAction?currentPage=${currentPage-1<=0?0:currentPage-1}&status=${status}&orderID=${orderID}&orderName=${orderName}&startDate=${startDate}&endDate=${endDate}">前一页</a>&nbsp;
							<a href="./initWashcarAction?currentPage=${currentPage+1>=maxPage?totalPage-1:currentPage+1}&status=${status}&orderID=${orderID}&orderName=${orderName}&startDate=${startDate}&endDate=${endDate}">后一页</a>&nbsp;
							<a href="./initWashcarAction?currentPage=${maxPage-1}&status=${status}&orderID=${orderID}&orderName=${orderName}&startDate=${startDate}&endDate=${endDate}">末页</a>&nbsp;&nbsp;
							
							<form id="changepage" style="display: inline;" action="./initWashcarAction?status=${status}&orderID=${orderID}&orderName=${orderName}&startDate=${startDate}&endDate=${endDate}" method="post">
								转到第
								
								<select class="easyui-combobox" id="currentPage" name="currentPage" onchange="submitPage()" required="true">
									<c:if test="${maxPage==0}"><option value="0">1</option></c:if>
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
			</table> -->
		
	</div>
  </body>
</html>