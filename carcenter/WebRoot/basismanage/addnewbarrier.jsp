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
    
    <title>道闸信息</title>
    
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
 <div id="man_zone" style="height: 250px;">
 <form id="barrierForm" name="barrierForm" action="./addBarrierAction?time=new Date().getTime()" method="post">
      <table width="90%">
      	<tr>
  			<td class="tor" width="10%">道闸编号:</td>
  			<td width="30%"> 
  				<input type="text" disabled="true" readonly id="newgateNumber" name="newgateNumber"  value="${gateNumber}" readonly/>
  			</td>
  			<td class="tor" width="10%">道闸名称:</td>
  			<td width="30%">
  				<input type="text"  id="gateType"  name="gateType"  value="${barriergate.gateType_s }"   disabled="true" readonly/>
  				<font id="errmsg" color="red">${errmsg }</font>
  				<input type="hidden" id="isUpdate" name="isUpdate" value="${isUpdate}"/>
  				<input type="hidden" id="gateNumber" name="gateNumber" value="${gateNumber}"/>
  			</td>
  		</tr>
  		<tr>
  			<td class="tor" width="10%">道闸所在道路:</td>
  			<td> <select class="easyui-combobox" id="entranceRoadID" name="entranceRoadID">
  					<c:forEach items="${roadforbarrier}" var="roadlist">
  						<option value="${roadlist.roadID_s }" <c:if test="${barriergate.enterroadinfo.roadID_s == roadlist.roadID_s}">  selected="selected" </c:if> >${roadlist.roadName_s }</option>
  					</c:forEach>
  				</select>
  			</td>
  			<td class="tor">状态：</td>
  			<td>
  				 <select class="easyui-combobox" id="status" name="status">
  				 	<option value="1" <c:if test="${barriergate.state_i == '1'}">  selected="selected" </c:if>>启用</option>
  					<option value="0" <c:if test="${barriergate.state_i == '0'}">  selected="selected" </c:if>>故障</option>
  				</select>
  			</td>
  		</tr>
  		<tr>
  			<td class="tor" width="10%">类型:</td>
  			<td> 
  				<select class="easyui-combobox" id="resaveds1_s" name="resaveds1_s">
  				 	<option value="1" <c:if test="${barriergate.resaveds1_s == '1'}">  selected="selected" </c:if>>入口道闸</option>
  					<option value="2" <c:if test="${barriergate.resaveds1_s == '2'}">  selected="selected" </c:if>>出口道闸</option>
  				</select>
  			</td>
  			<td class="tor"></td>
  			<td>
  				 
  			</td>
  		</tr>
  		<!--<tr>
  			<td class="tor">状态：</td>
  			<td>
  				 <select class="easyui-combobox" id="status" name="status">
  				 	<option value="1" <c:if test="${barriergate.state_i == '1'}">  selected="selected" </c:if>>启用</option>
  					<option value="0" <c:if test="${barriergate.state_i == '0'}">  selected="selected" </c:if>>故障</option>
  				</select>
  			</td>
  			<td></td>
  			<td></td>
  			 
  			<td class="tor">出口道路ID:</td>
  			<td> <select id="outRoadID" name="outRoadID">
  					<c:forEach items="${roadforbarrier}" var="roadlist">
  						<option value="${roadlist.roadID_s }">${roadlist.roadName_s }</option>
  					</c:forEach>
  				</select>
  			</td>
  		</tr>
  		<tr>
  			<td class="tor">状态：</td>
  			<td>
  				 <select class="easyui-combobox" id="status" name="status">
  				 	<option value="1" <c:if test="${barriergate.state_i == '1'}">  selected="selected" </c:if>>启用</option>
  					<option value="0" <c:if test="${barriergate.state_i == '0'}">  selected="selected" </c:if>>故障</option>
  				</select>
  			</td>
  			<td></td>
  			<td></td>
  		</tr> -->
		<tr>
			<td></td>
			<td width="30%"> 
				<input type="hidden" id="gateID" name="gateID"  value="${gateID}"/>
				<input type="hidden" id="gatestatue" name="gatestatue"  value=""/>
				<input type="hidden" id="RoadID" name="RoadID"  value=""/>
				<input type="hidden" id="gateresaveds1_s" name="gateresaveds1_s"  value=""/>
			</td>
			<td class="tor" width="10%"></td>
			<td width="30%">
				
			</td>
  		</tr>
  		
  		<tr>
  			<td colspan="4" align="center">
  				<a id="addBarrierBt" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定</a>
  			</td>
  		</tr>
  	</table>
  	</form>
  	<script type="text/javascript">
  		$("#addBarrierBt").click(function (){
  			
  			if($("#newgateNumber").val()==""){
  				$.messager.alert('Error','道闸编号不能为空！');
  				return false;
  			}
  			
  			//var statusi=$("#status").combobox('getValues');
  			//alert(statusi);
  			$("#gatestatue").val($("#status").combobox('getValues'));
  			$("#RoadID").val($("#entranceRoadID").combobox('getValues'));
  			$("#gateresaveds1_s").val($("#resaveds1_s").combobox('getValues'));
  			
  			//alert($("#gatestatue").val());
  			var str="提交操作？";
  				$.messager.confirm('确定', str, function(r){
  				    if (r){
	  			//校验略
	  			$.post(
	  				"./addBarrierAction",
	  				{
	  					gateNumber:$("#gateNumber").val(),
	  					newgateNumber:$("#newgateNumber").val(),
	  					gateType:$("#gateType").val(),
	  					//gateCompany:$("#gateCompany").val(),
	  					entranceRoadID:$("#RoadID").val(),
	  					//outRoadID:$("#outRoadID option:selected").val(),
	  					//status:$("#status").combobox('getValues'),
	  					status:$("#gatestatue").val(),
	  					gateID:$("#gateID").val(),
	  					resaveds1_s:$("#gateresaveds1_s").val(),
	  					time:new Date().getTime()
	  				},function(){	  				
	  					$.messager.alert('Success','道闸信息操作成功！');
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
