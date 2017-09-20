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
	width: 80px;
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
	var ex=1;
	var linshi = 0;//临时添加人员计数
	$(document).ready(function(){
		$(".cardDiv").mousemove(function(){
			$(this).css("border","1px solid #c71717");
		});
		$(".cardDiv").mouseout(function(){
			$(this).css("border","1px solid #c7c7c7");
		});
		
		$("#driveCPG").hide();
		$("#driverdiv").hide();
		$.post(
  				"./MjDoorToJson",
  				{
  					time:new Date().getTime()
  				},function(data,status){
  					//alert("Data: " + data + "\nStatus: " + status);
  					jsonlist=data;
  				}
  			);
  			
	});
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
  		&gt;&gt;<a href="./grantPrecardAction?orderId=${orderId}&customerId=${customerId}" class="currentFont">人卡发放</a> &nbsp;&nbsp;&nbsp;
  		<!--  &gt;&gt;<a href="./searchOilcardAction?orderId=${orderId}&customerId=${customerId}" style="font-weight: normal;">油卡发放</a>&nbsp;&nbsp;&nbsp;-->
  		<!-- &gt;&gt;<a href="./grantInterphoneAction?orderId=${orderId}&customerId=${customerId}" >对讲机发放</a> &nbsp;&nbsp;&nbsp; -->
  		&gt;&gt;<a href="./prepareRecordVehicleAction?orderId=${orderId}&customerId=${customerId}" style="font-weight: normal;">车辆信息与车卡</a> &nbsp;&nbsp;&nbsp;
  		<!--  &gt;&gt;<a href="./recordDriverAction?customerId=${customerId}&orderId=${orderId}">驾驶员登记</a>&nbsp;&nbsp;&nbsp;
  		&gt;&gt;<a href="./recordEntourageAction?customerId=${customerId}&orderId=${orderId}">随行人员登记</a>--></h3> 
  		<form action="./grantPrecardAction?orderId=${orderId}&customerId=${customerId}" id="sform" name="sform"></form>
  </div>
   <div id="man_zone" style="height: 515px;width: 100%;">
 <div style="padding: 5px;margin: 0px 5px 0px 10px"">
	  	<form action="./recordPrecardAction?orderId=${orderId}" method="post" id="addPersonForm" name="addPersonForm" style="margin-top: 0px;">
	  		<h3 class="h3bg" style="margin: 0px 5px 0px 10px;">已添加人员：</h3>
	  		<div id="div1" style="margin: 5px 5px 0px 10px;">
	  		<c:choose>
	  			<c:when test="${empty recepUserList}">
	  				<p>暂无人数据！</p>
	  			</c:when><c:otherwise>
	  				<c:forEach items="${recepUserList}" var="ulist" varStatus="status" >
			  			<input type="hidden" name="customerUserID" id="customerUserID" value="${ulist.customerUserID_s}"/>
				  		<input type="checkbox" id="checkuser" name="checkuser" checked="checked" style="border: 0;width: 20px"/>								
				  		人员名称：<input type="text" name="customerUserName" id="customerUserName" value="${ulist.customerUserName_s }" style="width:90px" onblur="Checkfun.isNull(this,'人员名称')" /><font color="red">*</font>
				  		卡面编号：<input type="text" name="serialface" id="serialface" value="${ulist.serialface_s }" style="width:150px" class="face"/><font color="red">*</font>
				  		人卡号：<input type="text" name="card" id="card" style="width:150px"  onclick="readCardInfo(this)" value="${ulist.card_s}" /><font color="red">*</font>
				  		部门：<select class="easyui-combobox" id="resaveds1" name="resaveds1" style="width:100px">
				  					<option value="17" <c:if test="${ulist.resaveds1_s ==17}"> selected="selected" </c:if>>临时用卡人员</option>
				  					<option value="16"  <c:if test="${ulist.resaveds1_s ==16}"> selected="selected"</c:if>>试验客户</option>
					  		</select>
				  		<!--  
				  		人员类型：<select id="userType" name="userType" style="width:150px">
				  					<option value="1"  <c:if test="${ulist.userType_i ==1}"> selected="selected"</c:if>>客户负责人</option>
					  				<option value="2" <c:if test="${ulist.userType_i ==2}"> selected="selected" </c:if>>陪同人员</option>
					  				<option value="3" <c:if test="${ulist.userType_i ==3}"> selected="selected" </c:if>>驾驶员</option>
					  			</select>-->
				  		房门集合：<input class="easyui-combobox" id="authorizeDoorsFace${status.index}" style="width: 150px;"	data-options="
				  			url:'MjDoorToJson?time=' +new Date().getTime() + '&customerUserID=${ulist.customerUserID_s}' +'&orderID=${orderId}' ,
							method:'get',
							valueField:'id',
							textField:'text',
							multiple:true,
							separator:'I'
					"><font color="red">*</font>
					失效时间：<input id="invalidate" name="invalidate" value="${ulist.invalidatestr }"  type="text" class="easyui-datebox" data-options="formatter:myformatter,parser:myparser"  style="width:120px"/><font color="red">*</font>
					
					<input type="hidden"  id="userType" name="userType" value="${ulist.userType_i}"/>
					<input type="hidden" name="sysNo" id="sysNo"   value="${ulist.sysNo_s}"  />
				  		<br/>
			  		</c:forEach>
			  		
			  	
	  			</c:otherwise>
	  		</c:choose>
	  		<input type="hidden" name="doorNum" id="doorNum" value="${fn:length(recepUserList) }" /> 
			<input type="hidden" name="authorizeDoors" id="authorizeDoors" />
	  		</div>
	  		<center id="forexp">
				  		<a href="#" onclick="return false" style="vertical-align: middle;margin-top: 10px" id="addPersonFormBt" class="easyui-linkbutton">
				  			<label onclick="submitAddPercardFrom()">确定发卡</label>
				  		</a>
			</center>
	 </form>
	 <object  classid="clsid:0b6ed426-9e67-4cf3-99da-8a346a98e5c6" codebase="Setup1.msi"
			width="0" height="0" id="helloBossma">
	</object>
	
	 <h3 class="h3bg" style="margin: 0px 3px 0px 10px;">未添加人员：</h3>
<div style="margin: 0px 5px 0px 10px;" >
	人员名称：<input id="fname" name="fname" value="" style="width: 120px;"/>	
	<img onclick="search()" alt="查询" title="查询" src="images/search.gif" style="width: 30px;height: 30px;vertical-align: middle;display: inline;cursor: hand;" >
	 <form action="./exPersonAction?orderId=${orderId}" method="post" id="exaddPersonForm" name="exaddPersonForm" >
	  	<table style="width: 99%;"  id="manageordertab"  >
  			<tr style="font-weight: bold;">
  				<td width="4%">序号</td>
	  			<td width="25%">人员编号</td>
				<td width="25%">人员名称</td>
				<td width="25%">类别</td>
				<td width="17%">
					<a title="添加" onclick="exadd('${customerId}')"  >
           				<img src="images/icons/add.png" style="cursor:hand;"  alt="添加" />
        			</a> 
				</td>
			</tr>
	  	<c:choose>
			<c:when test="${empty vcustomeruserlist}">
				<tr><td colspan="5">查无记录！</td></tr>
			</c:when>
			<c:otherwise>
				<c:forEach items="${vcustomeruserlist}" var="userList" varStatus="userListStatus">
					<c:set var="statusIndex" value="${userListStatus.index}" />
						<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
						<c:if test="${(statusIndex % 2) == 0}">
							<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
						</c:if> 
					<div id="${statusIndex+1 }">
					<tr style="${evenOddStyle}">
						<td>${statusIndex+1 }</td>
						<td>${userList.customeruserid_s}</td>
						<td>${userList.customerusername_s}</td>
						<td>
							<c:if test="${userList.usertypeI==1}">客户负责人</c:if>
							<c:if test="${userList.usertypeI==2}">客户陪同人员</c:if>
							<c:if test="${userList.usertypeI==3}">驾驶员</c:if>
						</td>
						<td>
							<c:choose>
								<c:when test="${userList.usertypeI == 3 }">
									<c:if test="${userList.isTrain == 1 }">
										<input width="5px" type="checkbox" id="receptionCustomerUser" name="receptionCustomerUser" value="${userList.customeruserid_s},${userList.customerusername_s},${userList.usertypeI}"  style="border: 0"/>								
									</c:if>
									<c:if test="${userList.isTrain == 0 }">
										<div id="traindiv">
										<input id="trainbtn" type="button"  src="images/icons/tick_circle.png" style="cursor:hand;" value="培训" />
										</div>
										<div id="driverdiv" >
										<input width="5px" type="checkbox" id="receptionCustomerUser" name="receptionCustomerUser" value="${userList.customeruserid_s},${userList.customerusername_s},${userList.usertypeI}"  style="border: 0"/>								
										</div>
									</c:if>
								</c:when><c:otherwise>
								<input width="5px" type="checkbox" id="receptionCustomerUser" name="receptionCustomerUser" value="${userList.customeruserid_s},${userList.customerusername_s},${userList.usertypeI}"  style="border: 0"/>								
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
</form>
</div>
		
		<br>
<center>
			<input type="hidden" name="userNum" id="userNum" value="${fn:length(vcustomeruserlist) }" /> 
	  		<a href="#" onclick="return false" style="vertical-align: middle;" id="addVehicleFormBt" class="easyui-linkbutton">
	  			<label onclick="submitExAddPersonFrom()">添加</label>
	  		</a>
</center>
	 </form>
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
	
		function submitAddPercardFrom(){
			//校验略
			//alert( $("#authorizeRoadsFace0").combobox('getText') );
			//alert( $("#authorizeRoadsFace1").combobox('getText') );
			//alert( $("#authorizeRoadsFace2").combobox('getText') );
			//alert( $("#authorizeRoadsFace3").combobox('getText') );
			var doorNames="";
			var i=0;
			var max=$("#doorNum").val();
			var flag=true;
			
			var boxs=document.getElementsByName("checkuser");
			//alert(boxs.length);
			//判断临时人员是否选中
			for(i=0;i<boxs.length;i++){
				//alert(boxs[i]);
				if(boxs[i].checked){
					 
					if($("#authorizeDoorsFace"+i).combobox('getValues')=="" || $("#authorizeDoorsFace"+i).prev().prev().prev().prev().val()==""){
						flag=false;
						break ;
					}
					doorNames+=$("#authorizeDoorsFace"+i).combobox('getValues')+"I" ;
				}
			}
			
			//for(i=0;i<max;i++){
				//alert($("#authorizeDoorsFace"+i).combobox('getValues') == null);
				//alert($("#authorizeDoorsFace"+i).prev().prev().prev().prev().val());
			//	if($("#authorizeDoorsFace"+i).combobox('getValues')=="" || $("#authorizeDoorsFace"+i).prev().prev().prev().val() == "" || $("#authorizeDoorsFace"+i).prev().prev().prev().prev().val() == ""){
			//		flag=false;
			//		break ;
			//	}
				//alert($("#authorizeDoorsFace"+i).combobox('getValues'))
			//	doorNames+=$("#authorizeDoorsFace"+i).combobox('getValues')+"I" ;
			//}
			//flag=true;
			//alert("组装后 "+doorNames);
			
			$("#authorizeDoors").val(doorNames);
			//alert("flag--"+flag);
			if(flag){
				$("#addPersonForm").submit();
				$.messager.alert("Success","人卡发放成功！");
			}else{
				$.messager.alert("Error","请将人卡及门禁发放给所有接待人员！");
			}
			
		}
		
		//checkbox全选
		$("#selectAllPerson").click(function (){
  			var selAll=document.getElementById("selectAllPerson").checked;
  			if(selAll){
				var boxs=document.getElementsByName("receptionCustomerUser");
				
				for(i=0;i<boxs.length;i++){
					boxs[i].checked=true;
				}
  			}else {
				var boxs=document.getElementsByName("receptionCustomerUser");
				for(i=0;i<boxs.length;i++){
					boxs[i].checked=false;
				}
  			}
  		});
		
		$("#trainbtn").click(function (){
			//如果点击培训按钮
			$("#driverdiv").show();
			$("#traindiv").hide();
					
		});
		
		//额外添加的接待人员信息
		function submitExAddPersonFrom(){
			//校验略
			//sharonyshi2014-10-9
			//$("#exaddPersonForm").submit();
			//sharonyshi2014-10-9
			//alert("1");
			var boxs=document.getElementsByName("receptionCustomerUser");
			//alert(boxs.length);
			//判断临时人员是否选中
			var num=parseInt($("#doorNum").val());
			
			if(num > 0){
				var i=0;
				for(i;i<boxs.length;i++){
					if(boxs[i].checked){
						//alert("YYY");
						//alert(num);
						var boxvalue;
						boxvalue=boxs[i].value.split(",");
						//alert(boxvalue[0]+"-"+boxvalue[1]);
						var Obj = eval("(" + jsonlist + ")");
						var text1="<input type='hidden' name='customerUserID' id='customerUserID' value='"+boxvalue[0]+"'/>";
						var text2=" 人员名称：<input type='text' name='customerUserName' id='customerUserName' value='"+boxvalue[1]+"' style='width:90px' onblur='Checkfun.isNull(this,'人员名称')' /><font color='red'>*</font>";
						var text3="	卡面编号：<input type='text' name='serialface' id='serialface' value='${ulist.serialface_s }' style='width:150px' /><font color='red'>*</font>";
				  		var text4="	人卡号：<input type='text' name='card' id='card' style='width:150px' onblur='Checkfun.isNull(this,'人卡')' onclick='readCardInfo(this)' value='${ulist.card_s}' onblur='checkNull(this)' /><font color='red'>*</font>";
				  		var text5="	部门：<select class=\"easyui-combobox\" id='resaveds1' name='resaveds1' style='width:100px'><option value='17' <c:if test='${ulist.resaveds1_s ==17}'> selected='selected' </c:if>>临时用卡人员</option>	<option value='16'  <c:if test='${ulist.resaveds1_s ==16}'> selected='selected'</c:if>>试验客户</option></select>";
				  		var text6="	房门集合：<input class='easyui-combobox' id='authorizeDoorsFace"+(num+linshi)+"' style='width: 150px;' multiple=true	/><font color='red'>*</font>";			  			
			  			var text7="	失效时间：<input id=\"invalidate\" name=\"invalidate\"  value=\""+$("#invalidate").datebox('getValue')+"\"  type=\"text\" class=\"easyui-datebox\" data-options=\"formatter:myformatter,parser:myparser\" style=\"width:120px\"/><font color='red'>*</font>";
						var text8="	<input type='hidden' name='sysNo' id='sysNo'   value='${ulist.sysNo_s}'  />";
						var text8="	<input type='hidden' name='userType' id='userType'   value='"+boxvalue[2]+"'  />";
						var text9="	<br/>";
						var text10="<input type='checkbox' id='checkuser' name='checkuser' checked='checked' style='border: 0;width: 20px'/>";		
						//alert((num+linshi));
						var targetObj = $("#div1").append(text10,text2,text3,text4,text5,text6,text7,text8,text1,text9);
						$.parser.parse(targetObj);
						$("#authorizeDoorsFace"+(num+linshi)).combobox({ 
							data:Obj,
							valueField:'id', 
							textField:'text' 
						}); 
						//alert(boxs[i]);
						linshi++;
						boxs[i].disabled=true;
					}
				}
			}else{
				var i=0;
				var userids="";
				var usernames="";
				var usertypes="";
				
				for(i;i<boxs.length;i++){
					if(boxs[i].checked){
						var boxvalue;
						boxvalue=boxs[i].value.split(",");
						userids = userids + boxvalue[0] + ",";
						usernames = usernames + boxvalue[1] + ",";
						usertypes = usertypes + boxvalue[2] + ",";
					}
				}
				
				$.post(
  					"./grantExpersonAction",
  	  				{
  						userids:userids,
  						usernames:usernames,
  						usertypes:usertypes,
  	  					time:new Date().getTime()
  	  				},function(){
	  	  				$("#sform").submit();
	  	  		});
			}
			
			$.messager.alert("Success","临时人员添加成功！");
		}
		
		
		
		function exadd(t){
			var winPar=window.showModalDialog("./prepareaddExuser?customerId="+t, "", "dialogWidth=980px;dialogHeight=600px;toolbar=no;menubar=no;location=no;status=no;scroll=no;");		
		 	var max=parseInt($("#userNum").val());
			var info=winPar.split(",");
			var temp="";
			if(info[2] == 1){
				temp="客户负责人";
			}else if(info[2] == 2){
				temp="客户陪同人员";
			}else if(info[2] == 3){
				temp="驾驶员";
			}
			var tr = "<tr";
			if((max+ex)%2==0){
				tr = tr + " style='background-color:#EEEEEE'";
			}else{
				tr = tr + " style='background-color:#FFFFFF'";
			}
			tr = tr +"><td>"+(max+ex)+"</td><td>"+info[0]+"</td><td>"+info[1]+"</td><td>"+temp+"</td><td><input style='border: 0;width: 20px' type='checkbox' id='receptionCustomerUser' name='receptionCustomerUser' value='"+info[0]+","+info[1]+","+info[2]+"'  /></td></tr>";								
			alert(tr);
			$("#manageordertab").append(tr);
			ex++;
		}
		
		function search(){
			var fname = $("#fname").val();
			if(fname == ""){
				$("table tr:gt(0)").show();
			}
			
			$("table tr:gt(0)").hide();
			var $d = $("table tr:gt(0)").filter(":contains('"+$.trim(fname)+"')");
			$d.show();
		}
			
		
</script>
  	</div>
  	
  	<!--  
  	 <h3 class="h3bg">订单【${orderId}】已发人卡信息列表：</h3>
  
  	<div>
  		<table style="width: 100%;">
  			<tr style="font-weight: bold;">
  				<td width="10%">人员编号</td>
  				<td width="10%">人员名称</td>
  				<td width="20%">人卡号</td>
  				<td width="20%">卡面编号</td>
  				<td width="20%">人员类型</td>
  				<td width="30%">房门集合</td>
  				<td width="10%">操作</td>
  			</tr>
  			<c:choose>
			<c:when test="${empty recepUserList}">
			<tr>
				<td colspan="6">查无记录！</td>
			</tr>	
			</c:when><c:otherwise>
  			<c:forEach items="${recepUserList}" var="recplist" varStatus="recplistStatus">
  				<c:set var="statusIndex" value="${recplistStatus.index}" />
				<c:set var="evenOddStyle" value="background-color:#EEEEEE" />
				<c:if test="${(statusIndex % 2) == 0}">
					<c:set var="evenOddStyle" value="background-color:#FFFFFF" />
				</c:if> 
				<tr style="${evenOddStyle}">
					<td>${recplist.customerUserID_s}</td>
					<td>${recplist.customerUserName_s}</td>
					<td>${recplist.card_s }</td>
					<td>${recplist.serialface_s}</td>
					<td>${recplist.userType_s}</td>
					<td>${recplist.deviceSysid_s}</td>
					<td>
						<a title="删除" href="./">
							<img src="images/icons/cross_circle.png" style="cursor:hand;"  alt="删除" />
						</a>
					</td>
				</tr>
				</c:forEach>
		</c:otherwise>
	</c:choose>	
  		</table>
  	</div>
  	<div class="dbgrid" style="border: 1px solid #ddd; width: 1060px;">
		
			<table class="dbgrid" style="background-color: #FFF;width: 1055px;" >
				<tr>
					<td width="50%" style="text-align: left;" >
						<div style="display: inline; width: 380px; padding-left: 10px;" >
							共有记录${totalPages }条，分${maxPage}页，当前第${currentPage+1}页
						</div>
					</td>
					<td width="50%" style="text-align: right;">
						<div style="padding-right: 5px;">
							<a href="./prepareRecordVehicleAction?flag=page&&currentPage=0" target="manFrame" >首页</a>&nbsp;
							<a href="./prepareRecordVehicleAction?flag=page&&currentPage=${currentPage-1<=0?0:currentPage-1}">前一页</a>&nbsp;
							<a href="./prepareRecordVehicleAction?flag=page&&currentPage=${currentPage+1>=maxPage?totalPage-1:currentPage+1}">后一页</a>&nbsp;
							<a href="./prepareRecordVehicleAction?flag=page&&currentPage=${maxPage-1}">末页</a>&nbsp;&nbsp;
							<form style="display: inline;" action="./registerCustomerSearchAction" method="post">
							转到第<select name="currentPage" onchange="submitPage()">
								<c:forEach begin="1" end="${maxPage}" step="1" var="item" >
								<option value="${item-1}" >第${item }页</option>
								</c:forEach>
							</select>页
							</form>
							<script type="text/javascript">
								function submitPage(){
									alert("准备翻页");
								}
							</script>
						</div>
					</td>
				</tr>
			</table>
		</div>
	-->	
	
  </div>
  </body>
</html>
