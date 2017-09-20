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
<script type="text/javascript" src="js/verify.js" ></script>
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
var jsonlist;
var i=0;
$(document).ready(function(){
	$.post(
				"./roadNameToJson",
				{
					time:new Date().getTime()
				},function(data,status){
					//alert("Data: " + data + "\nStatus: " + status);
					jsonlist=data;
					//alert(jsonlist);
				}
			);
			
});
	function readCardInfo(box) {
         //alert("111111");
         var demo = document.getElementById("helloBossma");
         //alert(demo);
         var result = demo.GetInterfacceSafyOptions();
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
  <body style="margin: 0px;padding: 0px;width: 99%;">
  
  <div id="man_zone" style="height: 545px;width: 100%;">
  	<!-- 添加车信息 -->
  	<div style="padding: 2px;">
	  	<form action="./recordStaticOvehicleAction" method="post" id="addVehicleForm" name="addVehicleForm" style="margin-top: 0px;">
	  		<h3 class="h3bg" style="margin: 0px 5px 0px 5px;">试验申请车辆：</h3>
	  		<div style="margin: 5px 5px 0px 5px;" id="div1">
	  		<c:choose>
	  			<c:when test="${empty recVehicleInfo}">
	  				<p>暂无车辆数据！</p>
	  			</c:when><c:otherwise>
	  				<c:forEach items="${recVehicleInfo}" var="vlist" varStatus="status">
			  			车辆型号：<input type="text" name="model" id="model" value="${vlist.model_s}"  onblur="Checkfun.isNull(this,'车辆型号',80)" /><font color="red">*</font>
				  		车轴数：<input type="text" name="axleNumber" id="axleNumber" value="${vlist.axleNumber_i }"   onblur="Checkfun.IsInteger(this,'车轴数',20)"/><font color="red">*</font>
				  		<!--  车辆颜色：<input type="text" name="color" id="color" value="${vlist.color_s }"  onblur="Checkfun.isNull(this,'车辆颜色')" />
				  		CPG牌号：<input type="text" name="vehicleCPG" id="vehicleCPG" value="${vlist.vehicleCPG_s }"  onblur="Checkfun.isNull(this,'CPG牌号',80)" readonly="readonly"/>-->
				  		<input type="hidden" name="vehicleCPG" id="vehicleCPG" value="${vlist.vehicleCPG_s }"  />
				  		车卡：<input type="text" name="vehicleCardID" id="vehicleCardID" onclick="readCardInfo(this)" value="${vlist.vehicleID_s}"  /><font color="red">*</font>
				  		授权路面：<input class="easyui-combobox" id="authorizeRoadsFace${status.index}" style="width: 200px;"	data-options="
				  			url:'roadNameToJson?time='+new Date().getTime() + '&vehicleID_s=' + '${vlist.vehicleID_s}' + '&orderID_s=' + '${vlist.orderID_s}'+ '&cpg=' + '${vlist.resaveds2_s}',
							method:'get',
							valueField:'id',
							textField:'text',
							multiple:true,
							separator:'-'
					"><font color="red">*</font>
					失效时间：<input id="invalidate" name="invalidate" value="${vlist.resaveds1_s}"  type="text" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser"  style="width:120px"/><font color="red">*</font>
				  		<br/>
			  		</c:forEach>
			  	
	  			</c:otherwise>
	  		</c:choose>
	  		</div>
	  		<center>
			  			<input type="hidden" name="roadNum" id="roadNum" value="${fn:length(recVehicleInfo) }" /> 
			  			<input type="hidden" name="authorizeRoads" id="authorizeRoads" /> 
			  			
				  		<a href="#" onclick="return false" style="vertical-align: middle;margin-top: 10px" id="addVehicleFormBt" class="easyui-linkbutton">
				  			<label onclick="submitAddVehicleFrom()">确定发卡</label>
				  		</a>
			</center>
	 </form>
	 <object  classid="clsid:0b6ed426-9e67-4cf3-99da-8a346a98e5c6" codebase="Setup1.msi"
  			width="0" height="0" id="helloBossma">
	</object>
	 <h3 class="h3bg" style="margin: 0px 5px 0px 5px;">临时车辆添加：</h3>
	 <div style="margin: 0px 5px 0px 5px;" >
	  		车辆型号：<input type="text" name="model2" id="model2" value=""   onblur="Checkfun.isNull(this,'车辆型号',80)"/><font color="red">*</font>
	  		车轴数：<input type="text" name="axleNumber2" id="axleNumber2" value=""   onblur="Checkfun.IsInteger(this,'车轴数',20)"/><font color="red">*</font>
	  		车辆颜色：<input type="text" name="color2" id="color2" value=""   onblur="Checkfun.isNull(this,'车辆颜色',80)"/><font color="red">*</font>
			失效时间：<input id="invalidate2" name="invalidate2" value=""  type="text" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser" style="width:120px"/><font color="red">*</font>
	  		<a href="#" onclick="return false" style="vertical-align: middle;" id="addVehicleFormBt" class="easyui-linkbutton">
	  			<label onclick="submitExAddVehicleFrom()">添加</label>
	  		</a>
	 </div>
<script type="text/javascript">
		function checkNull(box){
			//alert(box);
			$(box).css("border","solid 1px #3366DD");
			if( $(box).val()==null || $(box).val().length<1 ){
				$(box).css("border","solid 1px #F71717");
				$.messager.alert('Error','请确认内容是否输入？');
				$(box).focus();
				return false;
			}
		}
	
		function submitAddVehicleFrom(){
			if($("#model").val().length<1){
				$.messager.alert('Error','请输入车辆型号!','info');
				return false;				
			}
			if($("#axleNumber").val().length<1){
				$.messager.alert('Error','请输入车轴数!','info');
				return false;				
			}
			if($("#vehicleCardID").val().length<1){
				$.messager.alert('Error','请输入车卡!','info');
				return false;
			}
			
			
			//alert( $("#authorizeRoadsFace0").combobox('getText') );
			//alert( $("#authorizeRoadsFace1").combobox('getText') );
			//alert( $("#authorizeRoadsFace2").combobox('getText') );
			//alert( $("#authorizeRoadsFace3").combobox('getText') );
			var roadNames="";
			var j=0;
			var max=parseInt($("#roadNum").val());
			var facenum=max+i;
			//if(max == 0){
			//	facenum ++;
			//}
			 
			for(j=0;j<facenum;j++){
				//alert("授权路面："+$("#authorizeRoadsFace"+j).combobox('getText'));
				if($("#authorizeRoadsFace"+j).combobox('getText')== ""){
					$.messager.alert('Error','请授权路面!','info');
					return false;
				}
				roadNames+=$("#authorizeRoadsFace"+j).combobox('getText')+",";
			}
			//alert("组装后 "+roadNames);
			$("#authorizeRoads").val(roadNames);
			 
			$("#addVehicleForm").submit();
			$.messager.alert('Success',"车卡发放成功！");
			
		}
		
		
		
		function submitExAddVehicleFrom(){
			if($("#model2").val().length<1){
				$.messager.alert('Error','请输入车辆型号!','info');
				return false;				
			}
			if($("#axleNumber2").val().length<1){
				$.messager.alert('Error','请输入车轴数!','info');
				return false;				
			}
			if($("#invalidate2").datebox("getValue").length <1){
				$.messager.alert('Error','请选择失效日期!','info');
				return false;	
			}
			
				var num=parseInt($("#roadNum").val());
				//alert(num);
				var text1="车辆型号：<input type='text' name='model' id='model' value='"+$("#model2").val()+"'  onblur='Checkfun.isNull(this,'车辆型号',80)'/><font color='red'>*</font>";
				var text2="车轴数：<input type='text' name='axleNumber' id='axleNumber' value='"+$("#axleNumber2").val()+"'   onblur='Checkfun.IsInteger(this,'车轴数',20)'/><font color='red'>*</font>";
				var text3="车卡：<input type='text' name='vehicleCardID' id='vehicleCardID' onclick='readCardInfo(this)' value='${vlist.vehicleID_s}'  /><font color='red'>*</font>"
				var text4="授权路面：<input class='easyui-combobox' 	id='authorizeRoadsFace"+(num+i)+"' style='width: 150px;'	style='width: 200px;'/><font color='red'>*</font>";
				var text5="失效时间：<input id='invalidate' name='invalidate' value='"+$("#invalidate2").datebox("getValue")+"'  type='text' class='easyui-datebox' data-options='formatter:myformatter,parser:myparser' style='width:120px'/><font color='red'>*</font>";
				var text9="	<br/>";
				//$("#resaveds1").addClass("easyui-combobox");
				 //= $("<input id=\"invalidate\" name=\"invalidate\"  value=\"ghjgkh\"  type=\"text\" class=\"easyui-datebox\" data-options=\"formatter:myformatter,parser:myparser\" style=\"width:120px\"/>").appendTo("#liid");
				
				
				var Obj = eval("(" + jsonlist + ")");
				var targetObj = $("#div1").append(text1,text2,text3,text4,text5,text9);
				$.parser.parse(targetObj);
				//alert(jsonlist);
				$("#authorizeRoadsFace"+(num+i)).combobox({ 
					data:Obj,
					valueField:'id',
					textField:'text',
					multiple:true,
					separator:'-'
				}); 
				//alert(boxs[i]);
				
			
		i++;
		$.messager.alert("Success","临时车辆添加成功！");
		}
</script>
  	</div>
  	 <h3 class="h3bg" style="margin: 0px 5px 0px 5px;">订单【${orderId}】已发卡试验车列表：</h3>
  	<!-- 车信息 呈现区域 -->
  	<div style="margin: 0px 5px 0px 5px;">
  		<table style="width: 99%;"  id="manageordertab" >
  			<tr style="font-weight: bold;">
  				<td width="4%">序号</td>
  				<td width="10%">车辆型号</td>
  				<!--  <td width="10%">车辆颜色</td>-->
  				<td width="20%">CPG牌照</td>
  				<td width="20%">车卡编号</td>
  				<td width="30%">授权路面</td>
  				<td width="6%">操作</td>
  			</tr>
  			<c:choose>
			<c:when test="${empty recVehicleInfo}">
			<tr>
				<td colspan="7">查无记录！</td>
			</tr>	
			</c:when><c:otherwise>
  			<c:forEach items="${recVehicleInfo}" var="vehiclelist" varStatus="vehicleStatus">
  				<c:set var="statusIndex" value="${vehicleStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
				<tr style="${evenOddStyle}">
					<td>${statusIndex+1 }</td>
					<td>${vehiclelist.model_s}</td>
					<!--  <td>${vehiclelist.color_s}</td>-->
					<td>${vehiclelist.vehicleCPG_s }</td>
					<td>${vehiclelist.vehicleID_s}</td>
					<td>${vehiclelist.roadNames_s}</td>
					<td>
						<a title="删除" href="./deleteStaticOvehicleAction?vehicleCPG2=${vehiclelist.vehicleCPG_s}&vehicleID2=${vehiclelist.vehicleID_s}">
							<img src="images/icons/cross_circle.png" style="cursor:hand;"  alt="删除" />
						</a>
					</td>
				</tr>
				</c:forEach>
		</c:otherwise>
	</c:choose>	
  		</table>
  	</div>
		
  </div>
  </body>
</html>
