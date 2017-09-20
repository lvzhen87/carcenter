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
    
    <title>客户人员基础信息</title>
    
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
   <div id="man_zone">
   <!-- 条件查询div -->
	<div style="height: 40px;padding: 5px;margin: 0px 5px 0px 10px">
		<!-- 根据条件，查询该驾驶员信息 -->
		<form id="searchCustomerUserForm" name="searchCustomerUserForm" action="./searchcustomeruserAction" method="post">
			<div>
				公司名称：<input type="text" id="customerName" name="customerName" value="${customerName }"/>
				部门名称：<input type="text" id="department" name="department" value="${department }"/>
				人员名称：<input type="text" id="customerUserName" name="customerUserName" value="${customerUserName }"/>
				人员类别：<select id="userType" name="userType" class="easyui-combobox">
			  				<option value="-1">全部人员</option>
			  				<option value="1"  <c:if test="${userType==1 }"> selected="selected" </c:if> >客户负责人</option>
			  				<option value="2"  <c:if test="${userType==2 }"> selected="selected" </c:if> >陪同人员</option>
			  				<option value="3"  <c:if test="${userType==3 }"> selected="selected" </c:if> >驾驶员</option>
			  			</select>
				<img onclick="submitSearchForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				<img id="" onclick="prepareCustomerUser()" alt="添加" title="添加" src="images/icons/icon_add.png" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				<input type="hidden" name="search" value="1" />
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function submitSearchForm(){
			document.getElementById("searchCustomerUserForm").submit();
		}
		
		function prepareCustomerUser(){
			var winPar=window.showModalDialog("./prepareUserAction", "newwindow", "dialogWidth=1000px;dialogHeight=600px;status=no;help=no;scroll=no;");
			if(winPar=="refresh"){
				document.getElementById("searchCustomerUserForm").submit();
			}
		}
		function updateCustomerUser(id,type){
			var winPar=window.showModalDialog("./prepareUserAction?customerUserID="+id+"&&userType="+type, "newwindow", "dialogWidth=1000px;dialogHeight=600px;status=no;help=no;scroll=no;");
			if(winPar=="refresh"){
				document.getElementById("searchCustomerUserForm").submit();
			}
		}
		
		function deleteCustomerUser(s){
			var str="确定要删除？"
				$.messager.confirm('删除', str, function(r){
				    if (r){
				    	$.post(
				  				"./deleteCustomerUserAction",
				  				{
				  					customerUserID:s,
				  					time:new Date().getTime()
				  				},function(msg){
				  					//alert(msg);
				  					if(msg.length > 4){
				  						$.messager.alert("Error",msg);
				  					}else{
				  						//$.messager.alert("删除","操作成功！");
				  						document.getElementById("searchCustomerUserForm").submit();
				  					}
				  				}
				  			);
				    }
				});
		}
	</script>
	
	<table title="客户人员基础信息" id="manageordertab"  border="0" 
	width="95%" style="margin: 0px 0px 0px 10px">
			<tr style="background-color: #E8F0FF">
				<th width="4%">序号</th>
				<th width="15%">公司名称</th>
				<th width="15%">人员编号</th>
				<th width="15%">人员名称</th>
				<th width="15%">部门名称</th>
				<th width="15%">邮箱</th>
				<th width="13%">类别</th>
				<th width="8%">操作</th>
			</tr>
		
		<c:choose>
		<c:when test="${empty userList}">
			<tr><td colspan="8">查无记录！</td></tr>
		</c:when><c:otherwise>
		<c:forEach items="${userList}" var="userList" varStatus="userListStatus">
			<c:set var="statusIndex" value="${userListStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
				<td>${statusIndex+1 }</td>
				<td>${userList.customername}</td>
				<td>${userList.customeruserid_s}</td>
				<td>${userList.customerusername_s}</td>
				<td>${userList.department_s}</td>
				<td>${userList.email_s}</td>
				<td>
					<c:if test="${userList.usertypeI==1}">客户负责人</c:if>
					<c:if test="${userList.usertypeI==2}">客户陪同人员</c:if>
					<c:if test="${userList.usertypeI==3}">驾驶员</c:if>
				</td>
				<td>
					<a title="修改" onclick="updateCustomerUser('${userList.customeruserid_s}','${userList.usertypeI}')" >
            			<img src="images/icons/icon_edit.png" style="cursor:hand;"  alt="修改" />
           			</a> 
					<a title="删除" onclick="deleteCustomerUser('${userList.customeruserid_s}')" >
						<img src="images/icons/cross_circle.png" style="cursor:hand;"  alt="删除" />
					</a> 
					
				</td>
			</tr>
		</c:forEach>
		
	</c:otherwise>
</c:choose>
		</table>
		<table  class="dbgrid" style="background-color: #FFF;margin: 0px 0px 0px 10px" id="trans"  border="0" 
			width="95%" >
			<tr >
			<td width="50%">
				<div style="display: inline; width: 380px; padding-left: 10px;" >
				共有记录${totalPages }条，分${maxPage}页，当前第${currentPage+1}页
				</div>
			</td>
			<td width="50%" style="text-align: right;">
				<div style="display: inline;width: 300px;float: right;padding-right: 5px;">
					<a href="./searchcustomeruserAction?flag=page&&currentPage=0&&customerName=${customerName}&&department=${department}&&customerUserName=${customerUserName}&&userType=${userType}">首页</a>&nbsp;
					<a href="./searchcustomeruserAction?flag=page&&currentPage=${currentPage-1<=0?0:currentPage-1}&&customerName=${customerName}&&department=${department}&&customerUserName=${customerUserName}&&userType=${userType}">前一页</a>&nbsp;
					<a href="./searchcustomeruserAction?flag=page&&currentPage=${currentPage+1>=maxPage?totalPage-1:currentPage+1}&&customerName=${customerName}&&department=${department}&&customerUserName=${customerUserName}&&userType=${userType}">后一页</a>&nbsp;
					<a href="./searchcustomeruserAction?flag=page&&currentPage=${maxPage-1}&&customerName=${customerName}&&department=${department}&&customerUserName=${customerUserName}&&userType=${userType}">末页</a>&nbsp;&nbsp;
					<form id="changepage" style="display: inline;" action="./searchcustomeruserAction" method="post">
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