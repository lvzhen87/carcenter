<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>禁用时间段信息操作页面</title>
    
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
 <form id="timeruleForm" name="timeruleForm" action="./addTimeruleAction?time=new Date().getTime()" method="post">
      <table width="90%">
      	<tr>
  			<td class="tor" width="20%">禁用时间段:</td>
  			<td width="80%"> 
  				<select id="timerule" name="timerule" class="easyui-combobox">
  					<option value="1">0:00~1:00</option>
  					<option value="2">1:00~2:00</option>
  					<option value="3">2:00~3:00</option>
  					<option value="4">3:00~4:00</option>
  					<option value="5">4:00~5:00</option>
  					<option value="6">5:00~6:00</option>
  					<option value="7">6:00~7:00</option>
  					<option value="8">7:00~8:00</option>
  					<option value="9">8:00~9:00</option>
  					<option value="10">9:00~10:00</option>
  					<option value="11">10:00~11:00</option>
  					<option value="12">11:00~12:00</option>
  					<option value="13">12:00~13:00</option>
  					<option value="14">13:00~14:00</option>
  					<option value="15">14:00~15:00</option>
  					<option value="16">15:00~16:00</option>
  					<option value="17">16:00~17:00</option>
  					<option value="18">17:00~18:00</option>
  					<option value="19">18:00~19:00</option>
  					<option value="20">19:00~20:00</option>
  					<option value="21">20:00~21:00</option>
  					<option value="22">21:00~22:00</option>
  					<option value="23">22:00~23:00</option>
  					<option value="24">23:00~24:00</option>
  					
  				</select>
  				<!--  <input id="starttime" class="easyui-timespinner" style="width:200px;">~<input id="endtime" class="easyui-timespinner" style="width:200px;">-->
  			</td>
  			
  		</tr>
  		
  		<tr>
  			<td colspan="4" align="center">
  				<input type="hidden" id="rule" name="rule" value="">
  				<a id="addTimerule" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定</a>
  			</td>
  		</tr>
  	</table>
  	</form>
  	<script type="text/javascript">
  		$("#addTimerule").click(function (){
  			$("#rule").val($("#timerule").combobox('getValues'));
  		var str="提交操作？"
  		$.messager.confirm('确定', str, function(r){
  		if (r){	
  			
  			//校验略
  			$.post(
  				"./addTimeruleAction",
  				{
  					timeQuantum_s:$("#rule").val(),
  					time:new Date().getTime()
  				},function(){
  					$.messager.alert('Success','禁用时间段信息操作成功！');
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
