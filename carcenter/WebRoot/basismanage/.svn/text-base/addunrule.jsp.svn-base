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
    
    <title>退订规则操作页面</title>
    
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

  </head>
  
 <body style="margin: 0px;padding: 0px;">
 <div id="man_zone" style="height: 520px;">
      <form id="addruleform" method="post" action="./addUnruleAction?time=new Date().getTime()" enctype="multipart/form-data" >
  	<table width="90%">
  		<tr>
  			<td class="tor" width="10%">大于（小时）:</td>
  			<td width="30%"> 
  				<input type="text" id="greaterHourNumber_i" name="greaterHourNumber_i" value="${unrule.greaterHourNumber_i }" onblur="Checkfun.IsInteger(this,'小时',20)"/>
  			</td>
  			<td class="tor" width="10%">小于（小时）:</td>
  			<td width="30%"> 
  				<input type="text" id="lessHourNumber_i" name="lessHourNumber_i" value="${unrule.lessHourNumber_i }" onblur="Checkfun.IsInteger(this,'小时',20)"/>
  			 </td>
  		</tr>
  		<tr>
  			<td class="tor" width="10%">违约比例(%)：</td>
  			<td width="30%"> <input type="text" id="breakPromiseDeduction_i" name="breakPromiseDeduction_i" value="${unrule.breakPromiseDeduction_i}" /> </td>
  			<td class="tor" width="10%">是否生效：</td>
  			<td width="30%"> 
  				<select id="isEffect" name="isEffect" class="easyui-combobox">
  					<option value="1" <c:if test="${isEffect == '1'}">  selected="selected" </c:if>>生效</option>
  					<option value="0" <c:if test="${isEffect == '0'}">  selected="selected" </c:if>>无效</option>
  				</select>
  			</td>
  			
  		</tr>
  		<tr>
  			<td colspan="4" align="center">
  				<input type="hidden" id="eventNumber_s" name="eventNumber_s" value="${unrule.eventNumber_s}" />
  				<input type="hidden" id="effect" name="effect" value="" />
  				<a id="addInterphoneBt" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定</a>
  			</td>
  		</tr>
  	</table>
  	</form>
  	
  	<script type="text/javascript">
  		$("#addInterphoneBt").click(function (){
  		$("#effect").val($("#isEffect").combobox('getValues'));
  		var str="提交操作？"
  		$.messager.confirm('确定', str, function(r){
  		if (r){
  			//校验略
  			$.post(
  				"./addUnruleAction",
  				{
  					eventNumber_s:$("#eventNumber_s").val(),
  					greaterHourNumber_i:$("#greaterHourNumber_i").val(),
  					lessHourNumber_i:$("#lessHourNumber_i").val(),
  					breakPromiseDeduction_i:$("#breakPromiseDeduction_i").val(),
  					isEffect:$("#effect").val(),
  					time:new Date().getTime()
  				},function(){
  					$.messager.alert('Success','规则信息操作成功！');
  					window.returnValue="refresh";
  		  	  	    window.close();
  				}
  				
  			);
  			//document.getElementById("addbarrierform").submit();
  		}
  		});
  			
  		});
  	</script>
  	</form>
  </div>
  </body>
</html>
