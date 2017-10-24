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
    
    <title>道路基础信息管理</title>
    
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
		<form id="roadSearchForm" name="roadSearchForm" action="./searchroadAction?time=new Date().getTime()" method="post">
			<div>
				<!--  道路编号：<input type="text" id="roadID" name="roadID" value="${roadID }"  />-->
				道路名称：<input type="text" id="roadName" name="roadName" value="${roadName }"  />
				<!--技术参数：<input type="text" id="technicalParameters" name="technicalParameters" value="${technicalParameters }"  />
				  最大容量：<input type="text" id="maxcapacity" name="maxcapacity" value="" />-->
				状态：<select id="state" name="state" class="easyui-combobox">
						<option value="-1">请选择状态</option>
						<option value="0" <c:if test="${state == 0 }">selected="selected" </c:if>>未投入使用</option>
						<option value="1" <c:if test="${state == 1 }">selected="selected" </c:if>>已投入使用</option>
					</select>
				<img id="roadSearchFormBt" onclick="submitSearchForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				<img onclick="addRoadinfo()" alt="添加" title="添加" src="images/icons/icon_add.png" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function submitSearchForm(){
			document.getElementById("roadSearchForm").submit();
		}
		
		function addRoadinfo(){
			var winPar=window.showModalDialog("./prepareroadAction", "", "dialogWidth=1000px;dialogHeight=600px;status=no;help=no;scroll=no;");
			//alert(winPar);
			if(winPar=="refresh"){
				document.getElementById("roadSearchForm").submit();
			}
		}
	</script>
	
	<table title="道路信息" id="manageordertab"  border="0" 
	width="95%" style="margin: 0px 0px 0px 10px" >
			<tr style="font-weight: bold;background-color: #E8F0FF">
				<!--  <td width="10%">道路编号</td>-->
				<td width="4%">序号</td>
				<td width="10%">道路名称</td>
				<td width="10%">道路类型</td>
				<!--  <td width="8%">技术参数</td>-->
				<td width="7%">最大容量</td>
				<td width="7%">试验时间</td>
				<!--  <td width="10%">实验类型</td>-->
				<td width="7%">状态</td>
				<td width="7%">费用单价(元/分钟)</td>
				<td width="7%">包场单价(万/时)</td>
				<td width="7%">活动包场(万/半天)</td>
				<td width="7%">最少预订天数</td>
				<td width="7%">道路分组</td>
				<td width="8%">操作</td>
			</tr>
		<c:choose>
		<c:when test="${empty roadlist}">
			<tr><td colspan="11">查无记录！</td></tr>
		</c:when><c:otherwise>
		<c:forEach items="${roadlist}" var="roadlist" varStatus="roadStatus">
			<c:set var="statusIndex" value="${roadStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
				<!--  <td>${roadlist.roadID_s}</td>-->
				<td>${statusIndex+1 }</td>
				<td>${roadlist.roadName_s}</td>
				<td>
					<c:if test="${roadlist.roadType_s==1}" >共享专用道路</c:if>
					<c:if test="${roadlist.roadType_s==2}" >共享／精确道路</c:if>
				</td>
				<!--  <td>${roadlist.technicalParameters_s}</td>-->
				<td>${roadlist.maxCapacity_i}</td>
				<td>${roadlist.usefultime_s}</td>
				<!--  <td>${roadlist.types }</td>-->
				<td>
					<c:if test="${roadlist.state_i==0}" >未投入使用</c:if>
					<c:if test="${roadlist.state_i==1}" >已投入使用</c:if>
				</td>
				<td>${roadlist.roadCost.minuteUnitPrie_i }</td>
				<td>${roadlist.roadCost.wholeUnitPrie_i }</td>
				<td>${roadlist.roadCost.activityUnitPrie_i}</td>
				<td>${roadlist.beginningDay_i}</td>
				<td>${roadlist.resaveds1_s}</td>
				<td>
					<a title="修改" onclick="updateroad('${roadlist.roadID_s}')" >
            				<img src="images/icons/icon_edit.png" style="cursor:hand;"  alt="修改" />
           			</a> 
					<a title="删除" onclick="deleteroad('${roadlist.roadID_s}')" >
						<img src="images/icons/cross_circle.png" style="cursor:hand;"  alt="删除" />
					</a> 
				</td>
			</tr>
	</c:forEach>
	</c:otherwise>
</c:choose>
			
	</table>
	<script type="text/javascript">
		function updateroad(s){
			var winPar=window.showModalDialog("./prepareroadAction?roadID="+s,"","dialogWidth=1000px;dialogHeight=600px;status=no;help=no;scroll=no;");
			//window.showModalDialog('WMS_Material.aspx', '', "dialogWidth=310px;dialogHeight=600px;status=no;help=no;scrollbars=no;")
			//alert(winPar);
			if(winPar=="refresh"){
				document.getElementById("roadSearchForm").submit();
			}
		}
		
		function deleteroad(s){
			var str="确定要删除？"
			$.messager.confirm('删除', str, function(r){
			    if (r){
				
					$.post(
		  				"./deleteroadAction",
		  				{
		  					roadID:s,
		  					time:new Date().getTime()
		  				},function(msg){
		  					//alert(msg);
		  					if(msg.length > 4){
		  						$.messager.alert("Error",msg);
		  					}else{
		  						//$.messager.alert("删除","操作成功！");
		  						document.getElementById("roadSearchForm").submit();
		  					}
		  				}
		  			);
				}
		    });
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
							<a href="./searchroadAction?flag=search&&currentPage=0&&roadName=${roadName }&&state=${state}" target="manFrame" >首页</a>&nbsp;
							<a href="./searchroadAction?flag=search&&currentPage=${currentPage-1<=0?0:currentPage-1}&&roadName=${roadName }&&state=${state}">前一页</a>&nbsp;
							<a href="./searchroadAction?flag=search&&currentPage=${currentPage+1>=maxPage?totalPage-1:currentPage+1}&&roadName=${roadName }&&state=${state}">后一页</a>&nbsp;
							<a href="./searchroadAction?flag=search&&currentPage=${maxPage-1}&&roadName=${roadName }&&state=${state}">末页</a>&nbsp;&nbsp;
							<form id="changepage" style="display: inline;" action="./searchroadAction" method="post">
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
