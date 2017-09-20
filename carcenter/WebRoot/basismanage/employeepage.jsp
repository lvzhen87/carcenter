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
    
    <title>员工信息查询页面</title>
    
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
		<!-- 根据条件，查询该员工信息 -->
		<form id="searchEmployeeForm" name="searchEmployeeForm" action="./searchemployeeInfoAction" method="post">
			<div>
				职员编号：<input type="text" id="employeeID_s" name="employeeID_s" value="${employeeID_s}" />
				<!--  岗位编号：<input type="text" id="organizationPost_s" name="organizationPost_s" value="${organizationPost_s }" />
				部门编号：<input type="text" id="organizationDept_s" name="organizationDept_s" value="${ organizationDept_s}" />
				-->人员名称：<input type="text" id="customerUserName_s" name="customerUserName_s" value="${ customerUserName_s}" />
				<img onclick="submitSearchForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
				<!-- <img id="" onclick="addCustomerUser()" alt="添加" title="添加" src="images/icons/icon_add.png" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" > -->
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function submitSearchForm(){
			document.getElementById("searchEmployeeForm").submit();
		}
		
		function addCustomerUser(){
			var winPar=window.showModalDialog("./prepareEmpAction","newwindow", "dialogWidth=1000px;dialogHeight=600px;status=no;help=no;scroll=no;");
			//alert(winPar);
			if(winPar=="refresh"){
				document.getElementById("searchEmployeeForm").submit();
			}
		}
		
	</script>
	
	<table  title="员工基础信息" id="manageordertab"  border="0" 
	width="95%" style="margin: 0px 0px 0px 10px" >
			<tr style="font-weight: bold;background-color: #E8F0FF">
				<td width="4%">序号</td>
				<td width="10%">部门名称</td>
				<td width="10%">岗位名称</td>
				<td width="15%">人员名称</td>
				<td width="13%">登录名</td>
				<td width="15%">邮箱</td>
				<td width="10%">电话</td>
				<td width="15%">身份证号</td>
				<td width="8%">操作</td>
			</tr>
		
	<c:choose>
		<c:when test="${empty employeelist}">
			<tr><td colspan="9">查无记录！</td></tr>
		</c:when><c:otherwise>
		<c:forEach items="${employeelist}" var="employeelist" varStatus="employeelistStatus">
			<c:set var="statusIndex" value="${employeelistStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
			<tr style="${evenOddStyle}">
				<td>${statusIndex+1 }</td>
				<td>${employeelist.employeeDept.deptName_s}</td>
				<td>${employeelist.employeePost.postName_s}</td>
				<td>${employeelist.customerUserName_s}</td>
				<td>${employeelist.employeeLoginName}</td>
				<td>${employeelist.email_s}</td>
				<td>${employeelist.telephone_s }</td>
				<td>${employeelist.identityCard_s }</td>
				<td>
					<a title="修改" onclick="updateEmployee('${employeelist.employeeID_s}')" >
            				<img src="images/icons/icon_edit.png" style="cursor:hand;"  alt="修改" />
           			</a> 
					<!-- 
					<a title="删除" onclick="deleteemployee('${employeelist.employeeID_s}')" >
						<img src="images/icons/cross_circle.png" style="cursor:hand;"  alt="删除" />
					</a>  -->
				</td>
			</tr>
	</c:forEach>
	
	</c:otherwise>
</c:choose>
	</table>
	<script type="text/javascript">
			function updateEmployee(id){
				var winPar=window.open("./prepareEmpAction?employeeID_s="+id,"newwindow", "width=980,height=600;status=no;help=no;scroll=no;");
				 
					document.getElementById("searchEmployeeForm").submit();
				
			}
			
			function deleteemployee(s){
				var str="确定要删除？"
					$.messager.confirm('删除', str, function(r){
					    if (r){
					    	$.post(
					  				"./deleteemployeeInfoAction",
					  				{
					  					employeeID_s:s,
					  					time:new Date().getTime()
					  				},function(){
					  					
				  						$.messager.alert('Success','操作成功!');
				  						document.getElementById("searchEmployeeForm").submit();
					  				}
					  			);
					    }
					});
			}
		</script>
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
						
				<a href="./searchemployeeInfoAction?flag=page&&currentPage=0&&employeeID_s=${employeeID_s}&&customerUserName_s=${customerUserName_s}">首页</a>&nbsp;
				<a href="./searchemployeeInfoAction?flag=page&&currentPage=${currentPage-1<=0?0:currentPage-1}&&employeeID_s=${employeeID_s}&&customerUserName_s=${customerUserName_s}">前一页</a>&nbsp;
				<a href="./searchemployeeInfoAction?flag=page&&currentPage=${currentPage+1>=maxPage?totalPage-1:currentPage+1}&&employeeID_s=${employeeID_s}&&customerUserName_s=${customerUserName_s}">后一页</a>&nbsp;
				<a href="./searchemployeeInfoAction?flag=page&&currentPage=${maxPage-1}&&employeeID_s=${employeeID_s}&&customerUserName_s=${customerUserName_s}">末页</a>&nbsp;&nbsp;
				<form id="changepage" style="display: inline;" action="./searchemployeeInfoAction" method="post">
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