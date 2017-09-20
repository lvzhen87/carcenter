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
	font-size: 16px;
	font-weight: bold;
	color: #03038a;
}
.h3bg{
	background-color: #E8E8FF;
	margin: 0px;
	padding: 2px;
}
</style>
<script type="text/javascript">
var jsonlist;
var delvechile = "";
var delline = "";
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
  <div style="height: 30px;padding-left: 10px;">
  	<h3 style="padding: 0px;margin: 0px;">
  		&gt;&gt;<a href="./grantPrecardAction?orderId=${orderId}&customerId=${customerId}" style="font-weight: normal;">人卡发放</a> &nbsp;&nbsp;&nbsp;
  		<!-- &gt;&gt;<a href="./searchOilcardAction?orderId=${orderId}&customerId=${customerId}"  style="font-weight: normal;">油卡发放</a>&nbsp;&nbsp;&nbsp; -->
  		<!-- &gt;&gt;<a href="./grantInterphoneAction?orderId=${orderId}&customerId=${customerId}" >对讲机发放</a> &nbsp;&nbsp;&nbsp; -->
  		&gt;&gt;<a href="./prepareRecordVehicleAction?orderId=${orderId}&customerId=${customerId}" class="currentFont">车辆信息与车卡</a> &nbsp;&nbsp;&nbsp;
  		<!--  &gt;&gt;<a href="./recordDriverAction?customerId=${customerId}&orderId=${orderId}">驾驶员登记</a>&nbsp;&nbsp;&nbsp;
  		&gt;&gt;<a href="./recordEntourageAction?customerId=${customerId}&orderId=${orderId}">随行人员登记</a>--></h3>
  		<form action="./prepareRecordVehicleAction?orderId=${orderId}&customerId=${customerId}" id="rform" name="rform"></form>
  </div>

  <c:choose>
  	<c:when test="${!empty errmsg}">
	  	<script type="text/javascript">
	  		alert(${errmsg });
	   </script>
	</c:when>
  </c:choose>
  <div id="man_zone" style="height: 515px;width: 100%;">
  	<!-- 添加车信息 -->
  	<div style="padding: 2px;">
	  	<form action="./recordvehicleAction?orderId=${orderId}" method="post" id="addVehicleForm" name="addVehicleForm" style="margin-top: 0px;">
	  		<h3 class="h3bg" style="margin: 0px 5px 0px 5px;">试验申请车辆：</h3>
	  		<div style="margin: 5px 5px 0px 5px;" id="div1" >
	  		<c:choose>
	  			<c:when test="${empty recVehicleInfo}">
	  				<p>暂无车辆数据！</p>
	  			</c:when><c:otherwise>
	  				<c:forEach items="${recVehicleInfo}" var="vlist" varStatus="status">
	  				<div id="${status.index}">
	  				<input style="width:60px" type="checkbox" name="check${status.index}" id="check${status.index}"  checked="checked"   />
	  				序号:<span>${status.index+1}</span>&nbsp;&nbsp;
VIN号:<input type="text" name="vin${status.index}" id="vin${status.index}" value="${vlist.vin_s}" />&nbsp;&nbsp;
领卡人:<input type="text" name="receiveCardUser${status.index}" id="receiveCardUser${status.index}" value="${vlist.resaveds4_s}" /><font color="red">*</font> 
			  			车辆型号：<input type="text" name="model${status.index}" id="model${status.index}" value="${vlist.brandType_s}"  onblur="Checkfun.isNull(this,'车辆型号',80)" /><font color="red">*</font>
				  		车轴数：<input type="text" name="axleNumber${status.index}" id="axleNumber${status.index}" value="${vlist.axleNumber_i }"   onblur="Checkfun.IsInteger(this,'车轴数',20)"/><font color="red">*</font>
				  		<!--  车辆颜色：<input type="text" name="color" id="color" value="${vlist.color_s }"  onblur="Checkfun.isNull(this,'车辆颜色')" />-->
				  		
				  		<!--
				  		CPG牌号：<input type="text" name="vehicleCPG${status.index}" id="vehicleCPG${status.index}" value="${vlist.resaveds2_s }"  onblur="Checkfun.isNull(this,'CPG牌号',80)" /><font color="red">*</font>
				  -->
				  CPG牌号：<input type="text" name="vehicleCPG${status.index}" id="vehicleCPG${status.index}" value="${vlist.resaveds2_s }"  onblur="Checkfun.isNull(this,'CPG牌号',80)" /><font color="red">*</font>
				  		车卡：<input type="text" name="vehicleCardID${status.index}" id="vehicleCardID${status.index}" onclick="readCardInfo(this)" value="${vlist.vehicleID_s}"  /><font color="red">*</font>
				  		授权路面：<input class="easyui-combobox" id="authorizeRoadsFace${status.index}" style="width: 200px;"	data-options="
				  			url:'roadNameToJson?time='+new Date().getTime() + '&vehicleID_s=' + '${vlist.vehicleID_s}'+ '&cpg=' + '${vlist.resaveds2_s}' + '&orderID_s=' + '${vlist.orderID_s}' ,
							method:'get',
							valueField:'id',
							textField:'text',
							multiple:true,
							separator:'-'
					"><font color="red">*</font>
					<!--  
					  		授权路面：<input class="easyui-combobox" id="authorizeRoadsFace${status.index}" style="width: 200px;"	data-options="
				  			url:'roadNameToJson?time='+new Date().getTime() + '&vehicleID_s=' + '${vlist.vehicleID_s}'+ '&cpg=' + '${vlist.resaveds2_s}' + '&orderID_s=' + '${vlist.orderID_s}' ,
							method:'get',
							valueField:'id',
							textField:'text',
							multiple:true,
							separator:'-'
					"><font color="red">*</font>-->
					失效时间：<input id="invalidate${status.index}" name="invalidate${status.index}" value="${vlist.resaveds1_s}"  type="text" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser"  style="width:120px"/><font color="red">*</font>
					<a title="删除" onclick="deletevehicle('${status.index}','${vlist.vehicleCPG_s}','${vlist.vehicleID_s}')" >
            			<img src="images/icons/cross_circle.png" style="cursor:hand;"  alt="删除" />
           			</a>
           			<br/>
				  		<input type="hidden" name="vehiclecpg_s${status.index}" id="vehiclecpg_s${status.index}" value="${vlist.vehicleCPG_s}"/>
				  	</div>
			  		</c:forEach>

	  			</c:otherwise>
	  		</c:choose>
	  		</div>
		<center>
  			<input type="hidden" name="roadNum" id="roadNum" value="${fn:length(recVehicleInfo) }" />
  			<input type="hidden" name="authorizeRoads" id="authorizeRoads" />
  			<input type="hidden" name="deleteVehicles" id="deleteVehicles" value="" />
  			<input type="hidden" name="models" id="models" value="" />
  			<!-- 新增VIN号 -->
  			<input type="hidden" name="vins" id="vins" value="" />
  			<!-- 新增领卡人 -->
  			<input type="hidden" name="receiveCardUsers" id="receiveCardUsers" value="">
  			<input type="hidden" name="axleNumbers" id="axleNumbers" value="" />
  			<input type="hidden" name="vehicleCPGs" id="vehicleCPGs" value="" />
  			<input type="hidden" name="vehicleCardIDs" id="vehicleCardIDs" value="" />
  			<input type="hidden" name="invalidates" id="invalidates" value="" />
  			<input type="hidden" name="ywvehicleCPGs" id="ywvehicleCPGs" value="" />
  			<input type="hidden" name="checkRoads" id="checkRoads" value="" />
  			<input type="hidden" name="flag" id="flag" value="" />
	  		<a href="#" onclick="return false" style="vertical-align: middle;margin-top: 10px" id="addVehicleFormBt" class="easyui-linkbutton">
	  			<label onclick="submitAddVehicleFrom()">确定卡信息</label>
	  		</a>
 		</center>
	 </form>
	 <object  classid="clsid:0b6ed426-9e67-4cf3-99da-8a346a98e5c6" codebase="Setup1.msi"
  			width="0" height="0" id="helloBossma">
	</object>
	 <h3 class="h3bg" style="margin: 0px 5px 0px 5px;">临时车辆添加：</h3>
	 <div style="margin: 0px 5px 0px 5px;" >
	 <form action="./exrecordvehicleAction?orderId=${orderId}" method="post" id="exaddVehicleForm" name="exaddVehicleForm" >
	  <table width="99%" >
		<tr>
			<td width="15%">类别：
				<select class="easyui-combobox" id="categoryFace" style="width:120px;height: 25px;padding: 0px;margin-left: 0px;">
					<option value="1">试验车</option>
					<option value="2">通勤车</option>
				</select>
				<input type="hidden"  id="category"  name="category" />
			</td>
			<td width="18%">
				类型：
				<select class="easyui-combobox" id="modelFace" style="width:120px;height: 25px;padding: 0px;margin-left: 0px;">
					<option value="1">小于3.5t</option>
					<option value="2">大于3.5t</option>
				</select>
				<input type="hidden"  id="model" name="model" />
			</td>
			<td width="15%">
				<a href="javascript:void(0);" title="类型大于3.5t时填写" class="easyui-tooltip">
				车重：<input type="text" name="weight" id="weight" alt="车重大于3.5t时填写" >
				</a>
			</td>
			<td width="15%">
				<a href="javascript:void(0);" title="类型大于3.5t时填写" class="easyui-tooltip">
				轴重：<input type="text" name="maxWeight" id="maxWeight" alt="车重大于3.5t时填写"  >
				</a>
			</td>
			<td width="20%">
				车辆轴数：&nbsp;<input type="text" id="axleNumber" name="axleNumber" value="${axleNumber}" ><font color="red">*</font>
			</td>
			<td width="20%">
				燃&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp料：
				<select class="easyui-combobox" id="fuelDemandFace" style="width:120px;height: 25px;">
					<option value="1">汽油</option>
					<option value="2">柴油</option>
					<option value="3">充电</option>
					<option value="4">油电混合</option>
					<option value="5">其他</option>
				</select>
				<input type="hidden"  id="fuelDemand" name="fuelDemand" />
			</td>
		</tr>
		<tr>
			<td >
				颜色：<input type="text" id="color" name="color" style="margin-left: 4px;" >
			</td>
			<td >
				牌照：<input type="text" id="licensPlate" name="licensPlate" style="margin-left: 4px;"><font color="red">*</font>
			</td>
			<td>
				型号：<input type="text" name="brandType" id="brandType" >
			</td>
			<td>
				极速：<input type="text" name="maxSpeed"  id="maxSpeed">
			</td>
			<td >
				VIN后6位：<input type="text" name="vin" id="vin" >
			</td>
			<td >
			预计消耗：&nbsp;<input type="text" name="fuelConsumption" id="fuelConsumption" >
			</td>
		</tr>
	</table>
	<br/>
	<center>
	  		<a href="#" onclick="return false" style="vertical-align: middle;" id="addVehicleFormBt" class="easyui-linkbutton">
	  			<label onclick="jsAddExVehicle()">添加</label>
	  		</a>
	 </center>
	 </form>
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
			//var flag = "";
			//alert('a')
			var roadNames="";
			var models ="";
			//新增VIN号,领卡人
			var vins = "";
			var receivecardusers = "";
			var axles = "";
			var cards = "";
			var cpgs = "";
	 		var invalidates="";
	 		var checkroad="";
			var vehiclecpgs = "";
			var max=parseInt($("#roadNum").val());
			var facenum=max+i;

			if(facenum < 1){
				$.messager.alert('Error','请先去添加试验车辆!','info');
				return false;
			}

			//alert("facenum"+facenum);
			for(i=0;i<facenum;i++){
				//alert("授权路面："+$("#authorizeRoadsFace"+i).combobox('getText'));
				var temp= $("#"+i).is(":hidden");//是否隐藏
				//alert(temp);//如果已经隐藏，说明是要删除的，不校验
				if(!temp){
					if($("#model"+i).val().length<1){
						$.messager.alert('Error','请输入车辆型号!','info');
						return false;
					}
					if($("#axleNumber"+i).val().length<1){
						$.messager.alert('Error','请输入车轴数!','info');
						return false;
					}
		
					if($("#vehicleCPG"+i).val().length <1){
						$.messager.alert('Error','请输入CPG牌号!','info');
						return false;
					}
					if($("#vehicleCardID"+i).val().length<1){
						$.messager.alert('Error','请输入车卡!','info');
						return false;
					}

					if($("#authorizeRoadsFace"+i).combobox('getText')== "" ){
						$.messager.alert('Error','请授权路面!','info');
						return false;
					}

			 		if($("#invalidate"+i).combobox('getText')== "" ){
						$.messager.alert('Error','请输入 失效时间 !','info');
						return false;
					}
					//alert($("#check"+i).get(0).checked);
					if ($("#check"+i).get(0).checked)
					{
						checkroad += "on" + ",";
					}
					else
					{
						checkroad += "off" + ",";
					}
					//alert(checkroad);
					models += $("#model"+i).val() + ",";
					vins += $('#vin'+i).val() + ",";
					receivecardusers += $('#receiveCardUser'+i).val() + ",";
					axles += $("#axleNumber"+i).val()+",";
					cards += $("#vehicleCardID"+i).val() +",";
					cpgs += $("#vehicleCPG"+i).val() + ",";
				 	invalidates += $("#invalidate"+i).combobox('getValues') + ",";
					roadNames+=$("#authorizeRoadsFace"+i).combobox('getText')+",";
					vehiclecpgs+=$("#vehiclecpg_s"+i).val()+",";
				}
			}
			//alert("组装后 "+roadNames);
			$("#authorizeRoads").val(roadNames);
			//alert($("#vehicleCPG").val());
			$("#deleteVehicles").val(delvechile);
			$("#models").val(models);
			$("#vins").val(vins);
			$("#receiveCardUsers").val(receivecardusers);
			$("#axleNumbers").val(axles);
			$("#vehicleCPGs").val(cpgs);
			$("#vehicleCardIDs").val(cards);
			$("#ywvehicleCPGs").val(vehiclecpgs);
		 	$("#invalidates").val(invalidates);
		 	$("#checkRoads").val(checkroad);
			$("#addVehicleForm").submit();
			$.messager.alert('Success',"车卡发放成功！");

		}

		function jsAddExVehicle(){
			if($("#modelFace").combobox('getValue')==2){
				if( $("#weight").val().length<1 ){
					$.messager.alert('提示','类型大于3.5t，必须填写车重！');
					return false;
				}
				if( $("#maxWeight").val().length<1 ){
					$.messager.alert('提示','类型大于3.5t，必须填写轴重！');
					return false;
				}
			}
			if($("#axleNumber").val().length<1 || parseInt($("#axleNumber").val() )<1  ){
				$.messager.alert('提示','请填写车轴数');
				return false;
			}
			if($("#licensPlate").val().length<1 ){
				$.messager.alert('提示','请填写牌照号');
				return false;
			}

			//alert(parseInt($("#axleNumber").val() ));

			$("#category").val($("#categoryFace").combobox('getValue') );
			$("#model").val($("#modelFace").combobox('getValue') );
			$("#fuelDemand").val($("#fuelDemandFace").combobox('getText') );

			$.post(
	  				"./exrecordvehicleAction",
	  				{
	  					category:$("#category").val(),
	  					model:$("#model").val(),
	  					weight:$("#weight").val(),
	  					maxWeight:$("#maxWeight").val(),
	  					axleNumber:$("#axleNumber").val(),
	  					fuelDemand:$("#fuelDemand").val(),
	  					color:$("#color").val(),
	  					licensPlate:$("#licensPlate").val(),
	  					brandType:$("#brandType").val(),
	  					maxSpeed:$("#maxSpeed").val(),
	  					vin:$("#vin").val(),
	  					fuelConsumption:$("#fuelConsumption").val(),
	  					time:new Date().getTime()
	  				},function(msg){
	  					var num=parseInt($("#roadNum").val());

	  					if(num > 0){
	  						var text10="<div id='"+(num+i)+"'>";
	  						var text15="序号:<span>'"+(num+1+i)+"'</span>&nbsp;&nbsp;<font color='red'>*</font>";
	  						var text16="VIN号:<input type='text' name='vin"+(num+i)+"' id='vin"+(num+i)+"' value='"+$("#vin").val()+"' onblur='Checkfun.isNull(this,'VIN号',80)'/><font color='red'>*</font>";
	  						var text17="领卡人:<input type='text' name='receiveCardUser"+(num+i)+"' id='receiveCardUser"+(num+i)+"' value='${vlist.resaveds4_s}' onblur='Checkfun.isNull(this,'领卡人',80)'/><font color='red'>*</font>"
		  					var text1="车辆型号：<input type='text' name='model"+(num+i)+"' id='model"+(num+i)+"' value='"+$("#model").val()+"'  onblur='Checkfun.isNull(this,'车辆型号',80)'/><font color='red'>*</font>";
		  				    var text14="<input style='width:60px' type='checkbox' name='check"+(num+i)+"' id='check"+(num+i)+"'  checked='checked' /> ";
		  					var text2=" 车轴数：<input type='text' name='axleNumber"+(num+i)+"' id='axleNumber"+(num+i)+"' value='"+$("#axleNumber").val()+"'   onblur='Checkfun.IsInteger(this,'车轴数',20)'/><font color='red'>*</font>";
		  					var text6=" CPG牌号：<input type='text' name='vehicleCPG"+(num+i)+"' id='vehicleCPG"+(num+i)+"' value=''  onblur='Checkfun.isNull(this,'CPG牌号',80)'/><font color='red'>*</font>";
		  					var text3=" 车卡：<input type='text' name='vehicleCardID"+(num+i)+"' id='vehicleCardID"+(num+i)+"' onclick='readCardInfo(this)' value='${vlist.vehicleID_s}'  /><font color='red'>*</font>"
		  					var text4=" 授权路面：<input class='easyui-combobox' 	id='authorizeRoadsFace"+(num+i)+"' 	style='width: 200px;'/><font color='red'>*</font>";
		  					var text5=" 失效时间：<input id='invalidate"+(num+i)+"' name='invalidate"+(num+i)+"'  type='text' class='easyui-datebox' data-options='formatter:myformatter,parser:myparser' style='width:120px'/><font color='red'>*</font>";
		  					var text13="<input id='vehiclecpg_s"+(num+i)+"' name='vehiclecpg_s"+(num+i)+"' value='"+msg+"'  type='hidden'  />";
		  					var text12=" <a title='删除' onclick='deletevehicle('"+(num+i)+"')' ><img src='images/icons/cross_circle.png' style='cursor:hand;'  alt='删除' /></a> ";
		  					var text9="	<br/>";
		  					var text11="</div>";
		  					//$("#resaveds1").addClass("easyui-combobox");
		  					 //= $("<input id=\"invalidate\" name=\"invalidate\"  value=\"ghjgkh\"  type=\"text\" class=\"easyui-datebox\" data-options=\"formatter:myformatter,parser:myparser\" style=\"width:120px\"/>").appendTo("#liid");

		  					var Obj = eval("(" + jsonlist + ")");
		  					var targetObj = $("#div1").append(text10,text14,text15,text16,text17,text1,text2,text6,text3,text4,text5,text13,text12,text11,text9);

		  					$.parser.parse(targetObj);

		  					$("#authorizeRoadsFace"+(num+i)).combobox({
		  						data:Obj,
		  						valueField:'id',
		  						textField:'text',
		  						multiple:true,
		  						separator:'-'
		  					});
		  					i++;

	  					}else{
	  						$("#rform").submit();
	  					}
	  					$.messager.alert('Success',"临时车辆添加成功！");
	  				}
	  		);
		}

		function submitExAddVehicleFrom(){
			if($("#model2").val().length<1){
				$.messager.alert('Error','请输入新录入车辆型号!','info');
				return false;
			}
			if($("#axleNumber2").val().length<1){
				$.messager.alert('Error','请输入新录入车轴数!','info');
				return false;
			}
			if($("#color2").val().length<1){
				$.messager.alert('Error','请输入新录入车辆颜色!','info');
				return false;
			}
			if($("#vehicleID2").val().length<1){
				$.messager.alert('Error','请输入发放车卡!','info');
				return false;
			}
			$("#authorizeRoad2").val($("#authorizeRoad2Face").combobox('getText'));

			$("#exaddVehicleForm").submit();
			$.messager.alert('Success',"临时车辆添加成功！");
		}


		function deletevehicle(line,cpg,card){

			var max=parseInt($("#roadNum").val());
			//if(line > max){
			//	$("#"+line).hide();//隐藏行
			//}else{
				delvechile += cpg+","+card+"I";
				$("#"+line).hide();//隐藏行
			//}
			//alert(delvechile);
			delline += line;
		}
</script>
  	</div>


  </div>
  </body>
</html>
