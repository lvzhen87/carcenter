<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>手工添加进出道闸记录</title>
    
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
  	<form action="./addDriverInfoAction" method="post" id="adddriverform" >
  	<table width="90%">
  		<tr>
  			<td class="tor" width="10%">道路：</td>
  			<td width="30%"> 
  				<select class="easyui-combobox" id="roadID_s" name="roadID_s">
  					<c:forEach items="${roadforbarrier}" var="roadlist">
  						<option value="${roadlist.roadID_s }" <c:if test="${model.roadID_s == roadlist.roadID_s}">  selected="selected" </c:if> >${roadlist.roadName_s }</option>
  					</c:forEach>
  				</select>
  			</td>
  			<td class="tor" width="10%">状态：</td>
  			<td width="30%"> 
  				<select class="easyui-combobox" id="motion_s" name="motion_s">
  				 	<option value="1" <c:if test="${model.motion_s == '1'}">  selected="selected" </c:if>>进</option>
  					<option value="2" <c:if test="${model.motion_s == ''}">  selected="selected" </c:if>>出</option>
  				</select>
  			</td>
  		</tr>
  		<tr>
  			<td class="tor">发生时间：</td>
  			<td><input type="text" class="easyui-datetimebox" style="width:220px;height: 22px;" id="createTime_s"  value="${model.createTime_s }" > 
  		
  			<td class="tor">CPG牌照：</td>
  			<td >  
  				<select class="easyui-combobox" id="cpg_s" name="cpg_s">
  					<c:forEach items="${cpglist}" var="cpg">
  						<option value="${cpg.resaveds2_s}" <c:if test="${model.resaveds3_s == cpg.resaveds2_s}">  selected="selected" </c:if> >${cpg.resaveds2_s}</option>
  					</c:forEach>
  				</select>
  			</td>
  		</tr>  		 
  		<tr>
  			<td colspan="4" align="center"">
  				<input type="hidden" id="motions" name="motions"  />
  				<input type="hidden" id="roadIDs" name="roadIDs"  />
  				<input type="hidden" id="cpgs" name="cpgs"  />
  				<a id="addDriverBt" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定</a>
  			</td>
  		</tr>
  	</table>
  	<script type="text/javascript">
  		$("#addDriverBt").click(function (){
  			 
  			//校验略
  			 $("#roadIDs").val($("#roadID_s").combobox('getValues'));
  			 $("#motions").val($("#motion_s").combobox('getValues'));
  			 $("#cpgs").val($("#cpg_s").combobox('getValues'));
   			//$("#adddriverform").submit();
  			$.post(
  				"./addInorOutBarrierGateAction",
  				{
  					roadID_s:$("#roadIDs").val(),
  					motion_s:$("#motions").val(),
  					createTime_s:$("#createTime_s").datebox("getValue"),
  					cpg_s:$("#cpgs").val()
  				},function(){
  				
  					window.returnValue="refresh";
  					window.close();
  				}
  			);
  		});
  	</script>
  	</form>
  </div>
  </body>
</html>
