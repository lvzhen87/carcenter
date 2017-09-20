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
    
    <title>设施设置操作页面</title>
    
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
	.tor{
		text-align: right;;
	}
	tr{
		height: 30px;
	}
	input{
		width: 300px;
		border:1px solid #36D;
		height: 25px;
	}
	</style>
<script type="text/javascript">
function myformatter(date) {
var y = date.getFullYear();
var m = date.getMonth() + 1;
var d = date.getDate();
return y + '-' + (m < 10 ? ('0' + m) : m) + '-'
+ (d < 10 ? ('0' + d) : d);
}
function myparser(s) {
if (!s)
return new Date();
var ss = (s.split('-'));
var y = parseInt(ss[0], 10);
var m = parseInt(ss[1], 10);
var d = parseInt(ss[2], 10);
if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
return new Date(y, m - 1, d);
} else {
return new Date();
}
}
</script>
  </head>
  
 <body style="margin: 0px;padding: 0px;">
 <div id="man_zone" style="height: 520px;">
 <form id="stateForm" name="stateForm" action="./UpdatestateAction?time=new Date().getTime()" method="post">
      <table width="90%">
  		<tr>
  			<td class="tor" width="10%">设施编号:</td>
  			<td width="30%"> 
  				<select id="roadID" name="roadID" class="easyui-combobox">
  					<c:forEach items="${roadlist}" var="roadlist">
  						<option value="${roadlist.roadID_s }">${roadlist.roadName_s}</option>
  					</c:forEach>
  				</select>
  				
  			</td>
  			<td class="tor" width="10%">状态:</td>
  			<td width="30%"> <input type="text" id="state_s" name="state_s" value="${facilityState.state_s }" onblur="Checkfun.isNull(this,'状态')"/> </td>
  		</tr>
  		<tr>
  			<td class="tor">特殊信息:</td>
  			<td> 
  				<input type="text" id="specialInfo_s" name="specialInfo_s"  value="${facilityState.specialInfo_s }" onblur="Checkfun.isNull(this,'特殊信息')"/>
  			</td>
  			<td class="tor">指定日期：</td>
  			<td>
  				 <input type="text" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser"  onblur="Checkfun.isNull(this,'指定日期')" id="appointDate_d" name="appointDate_d"  value="${appointDate_d }"/>
  			</td>
  		</tr>
  		<tr>
  			<td class="tor" width="10%"></td>
  			<td width="30%"> 
  				<input type="hidden" id="serialNumber_s" name="serialNumber_s"  value="${facilityState.serialNumber_s}"/>
  			</td>
  			<td class="tor" width="10%"></td>
  			<td width="30%"></td>
  		</tr>
  		
  		<tr>
  			<td colspan="4" align="center"">
  				<a id="addBarrierBt" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定</a>
  			</td>
  		</tr>
  	</table>
  	</form>
  	<script type="text/javascript">
  		$("#addBarrierBt").click(function (){
  			
  			//校验略
  			
  			document.getElementById("stateForm").submit();
  			window.returnValue="refresh";
  	  	    window.close();
  		});
  	</script>
  	</form>
  </div>
  </body>
</html>
