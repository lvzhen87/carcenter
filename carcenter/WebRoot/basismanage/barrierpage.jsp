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
    
    <title>道闸信息查询页面</title>
    
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
  
 <body style="padding: 0px;margin: 0px; width: 99%">
   <div id="man_zone" >
   <!-- 条件查询div -->
	<div style="height: 40px;padding: 5px;margin: 0px 5px 0px 10px">
		<!-- 根据条件，查询道闸信息 -->
		<form id="searchBarrierForm" name="searchBarrierForm" action="./searchbarrierAction?time=new Date().getTime()" method="post">
			<div>
				道闸编号：<input type="text" id="gateNumber" name="gateNumber" value="${gateNumber }"  />
				道闸名称：<input type="text" id="gateType" name="gateType" value="${gateType }"  />
<!--				道闸公司名称：<input type="text" id="gateCompany" name="gateCompany" value="${gateCompany }"  />-->
				道闸所在道路：<select id="entranceRoadID" name="entranceRoadID" class="easyui-combobox">
							<option value="-1">请选择道闸所在道路 </option>
		  					<c:forEach items="${roadforbarrier}" var="roadlist">
		  						<option value="${roadlist.roadID_s }" <c:if test="${entranceRoadID==roadlist.roadID_s }">selected="selected" </c:if>>${roadlist.roadName_s }</option>
		  					</c:forEach>
		  				</select>
				<!--<input type="text" id="entranceRoadID" name="entranceRoadID" value="${entranceRoadID }" />  
				出口道路编号：<input type="text" id="outRoadID" name="outRoadID" value="${outRoadID }"  />-->
				<img onclick="submitSearchForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				<img id="" onclick="addBarrier()" alt="添加" title="添加" src="images/icons/icon_add.png" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				
			</div>
		</form>
	</div>
	<script type="text/javascript">
	 
		function submitSearchForm(){
			document.getElementById("searchBarrierForm").submit();
		}
		
		function addBarrier(){
			document.getElementById("searchBarrierForm").action="./tbBarrierAction?isUpdate=0";
	//		var winPar=window.showModalDialog("./addBarrierAction?isUpdate=0", "", "dialogWidth=980px;dialogHeight=600px;toolbar=no;menubar=no;location=no;status=no;scroll=no;");
		 	//alert(winPar);		 
			document.getElementById("searchBarrierForm").submit();
		 
			document.getElementById("searchBarrierForm").action="./searchbarrierAction?time=new Date().getTime()";
			submitSearchForm();
		}
		
	</script>
	

	<table  title="道闸基本信息" id="manageordertab"  border="0" width="98%" style="margin: 0px 0px 0px 10px">
			<tr style="font-weight: bold;background-color: #E8F0FF">
				<td width="4%">序号</td>
				<td width="8%">道闸编号</td>
				<td width="30%">道闸名称</td>
<!--				<td width="20%">道闸公司名称</td>-->
				<td width="28%">道闸所在道路</td>
				<td width="20%">类型</td>
				<!--  <td width="15%">出口道路编号</td>-->
				<td width="5%">状态</td>
				<td width="5%">操作</td>
			</tr>
		<c:choose>
		<c:when test="${empty barriergateList}">
			<tr><td colspan="7">查无记录！</td></tr>
		</c:when><c:otherwise>
		<c:forEach items="${barriergateList}" var="barriergatelist" varStatus="barriergateStatus">
			<c:set var="statusIndex" value="${barriergateStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
				<td>${statusIndex+1 }</td>
				<td>${barriergatelist.gateNumber_s}</td>
				<td>${barriergatelist.gateType_s}</td>
				<td>${barriergatelist.enterroadinfo.roadName_s }</td>
				<td>				 
					<c:if test="${barriergatelist.resaveds1_s==1}">入口道闸</c:if>
					<c:if test="${barriergatelist.resaveds1_s==2}">出口道闸</c:if>
				</td>
				<!--  <td>${barriergatelist.outroadinfo.roadName_s }</td>-->
				<td>
					<c:if test="${barriergatelist.state_i==0}">故障</c:if>
					<c:if test="${barriergatelist.state_i==1}">启用</c:if>
				</td>
				<td>
					<a title="修改" onclick="updateBarrier('${barriergatelist.gateID_s}','${barriergatelist.gateNumber_s}')" >
            			<img src="images/icons/icon_edit.png" style="cursor:hand;"  alt="修改" />
           			</a> 
           			<!--  
					<a title="删除" href="./deleteBarrierAction?gateID=${barriergatelist.gateID_s}">
						<img src="images/icons/cross_circle.png" style="cursor:hand;"  alt="删除" />
					</a> -->
					<input type="hidden" value="${barriergatelist.gateID_s}"/>
				</td>
			</tr>
		</c:forEach>
		</table>
	</c:otherwise>
</c:choose>
	<script type="text/javascript">
		function updateBarrier(s,t){
		   var winPar=window.showModalDialog("./prepareadBarrierAction?isUpdate=1&gateNumber="+t+"&gateID="+s, "", "dialogWidth=980px;dialogHeight=300px;toolbar=no;menubar=no;location=no;status=no;scroll=no;");
		 	//alert(winPar);

		   if(winPar=="refresh"){
				document.getElementById("searchBarrierForm").submit();
			}
		}
	</script>
	
		<!-- 分页 -->
			<table id="trans" class="dbgrid" style="background-color: #FFF;margin: 0px 0px 0px 10px" width="98%"  >
				<tr>
					<td width="50%" align="left" >
						<div style="display: inline; width: 380px; padding-left: 10px;" >
							共有记录${totalPages }条，分${maxPage}页，当前第${currentPage+1}页
						</div>
					</td>
					<td width="50%" style="text-align: right;">
						<div style="display: inline;width: 300px;float: right;padding-right: 5px;">
							<a href="./searchbarrierAction?flag=search&&currentPage=0&&gateNumber=${gateNumber}&&gateType=${gateType}&&entranceRoadID=${entranceRoadID}" target="manFrame" >首页</a>&nbsp;
							<a href="./searchbarrierAction?flag=search&&currentPage=${currentPage-1<=0?0:currentPage-1}&&gateNumber=${gateNumber}&&gateType=${gateType}&&entranceRoadID=${entranceRoadID}">前一页</a>&nbsp;
							<a href="./searchbarrierAction?flag=search&&currentPage=${currentPage+1>=maxPage?totalPage-1:currentPage+1}&&gateNumber=${gateNumber}&&gateType=${gateType}&&entranceRoadID=${entranceRoadID}">后一页</a>&nbsp;
							<a href="./searchbarrierAction?flag=search&&currentPage=${maxPage-1}&&gateNumber=${gateNumber}&&gateType=${gateType}&&entranceRoadID=${entranceRoadID}">末页</a>&nbsp;&nbsp;
							<form id="changepage" style="display: inline;" action="./searchbarrierAction" method="post">
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