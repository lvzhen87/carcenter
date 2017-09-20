<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>门禁信息管理</title>
    
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
form{
	margin: 0px;
	padding: 0px;
}
</style>
  </head>
  
 <body style="padding: 0px;margin: 0px; width: 99%">
   <div id="man_zone">
   <!-- 条件查询div -->
	<div style="height: 40px;padding: 5px;margin: 0px 5px 0px 10px">
		<!-- 根据条件，查询该驾驶员信息 -->
		<form id="doorSearchForm" name="doorSearchForm" action="./initDoorinfoAction?time=new Date().getTime()" method="post">
			<div>
				房门编号：<input type="text" id="doorID" name="doorID" value="${doorID }" onblur="Checkfun.IsIntegerAllowNull(this,'房门编号',20)" />
				房门名称：<input type="text" id="doorName" name="doorName" value="${doorName }"  />
				<img id="doorSearchForm" onclick="submitSearchForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				<!--  
				<img onclick="addDoorinfo()" alt="添加" title="添加" src="images/icons/icon_add.png" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				-->
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function submitSearchForm(){
			document.getElementById("doorSearchForm").submit();
		}
	</script>
<form action="./modifyDoorAction"  method="post" id="changedoorForm" name="changedoorForm" style="margin-top: 0px;">
	<table title="房门信息" id="manageordertab"  border="0" 
	width="95%" style="margin: 0px 0px 0px 10px" >
			<tr style="font-weight: bold;background-color: #E8F0FF">
				<!--  <td width="10%">道路编号</td>-->
				<td width="4%">序号</td>
				<td width="16%">房门编号</td>
				<td width="16%">房门名称</td>
				<td width="18%">所属设备识别号</td>
				<td width="18%">通道号</td>
				<td width="16%">门组识别号</td>
				<td width="12%"> 
			   		<input type="checkbox" title="全选" name="selAllDoorItem" id="selAllDoorItem" onclick="selectAllDoor()" style="width: 25px;border: 0px;">
			   		<input type="button"  value="确认" name="submitDoorBt" id="submitDoorBt" onclick="submitCheckDoorForm()" style="width: 40px;">
			   </td>
			</tr>
		<c:choose>
		<c:when test="${empty doorlist}">
			<tr><td colspan="7">查无记录！</td></tr>
		</c:when><c:otherwise>
		<c:forEach items="${doorlist}" var="dlist" varStatus="dlistStatus">
			<c:set var="statusIndex" value="${dlistStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
				<td>${statusIndex+1 }</td>
				<td>${dlist.doorIdI}</td>
				<td>${dlist.doorNameS}</td>
				<td>${dlist.devicesysidI}</td>
				<td>${dlist.channelnumI}</td>
				<td><input id="group_${statusIndex}" name="group_${statusIndex}"  value="${dlist.groupId_s }"/></td>
				<td>
				<!--  
					<a title="修改" onclick="updatedoor('${dlist.doorIdI}')" >
            			<img src="images/icons/icon_edit.png" style="cursor:hand;"  alt="修改" />
           			</a>
           		-->
           			<c:if test="${dlist.isUse_i == 1 }">
           				<input type="checkbox" name="selDoorItem" checked="true" value="${dlist.doorIdI }" style="border: 0px"> 
           			</c:if>
           			<c:if test="${dlist.isUse_i != 1}">
           				<input type="checkbox" name="selDoorItem"  value="${dlist.doorIdI }" style="border: 0px"> 
           			</c:if>
				</td>
			</tr>
	</c:forEach>
	</c:otherwise>
</c:choose>
			
	</table>
</form>
<!-- 
<input type="hidden" id="doorsID" name="doorsID" value="">
<input type="hidden" id="groupsID" name="groupsID" value="">
<input type="hidden" id="isUse" name="isUse" value="">
 -->
	<script type="text/javascript">
		
		function selectAllDoor(){
			var selAll=document.getElementById("selAllDoorItem").checked;
  			if(selAll){
				var boxs=document.getElementsByName("selDoorItem");
				for(i=0;i<boxs.length;i++){
					boxs[i].checked=true;
				}
  			}else {
				var boxs=document.getElementsByName("selDoorItem");
				for(i=0;i<boxs.length;i++){
					boxs[i].checked=false;
				}
  			}
			
		}
		function submitCheckDoorForm(){
			//alert("!!!");
			var doorsID="";
			var groupsID="";
			var isUse ="";
			//alert($("#group_12").val());
			var boxs=document.getElementsByName("selDoorItem");
			for(i=0;i<boxs.length;i++){
				doorsID += boxs[i].value +",";
				if(boxs[i].checked == true){
					isUse += "1," ;
				}
				if(boxs[i].checked==false){
					//alert(boxs[i].value);
					isUse += "0,";
				}
				
				if($("#group_"+i).val() != "" ){
					groupsID += $("#group_"+i).val() +",";
				}else{
					groupsID += "NA,";
				}
				
			}
			//$("#doorsID").value(doorsID);
			//$("#isUse").value(isUse);
			//$("#groupsID").value(groupsID);		
			
			//alert(doorsID);
			//alert(groupsID);
			//alert(isUse);
			//alert($("#doorsID").value());
			//alert($("#isUse").value());
			//alert($("#groupsID").value());
			//$("#changedoorForm").submit();
			$.post(
	  				"./modifyDoorAction",
	  				{
	  					doorsID:doorsID,
	  					groupsID:groupsID,
	  					isUse:isUse,
	  					time:new Date().getTime()
	  				},function(){
	  					$.messager.alert("Success","门禁设置成功！");
	  				}
	  		);
	  			
		}
	</script>
		<!-- 分页 -->
			<table class="dbgrid" style="background-color: #FFF;margin: 0px 0px 0px 10px" id="trans"  border="0" 
			width="95%"  >
				<tr>
					<td width="50%" >
						<div style="display: inline; width: 380px; padding-left: 10px;" >
							共有记录${totalPages }条，分${maxPage}页，当前第${currentPage+1}页
						</div>
					</td>
					<td width="50%" style="text-align: right;">
						<div style="display: inline;width: 300px;float: right;padding-right: 5px;">
							<a href="./initDoorinfoAction?flag=search&&currentPage=0&&doorID=${doorID}&&doorName=${doorName}" target="manFrame" >首页</a>&nbsp;
							<a href="./initDoorinfoAction?flag=search&&currentPage=${currentPage-1<=0?0:currentPage-1}&&doorID=${doorID}&&doorName=${doorName}">前一页</a>&nbsp;
							<a href="./initDoorinfoAction?flag=search&&currentPage=${currentPage+1>=maxPage?totalPage-1:currentPage+1}&&doorID=${doorID}&&doorName=${doorName}">后一页</a>&nbsp;
							<a href="./initDoorinfoAction?flag=search&&currentPage=${maxPage-1}&&doorID=${doorID}&&doorName=${doorName}">末页</a>&nbsp;&nbsp;
							<form id="changepage" style="display: inline;" action="./initDoorinfoAction" method="post">
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
  </body>
</html>
