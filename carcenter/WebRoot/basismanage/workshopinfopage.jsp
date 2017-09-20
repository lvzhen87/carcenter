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
    
    <title>车间信息管理</title>
    
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
  </head>
  
 <body style="padding: 0px;margin: 0px; width: 99%;">
   <div id="man_zone">
   <!-- 条件查询div -->
	<div style="height: 40px;padding: 5px;margin: 0px 5px 0px 10px">
		<!-- 根据条件，查询该驾驶员信息 -->
		<form id="searchworkshopForm" name="searchworkshopForm" action="./searchworkshopAction?time=new Date().getTime()" method="post">
			<div>
				<!--  车间编号：<input type="text" id="workShopID" name="workShopID" value="${workShopID }"  />-->
				车间名称：<input type="text" id="workShopName" name="workShopName"  value="${workShopName }"  />
				<!--  使用内容：<input type="text" id="useInfosearch" name="useInfosearch"  value="${useInfosearch }"  />-->
				<img onclick="submitSearchForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				<img onclick="addWorkshop()" alt="添加" title="添加" src="images/icons/icon_add.png" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function submitSearchForm(){
			document.getElementById("searchworkshopForm").submit();
		}
		
		function addWorkshop(){
			var winPar=window.showModalDialog("./prepareworkshopAction", "newwindow", "dialogWidth=1000px;dialogHeight=600px;status=no;help=no;scroll=no;");
			//alert(winPar);
			if(winPar=="refresh"){
				document.getElementById("searchworkshopForm").submit();
			}
		}
	</script>
	
	<table  title="车间基础信息"  id="manageordertab"  border="0" 
	width="95%" style="margin: 0px 0px 0px 10px" >
			<tr style="font-weight: bold;background-color: #E8F0FF">
				<td width="4%">序号</td>
				<td width="15%">车间名称</td>
				<!--  <td width="15%">车间使用内容</td>-->
				<td width="10%">预约车间</td>
				<td width="10%">按月预约</td>
				<td width="10%">按天预约</td>
				<td width="10%">最少预约天数</td>
				<td width="10%">单价费用(天)</td>
				<td width="8%">操作</td>
			</tr>
		<c:choose>
		<c:when test="${empty workshoplist}">
			<tr><td colspan="8">查无记录！</td></tr>
		</c:when><c:otherwise>
		<c:forEach items="${workshoplist}" var="workshoplist" varStatus="workshopStatus">
			<c:set var="statusIndex" value="${workshopStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
				<td>${statusIndex+1}</td>
				<td>${workshoplist.workShopName_s}</td>
				<!--  <td>${workshoplist.useInfos_s}</td>-->
				<td>
					<c:if test="${workshoplist.isSubscribe_i==0 }">否</c:if>
					<c:if test="${workshoplist.isSubscribe_i==1 }">是</c:if>
				</td>
				<td>
					<c:if test="${workshoplist.ismonthSubscribe_i==0 }">否</c:if>
					<c:if test="${workshoplist.ismonthSubscribe_i==1 }">是</c:if>
				</td>
				<td>
					<c:if test="${workshoplist.isdaysubscribe_i==0 }">否</c:if>
					<c:if test="${workshoplist.isdaysubscribe_i==1 }">是</c:if>
				</td>
				<td>${workshoplist.beginningday_i }</td>
				<td>${workshoplist.tBasisWorkshopcost.unitprieI}</td>
				<td>
					<a title="修改" onclick="updateworkshop('${workshoplist.workShopID_s}')" >
            				<img src="images/icons/icon_edit.png" style="cursor:hand;"  alt="修改" />
           			</a> 
					<a title="删除" onclick="deleteworkshop('${workshoplist.workShopID_s}')">
						<img src="images/icons/cross_circle.png" style="cursor:hand;"  alt="删除" />
					</a> 
				</td>
			</tr>
		</c:forEach>
	</c:otherwise>
	</c:choose>	
	<script type="text/javascript">
		function updateworkshop(s){
			var winPar=window.showModalDialog("./prepareworkshopAction?workShopID="+s, "newwindow", "dialogWidth=1000px;dialogHeight=600px;status=no;help=no;scroll=no;");
			//alert(winPar);
			if(winPar=="refresh"){
				document.getElementById("searchworkshopForm").submit();
			}
		}
		
		function deleteworkshop(s){
			var str="确定要删除？"
			$.messager.confirm('删除', str, function(r){
			    if (r){
			    	$.post(
			  				"./deleteworkshopAction",
			  				{
			  					workShopID:s,
			  					time:new Date().getTime()
			  				},function(msg){
								
		  						//$.messager.alert('删除','操作成功!');
		  						document.getElementById("searchworkshopForm").submit();
			  				}
			  			);
			    }
			});
		}
		
		
			
	</script>
	</table>
		<!-- 分页 -->
			<table class="dbgrid" style="background-color: #FFF;margin: 0px 0px 0px 10px" 
			  id="trans"  border="0" 
	width="95%">
				<tr>
					<td width="50%" >
						<div style="display: inline; width: 380px; padding-left: 10px;" >
							共有记录${totalPages }条，分${maxPage}页，当前第${currentPage+1}页
						</div>
					</td>
					<td width="50%" style="text-align: right;">
						<div style="display: inline;width: 300px;float: right;padding-right: 5px;">
							<a href="./searchworkshopAction?flag=search&&currentPage=0&&workShopName=${workShopName}" target="manFrame" >首页</a>&nbsp;
							<a href="./searchworkshopAction?flag=search&&currentPage=${currentPage-1<=0?0:currentPage-1}&&workShopName=${workShopName}">前一页</a>&nbsp;
							<a href="./searchworkshopAction?flag=search&&currentPage=${currentPage+1>=maxPage?totalPage-1:currentPage+1}&&workShopName=${workShopName}">后一页</a>&nbsp;
							<a href="./searchworkshopAction?flag=search&&currentPage=${maxPage-1}&&workShopName=${workShopName}">末页</a>&nbsp;&nbsp;
							<form id="changepage" style="display: inline;" action="./searchworkshopAction" method="post">
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