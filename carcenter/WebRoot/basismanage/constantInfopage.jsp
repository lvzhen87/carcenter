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
    <title>常量信息管理</title>
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
		<form id="registerUserSearchForm" name="registerUserSearchForm" action="ConstantInfoAction" method="post">
			<div>
				常量名称：<input type="text" name="constantName_s" value="${constantName_s }" />				
				常量描述：<input type="text" name="constantDescribe_s" value="${constantDescribe_s }"  />
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
			   <th width="7%" >常量名称</th>
			   <th width="20%" >常量值</th>
			   <th width="15%" >常量描述 </th>               
			   <th width="5%">操作</th>
			</tr>
			
		</thead>
		<c:choose>
			<c:when test="${empty ConstantInfoList}">
				<tr><td colspan="9">查询无结果！请确认查询条件后再次查询！</td></tr>
			</c:when><c:otherwise>		
		<!-- 遍历mapSess中存入的相应数据 -->
        <c:forEach items="${ConstantInfoList }" var="userlist" varStatus="userStatus">  
			<c:set var="statusIndex" value="${userStatus.index}" />
			<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
			<c:if test="${(statusIndex % 2) == 0}">
				<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
			</c:if>             
        <tr style="${evenOddStyle}">
           <td>${statusIndex+1 }</td>
           <td>${userlist.constantName_s}</td>
           <td>${userlist.constantValues_s }</td>
		   <td>${userlist.constantDescribe_s}</td>
		   
			<td>
			<!-- Icons -->
			<a title="修改" onclick="updatecustomer('${userlist.constantID_s}')" >
            <img src="images/icons/icon_edit.png" style="cursor:hand;"  alt="修改" />
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
			var winPar=window.showModalDialog("./prepareConstantAction?constantID_s="+s,"","dialogWidth=1000px;dialogHeight=600px;status=no;help=no;scroll=no;");
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