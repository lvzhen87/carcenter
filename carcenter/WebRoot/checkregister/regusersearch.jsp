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
    <title>企业信息管理</title>
    <link rel="stylesheet" href="css/common.css" type="text/css" />
    <script type="text/javascript" src="js/script.js"></script> 
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/html5shiv.js"></script>
    <script type="text/javascript" src="js/forms.js"></script>
	
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
    <script type="text/javascript">
    $(document).ready(function(){
		
    });
    	
    </script>
</head>

<body style="padding: 0px;margin: 0px; width: 99%">
<div id="man_zone">
<!-- 条件查询div -->
	<div style="height: 40px;padding: 5px;margin: 0px 5px 0px 10px">
		<!-- 查询 -->
		<form id="registerUserSearchForm" name="registerUserSearchForm" action="registerCustomerSearchAction" method="post">
			<div>
				注册编号：<input type="text" name="customerID" value="${customerID }" />
				公司名称：<input type="text" name="customerName" value="${customerName }"  />
				部门名称：<input type="text" name="departmentName" value="${departmentName }"  />
				<!--  创建人：<input type="text" name="createUserName" value="${createUserName }" />-->
				<img id="registerUserSearchFormBt" onclick="submitSearchForm()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function submitSearchForm(){
			document.getElementById("registerUserSearchForm").submit();
		}
	</script>
	<!--数据区域 -->
  <table id="manageordertab"  border="0" 
	width="95%" style="margin: 0px 0px 0px 10px">
		<tbody>
		<!-- 判断有无记录 -->
		
		<thead>
			<tr style="font-weight: bold;background-color:#E8F0FF">
				<th width="4%">序号</th>
			   <th width="7%" >注册编号</th>
			   <th width="20%" >公司名称</th>
			   <th width="15%" >部门名称</th>
               <th width="5%">联系人</th>
			   <th width="18%" >公司地址</th>
			   <th width="10%">公司电话</th>
               <th width="11%">邮箱</th>
			   <th width="5%">详情</th>
			</tr>
			
		</thead>
		<c:choose>
			<c:when test="${empty customerList}">
				<tr><td colspan="9">查询无结果！请确认查询条件后再次查询！</td></tr>
			</c:when><c:otherwise>		
		<!-- 遍历mapSess中存入的相应数据 -->
        <c:forEach items="${customerList }" var="userlist" varStatus="userStatus">  
			<c:set var="statusIndex" value="${userStatus.index}" />
			<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
			<c:if test="${(statusIndex % 2) == 0}">
				<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
			</c:if>             
        <tr style="${evenOddStyle}">
           <td>${statusIndex+1 }</td>
           <td>${userlist.customerID_s }</td>
           <td>${userlist.customerName_s }</td>
		   <td>${userlist.department_s }</td>
		   <td>${userlist.customerUserName_s }</td>
		   <td>${userlist.customerAddress_s }</td>
		   <td>${userlist.customerUserPhone_s }</td>
		   <td>${userlist.customerUserEmail_s }</td>
			<td>
			<!-- Icons -->
			<a title="修改" onclick="updatecustomer('${userlist.customerID_s}')" >
            <img src="images/icons/icon_edit.png" style="cursor:hand;"  alt="修改" />
           	</a>
            <a id="passimg" class="passcheck" title="查看详情" href="./showCustomerAction?userID=${userlist.customerID_s}" >
            	<img src="images/icons/icon_info.png" style="cursor:hand;" />
            </a>
			</td>
		</tr>
       	</c:forEach>
       		</c:otherwise>
		</c:choose>
		</tbody>					
	</table>
	<script type="text/javascript">
		function updatecustomer(s){
			var winPar=window.showModalDialog("./prepareCustomerAction?customerID="+s,"","dialogWidth=1000px;dialogHeight=600px;status=no;help=no;scroll=no;");
			//window.showModalDialog('WMS_Material.aspx', '', "dialogWidth=310px;dialogHeight=600px;status=no;help=no;scrollbars=no;")
			//alert(winPar);
			if(winPar=="refresh"){
				document.getElementById("registerUserSearchForm").submit();
			}
		}
	
	</script>
	
		<!-- 分页 -->
			<table  style="background-color: #FFF;margin: 0px 0px 0px 10px" id="trans"  border="0" 
			width="95%"  >
				<tr >
					<td width="50%" >
						<div style="display: inline; width: 380px; padding-left: 10px;" >
							共有记录${totalCustomer }条，分${maxPage}页，当前第${currentPage+1}页
						</div>
					</td>
					<td  style="text-align: right;">
						<div style="display: inline;width: 300px;float: right;padding-right: 5px;">
							<a href="./registerCustomerSearchAction?flag=page&&currentPage=0&&customerID=${customerID}&&customerName=${customerName}&&departmentName=${departmentName}&&createUserName=${createUserName}" target="manFrame" >首页</a>&nbsp;
							<a href="./registerCustomerSearchAction?flag=page&&currentPage=${currentPage-1<=0?0:currentPage-1}&&customerID=${customerID}&&customerName=${customerName}&&departmentName=${departmentName}&&createUserName=${createUserName}">前一页</a>&nbsp;
							<a href="./registerCustomerSearchAction?flag=page&&currentPage=${currentPage+1>=maxPage?totalPage-1:currentPage+1}&&customerID=${customerID}&&customerName=${customerName}&&departmentName=${departmentName}&&createUserName=${createUserName}">后一页</a>&nbsp;
							<a href="./registerCustomerSearchAction?flag=page&&currentPage=${maxPage-1}&&customerID=${customerID}&&customerName=${customerName}&&departmentName=${departmentName}&&createUserName=${createUserName}">末页</a>&nbsp;&nbsp;
							<form id="changepage" style="display: inline;" action="./registerCustomerSearchAction" method="post">
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