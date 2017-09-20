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
    
    <title>车辆信息</title>
    
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
		$("#weightchange").hide();
	</script>
  </head>
  
 <body style="margin: 0px;padding: 0px;">
 <div id="man_zone" style="height: 520px;">
  	<table width="90%">
  		<tr>
  			<td class="tor" width="15%">类别：</td>
  			<td width="34%"> 
				<select class="easyui-combobox" id="categoryFace" name="categoryFace" >
					<option value="1" <c:if test="${recvehicle.category_i==1 }"> selected</c:if>>试验车</option>
					<option value="2" <c:if test="${recvehicle.category_i==2 }"> selected</c:if>>通勤车</option>
				</select>
  			</td>
  			<td class="tor" width="15%">类型：</td>
            <td width="25%">
				<select class="easyui-combobox" id="modelFace" name="modelFace">
					<option value="1" <c:if test="${recvehicle.model_s==1 }"> selected</c:if>>小于3.5t</option>
					<option value="2" <c:if test="${recvehicle.model_s==2 }"> selected</c:if>>大于3.5t</option>
				</select>
			</td>
  		</tr>
  		<!-- <tr id="weightchange">
  			<td class="tor" width="15%">车重：</td>
  			<td width="30%">     
  				<a href="javascript:void(0);" title="类型大于3.5t时填写" class="easyui-tooltip">
				<input value="${recvehicle.weight_s }" type="text" name="weight" id="weight" alt="车重大于3.5t时填写" >
				</a>       
 			</td>
  			<td class="tor">轴重：</td>
  			<td > 
  				<a href="javascript:void(0);" title="类型大于3.5t时填写" class="easyui-tooltip">
				<input value="${recvehicle.maxWeight_s }"  type="text" name="maxWeight" id="maxWeight" alt="车重大于3.5t时填写"  >
				</a>
			</td>
  		</tr> -->
  		<tr>
  			<td class="tor">车辆轴数：</td>
  			<td>              	 
				<input type="text" id="axleNumber" name="axleNumber" value="${recvehicle.axleNumber_i}" >&nbsp;&nbsp;<font color="red">*</font>
 			</td>
  			<td class="tor">燃料种类：</td>
  			<td >
				<select class="easyui-combobox" id="fuelDemandFace" name="fuelDemandFace" >
					<option value="1" <c:if test="${recvehicle.fuelConsumption_s==1 }"> selected</c:if> >汽油</option>
					<option value="2" <c:if test="${recvehicle.fuelConsumption_s==2 }"> selected</c:if>>柴油</option>
					<option value="3" <c:if test="${recvehicle.fuelConsumption_s==3 }"> selected</c:if>>充电</option>
					<option value="4" <c:if test="${recvehicle.fuelConsumption_s==4 }"> selected</c:if>>油电混合</option>
					<option value="5" <c:if test="${recvehicle.fuelConsumption_s==5 }"> selected</c:if>>其他</option>
				</select>	
			 </td>
  		</tr>
  		<tr>
  			<td class="tor">颜色：</td>
  			<td> <input type="text" id="color" name="color" value="${recvehicle.color_s }" >	
			</td>
  			<td class="tor">牌照：</td>
  			<td> <input type="text" name="licensPlate"  id="licensPlate" value="${recvehicle.licensPlate_s}"></td>
  		</tr>
  		<tr>
  			<td class="tor">型号：</td>
  			<td > <input type="text" name="brandType" id="brandType" value="${recvehicle.brandType_s }"></td>
  			<td class="tor">极速：</td>
  			<td>            
  			<input type="text" name="maxSpeed" id="maxSpeed" value="${recvehicle.maxSpeed_s }">
			</td>
  		</tr>
  		<tr>
  			<td class="tor">VIN后6位：</td>
  			<td > 
				<input type="text" name="vin" id="vin"  value="${recvehicle.vin_s }" >
			</td>
			<td class="tor">预计消耗：</td>
  			<td > 
				<input type="text" name="fuelConsumption" id="fuelConsumption"  value="${recvehicle.fuelConsumption_s }">
			</td>
  		</tr>
  		<tr>
  			<td colspan="4" align="center">
  			<input id="createDate" name="createDate" value="${recvehicle.createDate_t }" type="hidden"/>
  			<input id="createUser" name="createUser" value="${recvehicle.createUser_s }" type="hidden"/>
  			<input id="vehicleCPG" name="vehicleCPG" value="${recvehicle.vehicleCPG_s }" type="hidden"/>
  				<a id="queryBt" class="easyui-linkbutton" data-options="iconCls:'icon-add'">确定</a>
  			</td>
  		</tr>
  			
  		
  	</table>	
  	<script type="text/javascript">
  	$("#queryBt").click(function (){
			//$("#addcustomeruserform").submit();
  		if($("#modelFace").combobox('getValue')==2){
			if( $("#weight").val().length<1 ){
				$.messager.alert('Error','类型大于3.5t，必须填写车重！');
				return false;
			}
			if( $("#maxWeight").val().length<1 ){
				$.messager.alert('Error','类型大于3.5t，必须填写轴重！');
				return false;
			}
		}
		if($("#axleNumber").val().length<1 || parseInt($("#axleNumber").val() )<1  ){
			$.messager.alert('Error','请填写车轴数！');
			return false;
		}
		
		var str="提交更新操作？"
			$.messager.confirm('确定', str, function(r){
			    if (r){
 				$.post(
 					"./modifyrecvehicleAction",
 	  				{
 						vehicleCPG:$("#vehicleCPG").val(),
 						categoryFace:$("#categoryFace").combobox('getValue'),
 						modelFace:$("#modelFace").combobox('getValue'),
 						weight:$("#weight").val(),
 						maxWeight:$("#maxWeight").val(),
 						axleNumber:$("#axleNumber").val(),
 						fuelDemandFace:$("#fuelDemandFace").combobox('getText'),
 						color:	$("#color").val(),
 						licensPlate:$("#licensPlate").val(),
 						brandType:$("#brandType").val(),
 						maxSpeed:$("#maxSpeed").val(),
 						vin:$("#vin").val(),
 						fuelConsumption:$("#fuelConsumption").val(),
 						createDate:$("#createDate").val(),
 						createUser:$("#createUser").val(),
 	  					time:new Date().getTime()
 	  				},function(){
 	  					$.messager.alert('Success',"操作成功！");
	  					window.returnValue="refresh";
	  		  			window.close();
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
