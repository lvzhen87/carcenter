<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>精确预订规则操作页面</title>
    
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
 <form id="timeruleForm" name="timeruleForm" action="./addruleAction?time=new Date().getTime()" method="post">
      <table width="90%">
      	<tr>
  			<td class="tor" width="20%">能预订几天内精确道路:</td>
  			<td width="70%"> 
  				 <input type="text" name="dayNumber_i"  id="dayNumber_i" value="${prerule.dayNumber_i }" onblur="Checkfun.IsInteger(this,'能预订几天内精确道路',20)"  >&nbsp;&nbsp;<font color="red">*</font>
  			</td>
  			
  		</tr>
  		
  		<tr>
  			<td colspan="2" align="center">
  				<input type="hidden" id="eventNumber_s" name="eventNumber_s" value="${prerule.eventNumber_s }"/> 
  				<a id="addrule" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定</a>
  			</td>
  		</tr>
  	</table>
  	</form>
  	<script type="text/javascript">
  		$("#addrule").click(function (){
  			if(!Checkfun.IsInteger($("#dayNumber_i"),'能预订几天内精确道路',20)){
  				return false;
  			}
  			
  		var str="提交操作？"
  		$.messager.confirm('确定', str, function(r){
  		if (r){	
  			
  			//校验略
  			$.post(
  				"./addruleAction",
  				{
  					eventNumber_s:$("#eventNumber_s").val(),
  					dayNumber_i:$("#dayNumber_i").val(),
  					time:new Date().getTime()
  				},function(){
  					$.messager.alert('Success','精确预订规则操作成功！');
  					window.returnValue="refresh";
  		  			window.close();
  				}
  			);
  			//document.getElementById("barrierForm").submit();
  			
  		}
  		});
  		});
  	</script>
  	</form>
  </div>
  </body>
</html>
