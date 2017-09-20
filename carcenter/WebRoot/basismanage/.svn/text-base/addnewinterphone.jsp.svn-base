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
    
    <title>对讲机添加/修改页面</title>
    
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
      <form id="addbarrierform" method="post" action="./addinterphoneAction?time=new Date().getTime()" enctype="multipart/form-data" >
  	<table width="90%">
  		<tr>
  			<td class="tor" width="10%">对讲机编号</td>
  			<td width="30%">
  				<c:if test="${empty interphoneID}">
  				 <input type="text" id="interphoneID" name="interphoneID" value="${interphoneID}" /> 
  				</c:if>
  				<c:if test="${interphoneID != null}">
  				 <input type="text" id="interphoneID" name="interphoneID" value="${interphoneID}"  disabled="disabled" readonly="readonly"/> 
  				</c:if>
  			</td>
  			<td class="tor" width="10%">对讲机型号:</td>
  			<td width="30%"> 
  				<input type="text" id="interphonePast" name="interphonePast" value="${interphone.interphonePast_s }" onblur="Checkfun.isNull(this,'对讲机型号',80)"/>&nbsp;&nbsp;<font color="red">*</font>
  			</td>
  			
  		</tr>
  		<tr>
  		<td class="tor" width="10%">对讲机品牌:</td>
  			<td width="30%"> <input type="text" id="brand" name="brand" value="${interphone.brand_s }" onblur="Checkfun.isNull(this,'对讲机品牌',80)"/> </td>
  			<td class="tor" width="10%">对讲机状态:</td>
  			<td width="30%"> 
  				<select id="state" name="state" class="easyui-combobox">
  					<option value="2" <c:if test="${interphone.state_i == '2'}">  selected="selected" </c:if> >闲置</option>
  					<option value="0" <c:if test="${interphone.state_i == '0'}">  selected="selected" </c:if> >故障</option>
  					<option value="1" <c:if test="${interphone.state_i == '1'}">  selected="selected" </c:if> >使用中</option>
  					<option value="1" <c:if test="${interphone.state_i == '3'}">  selected="selected" </c:if> >停用</option>
  				</select>
  			</td>
  			
  		</tr>
  		<tr>
  			<td colspan="4" align="center">
  				<input type="hidden" id="state" name="state" value=""/>
  				<a id="addInterphoneBt" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定</a>
  			</td>
  		</tr>
  	</table>
  	</form>
  	
  	<script type="text/javascript">
  		$("#addInterphoneBt").click(function (){
  			if(!Checkfun.isNull($("#interphonePast"),'对讲机型号',80)){
  				return false;
  			}
  			
  			$("#state").val($("#state").combobox('getValues'));
  			
  			var str="提交操作？"
  			$.messager.confirm('确定', str, function(r){  			 
  			 if (r){
	  			//校验略
	  			$.post(
	  				"./addinterphoneAction",
	  				{
	  					interphoneID:$("#interphoneID").val(),
	  					interphonePast:$("#interphonePast").val(),
	  					brand:$("#brand").val(),
	  					state:$("#state").val(),
	  					time:new Date().getTime()
	  				},function(){
	  					$.messager.alert('Success','对讲机信息操作成功！');
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
