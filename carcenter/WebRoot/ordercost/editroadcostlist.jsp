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
    	<link rel="stylesheet" href="css/common.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
<link rel="stylesheet" type="text/css" href="css/demo.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/verify.js"></script>

<title>订单核算</title>
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

<body style="margin: 0px;padding: 0px;">
<div id="man_zone">
<!-- 查询条件 -->
<div >
<form id="searchOrderForm" name="searchOrderForm" action="./searchOrderCostAction" method="post">
			<div style="margin: 0px 0px 0px 5px">
				订单编号：<input type="text" name="orderID" value="${orderID}" />
				<c:set value="'预定未确认','预定已确认','预定取消','预定冲突','已进场','试验进行中','试验结束','已结算'" var="stateStr" ></c:set>
				状态： <select class="easyui-combobox" name="states">
						<option value="-1" >请选择订单状态</option>
						<c:forEach var="item" items="${stateStr}" varStatus="i" >
							<option value="${i.index+1}" <c:if test="${i.index+1 == states}">selected="selected"</c:if>  >${item}</option>
						</c:forEach>
					</select>
				<input type="hidden" name="type" value="1" />	
				<img id="registerUserSearchFormBt" onclick="submitSearchForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
			</div>
</form>
<script type="text/javascript">
	function submitSearchForm(){
		if($("#states").val()==-1){
			$.messager.alert('Error',"请确认查询条件！");
			return false;
		}
		$("#searchOrderForm").submit();
	}
</script>
</div>
 <table id="manageordertab" width="95%">
	<thead>
		<tr style="background-color:#E8F0FF">
		   <th width="10%" >订单号</th>
		   <th width="10%">订单名称</th>
		   <th width="10%" >项目负责人</th>
		   <th width="10%" >联系方式</th>
		   <th width="10%" >客户助理</th>
		   <th width="10%" >联系方式</th>
		   <th width="20%">发票抬头</th>
		   <th width="10%" >状态</th>
		   <th width="10%" >修改项目</th>
		</tr>
	</thead>		
		<!-- 判断有无记录 -->
		<c:choose>
			<c:when test="${empty ordersList}">
				<tr><td colspan="9">没有找到相关记录.</td></tr>
			</c:when><c:otherwise>
		<!-- 遍历mapSess中存入的相应数据 -->
		<tbody>
        <c:forEach items="${ordersList}" var="orderslist" varStatus="ordersStatus">    
			<c:set var="statusIndex" value="${ordersStatus.index}" />
			<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
			<c:if test="${(statusIndex % 2) == 0}">
				<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
			</c:if>        
        <tr style="${evenOddStyle}">
           <td id="orderID_s">${orderslist.orderID_s}</td>
           <td>${orderslist.orderName_s }</td>
     	   <td>${orderslist.customerUser.customerUserName_s}</td>
     	   <td>${orderslist.customerUser.telephone_s}</td>
     	   <td>${orderslist.employee.customerUserName_s}</td> 
     	   <td>${orderslist.employee.telephone_s}</td> 
     	   <td>${orderslist.invoiceOrder_s}</td> 
		   <td>	<c:if test="${orderslist.status_i==1}">预订未确认</c:if>
		   		<c:if test="${orderslist.status_i==2}">预订已确认</c:if>	
		   		<c:if test="${orderslist.status_i==3}">订单取消</c:if>	
		   		<c:if test="${orderslist.status_i==4}">订单冲突</c:if>	
		   		<c:if test="${orderslist.status_i==5}">已进场</c:if>	
		   		<c:if test="${orderslist.status_i==6}">试验中</c:if>	
		   		<c:if test="${orderslist.status_i==7}">试验结束</c:if>	
		   		<c:if test="${orderslist.status_i==8}">订单已结算</c:if>	
		   </td>
           <td>
           	<a title="修改道路费用" href="./initUpdateCostAction?type=1&orderID=${orderslist.orderID_s}"  >
           		<img alt="修改道路费用" src="images/pencil.png" style="cursor: hand;" >
           	</a>
           	<a title="修改车间费用" href="./initUpdateCostAction?type=2&orderID=${orderslist.orderID_s}"  >
           		<img alt="修改车间费用" src="images/edit_remove.png" style="cursor: hand;" >
           	</a>
           	<a title="修改其他费用" href="./initUpdateCostAction?type=3&orderID=${orderslist.orderID_s}"  >
           		<img alt="修改其他费用" src="images/redo.png" style="cursor: hand;" >
           	</a>
           </td> 
		</tr>
       	</c:forEach>
    	<tr>
    		<td colspan="4" style="text-align: left;">
    			<div style="padding-left: 10px;" >
					共有记录${maxCount }条，分${maxPage}页，当前第${currentPage+1}页
				</div>
    		</td>
    		<td colspan="5" style="text-align: right;">
    			<div style="display: inline;width: 400px;float: right;padding-right: 5px;">
					<a href="./searchOrderCostAction?type=1&currentPage=0&states=${states}" >首页</a>&nbsp;
					<a href="./searchOrderCostAction?type=1&currentPage=${currentPage-1<=0?0:currentPage-1}&states=${states}">前一页</a>&nbsp;
					<a href="./searchOrderCostAction?type=1&currentPage=${currentPage+1>=maxPage?totalPage:currentPage+1}&states=${states}">后一页</a>&nbsp;
					<a href="./searchOrderCostAction?type=1&currentPage=${maxPage-1}&states=${states}">末页</a>&nbsp;&nbsp;
				</div>
    		</td>
    	</tr>
	</tbody>
    	</c:otherwise>
	</c:choose>
</table><br>
		<script type="text/javascript">
		$(".passcheck").click(function(){
			//alert("--ok--");
    		//alert($("#tabsub").val());
    		//获取当前行的roadid子项订单编号
			var rid=$(this).parent().parent().children("td").get(0).innerHTML;
			//alert($('#employeeID option:selected').val());
			var employid=$('#employeeID option:selected').val();
	
			$.ajax({
				type:"post",
				url:"./manageOrderAction",
				data:{orderid:rid,employeeID:employid},
				success:function(msg){
					//alert("baituo!!!");
				},
				error:function(){
					//alert("shibai");
				}
			});
		});
    </script>	
</div>
</body>
</html>
