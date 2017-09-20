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
    
    <title>上月消费记录查询页面</title>
    
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
	vertical-align:bottom;
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
	<div style="height: 40px;padding: 5px;margin: 0px 0px 0px 10px">
		<!-- 根据条件，查询员工消费记录信息 -->
		
			<div style="vertical-align:bottom;">
			<table class="dbgrid" style="background-color: #FFF;margin: 0px 0px 0px 10px" width="98%">
			<tr>
			<td style="width: 50%">
			<form id="expendRecordForm" name="expendRecordForm" action="./expendRecordAction" method="post">
			员工证件号：<input type="text" id="strSysNo" name="strSysNo" value="${strSysNo}"  />
			员工姓名：<input type="text" id="strEmplyName" name="strEmplyName" value="${strEmplyName}"  />	
				<img onclick="submitSearchForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align:bottom;display: inline;cursor: hand;" >
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a style = "visibility: hidden;" onclick="CaluSalory()" >&nbsp;&nbsp;上月补贴一次性发放&nbsp;&nbsp;</a>
			</form>
			</td>
			<td align="right"">
			<a class="easyui-linkbutton" onClick="doClick()" >&nbsp;&nbsp;上月补贴报表&nbsp;&nbsp;</a>
			</td>
			</tr>
			</table>
			</div>
		
	</div>
	<script type="text/javascript">
	
	 function CaluSalory()
	 {
	 	$.messager.confirm('确定', '是否确定发放补贴',
	 	 function(r){
		 	 if (r){
		 		$.post("./setExpendAction?time="+new Date()
		 		,function(msg){
			  				//alert(msg);
			  				if(msg.indexOf("success")>-1)
			  				{
			  					$.messager.alert('Success','发放补贴成功！');
			  				}
			  				else if(msg.indexOf("calu")>-1)
			  				{
			  					$.messager.alert('Success','补贴已发放！');
			  				}
			  				else if(msg.indexOf("error")>-1)
			  				{
			  					$.messager.alert('Error','发放补贴失败！');
			  				}
			  			}
	  			);
		 	}
	 	});
	 }
	 
	 function doClick(){  
		window.location.href="./setExportBalenceAction";  
	} 

	 function ExportBalence()
	 {
	 	$.post("./setExportBalenceAction?time="+new Date());
	 }
	 
	function submitSearchForm(){
		document.getElementById("expendRecordForm").submit();
	}		
	</script>
	

	<table title="员工消费记录" id="manageordertab"  border="0" width="98%" style="margin: 0px 0px 0px 10px">
			<tr style="font-weight: bold;background-color: #E8F0FF">
				<td width="4%">序号</td>
				<td width="18%">员工证件号</td>
				<td width="20%">员工姓名</td>
				<td width="20%">部门名称</td>
				<td width="10%">消费金额</td>
				<td width="20%">消费时间</td>
				<!-- <td width="8%">应发补贴</td> -->
			</tr>
		<c:choose>
		<c:when test="${empty erList}">
			<tr><td colspan="7">查无记录！</td></tr>
		</c:when><c:otherwise>
		<c:forEach items="${erList}" var="erList" varStatus="erStatus">
			<c:set var="statusIndex" value="${erStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
				<td>${statusIndex+1 }</td>
				<td>${erList.sysNo}</td>
				<td>${erList.employName}</td>
				<td>${erList.departMentName}</td>
				<td>${erList.dealMoney}</td>
				<td>${erList.dealDate_s}</td>
				<!--<td>${erList.subsidies}</td>-->
			</tr>
		</c:forEach>
		</table>
	</c:otherwise>
</c:choose>
	
	<!-- 分页 -->
		<table id="trans" class="dbgrid" style="background-color: #FFF;margin: 0px 0px 0px 10px" width="98%"  >
			<tr>
				<td width="40%" align="left" >
					<div style="display: inline; width: 380px; padding-left: 5px;" >
						共有记录${totalPages }条，分${maxPage}页，当前第${currentPage+1}页
					</div>
				</td>
				<td style="text-align: right;">
					<div style="display: inline;width: 300px;float: right;padding-right: 10px;">
						<a href="./expendRecordAction?currentPage=0&&strSysNo=${strSysNo}&strEmplyName=${strEmplyName}" target="manFrame" >首页</a>&nbsp;
						<a href="./expendRecordAction?currentPage=${currentPage-1<=0?0:currentPage-1}&&strSysNo=${strSysNo}&strEmplyName=${strEmplyName}">前一页</a>&nbsp;
						<a href="./expendRecordAction?currentPage=${currentPage+1>=maxPage?totalPage-1:currentPage+1}&&strSysNo=${strSysNo}&strEmplyName=${strEmplyName}">后一页</a>&nbsp;
						<a href="./expendRecordAction?currentPage=${maxPage-1}&&strSysNo=${strSysNo}&strEmplyName=${strEmplyName}">末页</a>&nbsp;&nbsp;
						<form id="changepage" style="display: inline;" action="./expendRecordAction" method="post">
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