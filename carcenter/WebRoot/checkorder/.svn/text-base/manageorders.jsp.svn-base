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
	<script type="text/javascript" src="js/verify.js"></script>
	
     <style type="text/css">
    	passcheck{}
    </style>
<title>管理区域</title>
<style type="text/css">
#manageordertab td{
	font-size: 12px;
	text-align: center;
	vertical-align: middle;
	height: 25px;
}

#trans td{
	font-size: 12px;
	vertical-align: middle;
	height: 25px;
}
#manageordertab tr{
	height: 25px;
}
#manageordertab td{
	height: 25px;
}
select{
	margin: 0px;
	padding: 0px;
}
form{
	margin: 0px;
	padding: 0px;
}
</style>
</head>

<body style="padding: 0px;margin: 0px; width: 99%">
<div id="man_zone">
<!-- 查询条件 -->
<div style="height: 40px;padding: 5px;margin: 0px 5px 0px 10px">
<form id="orderDistributionForm" name="orderDistributionForm" action="./distrubuteOrderAction" method="post">
			<div >
				<c:set value="全部未确认订单,待分配订单,已分配订单" var="stateStr" ></c:set>
				订单状态： <select name="states" id="states" class="easyui-combobox">
						<!-- <option value="-1" >请选择订单状态</option> -->
						<c:forEach var="item" items="${stateStr}" varStatus="i" >
							<option value="${i.index}" <c:if test="${i.index==states}">selected="selected"</c:if>  >${item}</option>
						</c:forEach>
					</select>
				<img id="registerUserSearchFormBt" onclick="submitDstrForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
			</div>
</form>
<script type="text/javascript">
	function submitDstrForm(){
		document.getElementById("orderDistributionForm").submit();
	}
</script>
</div>

 <table id="manageordertab" width="95%" style="margin: 0px 0px 0px 10px">
		<!-- 判断有无记录 -->

		<thead>
			<tr style="background-color:#E8F0FF">
			   <th width="4%">序号</th>
			   <th width="10%" >订单号</th>
			   <th width="20%" >试验名称</th>
			   <th width="21%">发票抬头</th>
			   <th width="10%">提交时间</th>
			   <th width="10%" >状态</th>
			   <th width="10%" >客户负责人</th>
			   <th width="15%" >客户助理</th>
			</tr>
		</thead>	
		<c:choose>
			<c:when test="${empty ordersList}">
				<tr><td colspan="8">没有待分配试验任务！</td></tr>
			</c:when>
		<c:otherwise>	
		<tbody>
		<!-- 遍历mapSess中存入的相应数据 -->
        <c:forEach items="${ordersList}" var="orderslist" varStatus="ordersStatus">    
			<c:set var="statusIndex" value="${ordersStatus.index}" />
			<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
			<c:if test="${(statusIndex % 2) == 0}">
				<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
			</c:if>        
        <tr style="${evenOddStyle}">
       	   <td>${statusIndex+1 }</td>
           <td id="orderID_s">${orderslist.orderID_s}</td>
     	   <td>${orderslist.orderName_s}</td>
     	   <td>${orderslist.invoiceOrder_s}</td> 
		   <td>${orderslist.reservationDate_t }</td>
		   <td><c:choose>
		   			<c:when test="${orderslist.status_i==1}">
				   		预订未确认
		   			</c:when><c:otherwise>
		   				
		   			</c:otherwise>
		   		</c:choose>
		   </td>
		   
		   <td>${orderslist.customerUser.customerUserName_s}</td>
		   <td >${orderslist.employeeID_s }
				<form action="./manageOrderAction" method="post" name="distributeForm" id="distributeForm">
		   			<select id="employeeID"  name="${statusIndex}" class="easyui-combobox">
		   				<option value="-1" >待分配</option>
		   				<c:forEach items="${employeeList}" var="elist">				
			   					<option value="${elist.employeeID_s }" <c:if test="${elist.employeeID_s==orderslist.employee.employeeID_s}">selected="selected" </c:if>>${elist.customerUserName_s }</option>
		   				</c:forEach>
		   			</select>	
		   			<input type="hidden" id="orderid" name="orderid" value="${orderslist.orderID_s}"  >
		   			<input type="hidden" id="emid" name="emid"   value="">
        	    	<input id="okbtn" type="button" onclick="submitEmploy('${orderslist.orderID_s}','${statusIndex}')"  src="images/icons/tick_circle.png" style="cursor:hand;" value="确认" />
				</form>	
            </td>
		</tr>
       	</c:forEach>
       	</c:otherwise>
		</c:choose>
		</tbody>	
	</table>
	<table id="trans" class="dbgrid" style="background-color: #FFF;margin: 0px 0px 0px 10px" width="95%"  align="left">
       		<tr>
	       		<td align="left" >共有记录${totalOrderInfos }条，分${maxPage}页，当前第${currentPage+1}页
	       		</td>
	       		<td align="right" >
	       			<div style="display: inline;width: 400px;float: right;padding-right: 5px;">
						<a href="./distrubuteOrderAction?currentPage=0&&states=${states}" >首页</a>&nbsp;
						<a href="./distrubuteOrderAction?currentPage=${currentPage-1<=0?0:currentPage-1}&&states=${states}">前一页</a>&nbsp;
						<a href="./distrubuteOrderAction?currentPage=${currentPage+1>=maxPage?totalPage:currentPage+1}&&states=${states}">后一页</a>&nbsp;
						<a href="./distrubuteOrderAction?currentPage=${maxPage-1}&&states=${states}">末页</a>&nbsp;&nbsp;
						<form style="display: inline;" action="./distrubuteOrderAction" method="post" name="pageForm" id="pageForm">
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
										document.getElementById("pageForm").submit();
						            }
						        });
						    });
						</script>
					</div>
	       		</td>
       		</tr>
       		</table>
	
		<script type="text/javascript">
		function orderEmploy(){
			document.getElementById("distributeForm").submit();
		}
		
		function submitEmploy(s,p){
			//$("#emid").val($("#employeeID").combobox('getValues'));
			var qtys= $("[name="+p+"]") ;
			//alert(qtys.val());
			//alert(qtys.val());
			$("#emid").val(qtys.val());
			//校验略
	  		var str="提交操作？";
	  		$.messager.confirm('确定', str, function(r){
	  			if (r){
		  			$.post(
		  				"./manageOrderAction",
		  				{
		  					employeeID:$("#emid").val(),
		  					orderid:s,
		  					time:new Date().getTime()
		  				},function(){
		  					$.messager.alert('Success','试验任务分配成功！');
		  					
		  				}
		  			);
	  			
	  			}
			});
		}
		
		
		
		$(".passcheck").click(function(){
			//alert("--ok--");
    		//alert($("#tabsub").val());
    		//获取当前行的roadid子项订单编号
			var rid=$(this).parent().parent().children("td").get(0).innerHTML;
			alert($('#employeeID option:selected').val());
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
