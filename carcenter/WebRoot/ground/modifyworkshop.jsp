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
    
    <title>更改预定车间信息页面</title>
    
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
		text-align: right;
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
  	<table width="90%">
  		<tr>
  			<td class="tor" width="15%">资源名称:</td>
  			<td width="25%">
  				<c:choose>
  				<c:when test="${empty workshop}">
					<select class="easyui-combobox" id="workShopID" name="workShopID" >
	        			<c:forEach items="${wslist}" var="workshopinfo">
	        				<option value="${workshopinfo.workShopID_s }" >${workshopinfo.workShopName_s }</option>
	        			</c:forEach>
	        		</select>
	        	</c:when><c:otherwise>
	        		<select id="workShopID" name="workShopID" onchange="workshopChange()">
	        				<option value="${workshop.workShopID_s }" >${workshop.workShopName_s }</option>
	        				
	        		</select>
	        	</c:otherwise>
	        	</c:choose>
  			</td>
  			<td class="tor" width="15%">开始日期：</td>
            <td width="34%">            
				<input type="text" class="easyui-datetimebox" id="startdatepicker"   name="startdatepicker"  value="${workshop.startDate_t}" style="width: 200px"/>&nbsp;&nbsp;<font color="red">*</font>
			</td>
  		</tr>
  		<tr>
  			<td class="tor" width="15%">预定时长：</td>
  			<td width="30%">            
				 <input type="text" value="" name="orderDuration" id="orderDuration" style="width: 40px;" onblur="Checkfun.IsInteger(this,'预定时长',20)">
        		 <select class="easyui-combobox" name="dateType" id="dateType" >
        		 	<option value="1" >天</option>
        		 	<option value="2" >月</option>
        		 	<option value="3">半年</option>
        		 	<option value="4">年</option>
        		 </select>&nbsp;&nbsp;<font color="red">*</font>
 			</td>
  			<td class="tor"></td>
  			<td > 
			</td>
  		</tr>
  		
  		<tr>
  			<td colspan="4" align="center">
  			<input id="isupdate" name="isupdate" value="${isupdate }" type="hidden"/>
  			<input id="createDate" name="createDate" value="${workshop.createDate_t }" type="hidden"/>
  			<input id="createUser" name="createUser" value="${workshop.createUser_s }" type="hidden"/>
  			<input id="wid" name="wid" value="" type="hidden"/><input id="wname" name="wname" value="" type="hidden"/>
  			<input id="dtype" name="dtype" value="" type="hidden"/>
  			<input id="orderWorkShopID_s" name="orderWorkShopID_s" value="${workshop.orderWorkShopID_s }" type="hidden"/>
        		<a id="queryBt" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定</a>
  			</td>
  		</tr>
  			
  		
  	</table>
  	<!-- 车间选择 更换后，展示该车间的 介绍 -->				
				<div id="workshopDescription" style="width: 980px;">
<table id="dg" width="90%"></table>
				</div>	
  	<script type="text/javascript">
  	
  	
  	$("#queryBt").click(function (){
  		if($("#startdatepicker").datebox("getValue")==null || $("#startdatepicker").datebox("getValue").length<2){
  				$.messager.alert("Error","开始日期不能为空！请填写！");
				return false;
			}
  		if(!Checkfun.IsInteger($("#orderDuration"),'预定时长',20)){
  			return false;
  		}
  		$("#dtype").val($("#dateType").combobox('getValues'));
  		$("#wid").val($("#workShopID").combobox('getValues'));
  		$("#wname").val($("#workShopID").combobox('getText'));
  		var str="提交更新操作？"
			$.messager.confirm('确定', str, function(r){
			    if (r){
 				$.post(
 					"./modifyworkshopAction",
 	  				{
 						orderWorkShopID_s:$("#orderWorkShopID_s").val(),
 						workshopID:$("#wid").val(),
 						workshopName:$("#wname").val(),
 						orderDuration:$("#orderDuration").val(),
 						dateType:$("#dtype").val(),
 						startdate:$("#startdatepicker").datebox("getValue"),
 						createDate:$("#createDate").val(),
 						createUser:$("#createUser").val(),
 	  					time:new Date().getTime()
 	  				},function(msg){
  	  					//alert(msg);
  	  					//alert(msg.substr(0,4));
  	  					if(msg.substr(0,4)=="操作成功"){
  	  						window.returnValue="refresh";
  	    		  			window.close();
  	  					}
  					
 	  				}
 			);
		}
			
		});
  		
  	});
  
  	
  	</script>
  	
  	</form>
  </div>
  </body>
</html>
