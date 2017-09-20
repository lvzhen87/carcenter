<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>对讲机回收页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/common.css" type="text/css" />
    <script src="js/script.js"></script> 
    <script src="js/query-1.9.1.js"></script>
    <script src="js/html5shiv.js"></script>
    <script src="forms.js"></script>
	
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
.currentFont{
	font-size: 14px;
	font-weight: bold;
}
.h3bg{
	background-color: #E8E8FF;
	margin: 0px;
	padding: 2px;
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
  
  <body style="margin: 0px;padding: 0px; width: 99%;height: 400px">
  <div style="height: 30px;padding-left: 10px;">
  	<h3 style="padding: 0px;margin: 0px;">
  		&gt;&gt;<a href="./recExperiencephoneAction" >对讲机发放</a> &nbsp;&nbsp;&nbsp;
  		&gt;&gt;<a href="./process/callbackinterphone.jsp" class="currentFont">对讲机回收</a>&nbsp;&nbsp;&nbsp;
  	</h3> 
  </div>
 
   <!-- 条件查询div -->
<div id="man_zone" style="height: 515px;width: 100%;">
<div style="padding: 5px;margin: 0px 5px 0px 10px">
	<h3 class="h3bg" style="margin: 0px 5px 0px 10px;">对讲机回收：</h3>
	<div style="margin: 5px 5px 0px 10px;">
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						对讲机编号：<input type="text" id="interphoneID_s" name="interphoneID_s" value="${interphoneID_s }" style="width: 200px;" onblur="Checkfun.isNull(this,'对讲机编号')"/>&nbsp;&nbsp;<font color="red">*</font>
					</td>
					<td>
						人卡编号：<input type="text" name="card" id="card" style="width:200px" onblur="" onclick="readCardInfo(this)" value="${ulist.card_s}"  />&nbsp;&nbsp;<font color="red">*</font>
					</td>
					<td>
						<a id="addBarrierBt" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定回收</a>
					</td>
				</tr>
			</table>
	</div>
	<object  classid="clsid:0b6ed426-9e67-4cf3-99da-8a346a98e5c6" codebase="Setup1.msi"
			width="0" height="0" id="helloBossma">
	</object>
	
		
	<script type="text/javascript">
		$("#addBarrierBt").click(function (){
			var str="确定回收该对讲机？";
			if(!Checkfun.isNull($("#interphoneID_s"),'对讲机编号',80)){
				return false;
			}
			if(!Checkfun.isNull($("#card"),'人卡编号',80)){
				return false;
			}
			$.messager.confirm('确定', str, function(r){
			 if (r){
  			//校验略
  			$.post(
  				"./callbackinterphoneAction",
  				{
  					interphoneID_s:$("#interphoneID_s").val(),
  					card:$("card").val(),
  					time:new Date().getTime()
  				},function(){
  					$.messager.alert('Success','操作成功！');
  				}
  			);
			//document.getElementById("barrierForm").submit();
			}
		});
		})
		
		
		
	</script>
	

	
	
	</div>
			
	</div>	
	
  </body>
</html>
