<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>培训规则信息操作页面</title>
    
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
  
  
 <body  style="margin: 0px;padding: 0px;">
  <div id="man_zone" style="height: 520px;">
   <!-- 条件查询div -->
	
		<!-- 根据条件，设置培训规则信息 -->
		<form id="RuleForm" name="RuleForm" action="./modifyTrainruleAction?time=new Date().getTime()" method="post">
			
			
		<table width="90%">
      	<tr>
  			<td class="tor" width="20%">培训失效周期（天）：</td>
  			<td width="70%"> 
				<input type="text" id="day_i" name="day_i" value="${dtrainingrule.day_i }"  onblur="Checkfun.IsInteger(this,'距离上次培训时间(天)')"/>&nbsp;&nbsp;<font color="red">*</font>
  			</td>
  			
  		</tr>
  		
  		<tr>
  			<td colspan="2" align="center">
  				<input type="hidden" id="id" name="id" value="${dtrainingrule.id }"/> 
  				<a id="addrule" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定</a>
  			</td>
  		</tr>
  	</table>
		</form>

	<script type="text/javascript">
		function submitSearchForm(){
			document.getElementById("RuleForm").submit();
		}
		$("#addrule").click(function (){
  			if(!Checkfun.IsInteger($("#day_i"),'培训失效周期（天）',4)){
  				return false;
  			}
  			
  		var str="提交操作？"
  		$.messager.confirm('确定', str, function(r){
  		if (r){	
  			
  			//校验略
  			$.post(
  				"./modifyTrainruleAction",
  				{
  					id:$("#id").val(),
  					day_i:$("#day_i").val(),
  					time:new Date().getTime()
  				},function(){
  					$.messager.alert('Success','驾驶员培训规则操作成功！');
  					window.returnValue="refresh";
  		  			window.close();
  				}
  			);
  			//document.getElementById("barrierForm").submit();
  			
  		}
  		});
  		});
		
	</script>
</div>
  </body>
</html>