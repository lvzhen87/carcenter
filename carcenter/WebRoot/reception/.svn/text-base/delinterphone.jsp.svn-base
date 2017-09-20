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
    
    <title>添加收费信息</title>
    
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
	function readCardInfo(box) {
         //alert("111111");
         var demo = document.getElementById("helloBossma");
         //alert(demo);
         var result = demo.GetCardNum();
         //alert(result+"demo");
         //document.getElementById("vehicleCardID").value=result;
         box.value=result;
         if (result == "0") {
             //alert("read card successful!");
         } else {
             //alert("CMCC_ReadTicketInfo failed");
         }
         //document.getElementById("vehicleCardID").value = result;
     }
	</script>
  </head>
  
 <body style="margin: 0px;padding: 0px; width: 1100px">
 <div id="man_zone" style="height: 520px; width: 1080px;">
<center>
  	<table width="60%">
  		
		<tr>
			<td>
			  	退订人员卡号：<input type="text" name="card" id="card"  value="" onclick="readCardInfo(this)" />
			</td>
		</tr>
  	</table>
  	<object  classid="clsid:0b6ed426-9e67-4cf3-99da-8a346a98e5c6" codebase="Setup1.msi"
			width="0" height="0" id="helloBossma">
	</object>
  
  		<input type="hidden" id="interphoneID_s" name="interphoneID_s" value="${interphoneID_s}"/>
  		<a id="addBt" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定</a>
  	</center>
  	<script type="text/javascript">
  		$("#addBt").click(function (){
  		
  		//校验略
  		if(!Checkfun.isNull($("#card"),'人卡',80)){
  			return false;
  		}	
  			
  		//校验略
  		var str="提交操作？"
  		$.messager.confirm('确定', str, function(r){
  			if (r){
  			$.post(
  				"./callbackinterphoneAction",
  				{
  					card:$("#card").val(),
  					interphoneID_s:$("#interphoneID_s").val(),
  					time:new Date().getTime()
  				},function(){
  					$.messager.alert('Success',"退订操作成功！");
  					window.returnValue="refresh";
  		  			window.close();
  				}
  			);
  			
  			}
  		});
  			//document.getElementById("addroadinfoform").submit();
  	  	  	//window.returnValue="refresh";
	  	   // window.close();
  			
  		});
  	</script>
 
  </div>
  </body>
</html>